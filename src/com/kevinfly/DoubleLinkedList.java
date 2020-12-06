package com.kevinfly;

public class DoubleLinkedList
{
    public static void main(String[] args)
    {
        DLinkedListNode<String> lln = new DLinkedListNode<>();
        lln.append("666");
        lln.append("777");
        lln.append("999");
        lln.append("777");
        lln.append("666");
        System.out.println(lln.toString());
        System.out.println(lln.toStringDebug());
        lln.nextT().insert("888");
        System.out.println(lln.toString());
        System.out.println(lln.toStringDebug());
        lln.remove();
        System.out.println(lln.toString());
        System.out.println(lln.toStringDebug());
        lln.remove("777");
        System.out.println(lln.toString());
        System.out.println(lln.toStringDebug());
    }
}

class DLinkedListNode<T>
{
    T data;
    private DLinkedListNode<T> next = null;
    private DLinkedListNode<T> prev = null;

    public DLinkedListNode<T> nextT()
    {
        return next;
    }

    public DLinkedListNode<T> prevT()
    {
        return prev;
    }

    public T getData()
    {
        return data;
    }

    public DLinkedListNode(T data)
    {
        this.data = data;
    }

    public DLinkedListNode()
    {

    }

    public void append(T content)
    {
        DLinkedListNode<T> currentNode = this;
        if (currentNode.data == null)
        {
            currentNode.data = content;
            return;
        }
        while (currentNode.hasNext())
        {
            currentNode = currentNode.next;
        }
        currentNode.next = new DLinkedListNode<>(content);
        currentNode.next.prev = currentNode;
    }

    public boolean hasNext()
    {
        return next != null;
    }

    public boolean hasPrev()
    {
        return prev != null;
    }

    public void remove()
    {
        if (this.prev != null)
        {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
        else
        {
            this.data = this.next.data;
            this.next = this.next.next;
            this.next.prev = this;
        }

    }

    public void remove(T data)
    {
        DLinkedListNode<T> currentNode = this;
        while (true)
        {
            if (currentNode.data.equals(data))
            {
                currentNode.remove();
            }
            if (currentNode.hasNext())
                currentNode = currentNode.next;
            else
                break;
        }
    }

    public void insert(T data)
    {
        DLinkedListNode<T> n = next;
        next = new DLinkedListNode<>(data);
        next.next = n;
        next.prev = this;
        n.prev = next;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        DLinkedListNode<T> currentNode = this;
        sb.append("[").append(currentNode.data);
        while (currentNode.hasNext())
        {
            currentNode = currentNode.next;
            sb.append(", ").append(currentNode.data);
        }
        sb.append("]");
        return sb.toString();
    }

    public String toStringDebug()
    {
        StringBuilder sb = new StringBuilder();
        DLinkedListNode current = this;
        while (true)
        {
            sb.append("<- ").append(returnIfNull(current.prev)).append("\n");
            sb.append(" - ").append(current.data).append("\n");
            sb.append(" -> ").append(returnIfNull(current.next)).append("\n");
            if (current.hasNext())
                current = current.next;
            else
                break;
        }
        return sb.toString();
    }

    private String returnIfNull(DLinkedListNode<T> data)
    {
        if (data == null)
            return "@NULL";
        return data.data.toString();
    }
}