package sort;

/**
 * 插入排序
 * 平均：n*n/4次比较 n*n/4次排序
 * 最坏：n*n/2次比较 n*n/2次排序
 * 最好：n-1次比较，0次交换
 */
public class Insertion extends Template {
    public Insertion(Comparable[] data) {
        super(data);
    }

    @Override
    public void sort() {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j >=1 ; j--) {
                if(less(data[j],data[j-1]))
                    exch(j,j-1);
                else
                    continue;
            }
        }

    }
}
