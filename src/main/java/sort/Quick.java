package sort;

import org.apache.commons.lang.StringUtils;

import java.text.MessageFormat;

/**
 * 目前的算法会出现栈溢出的问题，因为递归的深度问题。
 */
public class Quick extends Template {
    public Quick(Comparable[] data) {
        super(data);
    }

    @Override
    public void sort() {
        if (isOpenDebug())
            show();
        sort(0, data.length - 1);
    }

    /**
     * 将data[low,high]进行排序，包含low、high
     *
     * @param low
     * @param high
     */
    private void sort(int low, int high) {
        if(low>=high){
            return;
        }
        if (low == high)
            return;
        int length = high - low + 1;
        Comparable targerData = data[low];
        int ll = low , hh = high, targerIndex = low;
        boolean isFromHigh = true;
        for (int i = 0; i < length; i++) {
            if(ll==hh){
                data[ll]=targerData;
            }
            if(isFromHigh){
                if(lessEqual(targerData,data[hh])){
                    hh--;
                    continue;
                }else{
                    isFromHigh=false;
                    data[targerIndex]=data[hh];
                    ll++;
                    targerIndex=hh;
                }

            }else{
                if(lessEqual(data[ll],targerData)){
                    ll++;
                    continue;
                }else{
                    isFromHigh=true;
                    data[targerIndex]=data[ll];
                    hh--;
                    targerIndex=ll;
                }
            }
        }
        if (isOpenDebug())
            System.out.println(
                    MessageFormat.format(
                            "targerIndex:{0},targerData:{4},,low:{1},high:{2},data:{3}"
                            , targerIndex, low, high, StringUtils.join(data, ","), targerData));
        sort(low,targerIndex-1);
        sort(targerIndex+1,high);
    }
}
