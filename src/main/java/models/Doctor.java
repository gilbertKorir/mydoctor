package models;

import java.util.Objects;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String image;
    private String category_image;
    private String specialization;
    private String hospital;
    private double experience;
    private Integer phone;
    private double rating;
    private String about;


    public Doctor(int id, String firstName, String lastName, String image, String specialization, String hospital, double experience, Integer phone, double rating, String about) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.specialization = specialization;
        this.hospital = hospital;
        this.experience = experience;
        this.phone = phone;
        this.rating = rating;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                Double.compare(doctor.experience, experience) == 0 &&
                Double.compare(doctor.rating, rating) == 0 &&
                Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName) &&
                Objects.equals(image, doctor.image) &&
                Objects.equals(category_image, doctor.category_image) &&
                Objects.equals(specialization, doctor.specialization) &&
                Objects.equals(hospital, doctor.hospital) &&
                Objects.equals(phone, doctor.phone) &&
                Objects.equals(about, doctor.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, image, category_image, specialization, hospital, experience, phone, rating, about);
    }
}
