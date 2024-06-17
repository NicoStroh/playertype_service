package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

public class ShortBartleTest {

    public static int IndicatorFunction(boolean condition) {

        if (condition) {
            return 1;
        }
        return 0;

    }

    private Question[] questions = new Question[]{};

    public ShortBartleTest() {

        String questionsPath = null;
        try {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> resources = classLoader.getResources("questions");

            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String fileName = url.getFile();
                if (fileName.endsWith("questions")) {
                    questionsPath = fileName;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != questionsPath) {

            File[] questionFiles = new File(questionsPath).listFiles();
            this.questions = new Question[questionFiles.length];

            for (File questionFile : questionFiles) {
                String questionPath = questionFile.getPath();
                Question question = Question.ParseJsonFile(questionPath);
                questions[question.getId()] = question;
            }
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
