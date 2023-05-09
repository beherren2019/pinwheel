package com.galaxy.pinwheel.service.impl;

import com.galaxy.pinwheel.mapper.GithubResponseMapper;
import com.galaxy.pinwheel.model.GithubResponseVO;
import com.galaxy.pinwheel.model.external.GithubRepositoryInfoVO;
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

    @Autowired
    private GithubResponseMapper githubResponseMapper;

    @Override
    public GithubResponseVO getGithubRepositories(int pageNo, int pageSize, String sortBy, String sortDirection, String language, LocalDate date) {

        log.info("VersionControlRepositoryServiceImpl::getGithubRepositories::Start");

        GithubSearchInfoVO githubSearchInfoVO = GithubSearchInfoVO.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .sortBy(sortBy)
                .sortDirection(sortDirection)
                .date(date)
                .language(language)
                .build();

        GithubRepositoryInfoVO githubRepositoryInfoVO = githubRepositoryService.getGithubRepositories(githubSearchInfoVO);

        GithubResponseVO githubResponseVO = githubResponseMapper.map(githubRepositoryInfoVO);

        log.info("VersionControlRepositoryServiceImpl::getGithubRepositories::End");

        return githubResponseVO;
    }
}
