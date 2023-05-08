package com.galaxy.pinwheel.service.external;

import com.galaxy.pinwheel.model.GithubRepositoryInfoDto;
import com.galaxy.pinwheel.model.GithubSearchInfoVO;
import org.springframework.stereotype.Service;

public interface GithubRepositoryService {

    GithubRepositoryInfoDto getGithubRepositories(GithubSearchInfoVO githubSearchInfoVO);

}
