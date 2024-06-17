package de.unistuttgart.iste.meitrex.playertype_service.controller;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.ShortBartleTest;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.Question;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.ShortBartleTestResult;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerTypeController {

    private final ShortBartleTest test = new ShortBartleTest();

    @QueryMapping
    public String hello() {
        return "hello";
    }

    @QueryMapping
    public Question[] test() {
        return this.test.getQuestions();
    }

    @MutationMapping
    public String submitAnswer(@Argument("questionId") int questionId, @Argument("answer") boolean answer) {
        this.test.setAnswer(questionId, answer);
        return "Answer submitted successfully!";
    }

    @QueryMapping
    public ShortBartleTestResult evaluateTest() {
        return this.test.evaluateTest();
    }

}
