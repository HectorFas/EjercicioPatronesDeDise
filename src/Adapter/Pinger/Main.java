package Adapter.Pinger;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

class Pinger {
    interface Adapter {
        int ipsLenght();
        String ip(int i);
        boolean stop();
    }

    void ping(Adapter adapter) {
        for (int i = 0; i < adapter.ipsLenght(); i++) {
            try {
                if (InetAddress.getByName(adapter.ip(i)).isReachable(500)) {
                    System.out.println(adapter.ip(i) + " is online");
                    if (adapter.stop()) break;
                } else {
                    System.out.println(adapter.ip(i) + " is down");
                }
            } catch (IOException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pinger pinger = new Pinger();

        pinger.ping(new Pinger.Adapter() {
            @Override
            public int ipsLenght() {
                return 254;
            }

            @Override
            public String ip(int i) {
                return "10.2.1." + (i+1);
            }

            @Override
            public boolean stop() {
                return false;
            }
        });
    }
}