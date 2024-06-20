package de.unistuttgart.iste.meitrex.playertype_service.service;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestResultEntity;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestResult;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.mapper.PlayerTypeMapper;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.repository.PlayerTypeRepository;
import de.unistuttgart.iste.meitrex.playertype_service.validation.PlayerTypeValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PlayerTypeService {

    private final PlayerTypeRepository playerTypeRepository;
    private final PlayerTypeMapper playerTypeMapper;
    private final PlayerTypeValidator playerTypeValidator;

    /**
     * Creates a new quiz.
     *
     * @param userUUID     the id of the new user that was just created
     * @return an empty PlayerTypeTestResultEntity, indicating that the user has
     *                  not yet taken the PlayerTypeTest
     */
    public PlayerTypeTestResultEntity createUser(final UUID userUUID) {

        PlayerTypeTestResultEntity entity
                = new PlayerTypeTestResultEntity(userUUID,false);
        return playerTypeRepository.save(entity);

    }

    /**
     * Saves the result of a BartleTest for a user.
     *
     * @param userUUID      the users UUID
     * @param result        the users test result
     * @return a PlayerTypeTestResultEntity, representing the result of the users answers
     */
    public PlayerTypeTestResultEntity saveTestResult(final UUID userUUID,
                                                     final PlayerTypeTestResult result) {

        PlayerTypeTestResultEntity entity = new PlayerTypeTestResultEntity(userUUID,
                result.getAchieverPercentage(),
                result.getExplorerPercentage(),
                result.getSocializerPercentage(),
                result.getKillerPercentage());
        return playerTypeRepository.save(entity);
    }

    /**
     * Gets the player type percentages of a user.
     *
     * @param userUUID     the id of the user whose percentages are requested
     * @return a PlayerTypeTestResultEntity, representing the player types of the user
     */
    public Optional<PlayerTypeTestResultEntity> getEntity(final UUID userUUID) {
        return playerTypeRepository.findById(userUUID);
    }

}
