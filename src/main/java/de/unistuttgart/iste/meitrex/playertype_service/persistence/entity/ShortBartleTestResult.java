package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

public class ShortBartleTestResult {

    private int achieverPercentage;
    private int explorerPercentage;
    private int socializerPercentage;
    private int killerPercentage;

    public ShortBartleTestResult() {
        this.achieverPercentage = -1;
        this.explorerPercentage = -1;
        this.socializerPercentage = -1;
        this.killerPercentage = -1;
    }

    public ShortBartleTestResult(int achieverPercentage, int explorerPercentage,
                                 int socializerPercentage, int killerPercentage) {
        this.achieverPercentage = achieverPercentage;
        this.explorerPercentage = explorerPercentage;
        this.socializerPercentage = socializerPercentage;
        this.killerPercentage = killerPercentage;
    }

    public void increaseAchieverPercentage(int increase) {
        this.achieverPercentage += increase;
    }

    public void increaseExplorerPercentage(int increase) {
        this.explorerPercentage += increase;
    }

    public void increaseSocializerPercentage(int increase) {
        this.socializerPercentage += increase;
    }

    public void increaseKillerPercentage(int increase) {
        this.killerPercentage += increase;
    }

    public void print() {
        System.out.println("ShortBartleTestResult {" +
                "\n  achieverPercentage=" + achieverPercentage +
                "\n  explorerPercentage=" + explorerPercentage +
                "\n  socializerPercentage=" + socializerPercentage +
                "\n  killerPercentage=" + killerPercentage +
                "\n}");
    }

}