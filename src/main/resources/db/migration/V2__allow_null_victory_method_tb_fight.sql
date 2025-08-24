-- V2: Migration to alter the column methodWin on FightModel

ALTER TABLE tb_fight
ALTER COLUMN method_win DROP NOT NULL;