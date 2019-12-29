package com.designPattern.old.filter;

import java.util.List;

/**
 * Created by Brian in 2:43 2018/11/24
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
