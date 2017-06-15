package com.boot.process;

import com.boot.model.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * Created by Admin on 2017/6/15.
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException {

        //需要执行此方法super.process(T item)才会调用自定义校验器
        super.process(item);

        if (item.getNation().equals("汉族")) {
            item.setNation("01");
        } else {
            item.setNation("02");
        }
        return item;
    }
}
