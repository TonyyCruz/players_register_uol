package com.anthony.uol_host.repository;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.model.Player;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {
    private final JdbcClient jdbcClient;

    public PlayerRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Player save(Player player) {
        jdbcClient.sql("""
                INSERT INTO player (name, email, phone, codename, groupCodename)
                VALUES (:name, :email, :phone, :codename, :groupCodename)
                """)
                .param("name", player.name())
                .param("email", player.email())
                .param("phone", player.phone())
                .param("group_codename", player.codename())
                .param("groupCodename", player.groupCodename().name())
                .update();
        return player;
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
                SELECT distinct(codename) FROM PLAYERS
                WHERE group_codename=:groupCodename
                """)
                .param("groupCodename", groupCodename.name())
                .query(String.class)
                .list();
    }
}
