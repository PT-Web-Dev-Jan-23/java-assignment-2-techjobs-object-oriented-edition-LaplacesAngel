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

    @Before
    public void createJob1(){
       Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
        assertNotEquals(emptyJob1.getId(), emptyJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //Test that equals returns false.
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        //When passed a Job object, it should return a string that contains a blank line before and after the job information.
        //This test should check that the first and last characters of the string both the newline character, \n.
        //Recall that can get the character at a given position in a string using the string method charAt.
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = job1.toString();
        assertEquals('\n',string.charAt(0));
        assertEquals('\n',string.charAt(string.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        //The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.
        //ID:  _______
        //Name: _______
        //Employer: _______
        //Location: _______
        //Position Type: _______
        //Core Competency: _______

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = job1.toString();
        assertEquals('\n' +
                "ID: 9\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                '\n', string);
    }

    @Test
    //If a field is empty, the method should add Data not available after the label.
    //Did the bonus too: If all fields are empty return  "OOPS! This job does not seem to exist."
    public void testToStringHandlesEmptyField(){
        Job productTesterJob = new Job("Product Tester",null,null,null,null);
        Job noNameJob = new Job(null, new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job emptyJob = new Job();

        String string = productTesterJob.toString();
        String noNameJobString = noNameJob.toString();
        String emptyJobString = emptyJob.toString();

        assertEquals('\n' +
                "ID: 5\n" +
                "Name: Product Tester\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available" +
                '\n', string);

        assertEquals('\n' +
                "ID: 6\n" +
                "Name: Data not available\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                '\n', noNameJobString);

        assertEquals("OOPS! This job does not seem to exist.", emptyJobString);

    }

}
