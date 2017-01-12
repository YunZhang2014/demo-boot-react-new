package mcdonaldapp;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Yun Zhang on 12/1/17.
 * Reads branches from a CSV file
 */
public class CSVBranchReader implements BranchReader{
    public ArrayList<Branch> readBranch() {
        ArrayList<Branch> branches = new ArrayList<Branch>();
        InputStream inputStream = CSVBranchReader.class.getResourceAsStream("/locations.csv");

        BufferedReader br=null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new InputStreamReader(inputStream));
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                lineCount++;
                // use comma as separator
                if (lineCount > 1){
                    String[] fields = line.split(cvsSplitBy);
                    Branch branch = new Branch();
                    branches.add(branch);
                    branch.setLatitude(Double.parseDouble(fields[0]));
                    branch.setLongitude(Double.parseDouble(fields[1]));
                    branch.setTitle(fields[2]);
                    branch.setAddress(fields[3]+cvsSplitBy+fields[4]);
                    System.out.println("branch: " + branch);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return branches;
    }
}
