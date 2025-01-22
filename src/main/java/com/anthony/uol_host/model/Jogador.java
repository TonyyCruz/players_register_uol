package com.anthony.uol_host.model;

import com.anthony.uol_host.enums.GrupoCodinome;

public record Jogador(String nome, String email, String telefone, String codinome, GrupoCodinome grupo) {
    public Jogador(String nome, String email, String codinome, GrupoCodinome grupo) {
        this(nome, email, "", codinome, grupo);
    }
}
