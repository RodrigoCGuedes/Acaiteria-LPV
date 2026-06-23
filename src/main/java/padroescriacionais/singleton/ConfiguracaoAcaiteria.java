package padroescriacionais.singleton;

public class ConfiguracaoAcaiteria {
    private static ConfiguracaoAcaiteria instance;
    private String nomeLoja = "Açaiteria GoF";

    private ConfiguracaoAcaiteria() {}

    public static synchronized ConfiguracaoAcaiteria getInstance() {
        if (instance == null) {
            instance = new ConfiguracaoAcaiteria();
        }
        return instance;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}
