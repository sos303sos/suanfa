package sort;

import org.apache.commons.lang.StringUtils;

import java.text.MessageFormat;

/**
 * ��򵥵Ĺ鲢ʵ�֣��������⿪�ٿռ���ʵ�֣�Ч�ʸ߶���
 * ���� nlgn
 */
public class MergeCopy extends Template {
    private Comparable[] mergeDatas;
    public MergeCopy(Comparable[] data) {
        super(data);
        mergeDatas=new Comparable[data.length];
    }

    @Override
    public void sort() {
        if(isOpenDebug()){
            System.out.println("OriginData:"+StringUtils.join(data,","));
        }
        //������9��Ԫ��
        int length=data.length;
        int max=(int)Math.ceil(Math.log(length)/Math.log(2));
        for (int i = 0; i < max; i++) {
            //i=0 2��һ��
            //i=1 4��һ��
            //i=2 8��һ��
            //i=3 9��һ��
            int halfSize=(int)Math.pow(2,i);
            int size=halfSize*2;
            int innerSize=ceilChu(length,size);
            for (int j = 0; j < innerSize; j++) {
                //2��1��size=2 half=1 [0 1][2 3][4 5][6 7][8]
                //4��1�� [0,1  2,3][4,5 6,7][8]
                //8��1�� [0,1,2,3 4,5,6,7][8]
                //9��1�� [0,1,2,3,4,5,6,7 8]
                //0 001 1 223 2 445
                //0 013 457 888
                //0
                merge(size*j,size*j+halfSize-1,size*(j+1)-1>length-1?length-1:size*(j+1)-1);
            }
            if(isOpenDebug()){
               System.out.println(MessageFormat.format("i:{0},size:{2},data:{1}",i, StringUtils.join(data,","),size));
            }
        }
    }


    /**
     * ��[i,j]��[j+1,k]�ϲ�
     * @param i
     * @param j
     * @param k
     */
    private void merge(int i,int j,int k){
        int length=k-i+1;
        int ii=i;
        int jj=j+1;

        //1.�ϲ�
        for (int l = 0; l <length; l++) {
            if((jj>k||data[ii].compareTo(data[jj])<=0)&&ii<=j){
               mergeDatas[l]=data[ii++];
            }else{
                mergeDatas[l]=data[jj++];
            }
        }
        //2.����
        for (int l = 0; l<length ; l++) {
            data[i+l]=mergeDatas[l];

        }
    }

    public static void main(String[] args) {
        System.out.println(2^0);
    }
}
