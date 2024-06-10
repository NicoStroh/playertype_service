package de.unistuttgart.iste.meitrex.playertype_service.service;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.mapper.PlayerTypeMapper;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.repository.PlayerTypeRepository;
import de.unistuttgart.iste.meitrex.playertype_service.validation.PlayerTypeValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PlayerTypeService {

    private final PlayerTypeRepository playerTypeRepository;
    private final PlayerTypeMapper playerTypeMapper;
    private final PlayerTypeValidator playerTypeValidator;

}
