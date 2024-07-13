public class ThreeConsecutiveOdds {
    // just taking three consecutive numbers and find modulo with 2 and if giving 0, then return true;
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=2;i<arr.length;i++){
            if(arr[i-2]%2 != 0 && arr[i-1]%2 != 0 && arr[i]%2 != 0){
                return true;
            }
        }

        return false;
    }
}
