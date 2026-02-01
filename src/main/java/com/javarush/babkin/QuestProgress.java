package com.javarush.babkin;

public class QuestProgress {
    private String step = "start";
    private boolean finished = false;

    public QuestProgress() {
        this.step = "start";
        this.finished = false;
    }

    public String getStep() { return step; }
    public void setStep(String step) { this.step = step; }
    public boolean isFinished() { return finished; }
    public void setFinished(boolean finished) { this.finished = finished; }
}
