import static java.io.IO.println;

public class V_mass<T>{
    T[] data;
    int capacity=0;
    int size;

    V_mass(){
        size=1;
        data = (T[]) new Object[size];
    }

    public static void main(String[] args){

        V_mass<String> A = new V_mass<>();
        A.add("pablo");
        A.add("picasso");
        A.add("pablo");
        A.add("again");
        A.remove("again");
        A.remove("pablo");
        A.remove("picasso");
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

    boolean add(T value){
        for (int i=0;i<capacity;i++) {
            if(data[i]==value) return false;
        }
        if(is_overloaded()) resize();
        data[capacity++]=value;
        return true;
    }

    void remove(T value){
        for(int i=0; i<size;i++)
        {
            if(data[i]==value){
                T[] newdata=(T[]) new Object[size-1];

                data[i]=data[capacity-1];

                for(int j=0; j<size-1;j++)
                {
                    newdata[j]=data[j];
                }
                data=newdata;
                size--;
                capacity--;
                return;
            }
        }
    }

    void show(){
        for(int i=0;i<size;i++)
        {
            System.out.println(data[i]);
        }
    }

}
