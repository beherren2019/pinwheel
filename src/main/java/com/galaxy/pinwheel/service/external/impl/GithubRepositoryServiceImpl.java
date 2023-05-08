package com.galaxy.pinwheel.service.external.impl;

import com.galaxy.pinwheel.exception.ExternalServiceException;
import com.galaxy.pinwheel.model.GithubRepositoryInfoDto;
import com.galaxy.pinwheel.model.GithubSearchInfoVO;
import com.galaxy.pinwheel.service.external.GithubRepositoryService;
import com.galaxy.pinwheel.util.GitHubSearchUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service(value = "githubRepositoryServiceImpl")
public class GithubRepositoryServiceImpl implements GithubRepositoryService {

    @Value("${pinwheel.external.github.base.url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public GithubRepositoryInfoDto getGithubRepositories(GithubSearchInfoVO githubSearchInfoVO) {

        log.info("GithubRepositoryServiceImpl::getGithubRepositories::Start");

        GithubRepositoryInfoDto result;

        try {
            String url = GitHubSearchUtil.buildGithubUrl(baseUrl, githubSearchInfoVO);

            result = restTemplate.getForObject(url, GithubRepositoryInfoDto.class);

        } catch (HttpClientErrorException e) {
            throw new ExternalServiceException("Exception while calling external GitHub service!", e);
        } catch (HttpServerErrorException e) {
            throw new ExternalServiceException("Exception while calling external GitHub service!", e);
        } catch (Exception e) {
            throw new ExternalServiceException("Exception while calling external GitHub service!");
        }

        log.info("GithubRepositoryServiceImpl::getGithubRepositories::End");

        return result;
    }


}
