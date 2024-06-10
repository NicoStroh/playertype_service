package de.unistuttgart.iste.meitrex.playertype_service.service;

import de.unistuttgart.iste.meitrex.playertype_service.persistence.mapper.PlayerTypeMapper;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.repository.PlayerTypeRepository;
import de.unistuttgart.iste.meitrex.playertype_service.validation.PlayerTypeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerTypeService {

    private final PlayerTypeRepository playerTypeRepository;
    private final PlayerTypeMapper playerTypeMapper;
    private final PlayerTypeValidator playerTypeValidator;

}
