package lab04;

import java.util.LinkedList;
import java.util.EmptyStackException;

public class Pila<T> {
    private final LinkedList<T> elementos;

    public Pila() {
        elementos = new LinkedList<>();
    }

    public void push(T elemento) {
        elementos.addFirst(elemento);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.getFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}

