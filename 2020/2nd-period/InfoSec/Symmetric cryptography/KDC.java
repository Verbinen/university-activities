//Developed by Eduardo Verbinen & Felipe Correa
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class KDC {
    private Pessoa bob;
    private Pessoa alice;
    private String kS = "";
    private Random random;

    public KDC(Pessoa bob, Pessoa alice){
        this.bob = bob;
        this.alice = alice;
    }

    public void gerarChaveSessao(String remetente, byte[] remetenteCifrado, byte[] destinatarioCifrado) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException {
        String remetenteDecifrado = AES.decifra(remetenteCifrado, bob.getChaveMestre());
        if (remetente.equals(remetenteDecifrado)){
            System.out.println("KDC: " + remetente + " autenticado com sucesso");
        }
        else{
            System.out.println("KDC: Autenticação de " + remetente + " falhou");
        }

        String destinatarioDecifrado = AES.decifra(destinatarioCifrado, bob.getChaveMestre());
        if (destinatarioDecifrado.equals(alice.getNome())){
            System.out.println("KDC: " + remetente + " quer falar com " + destinatarioDecifrado);
        }
        else{
            System.out.println("KDC: destinatário de " + remetente + "Não encontrado");
        }
    }
    public void setK_S() {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        random = new Random();
        int index = 0;
        for( int i = 0; i < 16; i++ ) {
            index = random.nextInt( alfabeto.length() );
            this.kS += alfabeto.substring( index, index + 1 );
        }
        System.out.println("KDC: Chave de sessão gerada");
    }

    public Pessoa getBob() {
        return bob;
    }

    public Pessoa getAlice() {
        return alice;
    }

    public String getKS() {
        return kS;
    }

    public byte[] cifrarChaveSessaoBob() throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException {
        System.out.println("KDC: Cifrando Chave de Sessão em Chave Mestre de Bob");
        return AES.cifra(getKS(), getBob().getChaveMestre());
    }

    public byte[] cifrarChaveSessaoAlice() throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException {
        System.out.println("KDC: Cifrando Chave de Sessão em Chave Mestre de alice");
        return AES.cifra(getKS(), getAlice().getChaveMestre());
    }
}
