package com.anthony.uol_host.enums;

import lombok.Getter;

@Getter
public enum GrupoCodinome {
    LIGA_DA_JUSTICA(
            "liga da justiça",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml"
    ),
    VINGADORES(
            "vingadores",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"
    );

    private final String nome;
    private final String uri;

    GrupoCodinome(String nome, String uri) {
        this.nome = nome;
        this.uri = uri;
    }
}
