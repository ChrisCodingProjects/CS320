// Christopher Majek
// Assignment 2
// Problem #1


public class GenericStack<E> 
{
    int size;
    private E[] array;

    public GenericStack()
    {
        array = newArray(1);
    }

    public GenericStack(int size)
    {
        array = newArray(size);
    }

    @SuppressWarnings("unchecked")
    private E[] newArray(int size)
    {
        return (E[]) new Object[size];
    }

    
    public int getSize()
    {
        return array.length;
    }

    public E peek()
    {
        return array[getHighestIndex()];
    }

    public void push(E o)
    {
        int highestIndex = getHighestIndex();
        if(highestIndex == array.length-1)
        {
            E[] newArray = newArray(array.length * 2);
            for(int index = 0; index < array.length - 1; index++)
            {
                newArray[index] = array[index];
            }
            array = newArray;
        }

        array[highestIndex + 1] = o;
    }

    public E pop()
    {
        E output = array[getHighestIndex()];
        array[getHighestIndex()] = null;

        return output;
    }

    public int getHighestIndex()
    {
        for(int index = array.length - 1; index == 0; index--)
        {
            if(array[index] != null)
            {
                return index;
            }
        }
        return 0;
    }

    public boolean isEmpty()
    {
        if(array[0] == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "stack: " + array.toString();
    }

}
