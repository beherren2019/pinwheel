package com.galaxy.pinwheel.service.external;

import com.galaxy.pinwheel.model.external.GithubRepositoryInfoVO;
import com.galaxy.pinwheel.model.GithubSearchInfoVO;

public interface GithubRepositoryService {

    GithubRepositoryInfoVO getGithubRepositories(GithubSearchInfoVO githubSearchInfoVO);

}
