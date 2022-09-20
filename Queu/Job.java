package Queu;

public class Job {
    private int jobNum, cpuTime;

    public Job(int jobNum, int cpuTime) {
        this.jobNum = jobNum;
        this.cpuTime = cpuTime;
    }

    public int getJobNum() {
        return jobNum;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }
}
