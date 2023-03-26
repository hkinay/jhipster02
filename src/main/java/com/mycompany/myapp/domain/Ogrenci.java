package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Ogrenci.
 */
@Entity
@Table(name = "ogrenci")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Ogrenci implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "adi_soyadi")
    private String adiSoyadi;

    @Column(name = "ogr_no")
    private Integer ogrNo;

    @Column(name = "cinsiyeti")
    private Boolean cinsiyeti;

    @Column(name = "dogum_tarihi")
    private Instant dogumTarihi;

    @OneToMany(mappedBy = "ogrenci")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "ogretmen", "ogrenci" }, allowSetters = true)
    private Set<Sinif> sinifs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Ogrenci id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdiSoyadi() {
        return this.adiSoyadi;
    }

    public Ogrenci adiSoyadi(String adiSoyadi) {
        this.setAdiSoyadi(adiSoyadi);
        return this;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public Integer getOgrNo() {
        return this.ogrNo;
    }

    public Ogrenci ogrNo(Integer ogrNo) {
        this.setOgrNo(ogrNo);
        return this;
    }

    public void setOgrNo(Integer ogrNo) {
        this.ogrNo = ogrNo;
    }

    public Boolean getCinsiyeti() {
        return this.cinsiyeti;
    }

    public Ogrenci cinsiyeti(Boolean cinsiyeti) {
        this.setCinsiyeti(cinsiyeti);
        return this;
    }

    public void setCinsiyeti(Boolean cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public Instant getDogumTarihi() {
        return this.dogumTarihi;
    }

    public Ogrenci dogumTarihi(Instant dogumTarihi) {
        this.setDogumTarihi(dogumTarihi);
        return this;
    }

    public void setDogumTarihi(Instant dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public Set<Sinif> getSinifs() {
        return this.sinifs;
    }

    public void setSinifs(Set<Sinif> sinifs) {
        if (this.sinifs != null) {
            this.sinifs.forEach(i -> i.setOgrenci(null));
        }
        if (sinifs != null) {
            sinifs.forEach(i -> i.setOgrenci(this));
        }
        this.sinifs = sinifs;
    }

    public Ogrenci sinifs(Set<Sinif> sinifs) {
        this.setSinifs(sinifs);
        return this;
    }

    public Ogrenci addSinif(Sinif sinif) {
        this.sinifs.add(sinif);
        sinif.setOgrenci(this);
        return this;
    }

    public Ogrenci removeSinif(Sinif sinif) {
        this.sinifs.remove(sinif);
        sinif.setOgrenci(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ogrenci)) {
            return false;
        }
        return id != null && id.equals(((Ogrenci) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Ogrenci{" +
            "id=" + getId() +
            ", adiSoyadi='" + getAdiSoyadi() + "'" +
            ", ogrNo=" + getOgrNo() +
            ", cinsiyeti='" + getCinsiyeti() + "'" +
            ", dogumTarihi='" + getDogumTarihi() + "'" +
            "}";
    }
}
