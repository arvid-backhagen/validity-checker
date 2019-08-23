package com.company;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

class Tests {

    @Test
    void testNotNull() {
        NotNullCheck notNull = new NotNullCheck("hej");
        notNull.validate();
        NotNullCheck isNull = new NotNullCheck(null);
        isNull.validate();
        NotNullCheck isEmpty = new NotNullCheck("");
        isEmpty.validate();

        Assert.assertEquals(true, notNull.isValid());
        Assert.assertEquals(false, isNull.isValid());
        Assert.assertEquals(true, isEmpty.isValid());
    }
    @Test
    void testNotEmpty() {
        NotEmptyCheck notEmpty = new NotEmptyCheck("19940827-3333");
        notEmpty.validate();
        NotEmptyCheck isNull = new NotEmptyCheck(null);
        isNull.validate();
        NotEmptyCheck isEmpty = new NotEmptyCheck("");
        isEmpty.validate();

        Assert.assertEquals(true, notEmpty.isValid());
        Assert.assertEquals(true, isNull.isValid());
        Assert.assertEquals(false, isEmpty.isValid());
    }
    @Test
    void testPersonalNumberFormat() {

        String[] workingPns = {"19780202-9707", "19551111-6250", "19891005-0866", "19241105-7801", "19820411-2380" };
        String[] notWorking = {"20780202-9716", "1-552111-6250", "19551131-6260", "19994455-9040" };
        for (String pn :  workingPns) {
            PersonalNumberFormatCheck shouldWork = new PersonalNumberFormatCheck(pn);
            shouldWork.validate();
            System.out.println(shouldWork);
            Assert.assertEquals(true, shouldWork.isValid());
            System.out.println("-------------------------------------------------------");

        }
        for (String pn :  notWorking) {
            PersonalNumberFormatCheck shouldNotWork = new PersonalNumberFormatCheck(pn);
            shouldNotWork.validate();
            System.out.println(shouldNotWork);
            Assert.assertEquals(false, shouldNotWork.isValid());
            System.out.println("-------------------------------------------------------");

        }


    }
    @Test
    void testPersonalNumber() {
        String[] workingPns = {"19780202-9707", "19551111-6260", "19891005-0866", "19241105-7801", "19820411-2380", };
        String[] notWorking = {"19780202-9716", "19551111-6250", };

        for (String pn :  workingPns) {
            PersonalNumberCheck shouldWork = new PersonalNumberCheck(pn);
            shouldWork.validate();
            System.out.println(shouldWork);
            Assert.assertEquals(true, shouldWork.isValid());
            System.out.println("-------------------------------------------------------");
        }
        for (String pn :  notWorking) {
            PersonalNumberCheck shouldNotWork = new PersonalNumberCheck(pn);
            shouldNotWork.validate();
            System.out.println(shouldNotWork);
            Assert.assertEquals(false, shouldNotWork.isValid());
            System.out.println("-------------------------------------------------------");

        }
    }
    @Test
    void testValidityChecker() {
        String[] workingPns = {"19780202-9707", "19551111-6260", "19891005-0866", "19241105-7801", "19820411-2380", };
        String[] notWorking = {"19780202-9716", "19551111-6250", null, "" };

        for (String pn :  workingPns) {
            ValidityChecker shouldWork = new ValidityChecker(pn);
            shouldWork.addValidityCheck("NOTNULL");
            shouldWork.addValidityCheck("NOTEMPTY");
            shouldWork.addValidityCheck("PERSONALNUMBERFORMAT");
            shouldWork.addValidityCheck("PERSONALNUMBER");

            Assert.assertEquals(true, shouldWork.isValid());
            System.out.println("-------------------------------------------------------");

        }
        for (String pn :  notWorking) {
            ValidityChecker shouldNotWork = new ValidityChecker(pn);
            shouldNotWork.addValidityCheck("NOTNULL");
            shouldNotWork.addValidityCheck("NOTEMPTY");
            shouldNotWork.addValidityCheck("PERSONALNUMBERFORMAT");
            shouldNotWork.addValidityCheck("PERSONALNUMBER");

            Assert.assertEquals(false, shouldNotWork.isValid());
            System.out.println("-------------------------------------------------------");

        }
    }
}