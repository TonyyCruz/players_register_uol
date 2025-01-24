package com.anthony.uol_host.web;

import java.util.List;

public record AvengersDto(List<Codename> vingadores) implements ICodenameDto {

    public List<String> getCodenames() {
        return vingadores.stream().map(Codename::toString).toList();
    }
}

record Codename(String codename) {}
