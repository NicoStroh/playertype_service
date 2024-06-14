package de.unistuttgart.iste.meitrex.playertype_service.persistence.mapper;
import de.unistuttgart.iste.meitrex.playertype_service.persistence.entity.ShortBartleTestResultEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import de.unistuttgart.iste.meitrex.generated.dto.ShortBartleTestResult;

@Component
@RequiredArgsConstructor
public class PlayerTypeMapper {

    private final ModelMapper modelMapper;

    public ShortBartleTestResult entityToDto(final ShortBartleTestResultEntity entity) {

        return new ShortBartleTestResult(
                entity.getAchieverPercentage(),
                entity.getExplorerPercentage(),
                entity.getSocializerPercentage(),
                entity.getKillerPercentage()
                );

    }

}
