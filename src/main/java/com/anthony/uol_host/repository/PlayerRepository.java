package com.anthony.uol_host.repository;

import com.anthony.uol_host.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {
    private final JdbcClient jdbcClient;

    public void save(Player player) {
        jdbcClient.sql("""
                INSERT INTO player (name, email, phone, codename, group)
                VALUES (:name, :email, :phone, :codename, :group)
                """)
                .param("name", player.name())
                .param("email", player.email())
                .param("phone", player.phone())
                .param("codename", player.codename())
                .param("group", player.group())
                .update();
    }
}
