package com.duandian;

import java.util.Arrays;

/**
 * Created by Caily on 6/23/2017.
 * v1.0
 * github: http://github.com/CailyPersonal
 *
 */


public class SpecailNumberDeal {

    private final static String[] specailWords = new String[]{"Fizz", "Buzz", "Whizz"};
    private final static int studentCount = 100;



    /**
     * @bref Check if targetNum contains specailNum.
     * @param specialNum
     * @param targetNum
     * @return Return true if it contains, else false.
     *
     * @Attention
     *
     * Zero is a very special number. It is simple to not to support this number, else we need to consider it carefully.
     * We confiram here that zero is not a multiple for any number(except zero itself).
     *
     * It is necessary to make sure u have call {@link #inputCheck(int[])} before you can invoke this, or it will be
     * crashed!
     */
    private boolean hasFirstSpecialNumber(int specialNum, int targetNum){

        // Check each pos of the targetNumber(from right to left).
        if(specialNum == targetNum % 10 || specialNum == targetNum / 10 || specialNum == targetNum / 100) return true;

        return false;
    }

    /**
     * @bref Check if the input is valid
     * @param nums An array which hold numbers.
     * @return Return true if OK, else false.
     *
     * @Attention
     *
     * It is necessary to check:
     *  1. null
     *  2. count
     *  3. single number's range
     *  4. multi
     *
     * @checked true
     */
    private boolean inputCheck(int[] nums) {

        // Null and invalid element count check.
        if (null == nums || nums.length != 3) return false;

        // Make a simple sort to check multi number.
        Arrays.sort(nums);

        // Make sure each number is a single digit
        if(nums[0] > 9 || nums[0] < 1) return false;
        for(int i = 1; i < 3; i++){

            // Make sure each number is a single digit
            if(nums[i] > 9 || nums[i] < 0) return false;

            // Make sure there is no multi numbers.
            else if (nums[i] == nums[i-1]) return false;
        }

        // All done here.
        return true;
    }
}
