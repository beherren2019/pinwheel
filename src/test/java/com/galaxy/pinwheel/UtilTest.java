package com.galaxy.pinwheel;

import com.galaxy.pinwheel.model.GithubSearchInfoVO;
import com.galaxy.pinwheel.util.GitHubSearchUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    public void githubUrlBuilderTest() {

        String baseUrl = "localhost:8080?";

        String gitHubUrl = GitHubSearchUtil.buildGithubUrl(baseUrl, GithubSearchInfoVO.builder()
                .pageNo(1)
                .pageSize(1)
                .sortBy("stars")
                .sortDirection("desc")
                .date(LocalDate.now())
                .build());

        assertEquals("localhost:8080?q=created:>2023-05-09&sort=stars&order=desc&pageNo=1&per_page=1", gitHubUrl);
    }

}
