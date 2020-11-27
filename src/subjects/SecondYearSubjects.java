package subjects;

public class SecondYearSubjects {
	public SecondYearSubjects(String subjects[], String branch, String semester) {
		if(branch.equals("Computer Science And Engineering(CSE)")) {
			if(semester.equals("III")) {
				subjects[0] = "Engineering Mathematics III (3RCS001)";
				subjects[1] = "Data Structures and Algorithms (3RCS002)";
				subjects[2] = "Computer Organization (3RCS003)";
				subjects[3] = "Operating Systems (3RCS004)";
				subjects[4] = "Analog and Digital Circuits (3RCS005)";
				subjects[5] = "Discrete Mathematics (3RCS006)";
				subjects[6] = "Data Structures and Algorithms Lab (1RCSL01)";
				subjects[7] = "Analog and Digiatl Circuits Lab (1RCSL02)";
			} else {
				subjects[0] = "Probablity and Stattistics for Information Technology (4RCS001)";
				subjects[1] = "Theory Of Computations (4RCS002)";
				subjects[2] = "Analysis and Design of Algorithms (4RCS003)";
				subjects[3] = "Unix and Shell Programming (4RCS004)";
				subjects[4] = "MicroControllers and Embedded C Programming (4RCS005)";
				subjects[5] = "Constitution Of India and Professional Ethics";
				subjects[6] = "Microcontroller Lab (4RCSL01)";
				subjects[7] = "Analysis and Design of Algorithms Lab (4RCSL02)";
			}
		}
		
	}
}
