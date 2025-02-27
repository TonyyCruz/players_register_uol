package com.anthony.uol_host.service;

import com.anthony.uol_host.enums.GroupCodename;
import com.anthony.uol_host.exceptions.GroupCodenameException;
import com.anthony.uol_host.repository.ICodenameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CodenameService {
    private final CodenameRepositoryFactory codenameRepositoryFactory;

    public CodenameService(CodenameRepositoryFactory codenameRepositoryFactory) {
        this.codenameRepositoryFactory = codenameRepositoryFactory;
    }

    public String createCodename(GroupCodename groupCodename, List<String> usedCodenames) throws Exception {
        List<String> availableCodenames = listAvailableCodenames(groupCodename, usedCodenames);
        if (availableCodenames.isEmpty()) {
            throw new GroupCodenameException("No available codenames");
        }
        return getRandomItemInList(availableCodenames);
    }

    private List<String> listAvailableCodenames(GroupCodename groupCodename, List<String> usedCodenames) throws Exception {
        List<String> codenames = getCodenames(groupCodename);
        return codenames.stream().filter(codename -> !usedCodenames.contains(codename)).toList();
    }

    private List<String> getCodenames(GroupCodename groupCodename) throws Exception {
        ICodenameRepository codenameRepository = codenameRepositoryFactory.create(groupCodename);
        return codenameRepository.getCodenames().getCodenames();
    }

    private String getRandomItemInList(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
