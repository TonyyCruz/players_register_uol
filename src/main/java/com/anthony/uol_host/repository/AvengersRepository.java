package com.anthony.uol_host.repository;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.web.AvengersDto;
import com.anthony.uol_host.web.ICodenameDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
public class AvengersRepository implements ICodenameRepository {

    @Override
    public ICodenameDto getCodenames() throws Exception {
        var codenames = RestClient
                .builder()
                .baseUrl(GroupCodename.AVENGERS.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        return objectMapper.readValue(codenames, AvengersDto.class);
    }
}
