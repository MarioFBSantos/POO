package trabalhopoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vegetais implements PrecoAlimentos {

    private Map<String, String> ve = new HashMap<String, String>();

    /* Encapsulamento para proteger o que vai estar classificado como 
   vegetais a serem comprados pelo programa
     */
    public void addVege(String vege, String preco) {
        this.ve.put(vege, preco);
    }

    public void get() {
        System.out.println(this.ve.keySet());
    }

    @Override
    public void CalculaPreco() {
        System.out.println(this.ve);
    }
}
