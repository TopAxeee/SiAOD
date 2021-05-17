package Ex2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Handler;

public class Rehash3 {//хэш-таблица, которая записывает получившееся значение в ближайшую пустую клетку
    static class Item{
        //класс, описывающий элемнет таблицы - строки, ссылки
        private int key;
        public Item (int key){
            this.key=key;
        }
        public int getKey(){
            return key;
        }
        public void setKey(int key){
            this.key = key;
        }
    }
    static class HashTable{ //класс - Хэштаблица
        static Item[] table;//массив для хронениея элементов
        static int size;//размер таблицы
        public HashTable(int size){ //конструктор хэш-таблицы
            this.size=size;
            table = new Item[size];
        }
        public static int Hash(int key){
            return (key*2/17);
        }

        public static void Insert (int key){//добавление элемента в хэштаблицу
            Item item = new Item(key);
            int hash = Hash(key);
            while(table[hash]!=null){
                hash++;
                hash%=size;
            }
            table [hash]=item;
        }
        public static void Print(){//вывод таблицы на экран
            for (int i=0;i<size;i++)
                if (table[i]!=null) {
                    System.out.println(i + " " + table[i].getKey());
                }
        }
        public static String Find (int key){
            int hash=Hash(key);
            while (table[hash]!=null){
                if (table[hash].getKey()==key)
                    return "Элемент найден! Его индекс: "+hash;
                hash++;
                hash%=size;
            }
            return "Элемент не найден";
        }
        public static void Delete (int key){//добавление элемента в хэштаблицу
            int hash=Hash(key);
            while (table[hash]!=null) {
                if (table[hash].getKey() == key)
                    table[hash] = null;
                hash++;
                hash %= size;
            }
        }
    }


    public static void main (String [] arg){
        System.out.println("Get in array size:");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashTable ht = new HashTable(n*2);//текущий класс - класс хэштаблицы
        for (int i=0;i<n;i++){
            ht.Insert((int)(Math.random()*100));
        }
        ht.Print();
        System.out.println("Get search:");
        int search = s.nextInt();
        System.out.println(ht.Find(search));
        System.out.println("Get delete:");
        search = s.nextInt();
        ht.Delete(search);
        ht.Print();
    }

}

