package org.maxwell.mybatis.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @description: 响应状态码
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 20:25
 */

@Getter
@AllArgsConstructor
public enum ResponseStatus {

    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 失败 服务器端报错
     */
    FAIL(500, "failed"),


    HTTP_STATUS_200(200, "ok"),
    HTTP_STATUS_400(400, "request error"),
    HTTP_STATUS_401(401, "no authentication"),
    HTTP_STATUS_403(403, "no authorities"),
    HTTP_STATUS_500(500, "server error");


    /**
     * response code
     */
    private final Integer responseCode;

    /**
     * description.
     */
    private final String description;

}
