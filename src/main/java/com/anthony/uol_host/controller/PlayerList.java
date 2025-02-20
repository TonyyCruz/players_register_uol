package com.anthony.uol_host.controller;

import com.anthony.uol_host.model.Player;
import com.anthony.uol_host.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("player-list")
public class PlayerList {
    private final PlayerService playerService;

    public PlayerList(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String pagePlayerList(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "player_list";
    }
}
