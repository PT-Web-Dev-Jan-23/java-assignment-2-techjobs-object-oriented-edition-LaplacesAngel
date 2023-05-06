package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    //Consider the following questions to help you decide what code to put in the JobField class:

    //What fields do ALL FOUR of the classes have in common?
    //    private int id;
    //    private static int nextId = 1;
    //    private String value;

    //Which constructors are the same in ALL FOUR classes?
    //  public CoreCompetency() {
    //        this.id = nextId;
    //        nextId++;
    //    }
    //
    //    public CoreCompetency(String value) {
    //        this();
    //        this.value = value;

    //What getters and setters do ALL of the classes share?
    //    public int getId() {
    //        return id;
    //    }
    //
    //    public String getValue() {
    //        return value;
    //    }
    //
    //    public void setValue(String value) {
    //        this.value = value;
    //    }


    //Which custom methods are identical in ALL of the classes?
    //  @Override
    //    public String toString() {
    //        return value;
    //    }

    //  @Override
    //    public int hashCode() {
    //        return Objects.hash(id);
    //    }


    //In JobField, declare each of the common fields.
    private final int id;
    private static int nextId = 1;
    private String value;

    //Code the constructors.


    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }


    //Use Generate to create the appropriate getters and setters.

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    //Add in the custom methods.

    @Override
    public String toString() {
        return value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
