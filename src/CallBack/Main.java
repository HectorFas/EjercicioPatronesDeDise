package CallBack;
class Calculadora {
    interface Callback {
        int  sePuede(int resultado);
        int  noPosible();
    }
   public int divide(int a, int b, Callback callback) {
       if (b == 0) {
           return callback.noPosible();
       } else {
           return callback.sePuede(a/b);     // ¿ y si b es 0 ?
       }
   }

}
class Luis implements Calculadora.Callback {

    @Override
    public int sePuede(int resultado) {
        System.out.println("El resultado es : " + resultado);
        return 0;
    }

    @Override
    public int noPosible() {
        System.out.println("No se puede JoseLuis");
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        calculadora.divide(8, 2, new Luis());

         calculadora.divide(8, 0, new Luis());
    }
}