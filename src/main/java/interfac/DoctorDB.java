package interfac;

import models.Doctor;

import java.util.List;

public interface DoctorDB {
    //CRUD
    //Create a doctor
    void add(Doctor doctor);

    //Read or list all doctor
    List<Doctor> getAll();

    //update a doctor
    void update (int id, String firstName, String lastName, String image, String specialization, String hospital, double experience, Integer phone, double rating, String about);

    //finding a doctor by their id
    Doctor findById(int id);

    //deleting a doctor
    void deleteById(int id);
    void deleteAll();
}


