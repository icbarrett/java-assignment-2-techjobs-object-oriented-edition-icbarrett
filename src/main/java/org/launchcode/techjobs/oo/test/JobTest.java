package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job emptyJob1;
    Job emptyJob2;
    Job fullConstructorJob1;
    Job fullConstructorJob2;

    @Before
    public void createJobObjects() {
        emptyJob1 = new Job();
        emptyJob2 = new Job();
        fullConstructorJob1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        fullConstructorJob2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        emptyJob1 = new Job();
        emptyJob2 = new Job();
        assertEquals(emptyJob1.getId() + 1, emptyJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester",
                fullConstructorJob1.getName());
        assert (fullConstructorJob1.getEmployer() instanceof Employer);
        assert (fullConstructorJob1.getLocation() instanceof Location);
        assert (fullConstructorJob1.getPositionType() instanceof PositionType);
        assert (fullConstructorJob1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(fullConstructorJob1.equals(fullConstructorJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        assertTrue(emptyJob1.toString().startsWith("\n"));
        assertTrue(emptyJob1.toString().endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        // test ID Line
        String idLine = "ID: " + String.valueOf(fullConstructorJob1.getId()) + "\n";
        assertTrue(fullConstructorJob1.toString().contains(idLine));

        // test Name line
        String nameLine = "Name: " + fullConstructorJob1.getName() + "\n";
        assertTrue(fullConstructorJob1.toString().contains(nameLine));

        // test Employer line
        String employerLine = "Employer: " + fullConstructorJob1.getEmployer() + "\n";
        assertTrue(fullConstructorJob1.toString().contains(employerLine));

        // test Location line
        String locationLine = "Location: " + fullConstructorJob1.getLocation() + "\n";
        assertTrue(fullConstructorJob1.toString().contains(locationLine));

        // test PositionType line
        String PositionTypeLine = "Position Type: " + fullConstructorJob1.getPositionType() + "\n";
        assertTrue(fullConstructorJob1.toString().contains(PositionTypeLine));

        // test CoreCompetency line
        String coreCompetencyLine = "Core Competency: " + fullConstructorJob1.getCoreCompetency() + "\n";
        assertTrue(fullConstructorJob1.toString().contains(coreCompetencyLine));
    }

    @Test
    public void testOnlyID() {
        if (emptyJob1.getName() == null &&
                emptyJob1.getLocation() == null &&
                emptyJob1.getEmployer() == null &&
                emptyJob1.getCoreCompetency() == null &&
                emptyJob1.getPositionType() == null) {
            assertTrue(emptyJob1.toString().contains("\nOOPS! This job does not exist\n"));
        }
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJobEmptyName;

        //test for Name field
        testJobEmptyName = new Job("",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(testJobEmptyName.toString().contains("Name: Data not available"));

        //test for Employer field
        Job testJobEmptyEmployer = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJobEmptyEmployer.toString().contains("Employer: Data not available"));

        //test for Location field
        Job testJobEmptyLocation = new Job("Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(testJobEmptyLocation.toString().contains("Location: Data not available"));

        //test for PositionType field
        Job testJobEmptyPositionType = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType(""),
                new CoreCompetency("Persistence"));
        assertTrue(testJobEmptyPositionType.toString().contains("Position Type: Data not available"));

        //test for PositionType field
        Job testJobEmptyCoreCompetency = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency(""));
        assertTrue(testJobEmptyCoreCompetency.toString().contains("Core Competency: Data not available"));

    }
}






