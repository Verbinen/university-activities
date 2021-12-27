//Developed by Eduardo Verbinen & Felipe Correa
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AES{
    private static String ALGORITMO = "AES";

    public static byte[] cifra(String texto, String chave)
            throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException
    {
        Key key = new SecretKeySpec(chave.getBytes(StandardCharsets.UTF_8), ALGORITMO);
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        cifrador.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCifrado = cifrador.doFinal(texto.getBytes());
        return textoCifrado;
    }

    public static String decifra(byte[] texto, String chave)
            throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException
    {
        Key key = new SecretKeySpec(chave.getBytes(StandardCharsets.UTF_8), ALGORITMO);
        Cipher decifrador = Cipher.getInstance(ALGORITMO);
        decifrador.init(Cipher.DECRYPT_MODE, key);
        byte[] textoDecifrado = decifrador.doFinal(texto);
        return new String(textoDecifrado);
    }

    public static void Imprimir(String texto)
    {
        System.out.println(texto);
    }

    public static void Imprimir(byte[] texto)
    {
        System.out.println(new String(texto));
    }

    public static void main(String[] args) throws Exception {
        try
        {
            //PASSO 1
            Pessoa bob = new Pessoa("Bob","coneconeconecone");
            Pessoa alice = new Pessoa("Alice","euamomeusbatonss");

            KDC kdc = new KDC(bob, alice);

            byte[] bobCifrado = AES.cifra(bob.getNome(), bob.getChaveMestre()); //Bob faz autenticação
            byte[] aliceCifrada = AES.cifra(alice.getNome(), bob.getChaveMestre()); // Bob diz com quem ele quer falar cifrando a chave da pessoa
            kdc.gerarChaveSessao(bob.getNome(),bobCifrado, aliceCifrada);
            kdc.setK_S(); //Após confirmado, chave de sessão é gerada
            byte[] ksBob = kdc.cifrarChaveSessaoBob();
            byte[] ksAlice = kdc.cifrarChaveSessaoAlice();

            //PASSO 2
            bob.setK_S(AES.decifra(ksBob, bob.getChaveMestre())); // KDC envia a KS pro bob e bob entrega para Alice

            //PASSO 3
            alice.setK_S(AES.decifra(ksAlice, alice.getChaveMestre())); // Alice decifra a KS

            //PASSO 4
            bob.setNonce();
            System.out.println("Bob gera o nonce pseudoaleatoriamente");
            byte[] nonce = AES.cifra(bob.getNonce(), bob.getKS());
            System.out.println("Bob cifra o nonce na chave de sessão e manda para Alice");
            alice.setNonceAlice(AES.decifra(nonce, alice.getKS()));
            byte[] newNonce = AES.cifra(alice.somaNonce(alice.getNonce()), alice.getKS());
            System.out.println("Alice decifra o nonce, executa a função definida por ela e por Bob e cifra o novo nonce");

            //PASSO 5
            String newNonceBob = AES.decifra(newNonce, bob.getKS());
            System.out.println("Bob decifra o novo nonce e compara faz a comparação");

            if (newNonceBob.equals(bob.somaNonce(bob.getNonce()))){
                System.out.println("Autenticação concluída com sucesso");
                System.out.println("Bob e alice agora podem conversar de forma segura");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
