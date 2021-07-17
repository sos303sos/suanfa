package sort;

import java.util.stream.Stream;

public abstract class Template {
    protected Comparable[] data;
    public Template(Comparable[] data){
        this.data=data;
    }
    public abstract void sort();

    /**
     * a=1 b=2 true
     * a=1 b=1 false
     * a=1 b=0 false
     * @param a
     * @param b
     * @return
     */
    protected  boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    protected void exch(int i,int j){
        Comparable t=data[i];
        data[i]=data[j];
        data[j]=t;
    }
    protected void show(){
        Stream
                .of(data)
                .map(t->t+" ")
                .forEach(System.out::println);
        System.out.println();
    }
    protected boolean isSorted(){
        for (int i = 1; i < data.length; i++) {
            if(less(data[i],data[i-1]))
                return false;
        }
        return true;
    }


}
