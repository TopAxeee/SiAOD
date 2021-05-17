package Ex1;

import java.util.Scanner;
import java.util.Stack;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
public class B_Tree {

    static Node root;

    //добавление
    public void add(int value) { // Добавление узла
        root = addRecursive(root, value);
    }
    private Node addRecursive(Node current, int value) { //Добаление рекурсии для вставки
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    //удаление
    public void delete(int value) { // Метод удаления
        root = deleteRecursive(root, value);
    }
    private Node deleteRecursive(Node current, int value) {//рекурсивное удаление
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) { // Если нет детей
                return null;
            }
            else if (current.right == null) {// Если есть только левый
                return current.left;
            }

            else if (current.left == null) {// Если есть только правый
                return current.right;
            }

            else { // 2 детя
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    private int findSmallestValue(Node root) { // Поиск замены
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    //поиск
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }
    private boolean containsNodeRecursive(Node current, int value) { // Поиск элемента
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    //вывод дерева
    public void printTree(int n) { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.value+ "  "); // выводим его значение в консоли
                    localStack.push(temp.left); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.right);
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /=2 ;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public static void main (String[] arg){
        B_Tree tree = new B_Tree();
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите количесвто элементов массива:");
        int number = scan.nextInt();
        for (int i=0;i<number;i++){
            tree.add((int)(Math.random()*100));
        }
        // отображение дерева:
        tree.printTree(number);

        System.out.println("Введите искомый элемент:");
        int search = scan.nextInt();
        // находим узел по значению и выводим его в консоли
        long before = System.nanoTime();//засекаем время начала
        tree.containsNode(search);
        long after = System.nanoTime();//засекаем время завершения работы
        //foundNode.printNode();
        System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");

        System.out.println("Для добавления элемента в массив введите новое число:");
        int n_e_w = scan.nextInt();
        tree.add(n_e_w);

        // отображение дерева:
        tree.printTree(number);

        System.out.println("Для удаления элемента из массива введите искомый элемент:");
        n_e_w = scan.nextInt();
        tree.delete(n_e_w);

        // отображение дерева:
        tree.printTree(number);

    }
}