package trabalhopoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Chamado {
    
    public void gravaChamado(String endereco, String nome) throws IOException{
        File objeto = new File("Chamado.txt");
        try (FileWriter escritor = new FileWriter("Chamado.txt",true)) {
            escritor.append(endereco+";"+nome+"\n");
            escritor.close();
        }
    }

}
