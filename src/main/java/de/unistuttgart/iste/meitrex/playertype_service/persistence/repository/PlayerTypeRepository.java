package de.unistuttgart.iste.meitrex.playertype_service.persistence.repository;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for {@link PlayerTypeTestResultEntity}.
 */
@Repository
public interface PlayerTypeRepository extends JpaRepository<PlayerTypeTestResultEntity, UUID> {

}
