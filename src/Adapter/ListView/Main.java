package Adapter.ListView;

import java.util.List;

class ListView {
    interface Adapter {
        int arrayLenght();
        String valor(int i);
    }
    void show(Adapter adapter){
        for (int i = 0; i < adapter.arrayLenght(); i++) {
            System.out.println(adapter.valor(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> items = List.of("Java","Python","Javascript","C#", "C++", "TypeScript", "PHP");

        ListView listView = new ListView();

        listView.show(new ListView.Adapter() {
            @Override
            public int arrayLenght() {
                return items.size();
            }

            @Override
            public String valor(int i) {
                return items.get(i);
            }
        });
    }
}
