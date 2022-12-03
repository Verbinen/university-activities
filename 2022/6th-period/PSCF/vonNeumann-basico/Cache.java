package pscf;

import java.util.HashMap;
import java.util.Map;

public class Cache extends Memoria{
    private final Map<Integer, Integer> cacheMap;
    private RAM ram;

    public Cache(int words, RAM ram) {     // W é a capacidade da memória em "words"
        super(words);
        this.cacheMap = new HashMap<>(ram.capacidade);
        this.ram = ram;
    }

    @Override
    int Read(int endereco) throws EnderecoInvalido {
        try{
            VerificaEndereco(endereco);
            if(cacheMap.containsKey(endereco))  return cacheMap.get(endereco);

            //Transfere BLoco da ram pra cache
            for(int i = 0; i < this.capacidade; i++){
                int x = ram.Read(endereco);
                this.Write(i, x);
            }
            return 0;

            //ver se ta na cac
//            return dados[endereco];
        }
        catch (EnderecoInvalido e){
//            ram.Write(endereco, dados[endereco]);
            return 0;
        }

    }

    @Override
    void Write(int endereco, int valor) throws EnderecoInvalido {
        VerificaEndereco(endereco);

        cacheMap.put(endereco, valor);
    }

}
