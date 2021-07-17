package sort;

public class Shell extends Template{

    public Shell(Comparable[] data) {
        super(data);
    }

    @Override
    public void sort() {
        for (int gap =data.length/2; gap >=1 ; gap=gap/2) {
            for (int i = 0; i < data.length; i++) {
                if(i<gap)
                    continue;
                for (int j = 0; j < i/gap; j++) {
                    if(less(data[i-j*gap],data[i-(j+1)*gap]))
                        exch(i-j*gap,i-(j+1)*gap);
                    else
                        continue;

                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(Double.valueOf(9)/2));
    }
}
