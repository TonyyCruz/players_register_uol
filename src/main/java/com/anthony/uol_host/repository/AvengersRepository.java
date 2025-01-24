package com.anthony.uol_host.repository;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.web.AvengersDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

public class AvengersRepository implements ICodenameRepository {

    @Override
    public List<String> getCodenames() {
        var codenames = RestClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(GroupCodename.AVENGERS.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var objectMapper = new ObjectMapper();
        try {
            AvengersDto avengersDto = objectMapper.readValue(codenames, AvengersDto.class);
            return avengersDto.getCodenames();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
