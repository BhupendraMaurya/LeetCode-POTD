
import java.util.Arrays;
// Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.
// simply make the distance between student position and seat position smaller, thats why I did sorting, and then 
// fund the absolute difference and you will get your number.

// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=daily-question&envId=2024-06-13
public class MinovesToSeat {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int ans = 0;

        for(int i=0;i<seats.length;i++){
            int diff = Math.abs(seats[i] - students[i]);
            ans += diff;
        }

        return ans;
    }
}
