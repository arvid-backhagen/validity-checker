package com.company;

import java.util.ArrayList;

public class ValidityChecker {
    private ArrayList<ValidityCheck> validations = new ArrayList<ValidityCheck>();
    private boolean valid = true;
    private String input;

    ValidityChecker (String input){
        this.input = input;
    }
    public void addValidityCheck (String checkType) {
//      checkType could probably be extracted into some constants handler
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
    public boolean isValid() {
        this.runValidations();
        return this.valid;
    }
}
