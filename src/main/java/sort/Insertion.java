package sort;

/**
 * ��������
 * ƽ����n*n/4�αȽ� n*n/4������
 * ���n*n/2�αȽ� n*n/2������
 * ��ã�n-1�αȽϣ�0�ν���
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
