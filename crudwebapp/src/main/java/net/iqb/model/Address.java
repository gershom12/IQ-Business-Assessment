package net.iqb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import net.iqb.common.AddressType;

/**
 *
 * @author gershom
 */

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(name = "surbub")
    private String surbub;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    @Column(name = "line_1")
    private String line1;
    @Column(name = "line_2")
    private String line2;
    @Column(name = "line_3")
    private String line3;
    @Column(name = "line_4")
    private String line4;

    public Address(){}

    public Address(String surbub, String postalCode, AddressType addressType, String line1, String line2, String line3, String line4) {
        this.surbub = surbub;
        this.postalCode = postalCode;
        this.addressType = addressType;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
    }
    
    public String getSurbub() {
        return surbub;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getLine4() {
        return line4;
    }

    public void setSurbub(String surbub) {
        this.surbub = surbub;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public void setLine4(String line4) {
        this.line4 = line4;
    }
}
