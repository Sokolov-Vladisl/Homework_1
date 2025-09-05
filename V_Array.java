import java.util.Collection;
import java.util.List;

public class V_Array<T> {
    T[] data;
    int capacity=0;
    int size;

    V_Array(){
        size=1;
        data = (T[]) new Object[size];
    }

    public static void main(String[] args){

        V_Array<String> A = new V_Array<>();
        A.add(0,"pablo");
        A.add(1,"picasso");
        A.add(1,"pablo");
        A.add(8,"again");
        //A.remove(1);
        //A.remove(2);
        //A.remove(2);
        //A.set(3,"I'm right behind you");
        //Collection<String> ava = List.of("-_-_-_-_-_-_-_","Change", "the", "world", "-_-_-_-_-_-_-_");
        //A.addAll(2,ava);
        A.show();

    }

    void resize(){
        T[] newdata=(T[]) new Object[size+1];

        for(int i=0; i< size;i++)
        {
            newdata[i]=data[i];
        }
        size+=1;
        data = newdata;
    }

    boolean is_overloaded(){
        if(capacity==size) return true;
        else return false;
    }

    void add(int index, T value){
        if( index<0) return;
        if(index>=size){
            T[] newdata=(T[]) new Object[index+1];
            for(int j=0; j<size;j++)
            {
                newdata[j]=data[j];
            }
            newdata[index]=value;
            size=index+1;
            capacity=index;
            data=newdata;
            return;
        }
        T[] newdata=(T[]) new Object[size+1];

        for(int j=index; j<size;j++)
        {
            newdata[j+1]=data[j];
        }
        newdata[index]=value;
        for(int j=0; j<index;j++)
        {
            newdata[j]=data[j];
        }
        data=newdata;
        size++;
        capacity++;
    }

    void remove(int index){
        if(index>=size || index<0) return;

        T[] newdata=(T[]) new Object[size-1];

        for(int j=index; j<size-1;j++)
        {
            newdata[j]=data[j+1];
        }
        for(int j=0; j<index;j++)
        {
            newdata[j]=data[j];
        }
        data=newdata;
        size--;
        capacity--;
    }

    void show(){
        for(int i=0;i<size;i++)
        {
            System.out.println(data[i]);
        }
    }


    T get(int index){
        return data[index];
    }

    void set(int index, T value) {
        if(index<0) return;
        if(index>=size) {
            this.add(index,value);
            return;
        }
        data[index]=value;
    }

    void addAll(int ind, Collection<T> mass){
        for (T j : mass){
            this.add(ind++,j);
        }
        capacity+=mass.size();
    }



}
