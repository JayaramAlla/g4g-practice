package OwnDataStructures;

import java.util.Arrays;

public class OwnStringBuilder {
    /*
     * created by Jayaram on 07/07/19
     */



    char[] strings = new char[1000];
    int count = 0;

    public void append(String value) {
        ensureCapacity(count + value.length());
        System.arraycopy(value,0,strings,count,value.length());
        count += value.length();
    }

    public void append(char[] value) {
        ensureCapacity(count + value.length);
        System.arraycopy(value,0,strings,count,value.length);
        count += value.length;
    }

    public String toString() {
        return strings.toString();
    }

    public void ensureCapacity(int minCapacity){
        if(minCapacity > strings.length){
            expandCapacity(minCapacity);
        }
    }

    void expandCapacity(int minimumCapacity) {
        int newCapacity = strings.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0)
            newCapacity = minimumCapacity;
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        strings = Arrays.copyOf(strings, newCapacity);
    }

}
