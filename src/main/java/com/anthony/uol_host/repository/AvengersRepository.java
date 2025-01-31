package com.anthony.uol_host.repository;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.web.AvengersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class AvengersRepository implements ICodenameRepository {

    @Override
    public List<String> getCodenames() throws Exception {
        var codenames = RestClient
                .builder()
                .baseUrl(GroupCodename.AVENGERS.getUri())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var objectMapper = new ObjectMapper();
        AvengersDto avengersDto = objectMapper.readValue(codenames, AvengersDto.class);
        return avengersDto.getCodenames();
    }
}
