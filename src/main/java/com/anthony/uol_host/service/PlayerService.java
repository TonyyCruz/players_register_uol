package com.anthony.uol_host.service;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.model.Player;
import com.anthony.uol_host.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final CodenameService codenameService;

    public PlayerService(PlayerRepository playerRepository, CodenameService codenameService) {
        this.playerRepository = playerRepository;
        this.codenameService = codenameService;
    }

    public Player create(Player player) throws Exception {
        List<String> usedCodenames = getUsedCodenames(player.groupCodename());
        String codename = codenameService.createCodename(player.groupCodename(), usedCodenames);
        Player newPlayer = new Player(player.name(), player.email(), player.phone(), codename, player.groupCodename());
        return playerRepository.save(newPlayer);
    }

    private List<String> getUsedCodenames(GroupCodename groupCodename) {
        return playerRepository.findAllByCodename(groupCodename);
    }
}
