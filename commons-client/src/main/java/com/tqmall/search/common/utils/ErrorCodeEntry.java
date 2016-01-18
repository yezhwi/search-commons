package com.tqmall.search.common.utils;

import com.tqmall.search.common.result.ErrorCode;

/**
 * Created by xing on 16/1/4.
 * 字符串{@link ErrorCode#getCode()}对应的实例
 */
public final class ErrorCodeEntry {
    /**
     * 系统码
     */
    private int systemCode;

    /**
     * 错误级别
     */
    private ErrorCode.Level level;

    /**
     * 异常码
     */
    private int exceptionCode;

    /**
     * 参数的顺序不要搞错
     */
    private ErrorCodeEntry(int systemCode, ErrorCode.Level level, int exceptionCode) {
        this.systemCode = systemCode;
        this.level = level;
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public ErrorCode.Level getLevel() {
        return level;
    }

    public int getSystemCode() {
        return systemCode;
    }

    @Override
    public String toString() {
        return "[" + systemCode + ", " + level + ", " + exceptionCode + ']';
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {

        private int systemCode, exceptionCode;

        private ErrorCode.Level level;

        public Builder systemCode(int systemCode) {
            this.systemCode = systemCode;
            return this;
        }

        public Builder exceptionCode(int exceptionCode) {
            this.exceptionCode = exceptionCode;
            return this;
        }

        public Builder level(ErrorCode.Level level) {
            this.level = level;
            return this;
        }

        public ErrorCodeEntry create() {
            return new ErrorCodeEntry(systemCode, level, exceptionCode);
        }
    }
}