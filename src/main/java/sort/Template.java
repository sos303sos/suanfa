package sort;

import org.apache.commons.lang.StringUtils;

import java.util.stream.Stream;

public abstract class Template {
    protected Comparable[] data;
    private boolean isDebug=false;

    public Template(Comparable[] data) {
        this.data = data;
    }

    public abstract void sort();

    /**
     * a=1 b=2 true
     * a=1 b=1 false
     * a=1 b=0 false
     *
     * @param a
     * @param b
     * @return
     */
    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    protected boolean lessEqual(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    protected void exch(int i, int j) {
        Comparable t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    protected void show() {
        System.out.println("OriginData:"+ StringUtils.join(data,","));
    }

    protected boolean isSorted() {
        for (int i = 1; i < data.length; i++) {
            if (less(data[i], data[i - 1]))
                return false;
        }
        return true;
    }

    public static int ceilChu(int a, int b) {
        return (int) Math.ceil(Double.valueOf(a) / b);
    }

    public static void main(String[] args) {
        System.out.println(ceilChu(9, 2));
    }

    public void openDebug() {
        isDebug = true;
    }

    public void closeDebug() {
        isDebug = false;
    }

    public boolean isOpenDebug() {
        return isDebug;
    }

}
