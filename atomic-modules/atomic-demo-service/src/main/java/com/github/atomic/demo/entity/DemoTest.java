package com.github.atomic.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author an
 * @since 2019-01-07
 */
@TableName("demo_test")
public class DemoTest extends Model<DemoTest> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DemoTest{" +
        ", id=" + id +
        ", name=" + name +
        ", age=" + age +
        "}";
    }
}
