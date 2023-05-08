package com.galaxy.pinwheel.service.impl;

import com.galaxy.pinwheel.model.GithubRepositoryInfoDto;
import com.galaxy.pinwheel.model.GithubSearchInfoVO;
import com.galaxy.pinwheel.service.VersionControlRepositoryService;
import com.galaxy.pinwheel.service.external.GithubRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service("versionControlRepositoryServiceImpl")
public class VersionControlRepositoryServiceImpl implements VersionControlRepositoryService {

    @Autowired
    @Qualifier(value = "githubRepositoryServiceImpl")
    private GithubRepositoryService githubRepositoryService;

    @Override
    public GithubRepositoryInfoDto getGithubRepositories(int pageNo, int pageSize, String sortBy, String sortDirection, String language, LocalDate date) {

        log.info("VersionControlRepositoryServiceImpl::getGithubRepositories::Start");

        GithubSearchInfoVO githubSearchInfoVO = GithubSearchInfoVO.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .sortBy(sortBy)
                .sortDirection(sortDirection)
                .date(date)
                .language(language)
                .build();

        log.info("VersionControlRepositoryServiceImpl::getGithubRepositories::End");

        return githubRepositoryService.getGithubRepositories(githubSearchInfoVO);
    }
}
