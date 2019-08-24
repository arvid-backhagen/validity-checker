package com.company;

public abstract class ValidityCheck {
    boolean valid;

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid(){
        this.validate();
        return this.valid;
    }
    public abstract void validate();

    public abstract String toString();
}
