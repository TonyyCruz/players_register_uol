package com.anthony.uol_host.enums;

public enum GroupCodename {
    JUSTICE_LEAGUE(
            "justice_league",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml"
    ),
    AVENGERS(
            "avengers",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"
    );

    private final String name;
    private final String uri;

    GroupCodename(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }
}
