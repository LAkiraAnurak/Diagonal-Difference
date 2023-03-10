package pack1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class DDResult {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) 
    {
    // Write your code here
        int firstDiag=0;
            for(int i=0;i<arr.size();i++)
            {
                List<Integer> inArr=arr.get(i);
                for(int j=0;j<inArr.size();j++)
                {
                    if(i==j) firstDiag+=inArr.get(j);
                }
            }
        int secondDiag=0;
            for(int i=0;i<arr.size();i++)
            {
                List<Integer> inArr=arr.get(i);
                for(int j=0;j<inArr.size();j++)
                {
                    if((inArr.size()-j-1)==i) secondDiag+=inArr.get(j);
                }
            }
        int diff=firstDiag-secondDiag;
        if(diff<0) diff=-diff;
        return diff;
    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DDResult.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}