package com.anthony.uol_host.controller;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.model.Player;
import com.anthony.uol_host.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return getViewAndModel(model, new Player(null, null, null, null, null));
    }

    @PostMapping
    public String registerPlayer(@ModelAttribute @Valid Player player, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            return getViewAndModel(model, player);
        }
        playerService.create(player);
        return "redirect:/player-registration";
    }

    private static String getViewAndModel(Model model, Player player) {
        model.addAttribute("player", player);
        model.addAttribute("groupsCodenames", GroupCodename.values());
        return "player_registration";
    }
}
