package subjects;

public class FirstYearSubjects {
	public FirstYearSubjects(String subjects[], String branch, String semester) {
		if(branch.equals("Computer Science And Engineering(CSE)")) {
			if(semester.equals("I")) {
				subjects[0] = "Engineering Mathematics I (1RCS001)";
				subjects[1] = "Basic Electrical Engineering (1RCS002)";
				subjects[2] = "Engineering Physics (1RCS003)";
				subjects[3] = "Engineering Mechanics (1RCS004)";
				subjects[4] = "Basic Electrical Engineering Lab (1RCSL01)";
				subjects[5] = "Engineering Physics Lab (1RCSL02)";
				subjects[6] = "Mechanical CAED Lab (1RCSL03)";
			} else {
				subjects[0] = "Engineering Mathematics II (2RCS001)";
				subjects[1] = "Basic Electronics (2RCS002)";
				subjects[2] = "C Programming Language (2RCS003)";
				subjects[3] = "Engineering Chemistry (2RCS004)";
				subjects[4] = "Engineering Chemistry Lab (2RCSL01)";
				subjects[5] = "C Programming Lab (2RCSL02)";
				subjects[6] = "Mechanical Workshop (2RCSL03)";
			}
		}
		
		
	}
}
