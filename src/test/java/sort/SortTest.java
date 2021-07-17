package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;

public class SortTest {
    /**
     * @param size 总数量
     * @param type 1 从1～size
     *             2 从size～1
     *             3 随机不重复
     *             4 随机重复
     * @return
     */
    public static Comparable[] geneData(int size, int type) {
        if (type == 1) {
            return IntStream
                    .rangeClosed(1, size)
                    .boxed()
                    .toArray(Integer[]::new);
        }
        if (type == 2) {
            return IntStream
                    .iterate(size, (e) -> e - 1)
                    .limit(size)
                    .boxed()
                    .toArray(Integer[]::new);
        }
        if (type == 3) {
            Random r = new Random();
            return IntStream
                    .generate(r::nextInt)
                    .distinct()
                    .limit(size)
                    .boxed()
                    .toArray(Integer[]::new);
        }
        if (type == 4) {
            Random r = new Random();
            return IntStream
                    .generate(r::nextInt)
                    .limit(size)
                    .boxed()
                    .toArray(Integer[]::new);
        }
        return null;
    }

    @RepeatedTest(5)
    public void selectionTest() {
        long start=System.currentTimeMillis();
        Selection selection = new Selection(geneData(200000, 3));
        selection.sort();
        System.out.println(System.currentTimeMillis()-start);
        Assertions.assertTrue(selection.isSorted());
        // count:20,0000 type:1 time 11459 11355 11530 11541 11743
        // count:20,0000 type:2 time 11746 11804 18221 18803 18862
        // count:20,0000 type:3 time 24065
        // count:20,0000 type:3 time 21259
    }
    @RepeatedTest(5)
    public void insertionTest() {
        long start=System.currentTimeMillis();
        Insertion insertion = new Insertion(geneData(20_0000, 4));
        insertion.sort();
        System.out.println(System.currentTimeMillis()-start);
        Assertions.assertTrue(insertion.isSorted());
        // count:20,0000 type:1 time 13644 13694 16067 16057 16141
        // count:20,0000 type:2 time 36841 42448 36352 37131 36741
        // count:20,0000 type:3 time 64750 66951 53330 53483 58174
        // count:20,0000 type:4 time 36404 36936 36256 35898 36086
    }
}
