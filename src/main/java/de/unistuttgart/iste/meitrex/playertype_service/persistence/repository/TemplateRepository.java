package de.unistuttgart.iste.meitrex.playertype_service.persistence.repository;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {

    Optional<TemplateEntity> findByName(String name);

}
