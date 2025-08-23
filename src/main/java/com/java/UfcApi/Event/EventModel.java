package com.java.UfcApi.Event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.UfcApi.Fight.FightModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_event")
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EVENT_TYPE eventType;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<FightModel> fights;

    private LocalDate eventDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FightModel> getFights() {
        return fights;
    }

    public void setFights(List<FightModel> fights) {
        this.fights = fights;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
