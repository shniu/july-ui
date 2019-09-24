package com.github.shniu.spring.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author shniu
 * @date 2019/09/24 19:39:59
 */
@Configuration
@Profile(value = {"dev", "local", "ci"})
public class SwaggerConfiguration {
}
