package de.unistuttgart.iste.meitrex.playertype_service.persistence.mapper;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.PlayerTypeTestResultEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class PlayerTypeMapper {

    private final ModelMapper modelMapper;

}
