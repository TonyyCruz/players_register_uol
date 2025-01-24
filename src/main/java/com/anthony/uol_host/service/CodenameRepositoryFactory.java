package com.anthony.uol_host.service;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.repository.AvengersRepository;
import com.anthony.uol_host.repository.ICodenameRepository;
import com.anthony.uol_host.repository.JusticeLeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodenameRepositoryFactory {
    private final AvengersRepository avengersRepository;
    private final JusticeLeagueRepository justiceLeagueRepository;

    public ICodenameRepository create(GroupCodename groupCodename) {
        return switch (groupCodename) {
            case AVENGERS -> avengersRepository;
            case JUSTICE_LEAGUE -> justiceLeagueRepository;
        };
    }
}
