package com.java.UfcApi.Fighter;

import com.java.UfcApi.Fight.FightModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_fighter")
@AllArgsConstructor
@NoArgsConstructor
public class FighterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "weightDivision", nullable = false)
    private String weightDivision;

    @OneToMany
    @JoinColumn(name = "fight_id")
    private List<FightModel> fight;

    @Column(name = "numberVictory", nullable = false)
    private int numberVictory;

    @Column(name = "numberLose", nullable = false)
    private int numberLose;

    @Column(name = "numberDraw", nullable = false)
    private int numberDraw;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getWeightDivision() {
        return weightDivision;
    }

    public void setWeightDivision(String weightDivision) {
        this.weightDivision = weightDivision;
    }

    public List<FightModel> getFight() {
        return fight;
    }

    public void setFight(List<FightModel> fight) {
        this.fight = fight;
    }

    public int getNumberVictory() {
        return numberVictory;
    }

    public void setNumberVictory(int numberVictory) {
        this.numberVictory = numberVictory;
    }

    public int getNumberLose() {
        return numberLose;
    }

    public void setNumberLose(int numberLose) {
        this.numberLose = numberLose;
    }

    public int getNumberDraw() {
        return numberDraw;
    }

    public void setNumberDraw(int numberDraw) {
        this.numberDraw = numberDraw;
    }
}
