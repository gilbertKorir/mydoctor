package sql2o;

import interfac.DoctorDB;
import models.Doctor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oDoctor implements DoctorDB {

    public Sql2oDoctor() { }

    @Override
    public void add(Doctor doctor) {
        String query = "INSERT INTO doctors(firstName, lastName, image, specialization, hospital, experience, phone, rating, about) values(:firstName, :lastName, :image, :specialization, :hospital, :experience, :phone, :rating, :about)";

        try (Connection conn = DB.sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(doctor)
                    .executeUpdate()
                    .getKey();
            doctor.setId(id);

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Doctor> getAll() {
        String getAllUsers = "SELECT * FROM doctors";
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery(getAllUsers)
                    .executeAndFetch(Doctor.class);
        }


    }

    @Override
    public void update(int id, String firstName, String lastName, String image, String specialization, String hospital, double experience, Integer phone, double rating, String about) {
        String query = "UPDATE doctors SET firstName = :firstName WHERE id=:id";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("firstName", firstName)
                    .addParameter("lastName", lastName)
                    .addParameter("image", image)
                    .addParameter("specialization", specialization)
                    .addParameter("hospital", hospital)
                    .addParameter("experience", experience)
                    .addParameter("phone", phone)
                    .addParameter("rating", rating)
                    .addParameter("about", about)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Doctor findById(int id) {
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery("SELECT * FROM doctors WHERE id= :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Doctor.class);//fetch an individual or single user
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM doctors WHERE id=:id";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM doctors";
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery(query)
                    .executeUpdate();

        } catch (Sql2oException e) {
            System.out.println(e.getMessage());
        }
    }
}








