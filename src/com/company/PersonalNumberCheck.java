package com.company;

public class PersonalNumberCheck extends ValidityCheck{
    private String pn;

    PersonalNumberCheck(String pn){
        this.pn = pn;
    }

    public void validate() {
        int lastNumber;
        try {
            lastNumber = Integer.parseInt(this.pn.substring(this.pn.length()-1));
            String trimmedPn = this.pn.substring(2, 8) + this.pn.substring(9);
            int[] sumArr = new int[9];
            for (int i = 0; i < 9; i++) {
                int number = Integer.parseInt(trimmedPn.substring(i, i +1));
                if(i % 2 == 0) {
                    int newNumber = number*2;
                    if(newNumber > 9)  newNumber = 1 + newNumber%10;
                    sumArr[i] = newNumber;
                } else {
                    sumArr[i] = number;
                }
            }

            int total = sumArr[0] + sumArr[1] + sumArr[2] + sumArr[3] + sumArr[4] + sumArr[5] + sumArr[6] + sumArr[7] +
                    sumArr[8];

            total = total % 10;
            if((10 - total) % 10 == lastNumber){
                this.setValid(true);
            }else {
                this.setValid(false);
            }
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("Poorly formatted personal number");
        }
    }

    @Override
    public String toString() {
        if(this.isValid()){
            return this.pn + " is a valid personal number.";
        } else {
            return this.pn + " is an invalid personal number.";
        }
    }
}
