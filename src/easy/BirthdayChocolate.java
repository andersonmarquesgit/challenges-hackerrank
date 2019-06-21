package easy;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * @author Anderson
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class BirthdayChocolate {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println(result);

	}
	
	// Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
    	int count = 0;
        for (int i = 0; i < s.size() - m + 1; i++){
        	int sum = 0;
            for (int j = 0; j < m; j++){
                sum = sum + s.get(i + j);
            }
            if (sum == d) {
                count++;
            }
            
        }

        return count;

    }

}
