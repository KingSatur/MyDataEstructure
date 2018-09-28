package examenPratico2018;

import java.util.Comparator;

public class CompareStudents implements Comparator<Estudiante>{

	@Override
	public int compare(Estudiante u1, Estudiante u2) {	
		
		if(u1.getPromedio() < u2.getPromedio()) {
			return 1;
		}
		if(u1.getPromedio() == u2.getPromedio()) {
			if(u1.getSexo().equals("H") && u2.getSexo().equals("M")) {
				return 1;				
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
	}
	
	
	
	
	
	
	

}
