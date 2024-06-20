package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

@Getter
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

    private double calculateAchieverPercentage() {
        return (double) (100 * (IA(this.questions[0].getSelectedOption())
                + IA(! this.questions[1].getSelectedOption())
                + IA(! this.questions[2].getSelectedOption())
                + IA(! this.questions[3].getSelectedOption())
                + IA(! this.questions[5].getSelectedOption())
                + IA(! this.questions[6].getSelectedOption()))) / 6;
    }

    private double calculateExplorerPercentage() {
        return (double) (100 * (IA(this.questions[0].getSelectedOption())
                + IA(this.questions[2].getSelectedOption())
                + IA(! this.questions[5].getSelectedOption())
                + IA(! this.questions[6].getSelectedOption())
                + IA(! this.questions[8].getSelectedOption()))) / 5;
    }

    private double calculateSocializerPercentage() {
        return (double) (100 * (IA(! this.questions[0].getSelectedOption()))
                + IA(! this.questions[4].getSelectedOption())
                + IA(! this.questions[5].getSelectedOption())
                + IA(! this.questions[7].getSelectedOption())
                + IA(! this.questions[8].getSelectedOption())
                + IA(! this.questions[9].getSelectedOption())) / 6;
    }

    private double calculateKillerPercentage() {
        return (double) (100 * (IA(! this.questions[0].getSelectedOption())
                + IA(! this.questions[1].getSelectedOption())
                + IA(! this.questions[2].getSelectedOption())
                + IA(! this.questions[3].getSelectedOption())
                + IA(! this.questions[6].getSelectedOption())
                + IA(this.questions[9].getSelectedOption()))) / 6;
    }

    /**
     * Evaluates the answers for the question and calculates the player types.
     *
     * @return a ShortBartleTestResult, representing the player types of the user
     */
    public PlayerTypeTestResult evaluateTest() {

        double achieverPercentage = this.calculateAchieverPercentage();
        double explorerPercentage = this.calculateExplorerPercentage();
        double socializerPercentage = this.calculateSocializerPercentage();
        double killerPercentage = this.calculateKillerPercentage();

        double coefficient = 200 / (achieverPercentage + explorerPercentage
                + socializerPercentage + killerPercentage);

        achieverPercentage *= coefficient;
        explorerPercentage *= coefficient;
        socializerPercentage *= coefficient;
        killerPercentage *= coefficient;

        return new PlayerTypeTestResult((int)achieverPercentage,
                (int)explorerPercentage,
                (int)socializerPercentage,
                (int)killerPercentage);

    }

}
