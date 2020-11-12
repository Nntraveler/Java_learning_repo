package lecture_practice.lec_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack {
    List<Integer> integerList = new ArrayList<>();
    int index = 0;

    public int pop(){
        if(integerList.isEmpty()){
            return -1;
        }
        --index;
        return integerList.remove(index);
    }

    public void push(int num){
        integerList.add(num);
        ++index;
    }

    public int size(){
        return integerList.size();
    }

    public void clear(){
        index = 0;
        integerList.clear();
    }

    public StackIterator getIterator(){
        return new StackIterator();
    }

    public class StackIterator {
        int cursor;

        public StackIterator() {
            this.reset();
        }

        public void reset(){
            cursor = integerList.size();
        }

        public boolean hasNext() {
            return !integerList.isEmpty() && cursor > 0;
        }

        public Object next() {
            if(!this.hasNext()){
                return null;
            }
            cursor -= 1;
            return integerList.get(cursor);
        }
    }

}
