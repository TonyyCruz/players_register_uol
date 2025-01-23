package com.anthony.uol_host.model;

import com.anthony.uol_host.enums.GroupCodename;

public record Player(String name, String email, String phone, String codename, GroupCodename group) {
    public Player(String name, String email, String codename, GroupCodename group) {
        this(name, email, "", codename, group);
    }
}
