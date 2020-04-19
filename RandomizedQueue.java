import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int N; // next free location

    // construct an empty randomized queue
    public RandomizedQueue() {
        N = 0;
        q = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    private void resize(int capacity) {
        Item[] p = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            p[i] = q[i];
        }
        q = p;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        q[N++] = item;
        if (N == q.length) {
            resize(2 * q.length);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
        int r = StdRandom.uniform(N);
        Item item = q[r];
        q[r] = q[N - 1];
        q[N - 1] = null;
        --N;
        if (N >= 0 && N <= q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
        return q[StdRandom.uniform(N)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RQIterator<Item>();
    }

    private class RQIterator<Item> implements Iterator<Item> {
        private int[] perm;
        private int i;

        RQIterator() {
            i = 0;
            perm = StdRandom.permutation(N);
        }

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            if (N == 0) {
                throw new NoSuchElementException();
            }
            if (i < N) {
                return (Item) q[perm[i++]];
            }
            else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void display(RandomizedQueue<Item> rq) {
        for (Item t : rq) {
            System.out.print(t + "\t");
        }
        System.out.println();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();

        System.out.println("isEmpty() == " + rq.isEmpty());

        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("A");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("B");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("C");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("D");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("E");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("F");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("G");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.enqueue("H");
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        System.out.println("\nsample() = " + rq.sample());

        System.out.println("\nsample() = " + rq.sample());

        System.out.println("\nsample() = " + rq.sample());

        System.out.println("\nsample() = " + rq.sample());

        rq.dequeue();
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.dequeue();
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.dequeue();
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.dequeue();
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        rq.dequeue();
        System.out.println("\nSize = " + rq.size());
        rq.display(rq);

        // rq.dequeue();
        // System.out.println("\nSize = " + rq.size());
        // rq.display(rq);
        //
        // rq.dequeue();
        // System.out.println("\nSize = " + rq.size());
        // rq.display(rq);
        //
        // rq.dequeue();
        // System.out.println("\nSize = " + rq.size());
        // rq.display(rq);

        System.out.println("isEmpty() == " + rq.isEmpty());

        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }

        Iterator<String> itr = rq.iterator();
        while (true) {
            if (itr.hasNext())
                System.out.print(itr.next() + "\t");
            else {
                System.out.print(itr.next() + "\t");
            }
        }

    }

}
