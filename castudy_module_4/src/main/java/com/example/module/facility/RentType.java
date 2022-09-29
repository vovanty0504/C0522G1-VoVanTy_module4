package com.example.module.facility;


import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;
    private String rentTypeName;

    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facilitySet;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, Set<Facility> facilitySet) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.facilitySet = facilitySet;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
