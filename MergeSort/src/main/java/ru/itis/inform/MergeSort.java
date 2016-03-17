package ru.itis.inform;

/**
 * Created by Nurami on 14.03.2016.
 */
public class MergeSort <T> {
    public LinkedList<T> mergeSort (LinkedList element){
        ArrayList<LinkedList> stack = new ArrayList<LinkedList>();
        LinkedList result = new LinkedList();
        Iterator it = element.iterator();
        LinkedList el= new LinkedList();
        el.addEnd(it.pickNext());
        int number=1;
        stack.add(0, el);
        it.next();
        while (it.hasNext()) {
            int k=0;
            LinkedList list = new LinkedList();
            list.addEnd(it.pickNext());
            stack.add(number, list);

            for (int i=number; i>0; i--){
                if (stack.get(i).getCount()==stack.get(i-1).getCount()){
                    result = result.merge(stack.get(i), stack.get(i-1));
                    stack.add(i-1, result);
                    k++;
                }
            }
            it.next();
            number++;
            number = number-k;
        }

        for (int i=number-1; i>0; i--) {
            result = result.merge(stack.get(i), stack.get(i - 1));
            stack.add(i - 1, result);
        }

        return stack.get(0);
    }
}

