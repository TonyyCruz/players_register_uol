package com.anthony.uol_host.repository;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.web.JusticeLeagueDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

public class JusticeLeagueRepository implements ICodenameRepository {

    @Override
    public List<String> getCodenames() throws Exception {
        var codenames = RestClient
                .builder()
                .baseUrl(GroupCodename.JUSTICE_LEAGUE.getUri())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_ATOM_XML_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_ATOM_XML_VALUE)
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var xmlMapper = new XmlMapper();
        var justiceLeague = xmlMapper.readValue(codenames, JusticeLeagueDto.class);
        return justiceLeague.getCodenames();
    }
}
