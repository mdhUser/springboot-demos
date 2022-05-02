package org.maxwell.webdemo.constant;

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
    HTTP_STATUS_500(500, "server error"),
    /**
     * 业务非法操作
     */
    SAVE_ERROR(4001, "报错失败！"),

    UPDATE_ERROR(4002, "更新失败！"),

    SELECT_ERROR(4003, "查询失败，无此用户！"),

    DELETE_ERROR(4004, "删除失败！"),

    /**
     * 系统异常
     */
    SYSTEM_ERR(5001, "系统异常"),
    SYSTEM_TIMEOUT_ERR(5002, "系统超时"),
    SYSTEM_UNKNOWN_ERR(5003, "系统未知异常");

    /**
     * response code
     */
    private final Integer code;

    /**
     * description.
     */
    private final String description;

}
