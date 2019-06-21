package easy;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


/**
 * 
 * @author Anderson
 * https://www.hackerrank.com/challenges/grading/problem
 */
public class GradingStudents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = gradingStudents(grades);
        result.stream()
        	.forEach(i -> System.out.println(i));
        
        bufferedReader.close();

	}

	/*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    	Integer nextMultiple5;
    	List<Integer> resultGrades = new ArrayList<Integer>();
    	
    	for (Integer integer : grades) {
    		nextMultiple5 = integer;
    		Integer grade = 0;
    		boolean isMultiple5 = false;
    				
    		if(integer < 38) {
    			grade = integer;
    		}else {
    			while(!isMultiple5) {
    				nextMultiple5++;
    				if(nextMultiple5 % 5 == 0) {
    					isMultiple5 = true;
    				}
    			}
    			
    			if(nextMultiple5 - integer < 3) {
    				grade = nextMultiple5;
    			}else {
    				grade = integer;
    			}
    		}
    		
    		resultGrades.add(grade);
		}
   	
    	return resultGrades;
    }
}
