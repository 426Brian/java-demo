package com.designPattern.old.filter;

import java.util.List;

/**
 * Created by Brian in 2:47 2018/11/24
 */
public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);

        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
