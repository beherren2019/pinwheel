package com.galaxy.pinwheel.service;

import com.galaxy.pinwheel.model.GithubRepositoryInfoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public interface VersionControlRepositoryService {

    GithubRepositoryInfoDto getGithubRepositories(int pageNo, int pageSize, String sortBy, String sortDirection, String language, LocalDate date);

}