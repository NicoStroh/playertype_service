package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

public class PlayerTypeTest {

    /**
     * Indicator function for a condition.
     *
     * @param condition the condition of the indicator function
     * @return (int)1 if condition, (int)0 else
     */
    public static int IA(boolean condition) {

        if (condition) {
            return 1;
        }
        return 0;

    }

    private Question[] questions = new Question[]{};

    public PlayerTypeTest() {

        String questionsPath = getQuestionsPath();

        if (null != questionsPath) {

            File[] questionFiles = new File(questionsPath).listFiles();

            if (null != questionFiles) {

                this.questions = new Question[questionFiles.length];

                for (File questionFile : questionFiles) {
                    String questionPath = questionFile.getPath();
                    Question question = Question.ParseJsonFile(questionPath);

                    if (null != question) {
                        questions[question.getId()] = question;
                    }

                }

            }

        }

    }

    private String getQuestionsPath() {

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

        } catch (Exception ignored) {

        }
        return questionsPath;

    }

    public void setAnswer(int questionId, boolean selectedAnswer) {
        this.questions[questionId].setSelectedOption(selectedAnswer);
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    private int calculateAchiever() {
        return IA(this.questions[0].getSelectedOption())
                + IA(! this.questions[1].getSelectedOption())
                + IA(! this.questions[2].getSelectedOption())
                + IA(! this.questions[3].getSelectedOption())
                + IA(this.questions[4].getSelectedOption())
                + IA(! this.questions[5].getSelectedOption())
                + IA(this.questions[6].getSelectedOption())
                + IA(this.questions[7].getSelectedOption())
                + IA(this.questions[8].getSelectedOption());
    }

    private int calculateExplorer() {
        return IA(this.questions[0].getSelectedOption())
                + IA(this.questions[1].getSelectedOption())
                + IA(this.questions[2].getSelectedOption())
                + IA(this.questions[3].getSelectedOption())
                + IA(this.questions[4].getSelectedOption())
                + IA(! this.questions[5].getSelectedOption())
                + IA(! this.questions[6].getSelectedOption())
                + IA(this.questions[7].getSelectedOption())
                + IA(! this.questions[8].getSelectedOption());
    }

    private int calculateSocializer() {
        return IA(! this.questions[0].getSelectedOption())
                + IA(this.questions[1].getSelectedOption())
                + IA(this.questions[2].getSelectedOption())
                + IA(this.questions[3].getSelectedOption())
                + IA(! this.questions[4].getSelectedOption())
                + IA(! this.questions[5].getSelectedOption())
                + IA(this.questions[6].getSelectedOption())
                + IA(! this.questions[7].getSelectedOption())
                + IA(! this.questions[8].getSelectedOption())
                + IA(! this.questions[9].getSelectedOption());
    }

    private int calculateKiller() {
        return IA(! this.questions[0].getSelectedOption())
                + IA(! this.questions[1].getSelectedOption())
                + IA(! this.questions[2].getSelectedOption())
                + IA(! this.questions[3].getSelectedOption())
                + IA(this.questions[4].getSelectedOption())
                + IA(this.questions[5].getSelectedOption())
                + IA(! this.questions[6].getSelectedOption())
                + IA(this.questions[7].getSelectedOption())
                + IA(this.questions[8].getSelectedOption())
                + IA(this.questions[9].getSelectedOption());
    }

    /**
     * Evaluates the answers for the question and calculates the player types.
     *
     * @return a ShortBartleTestResult, representing the player types of the user
     */
    public PlayerTypeTestResult evaluateTest() {

        int achiever = this.calculateAchiever();
        int explorer = this.calculateExplorer();
        int socializer = this.calculateSocializer();
        int killer = this.calculateKiller();

        int achieverPercentage = (achiever * 8) / 100;
        int explorerPercentage = (explorer * 8) / 100;
        int socializerPercentage = (socializer * 9) / 100;
        int killerPercentage = (killer * 9) / 100;

        return new PlayerTypeTestResult(achieverPercentage, explorerPercentage, socializerPercentage, killerPercentage);
    }

}
