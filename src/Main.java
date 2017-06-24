import com.duandian.SpecailNumberDeal;

/**
 * Created by Caily on 6/23/2017.
 */
public class Main {

    /**
     * @brief Common entry for a Java application.
     * @param main
     */
    public static void main(String[] main) {


        // Entry for execute the method. So, you just need to change the special numbers here!
        if (false == SpecailNumberDeal.makeAndOutputResult(new int[]{0, 5, 7})){
            System.out.println("It means you have given an invalid array, check if multi, wrong lenght of array or out of range!");
        }
    }
}
