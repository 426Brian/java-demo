package com.designPattern.old.filter;

import java.util.List;

/**
 * Created by Brian in 2:49 2018/11/24
 */
public class OrCriteria implements Criteria{
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);
        firstCriteriaPersons.removeAll(otherCriteriaItems);
        otherCriteriaItems.addAll(firstCriteriaPersons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
