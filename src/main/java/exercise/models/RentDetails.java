package exercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RentDetails {

    @JsonProperty
    private Date rentExpireDate;

    public RentDetails(){}

    public RentDetails(Date rentExpireDate) {
        this.rentExpireDate = rentExpireDate;
    }

    public Date getRentExpireDate() {
        return rentExpireDate;
    }

    public void setRentExpireDate(Date rentExpireDate) {
        this.rentExpireDate = rentExpireDate;
    }

}
