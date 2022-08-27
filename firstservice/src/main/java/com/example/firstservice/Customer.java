package com.example.firstservice;

public class Customer {
    private String ID;
    private String name;
    private boolean sex;
    private int age;

    public Customer() {
        this("", null,false, 0);
    }

    public Customer(String Id, String n, boolean s, int a){
        this.ID = Id;
        this.name = n;
        this.sex = s;
        this.age = a;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(String sex) {
        if(sex.equals("male")){
            this.sex = true;
        }else if(sex.equals("female")){
            this.sex = false;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            this.age = 0;
        }else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

}
