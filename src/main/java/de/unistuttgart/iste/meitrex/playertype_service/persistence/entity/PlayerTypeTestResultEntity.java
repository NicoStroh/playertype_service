package de.unistuttgart.iste.meitrex.playertype_service.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "PlyaerTypeTestResult")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerTypeTestResultEntity {

    public PlayerTypeTestResultEntity(UUID userUUID, boolean userHasTakenTest) {

        this.userUUID = userUUID;
        this.userHasTakenTest = userHasTakenTest;

    }

    public PlayerTypeTestResultEntity(UUID userUUID,
                                      int achieverPercentage, int explorerPercentage,
                                      int socializerPercentage, int killerPercentage) {

        this.userUUID = userUUID;
        this.userHasTakenTest = true;
        this.achieverPercentage = achieverPercentage;
        this.explorerPercentage = explorerPercentage;
        this.socializerPercentage = socializerPercentage;
        this.killerPercentage = killerPercentage;

    }

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
