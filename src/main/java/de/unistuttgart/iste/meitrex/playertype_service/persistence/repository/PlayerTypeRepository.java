package de.unistuttgart.iste.meitrex.playertype_service.persistence.repository;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.ShortBartleTestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlayerTypeRepository extends JpaRepository<ShortBartleTestResult, UUID> {

}