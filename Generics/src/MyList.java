public class MyList<T> {

    private T[] genericArray;
    private int capacity;


    //DEFAULT genericArray LENGTH IS 10
    public MyList() {
        setCapacity(10);
        setGenericArray(new Object[getCapacity()]);
    }

    public MyList(int capacity) {
        setCapacity(capacity);
        setGenericArray(new Object[getCapacity()]);
    }

    //ADDING ONE ELEMENT
    public void add(T element){
        checkCapacity(1);
        getGenericArray()[size()] = element;
    }

    //CAPACITY CONTROL
    public void checkCapacity(int numOfElements){
        if(numOfElements > getAvailableCapacity()){
            doubleCapacity();
            checkCapacity(numOfElements);
        }
    }

    //HOW MANY ELEMENTS AR THERE IN ARRAY
    public int size(){
        int counter = 0;
        for(int i = 0; i<getCapacity();i++){
            if(getGenericArray()[i] != null){
                counter++;
            }
        }return counter;
    }

    //HOW MUCH SPACE IS AVAILABLE
    public int getAvailableCapacity(){
        return getCapacity() - size();
    }

    //DOUBLE THE CAPACITY
    public void doubleCapacity(){
        T[] tempArray = getGenericArray();

        setCapacity(getCapacity()*2);
        setGenericArray(new Object[getCapacity()]);

        int i = 0;
        for(T oldElements : tempArray){
            this.getGenericArray()[i] = oldElements;
            i++;
        }
    }

    //GET VALUE BY INDEX
    public T get(int index){
        if(getGenericArray()[index] == null){
            return null;
        }
        T value = getGenericArray()[index];
        return value;
    }

    //REMOVE THE ELEMENT OF GIVING INDEX AND SHIFT THE ELEMENTS AFTER THE INDEX TO THE LEFT.
    public void remove(int index){

        //If index not empty
        if(getGenericArray()[index] != null){
            //remove
            getGenericArray()[index] = null;

            //shift
            int i;
            for(i = index + 1; i == size(); i++){
                getGenericArray()[i-1] = getGenericArray()[i];
            }
        }

    }

    //SET ELEMENT OF GIVING INDEX WITH GIVING ELEMENT
    public void set(int index, T element){
        //If index not empty
        if(getGenericArray()[index] != null){
            //set
            getGenericArray()[index] = element;

        }
    }

    //LISTING ELEMENTS OF ARRAY
    public String toString(){

        String list = "[";
         for(T element : getGenericArray()){
             if(element != null){
                 list = list + element;
             }else{
                 list = list + "]";
                 break;
             }
         }
         return list;
    }

    //FINDING THE FIRST INDEX VALUE OF AN ELEMENT IN AN ARRAY
    public int indexOf(T element){
        int index = -1;
        for(T i : getGenericArray()){
            index++;
            if(i == element){
                return index;
            }
        }
        return -1;
    }

    //FINDING THE LARGEST INDEX VALUE OF AN ELEMENT IN AN ARRAY
    public int lastIndexOf(T element){
        int index = -1;
        int lastIndex = -1;
        for(T i : getGenericArray()){
            index++;
            if(i == element){
                lastIndex = index;
            }
        }
        return lastIndex;
    }

    //IS ARRAY EMPTY
    public boolean isEmpty(){
        boolean isEmpty = true; //I assumed that it is empty
        for(T element : getGenericArray()){
            if(element != null){
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    //ARRANGES THE ITEMS IN THE LIST INTO AN ARRAY IN THE SAME ORDER
    public T[] toArray(){
        T[] newArray = (T[]) new Object[size()];
        for(int i = 0; i < size(); i++){
            newArray[i] = getGenericArray()[i];
        }
        return newArray;
    }

    //REMOVE ALL ELEMENTS IN THE ARRAY
    public void clear(){
        for(int i = 0; i < size(); i++){
            getGenericArray()[i] = null;
        }
    }

    //RETURNS A LIST OF THE INDEX RANGE GIVEN IN THE PARAMETER
    public MyList<T> subList(int start,int finish){
        //BOUNDS MUST BE BIGGER THAN ZERO
        if(start>=0 && finish>=0){
            //BOUNDS MUST BE SMALLER THAN THE CAPACITY
            if(start<=this.getCapacity() && finish<=this.getCapacity()){
                int size = finish - start + 1;

                MyList<T> myList = new MyList<>(size);
                for(int i = start; i <= finish; i++){
                    myList.add(get(i));
                }
                return myList;
            }

        }return null;

    }

    //RETURNS TURE IF THE VALUE GIVEN IN THE PARAMETER IS IN THE ARRAY
    public boolean contains(T data){
        boolean isContains = false;
        for (int i = 0; i <= size(); i++){
            if(getGenericArray()[i] == data){
                isContains = true;
            }
        }return isContains;
    }


    //GETTERS and SETTERS
    private void setGenericArray(Object[] array){
        this.genericArray = (T[]) array;

    }

    public T[] getGenericArray() {
        return this.genericArray;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
