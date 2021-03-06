package com.tqmall.search.commons.condition;

import com.tqmall.search.commons.lang.Function;
import com.tqmall.search.commons.lang.StrValueConvert;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Created by xing on 16/1/23.
 * 单个字段相关的条件
 */
public abstract class FieldCondition<T> implements Condition, Serializable {

    private static final long serialVersionUID = 1L;

    private final String field;

    private final StrValueConvert<T> valueConvert;
    /**
     * 是否为非条件
     */
    private final boolean isNo;

    public FieldCondition(String field, StrValueConvert<T> valueConvert, boolean isNo) {
        Objects.requireNonNull(field);
        this.field = field;
        this.valueConvert = valueConvert;
        this.isNo = isNo;
    }

    @Override
    public final Set<String> fields() {
        return Collections.singleton(field);
    }

    @Override
    public final boolean verify(Function<String, String> values) {
        return verify(valueConvert == null ? null : valueConvert.convert(values.apply(field)));
    }

    /**
     * 执行具体的verify操作, 不考虑是否为非条件
     */
    abstract boolean doVerify(T value);

    public final boolean verify(T value) {
        return isNo != doVerify(value);
    }

    public final String getField() {
        return field;
    }

    public final boolean isNo() {
        return isNo;
    }

    public final StrValueConvert<T> getValueConvert() {
        return valueConvert;
    }

    @Override
    public String toString() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldCondition)) return false;

        FieldCondition<?> that = (FieldCondition<?>) o;

        return field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return field.hashCode();
    }
}
