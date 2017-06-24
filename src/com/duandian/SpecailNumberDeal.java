package com.duandian;

import java.util.Arrays;

/**
 * Created by Caily on 6/23/2017.
 * v1.0
 * github: http://github.com/CailyPersonal
 *
 */


public class SpecailNumberDeal {

    private static SpecailNumberDeal classInstance;

    private static boolean containZero;

    private final String[] specailWords;
    private final int studentCount;

    private static final int NOT_VALID_WORD_INDEX = 0;

    private final int FIRST_POS     = 0x01,
                      SECOND_POS    = 0x02,
                      THRID_POS     = 0x04;

    /**
     * @brief Constructor method for class.
     * @detial
     * <p>
     *  According to the rules, there are 7 kinds of output. Here I use a bit operator to simply combine situations.
     *  So the judge method {@link #getNumberOutputIndex(int[], int)} can simple return the index of the result.
     *  ATTENTION: The first place is used to make a judgement if situation is confirmed.
     */
    private SpecailNumberDeal() {

        specailWords = new String[]{
                "",                     // HEX:0x00 (BIN: 0000 0000) Normal Number.
                "Fizz",                 // HEX:0x01 (BIN: 0000 0001)
                "Buzz",                 // HEX:0x02 (BIN: 0000 0010)
                "FizzBuzz",             // HEX:0x03 (BIN: 0000 0011)
                "Whizz",                // HEX:0x04 (BIN: 0000 0100)
                "FizzWhizz",            // HEX:0x05 (BIN: 0000 0101)
                "BuzzWhizz",            // HEX:0x06 (BIN: 0000 0110)
                "FizzBuzzWhizz"         // HEX:0x07 (BIN: 0000 0111)
        };

        studentCount = 100;
    }

    /**
     * @brief Core method to make the output.
     * @param nums Special numbers.
     * @return Return true if success, else false.
     * <p>
     * Attention:
     * 1. nums are checked in {@link #makeAndOutputResult(int[])}, so no need to check them again.
     * <p>
     * @checked false.
     */
    private boolean outputResult(int[] nums) {

        int toOutputWordIndex = NOT_VALID_WORD_INDEX;

        for (int i = 1; i <= studentCount; i++) {

            // Rule 6, ignore rule 3 and rule 4. (Attention: according to the requirement, rule 5 is ignored too, because
            // 35 = 3 * 5, but "Fizz" is output only.)
            if (hasFirstSpecialNumber(nums[0], i)) System.out.println(specailWords[1]);

            // Not a specail number, so make the normal rule pair and output.
            else {
                toOutputWordIndex = getNumberOutputIndex(nums, i);

                if(NOT_VALID_WORD_INDEX == toOutputWordIndex) System.out.println(i);
                else System.out.println(specailWords[toOutputWordIndex]);
            }
        }

        return true;
    }

    /**
     * @brief Entry and method to make and output the result.
     * @param nums Special numbers.
     * @return Return true if success, else false.
     * <p>
     * Attention: Factory mode.
     * @checked false.
     */
    public synchronized static boolean makeAndOutputResult(int[] nums) {

        // In case of multi threads.

            // Input check before deal with it.
            if (!inputCheck(nums)) return false;

            // Create class instance before do it.
            if (null == classInstance) classInstance = new SpecailNumberDeal();

            // Make and do it.
            return classInstance.outputResult(nums);
    }

    /**
     * @brief Get the index of specailWords.
     * @param nums Special words.
     * @param targetNum Target number.
     * @return Index of array specailWords.
     * <p>
     * @detial In order to in case of zero, function is seperated to two kinds mainly.
     * <p>
     * @checked false.
     */
    private int getNumberOutputIndex(final int[] nums, int targetNum) {
        int result = NOT_VALID_WORD_INDEX;

        if (containZero) {
            if (0 != nums[0] && 0 == targetNum % nums[0]) result |= FIRST_POS;
            if (0 != nums[1] && 0 == targetNum % nums[1]) result |= SECOND_POS;
            if (0 != nums[2] && 0 == targetNum % nums[2]) result |= THRID_POS;
        } else {
            if (0 == targetNum % nums[0]) result |= FIRST_POS;
            if (0 == targetNum % nums[1]) result |= SECOND_POS;
            if (0 == targetNum % nums[2]) result |= THRID_POS;
        }

        return result;
    }


    /**
     * @param specialNum
     * @param targetNum
     * @return Return true if it contains, else false.
     * @brief Check if targetNum contains specailNum.
     * @Attention
     * <p>
     * Zero is a very special number. It is simple to not to support this number, else we need to consider it carefully.
     * We confiram here that zero is not a multiple for any number(except zero itself).
     * <p>
     * It is necessary to make sure u have call {@link #inputCheck(int[])} before you can invoke this, or it will be
     * crashed!
     * <p>
     * @checked false.
     */
    private boolean hasFirstSpecialNumber(int specialNum, int targetNum) {

        // Check each pos of the targetNumber(from right to left).
        if (specialNum == targetNum % 10 || specialNum == targetNum / 10 || specialNum == targetNum / 100) return true;

        return false;
    }

    /**
     * @param nums An array which hold numbers.
     * @return Return true if OK, else false.
     * @brief Check if the input is valid
     * @Attention It is necessary to check:
     * 1. null
     * 2. count
     * 3. single number's range
     * 4. multi
     * 5. It is not allowed to alter element or change pos!
     * @checked true
     */
    private static boolean inputCheck(final int[] nums) {

        // Null and invalid element count check.
        if (null == nums || nums.length != 3) return false;

        // Make sure each number is a single digit
        if (nums[0] > 9 || nums[0] < 1) return false;

        // Check multiple. (ATTENTION: it is dangerous to alter or change elements' pos!)
        if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) return false;

        if( 0 == nums[0] || 0 == nums[1] || 0 == nums[2]) containZero = true;
        else containZero = false;

        // All done here.
        return true;
    }
}
