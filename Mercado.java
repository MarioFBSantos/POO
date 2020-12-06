package trabalhopoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mercado {

    public void gravarMercado(String nome, String endereco, String CNPJ) throws FileNotFoundException, IOException {
        File objeto = new File("Mercados.txt");
        try (FileWriter escritor = new FileWriter("Mercados.txt", true)) {
            escritor.append(nome + ";" + endereco + ";" + CNPJ + ";" + "\n");
            escritor.close();
        }
    }

    public void consultarMercados() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("Mercados.txt"))) {
            String array[] = new String[3];

            String line;
            while ((line = br.readLine()) != null) {
                array[0] = line.split(";")[0].toLowerCase();
                array[1] = line.split(";")[1].toLowerCase();
                array[2] = line.split(";")[2].toLowerCase();

                System.out.println("[" + array[0] + "] = [" + array[1] + "]");

            }
        }
    }
}
