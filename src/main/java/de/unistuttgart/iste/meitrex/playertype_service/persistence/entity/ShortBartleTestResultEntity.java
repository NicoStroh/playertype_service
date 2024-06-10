package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "ShortBartleTestResult")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortBartleTestResultEntity {


    @Id
    private UUID userUUID;

    @Column(nullable = false)
    private boolean userHasTakenTest;

    @Column(nullable = false)
    private int achieverPercentage;

    @Column(nullable = false)
    private int explorerPercentage;

    @Column(nullable = false)
    private int socializerPercentage;

    @Column(nullable = false)
    private int killerPercentage;


}
