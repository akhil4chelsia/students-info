package com.cms.helper;

import java.util.List;

public interface DBHelper {
 
    public boolean execute(String query);

    public <T> List<T> query(String query, Class<T> clazz);

}
