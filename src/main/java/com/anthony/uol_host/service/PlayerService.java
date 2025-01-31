package com.anthony.uol_host.service;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.model.Player;
import com.anthony.uol_host.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final CodenameService codenameService;

    public Player create(Player player) throws Exception {
        List<String> usedCodenames = getUsedCodenames(player.group());
        String codename = codenameService.createCodename(player.group(), usedCodenames);
        Player newPlayer = new Player(player.name(), player.email(), player.phone(), codename, player.group());
        return playerRepository.save(newPlayer);
    }

    private List<String> getUsedCodenames(GroupCodename groupCodename) {
        return playerRepository.findAllByCodename(groupCodename);
    }
}
