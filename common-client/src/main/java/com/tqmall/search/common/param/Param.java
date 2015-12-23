package com.tqmall.search.common.param;

import java.util.Iterator;
import java.util.List;

/**
 * Created by xing on 15/12/5.
 * 参数抽象父类
 */
public abstract class Param {
    /**
     * 记录系统调用来源
     */
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 过滤掉值为null的value
     * 参数建议使用List.
     * Set, Map等开销较大, 不建议使用, 如果需要去重, 可以自己手动处理
     */
    final protected <T> List<T> filterNullValue(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) it.remove();
        }
        return list.isEmpty() ? null : list;
    }

    /**
     * 过滤String
     * 关键字不能为null, 不能为空, 并且trim后不能为空
     */
    final protected String filterString(String q) {
        return (q != null && !q.isEmpty() && !(q = q.trim()).isEmpty()) ? q : null;
    }
}