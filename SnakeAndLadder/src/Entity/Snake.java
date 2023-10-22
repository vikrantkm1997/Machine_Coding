package Entity;

public class Snake {
    private int head;
    private int tail;

    public Snake(int head,int tail)
    {
        this.head = head;
        this.tail = tail;
    }
    int getTail()
    {
        return this.tail;
    }
}
