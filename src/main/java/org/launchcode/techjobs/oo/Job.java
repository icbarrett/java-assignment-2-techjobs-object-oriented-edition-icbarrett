package org.launchcode.techjobs.oo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
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
            String nameLine = "";
            String employerLine = "";
            String locationLine = "";
            String positionTypeLine = "";
            String coreCompetencyLine = "";

            if (getName() == null || getName().isEmpty()) {
                setName("Data not available");
            } else {
                nameLine = "Name: " + getName() + "\n";
            }

            if (getEmployer() == null || getEmployer().getValue().isEmpty()) {
                employerLine = "Employer: Data not available";
            } else {
                employerLine = "Employer: " + getEmployer() + "\n";
            }

            if (getLocation() == null || getLocation().getValue().isEmpty()) {
                locationLine = "Location: Data not available\n";
            } else {
                locationLine = "Location: " + getLocation() + "\n";            }

            if (getPositionType() == null || getPositionType().getValue().isEmpty()) {
                positionTypeLine = "Position Type: Data not available\n";
            } else {
                positionTypeLine = "PositionType: " + getPositionType() + "\n";
            }

            if (getCoreCompetency() == null || getCoreCompetency().getValue().isEmpty()) {
                coreCompetencyLine = "Core Competency: Data not available\n";
            } else {
                coreCompetencyLine = "Core Competency: " + getCoreCompetency() + "\n";
            }

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
