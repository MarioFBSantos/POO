package trabalhopoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Login {

    public void gravarLogin(String senha, String nome, String endereco, String CPF) throws FileNotFoundException, IOException {
        File objeto = new File("Login.txt");
        try (FileWriter escritor = new FileWriter("Login.txt", true)) {
            escritor.append(senha + ";" + nome + ";" + endereco + ";" + CPF + ";\n");
            escritor.close();
        }
    }

    public int consultarLogin(String senha, String nome) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Login.txt"));
        String array[] = new String[2];

        String line;
        while ((line = br.readLine()) != null) {
            array[0] = line.split(";")[0].toLowerCase();
            array[1] = line.split(";")[1].toLowerCase();

            if (array[0].equals(senha) && array[1].equals(nome)) {
                System.out.println("entrou");
                br.close();
                return 1;
            }

        }
        br.close();
        return 0;
    }

    public String consultaEnd(String senha, String nome) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("Login.txt"))) {
            String array[] = new String[3];
            String line;
            while ((line = br.readLine()) != null) {
                array[0] = line.split(";")[0].toLowerCase();
                array[1] = line.split(";")[1].toLowerCase();
                if (array[0].equals(senha) && array[1].equals(nome)) {
                    br.close();
                    array[2] = line.split(";")[2].toLowerCase();
                    String retornar = array[2];
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n[Chamado acionado no sistema, iremos a sua residencia.]");
                    return retornar;

                }
            }

            return "Endereço não achado";
        }
    }

    public String pegaNome(String senha, String nome) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("Login.txt"))) {
            String array[] = new String[3];

            String line;
            while ((line = br.readLine()) != null) {
                array[0] = line.split(";")[0].toLowerCase();
                array[1] = line.split(";")[1].toLowerCase();
                array[2] = line.split(";")[2].toLowerCase();

                if (array[0].equals(senha) && array[1].equals(nome)) {
                    br.close();
                    return array[1];
                }
            }
            br.close();
        }
        return "sem nome";
    }
}
