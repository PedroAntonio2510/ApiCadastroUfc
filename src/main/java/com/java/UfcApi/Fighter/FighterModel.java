package com.java.UfcApi.Fighter;

import com.java.UfcApi.Fight.FightModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_fighter")
@AllArgsConstructor
@NoArgsConstructor
public class FighterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private WEIGHT_DIVISION WEIGHTDIVISION;

    @OneToMany
    @JoinColumn(name = "fight_id")
    private FightModel fight;

    @Column(name = "victory")
    private int victory;

    @Column(name = "lose")
    private int lose;

    @Column(name = "draw")
    private int draw;

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

    public WEIGHT_DIVISION getWEIGHTDIVISION() {
        return WEIGHTDIVISION;
    }

    public void setWEIGHTDIVISION(WEIGHT_DIVISION WEIGHTDIVISION) {
        this.WEIGHTDIVISION = WEIGHTDIVISION;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
