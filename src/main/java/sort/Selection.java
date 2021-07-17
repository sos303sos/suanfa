package sort;

/**
 * ѡ������
 * n*n/2�Ƚ� n�ν���
 * 1.����ʱ��������޹�
 * 2.�����ƶ������ٵ�
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
