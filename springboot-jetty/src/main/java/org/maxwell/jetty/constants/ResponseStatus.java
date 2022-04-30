package org.maxwell.jetty.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author pdai
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {

    /**
     * 响应信息封装
     */
    SUCCESS("200", "success"),
    FAIL("500", "failed"),

    HTTP_STATUS_200("200", "ok"),
    HTTP_STATUS_400("400", "request error"),
    HTTP_STATUS_401("401", "no authentication"),
    HTTP_STATUS_403("403", "no authorities"),
    HTTP_STATUS_500("500", "server error");


    /**
     * response code
     */
    private final String responseCode;

    /**
     * description.
     */
    private final String description;

}
