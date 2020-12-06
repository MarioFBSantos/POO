package trabalhopoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ervas implements PrecoAlimentos {

    private Map<String, String> erva = new HashMap<String, String>();

    public void addErvas(String er, String er2) {
        this.erva.put(er, er2);
    }

    public void get() {
        System.out.println(this.erva.keySet());
    }

    @Override
    public void CalculaPreco() {
        System.out.println(this.erva);
    }
}
