package Queu;

import java.util.*;

public class RoundRobin {
    private static Scanner scanner = new Scanner(System.in);
    private static QueuArrayGeneric<Job> jobQueu = new QueuArrayGeneric<Job>();
    private static int quantum;

    public static void main(String[] args) {
        setJobs();
        runScheduler();
    }

    public static void setJobs() {
        Job job;
        int jobNum, cpuTime;

        System.out.print("Enter number of jobs: ");
        jobNum = scanner.nextInt();
        System.out.print("Enter size of quantum: ");
        quantum = scanner.nextInt();
        System.out.println();

        for(int i = 0; i < jobNum; i++) {
            System.out.println("Enter CPU time for job "+ i+": ");
            cpuTime = scanner.nextInt();
            job = new Job(i, cpuTime);
            jobQueu.enqueu(job);
        } 
        System.out.println();
    }
    public static void runScheduler() {
        Job job;
        int cpuTime, accumulatedCpuTime;
        accumulatedCpuTime = 0;

        while(!jobQueu.empty()) {
            job = jobQueu.dequeu();
            cpuTime = job.getCpuTime();

            if (cpuTime - quantum > 0) {
                accumulatedCpuTime = accumulatedCpuTime + quantum;
                job.setCpuTime(cpuTime-quantum);
                jobQueu.enqueu(job);
            }
            else {
                accumulatedCpuTime = accumulatedCpuTime + cpuTime;
                System.out.println("Job "+job.getJobNum()+" fished at "+ accumulatedCpuTime);
            }
        }
    }
}
