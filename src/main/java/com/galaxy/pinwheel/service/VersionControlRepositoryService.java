package com.galaxy.pinwheel.service;

import com.galaxy.pinwheel.model.GithubResponseVO;

import java.time.LocalDate;

public interface VersionControlRepositoryService {

    GithubResponseVO getGithubRepositories(int pageNo, int pageSize, String sortBy, String sortDirection, String language, LocalDate date);

}