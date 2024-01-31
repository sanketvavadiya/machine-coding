package Cache;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = 10;
        LRUCache cache = new LRUCache(capacity);
        String [] operations = "put,put,put,put,put,get,put,get,get,put,get,put,put,put,get,put,get,get,get,get,put,put,get,get,get,put,put,get,put,get,put,get,get,get,put,put,put,get,put,get,get,put,put,get,put,put,put,put,get,put,put,get,put,put,get,put,put,put,put,put,get,put,put,get,put,get,get,get,put,get,get,put,put,put,put,get,put,put,put,put,get,get,get,put,put,put,get,put,put,put,get,put,put,put,get,get,get,put,put,put,put,get,put,put,put,put,put,put,put".split(",");
//        String operations[] = "put,put,put,put,get,get,get,get,put,get,get,get,get,get".split(",");
        int [][] values = {{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};
//        int [][] values = {{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},{1},{2},{3},{4},{5}};

        for (int i=0 ; i<operations.length ; i++) {
            if(operations[i].equals("put")) {
                System.out.println("calling for: " + values[i][0] + ", " + values[i][1]);
                cache.put(values[i][0], values[i][1]);
            }
            else
                System.out.println("Get" + values[i][0] + ": " + cache.get(values[i][0]));
        }

        /*while (true) {
            System.out.print("Operation: ");
            char operation = sc.nextLine().charAt(0);
            switch (operation) {
                case 'p':
                    System.out.print("Put: ");
                    String[] key_val = sc.nextLine().split(" ");
                    int key = Integer.parseInt(key_val[0]);
                    int val = Integer.parseInt(key_val[1]);
                    cache.put(key, val);
                    break;
                case 'g':
                    System.out.print("Get: ");
                    String get_key = sc.nextLine();
                    int key1 = Integer.parseInt(get_key);
                    System.out.println("Get output: " + cache.get(key1));
            }
        }*/
    }
}
