package com.example.model;

public class MedicalDeclaration {
    private String name;
    private String dayOfBirth;
    private String gender;
    private String country;
    private int idCard;
    private String travelInformation;
    private String license;
    private int numberOfSeat;
    private int departureDay;
    private int departureMonth;
    private int departureYear;
    private int endDay;
    private int endMonth;
    private int endYear;
    private String travelHistory;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, String dayOfBirth, String gender, String country, int idCard,
                              String travelInformation, String license, int numberOfSeat, int departureDay,
                              int departureMonth, int departureYear, int endDay, int endMonth, int endYear,
                              String travelHistory) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.license = license;
        this.numberOfSeat = numberOfSeat;
        this.departureDay = departureDay;
        this.departureMonth = departureMonth;
        this.departureYear = departureYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.travelHistory = travelHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(int departureDay) {
        this.departureDay = departureDay;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(int departureMonth) {
        this.departureMonth = departureMonth;
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(int departureYear) {
        this.departureYear = departureYear;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }
}
