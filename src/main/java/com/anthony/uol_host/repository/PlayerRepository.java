package com.anthony.uol_host.repository;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Player findById(Long id) {
        return jdbcClient.sql("""
                SELECT * FROM PLAYERS
                WHERE id=:id
                """)
                .param("id", id)
                .query(Player.class)
                .single();
    }

    public List<String> findAllByCodename(GroupCodename groupCodename) {
        return jdbcClient.sql("""
                SELECT distinct(codenames) FROM PLAYERS
                WHERE group=:groupCodename
                """)
                .param("groupCodename", groupCodename.name())
                .query(String.class)
                .list();
    }
}
