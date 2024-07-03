package de.unistuttgart.iste.meitrex.playertype_service.controller;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTest;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestResultEntity;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestQuestion;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestResult;
import de.unistuttgart.iste.meitrex.playertype_service.service.PlayerTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PlayerTypeController {

    private final PlayerTypeService playerTypeService;
    private PlayerTypeTest test;

    @QueryMapping
    public PlayerTypeTestQuestion[] test() {
        this.test = new PlayerTypeTest();
        return this.test.getQuestions();
    }

    @MutationMapping
    public String submitAnswer(@Argument final int questionId, @Argument final boolean answer) {

        if (this.test != null) {
            this.test.setAnswer(questionId, answer);
            return "Answer submitted successfully!";
        }
        return "No test selected!";

    }

    @MutationMapping
    public PlayerTypeTestResultEntity evaluateTest(@Argument final UUID userUUID) {

        if (this.test != null && !this.test.justCreated) {
            PlayerTypeTestResult result = this.test.evaluateTest();
            return playerTypeService.saveTestResult(userUUID, result);
        }
        return new PlayerTypeTestResultEntity(userUUID, false);

    }

    @QueryMapping
    public boolean userHasTakenTest(@Argument final UUID userUUID) {

        Optional<PlayerTypeTestResultEntity> entity = playerTypeService.getEntity(userUUID);
        if (entity.isEmpty()) {
            // User is not present in playertype_database
            playerTypeService.createUser(userUUID);
            return false;
        }
        return entity.get().isUserHasTakenTest();

    }

    @QueryMapping
    public boolean userCanSeeScoreboard(@Argument final UUID userUUID) {

        Optional<PlayerTypeTestResultEntity> entity = playerTypeService.getEntity(userUUID);
        return entity.isPresent() &&
                (entity.get().getKillerPercentage() >= 50
                || entity.get().getAchieverPercentage() >= 50);
    }

    @QueryMapping
    public boolean userCanSeeBadges(@Argument final UUID userUUID) {

        Optional<PlayerTypeTestResultEntity> entity = playerTypeService.getEntity(userUUID);
        return entity.isPresent() &&
                (entity.get().getKillerPercentage() >= 50
                || entity.get().getExplorerPercentage() >= 50
                || entity.get().getSocializerPercentage() >= 50);
    }

}
