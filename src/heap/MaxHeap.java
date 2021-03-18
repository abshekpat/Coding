package heap;

public class MaxHeap {
    private int Heap[];
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize+1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos)
    {
        return pos/2;
    }

    private int leftchild(int pos)
    {
        return pos*2;
    }

    private int rightchild(int pos)
    {
        return (pos*2)+1;
    }

    private boolean isLeaf(int pos)
    {
        if(pos >= size/2 && pos <= size )
            return true;
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int temp;
        temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if(Heap[pos] < Heap[leftchild(pos)] || Heap[pos] < Heap[rightchild(pos)])
        {
            if(Heap[leftchild(pos)] > Heap[rightchild(pos)])
            {
                swap(pos, leftchild(pos));
                maxHeapify(leftchild(pos));
            }
            else
            {
                swap(pos, rightchild(pos));
                maxHeapify(rightchild(pos));
            }
        }
    }



    public void print()
    {
        for(int i=1;i<=size/2;i++)
        {
            System.out.println("PARENT : "+Heap[i]+" LEFT CHILD : "+Heap[leftchild(i)]+" RIGHT CHILD : "+Heap[rightchild(i)]);
        }
    }

    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
        while(Heap[current] > Heap[parent(current)])
        {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());
    }

}
