package com.java.UfcApi.Fight;

import com.java.UfcApi.Event.EventModel;
import com.java.UfcApi.Fighter.FighterModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_fight")
@AllArgsConstructor
@NoArgsConstructor
public class FightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel event;

    @ManyToOne
    @JoinColumn(name = "fighter_red_id")
    private FighterModel fighterRedCorner;

    @ManyToOne
    @JoinColumn(name = "fighter_blue_id")
    private FighterModel fighterBlueCorner;

    @ManyToOne
    @JoinColumn(name = "fighter_winner_id")
    private FighterModel fighterWinner;

    @Enumerated(EnumType.STRING)
    private METHOD_WIN methodWin;

    @Column(name = "roundFinal")
    private int roundFinal;

    @Column(name = "timeFinal")
    private String timeFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventModel getEvent() {
        return event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public FighterModel getFighterRedCorner() {
        return fighterRedCorner;
    }

    public void setFighterRedCorner(FighterModel fighterRedCorner) {
        this.fighterRedCorner = fighterRedCorner;
    }

    public FighterModel getFighterBlueCorner() {
        return fighterBlueCorner;
    }

    public void setFighterBlueCorner(FighterModel fighterBlueCorner) {
        this.fighterBlueCorner = fighterBlueCorner;
    }

    public FighterModel getFighterWinner() {
        return fighterWinner;
    }

    public void setFighterWinner(FighterModel fighterWinner) {
        this.fighterWinner = fighterWinner;
    }

    public METHOD_WIN getMethodWin() {
        return methodWin;
    }

    public void setMethodWin(METHOD_WIN methodWin) {
        this.methodWin = methodWin;
    }

    public int getRoundFinal() {
        return roundFinal;
    }

    public void setRoundFinal(int roundFinal) {
        this.roundFinal = roundFinal;
    }

    public String getTimeFinal() {
        return timeFinal;
    }

    public void setTimeFinal(String timeFinal) {
        this.timeFinal = timeFinal;
    }
}
