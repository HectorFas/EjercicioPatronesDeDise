class Computer {
    String HDD, RAM;
    boolean isGraphicsCardEnabled;
    boolean isBluetoothEnabled;

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    static class Builder {
        String HDD, RAM;
        boolean isGraphicsCardEnabled;
        boolean isBluetoothEnabled;

        public Builder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        Builder setisGrhapics (boolean condicion) {
            this.isGraphicsCardEnabled = condicion;
            return this;
        }

        Builder setisBluetooth (boolean condicion) {
            this.isBluetoothEnabled = condicion;
            return this;
        }


        Computer build() {
            Computer computer = new Computer();
            computer.RAM = this.RAM;
            computer.HDD = this.HDD;
            computer.isBluetoothEnabled = this.isBluetoothEnabled;
            computer.isGraphicsCardEnabled = this.isGraphicsCardEnabled;
            return computer;
        }
    }

}

public class Main {
    public static void main(String[] args) {

       Computer computer = new Computer.Builder("HDD1", "32Gb")
                .setisBluetooth(true)
                .build();

        System.out.println(computer);
    }
}