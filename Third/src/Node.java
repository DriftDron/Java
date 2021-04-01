import java.util.Comparator;

public class Node<Key, Val> {
    private Key key;
    private Val value;
    private Node<Key, Val> left;
    private Node<Key, Val> right;
    private int height;

    Node(Key key, Val data) {
        this.value = data;
        this.key = key;
        this.right = null;
        this.left = null;
        this.height = 1;
    }

    public void newvalue(Val newval) {
        this.value = newval;
    }

    public void newheight(int newheight) {
        this.height = newheight;
    }

    public void newleft(Node<Key, Val> newleft) {
        this.left = newleft;
    }

    public void newright(Node<Key, Val> newright) {
        this.right = newright;
    }

    public int getHeight() {
        return this.height;
    }

    public Val getVal() {
        return this.value;
    }

    public Key getKey() {
        return this.key;
    }

    public Node<Key, Val> getLeft() {
        return this.left;
    }

    public Node<Key, Val> getRight() {
        return this.right;
    }

    public int compareTo(Key val1) {
        Comparator<Key> comp = new Comparator<Key>() {
            @Override
            public int compare(Key o1, Key o2) {
                try {
                    Comparable val1 = (Comparable) o1;
                    Comparable val2 = (Comparable) o2;
                    return val1.compareTo(val2);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return comp.compare(val1, this.key);
    }
}