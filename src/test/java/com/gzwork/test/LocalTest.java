package com.gzwork.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * @author Gzwork
 */
public class LocalTest {
    @Test
    public void sort() {
        int length = 10;
        GetNumList getNumList = new LocalTest().new GetNumList();
        List<Integer> nums = getNumList.getNums(length);
        System.out.println(Arrays.toString(nums.toArray()));
    }

    @Test
    public void md5() {
        System.out.println(DigestUtils.md5Hex("gzwork"));
    }

    @Test
    public void input() {

    }

    private void quick(Integer nums[], int bengin, int end) {

    }

    @Test
    public void format() {
        BigDecimal decimal = new BigDecimal("20.00");
        String num = new DecimalFormat("#.00").format(decimal);
        System.out.println(num);
    }

    /**
     * @author Gzwork
     */
    class GetNumList {

        private Random random = new Random();

        public List<Integer> getNums(int length) {

            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                nums.add(this.random.nextInt(length));
            }
            return nums;
        }
    }
}
