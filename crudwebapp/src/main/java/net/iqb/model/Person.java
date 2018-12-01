package net.iqb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import net.iqb.common.PersonType;

/**
 *
 * @author gershom
 */
@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "date_of_birth", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(name = "telephone_number", nullable = true)
    private String telephoneNumber;
    @Column(name = "mobile_number", nullable = true)
    private String mobileNumber;
    @Column(name = "twitter_handle", nullable = true)
    private String twitterHandle;
    @Column(name = "facebook_handle", nullable = true)
    private String facebookHandle;
    @Column(name = "addresses", nullable = false)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<Address>();
    @Column(name = "person_type", nullable = false)
    private PersonType personType;
    
    public Person(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public String getFacebookHandle() {
        return facebookHandle;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public void setFacebookHandle(String facebookHandle) {
        this.facebookHandle = facebookHandle;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
    
    public void addAddress(Address address)
    {
        this.addresses.add(address);
    }
}
