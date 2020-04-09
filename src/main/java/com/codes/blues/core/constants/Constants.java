package com.codes.blues.core.constants;

import com.codes.blues.core.model.IResponseStatus;

/**
 * 系统级常量
 * @author linzg
 * @date 2020/03/02 15:25
 */
public interface Constants {

    /**
     * 系统级响应对象
     * @author linzg
     * @date 2020/03/02 15:25
     */
    enum Response implements IResponseStatus {
        SUCCESS("SUCCESS", "请求成功"),
        FAILURE("FAILURE", "请求失败"),
        DATA_EMPTY("DATA_EMPTY", "未找到目标资源"),
        BAD_REQUEST("BAD_REQUEST", "非法请求"),
        ;

        private String code;

        private String message;

        Response(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}