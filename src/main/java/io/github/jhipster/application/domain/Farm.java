package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Farm.
 */
@Entity
@Table(name = "farm")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Farm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "company_legal_person")
    private String companyLegalPerson;

    @Column(name = "registered_capital")
    private String registeredCapital;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "address")
    private String address;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "jhi_scope")
    private String scope;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "province")
    private String province;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Farm companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public Farm companyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
        return this;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyLegalPerson() {
        return companyLegalPerson;
    }

    public Farm companyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson;
        return this;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public Farm registeredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
        return this;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getEmail() {
        return email;
    }

    public Farm email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Farm phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Farm createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public Farm address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public Farm webAddress(String webAddress) {
        this.webAddress = webAddress;
        return this;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getScope() {
        return scope;
    }

    public Farm scope(String scope) {
        this.scope = scope;
        return this;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Farm longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Farm latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getProvince() {
        return province;
    }

    public Farm province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Farm farm = (Farm) o;
        if (farm.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), farm.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Farm{" +
            "id=" + getId() +
            ", companyName='" + getCompanyName() + "'" +
            ", companyLocation='" + getCompanyLocation() + "'" +
            ", companyLegalPerson='" + getCompanyLegalPerson() + "'" +
            ", registeredCapital='" + getRegisteredCapital() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", address='" + getAddress() + "'" +
            ", webAddress='" + getWebAddress() + "'" +
            ", scope='" + getScope() + "'" +
            ", longitude=" + getLongitude() +
            ", latitude=" + getLatitude() +
            ", province='" + getProvince() + "'" +
            "}";
    }
}
