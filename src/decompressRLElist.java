import java.util.List;

public class decompressRLElist {
    public static int[] decompressRLElist(int[] nums){
        int numsPointer=1;
        int freqPointer=0;
        int newArrLen=0;

        for (int i=0;i<nums.length; i+=2){
            newArrLen += nums[i];
        }

        int[] newNums= new int[newArrLen];
        int freqCounter=1;
        for (int newNumsPointer=0; newNumsPointer<newNums.length; newNumsPointer++){
            newNums[newNumsPointer]=nums[numsPointer];
            if(freqCounter==nums[freqPointer]){
                numsPointer+=2;
                freqPointer+=2;
                freqCounter=0;
            }
            freqCounter++;
        }
        return newNums;
    }
    static void test(){
        int[] test_data = {1,7,2,4,7,5,2,6};
        int[] result =  decompressRLElist(test_data);
        for (int i: result) {
            System.out.print(i);
        }
    }
}
