package exercicios.ex5.servico;

import exercicios.ex5.json.JsonPix;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class APIBanco {
    static final ObjectMapper mapper = new ObjectMapper();

    public static String gerarQRCode(java.math.BigDecimal valor, Integer idPedido) throws IOException {
        JsonPix dadosPix = dadosAjustados();
        String valorString = valor.setScale(2).toPlainString();
        String nome = dadosPix.getNome();
        String qrString = "000201" +
                        "26580014BR.GOV.BCB.PIX" +
                        "0136(%s)".formatted(dadosPix.getChave()) +
                        "52040000" +
                        "5303986" +
                        "54(%02d)(%s)".formatted(valorString.length(), valorString) +
                        "5802BR" +
                        "59(%02d)(%s)".formatted(nome.length(), nome) +
                        "60(%02d)(%s)".formatted(nome.length(), nome) +
                        "62140510RPntNEWDeS" +
                        "6304906A";
        return qrString;
    }

    private static JsonPix getDadosPIX() throws IOException {
        JsonPix json = mapper.readValue(new File("exercicios/ex5/vault/config.json"), JsonPix.class);
        return json;
    }

    private static JsonPix dadosAjustados(){
        JsonPix dadosPix = new JsonPix();
        try {
            dadosPix = getDadosPIX();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String nome = dadosPix.getNome();
        String cidade = dadosPix.getCidade();
        String[] strings = {nome, cidade};
        strings = trimToLength(strings);
        dadosPix.setNome(strings[0]);
        dadosPix.setCidade(strings[1]);
        return dadosPix;
    }

    private static String[] trimToLength(String[] strings){
        for(String s: strings) {
            s = s.trim().toUpperCase();
            if(s.length() > 25){
                s = s.substring(0, 25);
            }
        }
        return strings;
    }

    public static void main() {
        try {
            System.out.println(gerarQRCode(new java.math.BigDecimal("123.45"), 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
