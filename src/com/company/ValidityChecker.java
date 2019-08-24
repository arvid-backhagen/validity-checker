package com.company;

import java.util.ArrayList;

public class ValidityChecker {
    private ArrayList<ValidityCheck> validations = new ArrayList<ValidityCheck>();
    private boolean valid = true;
    private String input;
    private int numberOfChecks = 0;

    ValidityChecker (String input){
        this.input = input;
    }
    public void addValidityCheck (String checkType) {
        numberOfChecks++;
        if (checkType.equalsIgnoreCase("PERSONALNUMBER")){
            validations.add(new PersonalNumberCheck(this.input));
        } else if( checkType.equalsIgnoreCase("PERSONALNUMBERFORMAT")){
            validations.add(new PersonalNumberFormatCheck(this.input));
        } else if( checkType.equalsIgnoreCase("NOTNULL")){
            validations.add(new NotNullCheck(this.input));
        } else if( checkType.equalsIgnoreCase("NOTEMPTY")){
            validations.add(new NotEmptyCheck(this.input));
        } else {
            System.out.println("No type of validation found");
            numberOfChecks--; // To nullify the call if it was falsely made
        }
    }

    public void runValidations() {
        for(ValidityCheck validation : validations){
            if(!validation.isValid()) {
                this.valid = false;
                System.out.println(validation);
                break;
            }
            System.out.println(validation);
        }
    }
    public int getNumberOfChecks () {
        return numberOfChecks;
    }
    public boolean isValid() {
        this.runValidations();
        return this.valid;
    }
}
