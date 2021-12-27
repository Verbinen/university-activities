//Developed by Eduardo Verbinen & Felipe Correa
import java.util.Random;

public class Pessoa {
    private String nome;
    private String chaveMestre;
    private String kS;
    private String nonce = "N";
    private Random random;

    public Pessoa (String nome, String chaveMestre){
        this.nome = nome;
        this.chaveMestre = chaveMestre;
    }

    public String getNome() {
        return nome;
    }

    public String getChaveMestre() {
        return chaveMestre;
    }

    public void setK_S(String k_S) {
        this.kS = k_S;
    }

    public String getKS() {
        return kS;
    }

    public void setNonce() {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        random = new Random();
        int index = 0;
        for( int i = 0; i < 15; i++ ) {
            index = random.nextInt( alfabeto.length() );
            this.nonce += alfabeto.substring( index, index + 1 );
        }
    }

    public void setNonceAlice(String nonce){
        this.nonce = nonce;
    }

    public String getNonce() {
        return nonce;
    }

    public String somaNonce(String nonce){

        return this.nonce + nonce;
    }

}
