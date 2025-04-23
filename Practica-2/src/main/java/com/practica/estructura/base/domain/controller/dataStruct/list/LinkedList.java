package com.practica.estructura.base.domain.controller.dataStruct.list;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> last;
    private Integer length;

    // getter and setter
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer lenth) {
        this.length = lenth;
    }

    public LinkedList() {
        this.head = null;
        this.last = null;
        this.length = 0;
    }

    public Boolean isEmpty() {
        return head == null || length == 0;
    }

    private Node<E> getNode(Integer pos) throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Indice Fuera de rango");
            // System.out.println("lista vacia");
            // return null;
        } else if (pos < 0 || pos >= length) {
            throw new ArrayIndexOutOfBoundsException("Indice Fuera de rango");
            // System.out.println("Fuera de rango");
            // return null;
        } else if (pos == 0) {
            return head;
        } else if ((length.intValue()-1) == pos.intValue()) {
            return last;
        } else {
            Node<E> search = head;
            Integer cont = 0;
            while (cont < pos) {
                search = search.getNext();
                cont++;
            }
            return search;
        }
    }

    private E getDattaFirst() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("La lista esta vacia");
        } else {
            return last.getData();
        }
    }

    public E get(Integer pos) throws ArrayIndexOutOfBoundsException {
        return getNode(pos).getData();
    }

    private void addFirst(E data) {
        if (isEmpty()) {
            Node<E> aux = new Node<>(data);
            head = aux;
            last = aux;
            length++;
        } else {
            Node<E> head_old = head;
            Node<E> aux = new Node<>(data, head_old);
            head = aux;

        }
        length++;
    }

    private void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<E> aux = new Node<>(data);
            last.setNext(aux);
            last = aux;
            length++;
        }
    }

    public void add(E data, Integer pos) throws ArrayIndexOutOfBoundsException {
        if (pos == 0) {
            addFirst(data);
        } else if (length.intValue() == pos.intValue()) {
            addLast(data);
        } else {
            // a b c d f
            // e post 4
            // search_preview = a b c d
            // search = f
            // aux = e f
            // search_preview a b c d e f
            Node<E> search_preview = getNode(pos - 1);
            Node<E> search = getNode(pos);
            Node<E> aux = new Node<>(data, search);
            search_preview.setNext(aux);
            length++;
        }
    }

    public void add(E data) {
        addLast(data);
    }

    public String print() {
        if (isEmpty()) {
            return "La lista esta vacia";

        } else {
            // head = null
            StringBuilder resp = new StringBuilder();
            Node<E> help = head;
            while (help != null) {
                // resp += help.getData() + " -> ;
                resp.append(help.getData()).append(" -> ");
                help = help.getNext();
            }
            resp.append("\n");
            return resp.toString();
        }
    }

    public void update(E data, Integer pos) throws ArrayIndexOutOfBoundsException {
        getNode(pos).setData(data);
    }

    public void clear() {
        head = null;
        last = null;
        length = 0;

    }
    public E deleteFirst () throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("La lista se encuentra vacia");
        } else {
            E data = head.getData();
            Node<E> aux = head.getNext();
            head = aux;
            if (length.intValue() == 1) {
                last = null;
            }
            length--;
            return data;
        }
    }

    public E deleteLast() throws ArrayIndexOutOfBoundsException{
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("La lista se encuentra vacia");
        } else {
            E data = last.getData();
            Node<E> aux = getNode(length - 2);
            if (aux == null) {
                last = null;
                if (length == 2) {
                    last = head;
                } else {
                    head = null;
                }   
            } else {
                last = null;
                last = aux;
                last.setNext(null);
            }
            length --;
            return data;
        }
    }

    public E delete(Integer pos) throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("La lista se encuentra vacia");
        } else if (pos == 0) {
            return deleteFirst();
        } else if (length.intValue() == pos.intValue()) {
            return deleteLast();
        } else {
            Node<E> search_preview = getNode(pos - 1);
            Node<E> search = getNode(pos);
            E data = search_preview.getData();
            Node<E> aux = search.getNext();
            search = null;
            search_preview.setNext(aux);
            length--;
            return data;
        }
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        LinkedList<Double> lista = new LinkedList<>();
        try {
            System.out.println("Hola");
            // lista.update(10.00, 0);

            lista.add(56.7);
            lista.add(65.7);
            lista.add(1.0, 0);
            lista.add(4.7);
            // System.out.println(lista.print());
            lista.add(9.0, 3);
            System.out.println(lista.print());
            System.out.println(lista.get(lista.getLength()-1));
            System.out.println("Actualizar");
            lista.update(10.00, 3);
            System.out.println(lista.print());

        } catch (Exception e) {
            System.out.println("Error: " + e);
            // TODO: handle exception
        }
        System.out.println(lista.print());
        System.out.println("Final");
    }

}