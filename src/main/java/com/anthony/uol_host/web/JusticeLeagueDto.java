package com.anthony.uol_host.web;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record JusticeLeagueDto(
        @JacksonXmlProperty(localName = "codinomes") CodenamesDto codenames) implements ICodenameDto {

    public List<String> getCodenames() {
        return codenames.codenames();
    }
}

record CodenamesDto(
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "codinome")
        List<String> codenames
) {}
