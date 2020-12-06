package com.kevinfly;

public class SingleLinkedList
{
    public static void main(String[] args)
    {
        LinkedListNode<String> lln = new LinkedListNode<>();
        lln.append("666");
        lln.append("777");
        lln.append("999");
        lln.append("777");
        lln.append("666");
        System.out.println(lln.toString());
        lln.nextT().insert("888");
        System.out.println(lln.toString());
        lln.remove();
        System.out.println(lln.toString());
        lln.remove("777");
        System.out.println(lln.toString());
    }
}

class LinkedListNode<T>
{
    T data;
    private LinkedListNode<T> next;

    public LinkedListNode<T> nextT()
    {
        return next;
    }

    public T getData()
    {
        return data;
    }

    public LinkedListNode(T data)
    {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode()
    {
        this.data = null;
        this.next = null;
    }

    public void append(T content)
    {
        LinkedListNode<T> currentNode = this;
        if (currentNode.data == null)
        {
            currentNode.data = content;
            return;
        }
        while (currentNode.hasNext())
        {
            currentNode = currentNode.next;
        }
        currentNode.next = new LinkedListNode<>(content);
    }

    public boolean hasNext()
    {
        return next != null;
    }

    public void remove()
    {
        this.data = next.data;
        this.next = next.next;
    }

    public void remove(T data)
    {
        LinkedListNode<T> currentNode = this;
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
        LinkedListNode<T> n = next;
        next = new LinkedListNode<>(data);
        next.next = n;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        LinkedListNode<T> currentNode = this;
        sb.append("[").append(currentNode.data);
        while (currentNode.hasNext())
        {
            currentNode = currentNode.next;
            sb.append(", ").append(currentNode.data);
        }
        sb.append("]");
        return sb.toString();
    }
}