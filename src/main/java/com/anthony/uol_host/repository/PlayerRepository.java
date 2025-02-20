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
                INSERT INTO PLAYERS (name, email, phone, codename, group_codename)
                VALUES (:name, :email, :phone, :codename, :group_codename)
                """)
                .param("name", player.name())
                .param("email", player.email())
                .param("phone", player.phone())
                .param("codename", player.codename())
                .param("group_codename", player.groupCodename().name())
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

    public List<Player> findAll() {
        return jdbcClient.sql("SELECT * FROM PLAYERS ORDER BY LOWER(name), id")
                .query(Player.class)
                .list();
    }

    public List<Player> findAllByGroupCodename(GroupCodename groupCodename) {
        return jdbcClient.sql("""
                SELECT * FROM PLAYERS
                WHERE group_codename=:groupCodename
                """)
                .param("groupCodename", groupCodename.name())
                .query(Player.class)
                .list();
    }
}
