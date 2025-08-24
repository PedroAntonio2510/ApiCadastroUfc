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

    @ManyToOne(fetch = FetchType.LAZY) // Muitas lutas podem ter o mesmo lutador 1
    @JoinColumn(name = "fighterRed_id", nullable = false) // Define a coluna da chave estrangeira
    private FighterModel fighterRedCorner;

    @ManyToOne(fetch = FetchType.LAZY) // Muitas lutas podem ter o mesmo lutador 2
    @JoinColumn(name = "fighterBlue_id", nullable = false)
    private FighterModel fighterBlueCorner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id") // Vencedor pode ser nulo (empate/no contest)
    private FighterModel fighterWinner;

    @Column(name = "methodWin")
    private String methodWin;

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

    public String getMethodWin() {
        return methodWin;
    }

    public void setMethodWin(String methodWin) {
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
