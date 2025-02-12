package com.anthony.uol_host.repository;

import com.anthony.uol_host.web.ICodenameDto;

import java.util.List;

public interface ICodenameRepository {
    ICodenameDto getCodenames() throws Exception;
}
