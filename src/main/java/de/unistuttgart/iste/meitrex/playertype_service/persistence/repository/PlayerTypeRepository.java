package de.unistuttgart.iste.meitrex.playertype_service.persistence.repository;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.ShortBartleTestResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for {@link ShortBartleTestResultEntity}.
 */
@Repository
public interface PlayerTypeRepository extends JpaRepository<ShortBartleTestResultEntity, UUID> {

}
