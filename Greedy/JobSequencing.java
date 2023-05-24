package Greedy;
import java.util.*;
import java.util.ArrayList;

public class JobSequencing {
    static class Job{
        int deadline, profit, id;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i = 0; i < jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a,b) -> b.profit - a.profit); // descending order profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i < jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max Jobs: " + seq.size());
        for(int i = 0; i < seq.size(); i++){
            System.out.print("{" + jobInfo[seq.get(i)][0] + ", " + jobInfo[seq.get(i)][1] + "} ");
        }System.out.println();
    }
}
