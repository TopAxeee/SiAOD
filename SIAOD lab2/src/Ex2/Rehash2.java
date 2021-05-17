package Ex2;

import java.util.HashMap;
import java.util.Scanner;

public class Rehash2 {
        static HashMap<Integer,Integer> hm = new HashMap<>();
        static int n;
        public static void main (String[] args){
            //создаем хэшкарту Ключ-значение, где ключ - это код, а значение это исходное число
            Scanner s = new Scanner(System.in);
            System.out.println("Get in number of elements:");
            n = s.nextInt();
            int [] arr = new int [n];
            for (int i=0;i<n;i++){
                arr[i] = (int)(Math.random()*100);
            }
            for (int i=0;i<n;i++){
                Add(arr[i]);
            }
            System.out.println("Format Hashcode - Number");
            System.out.println(hm);
            System.out.println("Get in new element:");
            int n_el = s.nextInt();
            Add(n_el);
            System.out.println(hm);
            System.out.println("Element for deleting?");
            n_el=s.nextInt();
            Delete(n_el);
        }
        public static int Hash(int key) {//метод хеширования
            int ret = (key*3)%102;
            return ret;
        }
        public static void Add(int key) {//метод добавляения нового числа
            int k= key;
            while (hm.containsKey(Hash(key))==true||hm.get(Hash(key))!=null){
                key=Hash(key);
            }hm.put(Hash(key),k);
        }
        public static void Delete(int key){//метод удаления числа, но не хэша
            if(hm.containsKey(Hash(key))==false) {
                System.out.println("No Element");
            }else{
                hm.put(Hash(key),null);
                System.out.println("Elemet is delete"+hm);
            }
        }
}
