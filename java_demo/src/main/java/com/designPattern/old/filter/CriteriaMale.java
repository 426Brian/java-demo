package com.designPattern.old.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian in 2:43 2018/11/24
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("male")){
                malePersons.add(person);
            }
        }
        return null;
    }
}
