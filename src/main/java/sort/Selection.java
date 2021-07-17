package sort;

/**
 * 选择排序
 * n*n/2比较 n次交换
 * 1.运行时间和输入无关
 * 2.数据移动是最少的
 */
public class Selection extends Template {
    public Selection(Comparable[] data) {
        super(data);
    }

    @Override
    public void sort() {
        for (int i = 0; i < data.length-1; i++) {
            Comparable min=data[i];
            for (int j = i+1; j < data.length; j++) {
                if(less(data[j],min))
                    min=data[j];
            }
            data[i]=min;
        }
    }
}
