package sort;

import org.apache.commons.lang.StringUtils;

import java.text.MessageFormat;

/**
 * 最简单的归并实现，采用另外开辟空间来实现，效率高多了
 * 排序 nlgn
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
        //假设有9个元素
        int length=data.length;
        int max=(int)Math.ceil(Math.log(length)/Math.log(2));
        for (int i = 0; i < max; i++) {
            //i=0 2个一组
            //i=1 4个一组
            //i=2 8个一组
            //i=3 9个一组
            int halfSize=(int)Math.pow(2,i);
            int size=halfSize*2;
            int innerSize=ceilChu(length,size);
            for (int j = 0; j < innerSize; j++) {
                //2个1组size=2 half=1 [0 1][2 3][4 5][6 7][8]
                //4个1组 [0,1  2,3][4,5 6,7][8]
                //8个1组 [0,1,2,3 4,5,6,7][8]
                //9个1组 [0,1,2,3,4,5,6,7 8]
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
     * 将[i,j]与[j+1,k]合并
     * @param i
     * @param j
     * @param k
     */
    private void merge(int i,int j,int k){
        int length=k-i+1;
        int ii=i;
        int jj=j+1;

        //1.合并
        for (int l = 0; l <length; l++) {
            if((jj>k||data[ii].compareTo(data[jj])<=0)&&ii<=j){
               mergeDatas[l]=data[ii++];
            }else{
                mergeDatas[l]=data[jj++];
            }
        }
        //2.复制
        for (int l = 0; l<length ; l++) {
            data[i+l]=mergeDatas[l];

        }
    }

    public static void main(String[] args) {
        System.out.println(2^0);
    }
}
