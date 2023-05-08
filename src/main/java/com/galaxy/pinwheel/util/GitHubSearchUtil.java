package com.galaxy.pinwheel.util;

import com.galaxy.pinwheel.exception.NoSearchCriteriaAvailableException;
import com.galaxy.pinwheel.model.GithubSearchInfoVO;

public class GitHubSearchUtil {

    public static String buildGithubUrl(String baseUrl, GithubSearchInfoVO githubSearchInfoVO) {

        StringBuilder builder = new StringBuilder();

        boolean hasDate = false;
        boolean hasLanguage = false;

        if (githubSearchInfoVO == null) {
            throw new NoSearchCriteriaAvailableException("Search criteria for GitHub search is not provided!");
        }

        builder.append(baseUrl);

        if (githubSearchInfoVO.getDate() != null) {
            builder.append("q=created:>" + githubSearchInfoVO.getDate());
            hasDate = true;
        }

        if(githubSearchInfoVO.getLanguage() != null) {
            if (!hasDate) {
                builder.append("q=");
            } else {
                builder.append("+");
            }

            builder.append("language:"+githubSearchInfoVO.getLanguage());
            hasLanguage = true;
        }

        if (githubSearchInfoVO.getSortBy() != null) {
            if (hasLanguage || hasDate) {
                builder.append("&");
            }
            builder.append("sort=" + githubSearchInfoVO.getSortBy());
        }

        if (githubSearchInfoVO.getSortDirection() != null) {
            builder.append("&").append("order=" + githubSearchInfoVO.getSortDirection());
        }

        builder.append("&").append("pageNo=" + githubSearchInfoVO.getPageNo())
                .append("&")
                .append("per_page=" + githubSearchInfoVO.getPageSize());

        return builder.toString();
    }
}
