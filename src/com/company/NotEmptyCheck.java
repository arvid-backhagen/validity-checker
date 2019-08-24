package com.company;

public class NotEmptyCheck extends ValidityCheck{
    private boolean notEmpty;
    private String input;

    NotEmptyCheck(String input){
        this.input = input;
    }
    @Override
    public void validate() {
        this.notEmpty = !"".equals(this.input);
        this.setValid(notEmpty);
    }

    @Override
    public String toString() {
        if(this.notEmpty) return "String is not Empty and is: " + this.input;
        return  "String is empty";
    }
}
