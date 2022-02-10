package org.launchcode.techjobs.oo;

import static org.junit.Assert.assertTrue;

public class Job {

    private int id;
    private static int nextId = 1;
    private String value;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Job)) return false;
        if (!super.equals(object)) return false;
        Job job = (Job) object;
        return getId() == job.getId();
    }

    public int hashCode() {
        return java.util.Objects.hash(
                new Object[]{super.hashCode(), getId()});
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // Add toString Method
    @Override
    public String toString() {
        if ((getName() == null) && (getLocation() == null) && (getEmployer() == null) && (getCoreCompetency() == null) && (getPositionType() == null)) {
            return "\nOOPS! This job does not exist\n";
        } else {
            String printString = "";
            String blankLine = "\n";
            String idLine = "ID: " + getId() + "\n";
            String nameLine = "Name: " + getName() + "\n";
            String employerLine = "Employer: " + getEmployer() + "\n";
            String locationLine = "Location: " + getLocation() + "\n";
            String positionTypeLine = "PositionType: " + getPositionType() + "\n";
            String coreCompetencyLine = "Core Competency: " + getCoreCompetency() + "\n";

            printString = blankLine +
                    idLine +
                    nameLine +
                    employerLine +
                    locationLine +
                    positionTypeLine +
                    coreCompetencyLine;

            return printString;
        }
    }

}
