package com.anthony.uol_host.service;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.repository.ICodenameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CodenameService {
    private final CodenameRepositoryFactory codenameRepositoryFactory;

    public String createCodename(GroupCodename groupCodename, List<String> usedCodenames) throws Exception {
        List<String> availableCodenames = listAvailableCodenames(groupCodename, usedCodenames);
        if (availableCodenames.isEmpty()) {
            throw new RuntimeException("No available codenames");
        }
        return getRandomItemInList(availableCodenames);
    }

    private List<String> listAvailableCodenames(GroupCodename groupCodename, List<String> usedCodenames) throws Exception {
        List<String> availableCodenames = getCodenames(groupCodename);
        availableCodenames.removeAll(usedCodenames);
        return availableCodenames;
    }

    private List<String> getCodenames(GroupCodename groupCodename) throws Exception {
        ICodenameRepository codenameRepository = codenameRepositoryFactory.create(groupCodename);
        return codenameRepository.getCodenames();
    }

    private String getRandomItemInList(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
