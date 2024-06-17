package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

import java.io.File;

public class ShortBartleTest {

    public static int IndicatorFunction(boolean condition) {

        if (condition) {
            return 1;
        }
        return 0;

    }

    private final Question[] questions;

    public ShortBartleTest() {

        // Relative path to where questions are
        String questionsPath = "./src/main/resources/questions/";
        File[] questionFiles = new File(questionsPath).listFiles();
        this.questions = new Question[questionFiles.length];

        for (int i = 0; i < questionFiles.length; i++) {
            String questionPath = questionsPath + "question" + i + ".json";
            Question question = Question.ParseJsonFile(questionPath);
            questions[i] = question;
        }

    }

    public void setAnswer(int questionId, boolean selectedAnswer) {
        this.questions[questionId].setSelectedOption(selectedAnswer);
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    // Bewertung des Tests, Auswertung der Antworten
    public ShortBartleTestResult evaluateTest() {

        int achieverPercentage = 2 * IndicatorFunction(this.questions[0].getSelectedOption());
        int explorerPercentage = 3 * IndicatorFunction(this.questions[1].getSelectedOption());
        int socializerPercentage = 5 * IndicatorFunction(this.questions[2].getSelectedOption());
        int killerPercentage = 7 * IndicatorFunction(this.questions[3].getSelectedOption());

        return new ShortBartleTestResult(achieverPercentage, explorerPercentage, socializerPercentage, killerPercentage);
    }

}
