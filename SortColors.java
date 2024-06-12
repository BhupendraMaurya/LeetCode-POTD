class SortColors {
    //❌ Solved this problem without any taking extra space. This problem can also be solved using sorting.❌
    public void sortColors(int[] nums) {
        
        int c0=0;
        int c1=0;
        int c2=0;

        //just trying to count the frequencies of 1,2, and 3 and then fill in given array,

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                c0++;//freq of 0;
            }
            else if(nums[i] == 1){
                c1++;// freq of 1;
            }

            else{
                c2++;// freq of 2.
            }
        }

        int j =0;
        for(int i=0;i<c0;i++){
            nums[j++] = 0;
        }

        for(int i=0;i<c1;i++){
            nums[j++] = 1;
        }

        for(int i=0;i<c2;i++){
            nums[j++] = 2;
        }

    }
}
