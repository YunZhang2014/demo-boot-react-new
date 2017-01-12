package com.example;

import mcdonaldapp.Branch;
import mcdonaldapp.BranchReader;
import mcdonaldapp.CSVBranchReader;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YunZhang on 12/1/17.
 */
@RestController
public class BranchController {
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/getBranches")
    public List<Branch> getBranches(@RequestParam(value="sorted", defaultValue="false") boolean sorted){
        BranchReader branchReader = new CSVBranchReader();
        ArrayList<Branch> branches = branchReader.readBranch();

        //sort the branches by title
        if (sorted){
            sortBranches(branches);
        }
        return branches;
    }

    //selection sort
    private static void sortBranches(ArrayList<Branch> branches) {
        for (int i = 0; i < branches.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < branches.size(); j++)
                if (branches.get(j).getTitle().compareTo(branches.get(index).getTitle()) < 0)
                    index = j;

            Branch smaller = branches.get(index);
            branches.set(index,branches.get(i));
            branches.set(i,smaller);
        }
    }
}
