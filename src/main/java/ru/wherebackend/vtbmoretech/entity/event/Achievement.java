package ru.wherebackend.vtbmoretech.entity.event;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "VTBMT_ACHVIEMENT")
@Entity(name = "vtbmt_Achviement")
public class Achievement {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_OF_RECEIVING")
    private Date dateOfReceiving;

    @Column(name = "AWARD")
    private Double award;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfReceiving() {
        return dateOfReceiving;
    }

    public void setDateOfReceiving(Date dateOfReceiving) {
        this.dateOfReceiving = dateOfReceiving;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getAward() {
        return award;
    }

    public void setAward(Double award) {
        this.award = award;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}