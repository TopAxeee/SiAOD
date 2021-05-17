package Ex2;

import java.util.ArrayList;
import java.util.Scanner;
// Класс для представления всей хеш-таблицы
class Map<K, V> {
    // узел цепей
    static class HashNode<K, V> {

        K key;
        V value;
        HashNode<K, V> next;// Ссылка на следующий узел

        public HashNode(K key, V value)// Конструктор
        {
            this.key = key;
        }
    }

    private ArrayList<HashNode<K, V>> bucketArray;// bucketArray используется для хранения массива цепочек
    private int numBuckets;// Текущая емкость списка массивов
    private int size;// Текущий размер списка массивов

    public Map(int numBuckets) {// Конструктор (Инициализирует емкость, размер и пустые цепочки.
        bucketArray = new ArrayList<>();
        this.numBuckets = numBuckets;
        size = 0;
        // Создать пустые цепочки
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {// Реализует хеш-функцию для поиска индекса для ключа
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;

    }

    public V remove(K key) {// Метод для удаления данного ключа
        int bucketIndex = getBucketIndex(key);// Применяем хеш-функцию для поиска индекса для данного ключа
        HashNode<K, V> head = bucketArray.get(bucketIndex);// Получить голову цепи
        HashNode<K, V> prev = null;// Поиск ключа в его цепочке
        while (head != null) {
            if (head.key.equals(key))// если ключ найден
                break;
            // Остальное продолжаем двигаться по цепочке
            prev = head;
            head = head.next;
        }
        if (head == null)// Если ключа там не было
            return null;
        size--;// Уменьшаем размер
        if (prev != null) {// Удалить ключ
            prev.next = head.next;
        }else{
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }

    public V get(K key) {// Возвращает значение для ключа
        int bucketIndex = getBucketIndex(key);// Найти начало цепочки для данного ключа
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {// Поиск ключа в цепочке
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;// Если ключ не найден
    }

    public void add(K key, V value) {// Добавляет пару ключ-значение в хеш
        int bucketIndex = getBucketIndex(key);// Найти начало цепочки для данного ключа
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {// Проверяем, присутствует ли ключ
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // Вставляем ключ в цепочку
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        if ((1.0 * size) / numBuckets >= 0.7) {// Если коэффициент загрузки превышает пороговое значение,
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;//то размер двойного хеш-таблицы
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public static void main(String[] args) {

        Map<String, Integer>map = new Map<>(4);

        map.add("this",1 );

        map.add("coder",2 );

        map.add("this",4 );

        map.add("hi",5 );

        System.out.println(map.size());

        System.out.println(map.remove("this"));

        System.out.println(map.remove("this"));

        System.out.println(map.size());

        System.out.println(map.isEmpty());

    }
}