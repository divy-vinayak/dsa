package Greedy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
public class ActivitySelection {
    public static void reversePrintStack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int val = st.pop();
        reversePrintStack(st);
        System.out.print(val + " ");
    }
    public static void main(String[] args) {
        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9}; // sorted on end time
        
        int start[] = {5, 1, 0, 3, 8, 5};
        int end[] = {7, 2, 6, 4, 9, 9}; // unsorted

        // sorting if required
        int activities[][] = new int[start.length][3];
        for(int i = 0; i < start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> shortform of a big function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int count = 1; // chose the first activity
        Stack<Integer> ans = new Stack<>();
        ans.push(activities[0][0]);
        for(int i = 1; i < end.length; i++){
            if(activities[i][1] >= end[ans.peek()]){
                count++;
                ans.push(activities[i][0]);
            }
        }

        System.out.println("Total number of ways: " + count);
        reversePrintStack(ans);
        System.out.println();
    }
}
