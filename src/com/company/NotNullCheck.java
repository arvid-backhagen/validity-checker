package com.company;

public class NotNullCheck extends ValidityCheck{
    private boolean notNull;
    private String input;

    NotNullCheck(String input){
        this.input = input;
    }
    @Override
    public void validate() {
        notNull = this.input != null;
        this.setValid(notNull);
    }

    @Override
    public String toString() {
        if(notNull) return "String is not null and is: " + input ;
        return "Expected String was null";
    }
}
