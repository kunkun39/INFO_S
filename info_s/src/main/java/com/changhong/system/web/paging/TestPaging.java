package com.changhong.system.web.paging;

import java.util.List;

/**
 * User: pengjie
 * Date: 2016/3/11
 * Time: 10:30
 */
public class TestPaging extends AbstractPaging<Object> {
    @Override
    public List<Object> getItems() {
        return null;
    }

    @Override
    public long getTotalItemSize() {
        return 50;
    }

    @Override
    public String getParameterValues() {
        return null;
    }
}
