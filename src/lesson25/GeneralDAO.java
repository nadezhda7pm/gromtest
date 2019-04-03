package lesson25;

import java.util.Arrays;

public class GeneralDAO<T> {
    @SuppressWarnings("unchecked")
private T[] array = (T[]) new Object[10];


    private void print(Order order){
        System.out.println("order is:" + order.toString());

    }

    public T save(T t)  throws Exception{
        if (t == null)
            throw new Exception("null can't be save");

        for(T el : array) {
            if (el != null && el.equals(t))
                throw new Exception("such element already exists");
        }

        int count = 0;
        for (T el : array){
            if (el == null)
                count++;
        }
        if (count < 1)
            throw new Exception("the array is full");


        int index = 0;
        for (T el : array){
            if (el == null){
                array[index] = t;
                break;
            }index++;
        }

        return array[index];
    }


//    public <T extends IdEntity> void validate(T t) throws Exception{
//        if(t.getId() <= 0)
//            throw new Exception("id cannot be negative");
//    }

    public <K> void validate(K k){
        if (k.equals(100))
            System.out.println("true");
        else
            System.out.println("false");
    }

    public T[] getAll() {
        return array;
    }

    @Override
    public String toString() {
        return "GeneralDAO{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
