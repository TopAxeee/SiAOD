package Ex1;

import java.util.Stack;
import java.util.Scanner;

class Binary_tree {

    public static class Node {
        private int value; // ключ узла
        private Node leftChild; // Левый узел потомок
        private Node rightChild; // Правый узел потомок

        public void printNode() { // Вывод значения узла в консоль
            System.out.println(" Выбранный узел имеет значение :" + value);
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(final Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(final Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }//класс узлов. Хранит и передает значения узлов
    static class Tree {//класс со всеми методами
        private Node rootNode; // корневой узел

        public Tree() { // Пустое дерево, констурктор класса
            rootNode = null;
        }

        public Node findNodeByValue(int value) { // поиск узла по значению
            Node currentNode = rootNode; // начинаем поиск с корневого узла
            while (currentNode.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
                if (value < currentNode.getValue()) { // движение влево?
                    currentNode = currentNode.getLeftChild();
                } else { //движение вправо
                    currentNode = currentNode.getRightChild();
                }
                if (currentNode == null) { // если потомка нет,
                    return null; // возвращаем null
                }
            }
            return currentNode; // возвращаем найденный элемент
        }

        public void insertNode(int value) { // метод вставки нового элемента
            Node newNode = new Node(); // создание нового узла
            newNode.setValue(value); // вставка данных
            if (rootNode == null) { // если корневой узел не существует
                rootNode = newNode;// то новый элемент и есть корневой узел
            } else { // корневой узел занят
                Node currentNode = rootNode; // начинаем с корневого узла
                Node parentNode;
                while (true) // мы имеем внутренний выход из цикла
                {
                    parentNode = currentNode;
                    if (value == currentNode.getValue()) {   // если такой элемент в дереве уже есть, не сохраняем его
                        return;    // просто выходим из метода
                    } else if (value < currentNode.getValue()) {   // движение влево?
                        currentNode = currentNode.getLeftChild();
                        if (currentNode == null) { // если был достигнут конец цепочки,
                            parentNode.setLeftChild(newNode); //  то вставить слева и выйти из методы
                            return;
                        }
                    } else { // Или направо?
                        currentNode = currentNode.getRightChild();
                        if (currentNode == null) { // если был достигнут конец цепочки,
                            parentNode.setRightChild(newNode);  //то вставить справа
                            return; // и выйти
                        }
                    }
                }
            }
        }//Добавление нового элемента

        public boolean deleteNode(int value) // Удаление узла с заданным ключом
        {
            Node currentNode = rootNode;
            Node parentNode = rootNode;
            boolean isLeftChild = true;
            while (currentNode.getValue() != value) { // начинаем поиск узла
                parentNode = currentNode;
                if (value < currentNode.getValue()) { // Определяем, нужно ли движение влево?
                    isLeftChild = true;
                    currentNode = currentNode.getLeftChild();
                } else { // или движение вправо?
                    isLeftChild = false;
                    currentNode = currentNode.getRightChild();
                }
                if (currentNode == null)
                    return false; // yзел не найден
            }
            //Если нет потомков
            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                if (currentNode == rootNode)
                    rootNode = null;//удалем узел
                else if (isLeftChild)
                    parentNode.setLeftChild(null); //удалем узел
                else
                    parentNode.setRightChild(null);//удалем узел

            // если правого потомка нет
            } else if (currentNode.getRightChild() == null) {
                if (currentNode == rootNode)
                    rootNode = currentNode.getLeftChild();//узел заменяется левым поддеревом
                else if (isLeftChild)
                    parentNode.setLeftChild(currentNode.getLeftChild());//узел заменяется левым поддеревом
                else
                    parentNode.setRightChild(currentNode.getLeftChild());//узел заменяется левым поддеревом
            //если левого потомка нет
            } else if (currentNode.getLeftChild() == null) {
                if (currentNode == rootNode)
                    rootNode = currentNode.getRightChild();// узел заменяется правым поддеревом
                else if (isLeftChild)
                    parentNode.setLeftChild(currentNode.getRightChild());// узел заменяется правым поддеревом
                else
                    parentNode.setRightChild(currentNode.getRightChild());// узел заменяется правым поддеревом
            // если есть два потомка
            } else {
                Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
                if (currentNode == rootNode)
                    rootNode = heir;
                else if (isLeftChild)
                    parentNode.setLeftChild(heir);
                else
                    parentNode.setRightChild(heir);
            }
            return true; // элемент успешно удалён
        }

        // метод возвращает узел со следующим значением после передаваемого аргументом.
        // для этого он сначала переходим к правому потомку, а затем
        // отслеживаем цепочку левых потомков этого узла.
        private Node receiveHeir(Node node) {//поиск преемника
            Node parentNode = node;
            Node heirNode = node;
            Node currentNode = node.getRightChild(); // Переход к правому потомку
            while (currentNode != null) // Пока остаются левые потомки
            {
                parentNode = heirNode;// потомка задаём как текущий узел
                heirNode = currentNode;
                currentNode = currentNode.getLeftChild(); // переход к левому потомку
            }
            // Если преемник не является
            if (heirNode != node.getRightChild()) // правым потомком,
            { // создать связи между узлами
                parentNode.setLeftChild(heirNode.getRightChild());
                heirNode.setRightChild(node.getRightChild());
            }
            return heirNode;// возвращаем преемника
        }

        public void printTree() { // метод для вывода дерева в консоль
            Stack globalStack = new Stack(); // общий стек для значений дерева
            globalStack.push(rootNode);
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
                        System.out.print(temp.getValue()); // выводим его значение в консоли
                        localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                        localStack.push(temp.getRightChild());
                        if (temp.getLeftChild() != null ||
                                temp.getRightChild() != null)
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
                gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
                while (localStack.isEmpty() == false)
                    globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
            }
            System.out.println(separator);// подводим черту
        }
    }
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        Tree tree = new Tree();//создаем новое дерево
        //количесвто элементов в массиве
        System.out.println("Введите количесвто элементов массива:");
        int number = scan.nextInt();
        // вставляем узлы в дерево:
        for (int i=0;i<number;i++){
            tree.insertNode((int)(Math.random()*100));
        }
        // отображение дерева:
        tree.printTree();

        //вызываем поиск
        System.out.println("Введите искомый элемент:");
        int search = scan.nextInt();
        // находим узел по значению и выводим его в консоли
        long before = System.nanoTime();//засекаем время начала
        Node foundNode = tree.findNodeByValue(search);
        long after = System.nanoTime();//засекаем время завершения работы
        foundNode.printNode();
        System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");

        System.out.println("Для добавления элемента в массив введите новое число:");
        int n_e_w = scan.nextInt();
        tree.insertNode(n_e_w);

        // отображение дерева:
        tree.printTree();

        System.out.println("Для удаления элемента из массива введите искомый элемент:");
        n_e_w = scan.nextInt();
        tree.deleteNode(n_e_w);

        // отображение дерева:
        tree.printTree();
    }


}
