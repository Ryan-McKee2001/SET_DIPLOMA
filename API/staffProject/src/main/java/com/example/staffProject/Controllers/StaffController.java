package com.example.staffProject.Controllers;

import com.example.staffProject.models.Management;
import com.example.staffProject.repository.MySQLData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StaffController {

    @Autowired
    MySQLData mySQLData;

    @GetMapping("/get-all-staff")
    public List<Management> getAllStaff() {
        return mySQLData.findAll();
    }

    @GetMapping("/get-staff/{id}")
    public Management getSingleStaffMember(@PathVariable Integer id) {
        return mySQLData.findById(id).get();
    }

    @GetMapping("/delete-staff/{id}")
    public boolean deleteStaffRequest(@PathVariable Integer id) {
        if(!mySQLData.findById(id).equals(Optional.empty())){
            mySQLData.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update-staff/{id}")
    public Management updateStaffRequest(@PathVariable Integer id,
                                         @RequestBody Map<String, String> bodyReceived) {
        Management currentRecord = mySQLData.findById(id).get();
        currentRecord.setForename(bodyReceived.get("forename"));
        currentRecord.setSurname(bodyReceived.get("surname"));
        currentRecord.setDeptNumber(Integer.parseInt(bodyReceived.get("deptnumber")));
        mySQLData.save(currentRecord);
        return currentRecord;
    }

    @PostMapping("/add-new-staff-member")
    public Management addNewStaffRequest(@RequestBody Map<String, String> bodyReceived ) {
        String forename = bodyReceived.get("forename");
        String surname = bodyReceived.get("surname");
        Integer deptNo = Integer.parseInt(bodyReceived.get("deptnumber"));

        Management newStaffMember = new Management(forename, surname, deptNo);

        mySQLData.save(newStaffMember);
        return newStaffMember;
    }

    @DeleteMapping("/delete-staff-member/{id}")
    public boolean deleteStaffMember(@PathVariable Integer id) {

        if(mySQLData.findById(id).get() != null) {
            mySQLData.deleteById(id);
            return true;
        }
        return false;
    }
}
