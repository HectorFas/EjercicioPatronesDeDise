package SimuladorHipoteca;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class SimuladorHipoteca {
    interface Callback {
        void noTienesUnDuro();
        void teSaleADevolver();
        void muBien(double resultado);
        void errorConectando();
    }

    static void calcularCuota(double capital, double plazo, Callback callback) {
        if (capital <= 0) {
            callback.noTienesUnDuro();
        } else if (plazo <= 0) {
            callback.teSaleADevolver();
        } else {
            double interes = 0;

            try {
                // obtener 'interes' del banco...
                interes = Double.parseDouble(HttpClient.newHttpClient().send(HttpRequest.newBuilder().uri(URI.create("https://fakebank-tan.vercel.app/api/get-interest")).GET().build(), HttpResponse.BodyHandlers.ofString()).body());
            } catch (Exception e) {
                callback.errorConectando();
            }

            callback.muBien((capital * interes / 12 / (1 - Math.pow(1 + (interes / 12), -plazo * 12))));
        }
    }
}

class CaixaLaVall implements SimuladorHipoteca.Callback {

    @Override
    public void noTienesUnDuro() {
        System.out.println("Eres pobre que un rata Antonio");
    }

    @Override
    public void teSaleADevolver() {
        System.out.println("Ves hablar con tu banco por que aqui sale todo en negativo");
    }

    @Override
    public void muBien(double resultado) {
        System.out.println("A pagar 35 años luis: " + resultado);
    }

    @Override
    public void errorConectando() {
        System.out.println("ERROR BANCO");
    }
}

public class Main {
    public static void main(String[] args) {
        CaixaLaVall caixaLaVall = new CaixaLaVall();
        SimuladorHipoteca.calcularCuota(20, 2, caixaLaVall);

    }
}