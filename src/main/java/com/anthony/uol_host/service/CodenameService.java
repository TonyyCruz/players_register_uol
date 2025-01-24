package com.anthony.uol_host.service;

import com.anthony.uol_host.enums.GroupCodename;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CodenameService {
    private final CodenameRepositoryFactory codenameRepositoryFactory;

    public String createCodename(GroupCodename groupCodename, List<String> usedCodenames) {
        List<String> availableCodenames = listAvailableCodenames(usedCodenames);
        if (availableCodenames.isEmpty()) {
            throw new RuntimeException("No available codenames");
        }
        return getRandomItemInList(availableCodenames);
    }

    private List<String> listAvailableCodenames(List<String> usedCodenames) {
        List<String> availableCodenames = codenameRepositoryFactory.create(GroupCodename.AVENGERS).getCodenames();
        availableCodenames.removeAll(usedCodenames);
        return availableCodenames;
    }

    private String getRandomItemInList(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
