package com.anthony.uol_host.controller;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.model.Player;
import com.anthony.uol_host.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("player-registration")
public class PlayerRegistrationController {
    private final PlayerService playerService;

    public PlayerRegistrationController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String pagePlayerRegistration(Model model) {
        model.addAttribute("player", new Player(null, null, null, null, null));
        model.addAttribute("groupsCodenames", GroupCodename.values());
        return "player_registration";
    }

    @PostMapping
    public String registerPlayer(@ModelAttribute Player player) {
        try {
            playerService.create(player);
            return "redirect:/player-registration";
        } catch (Exception e) {
            return "redirect:/player-registration";
        }
    }
}
