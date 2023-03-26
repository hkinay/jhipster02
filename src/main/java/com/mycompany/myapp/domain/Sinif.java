package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.myapp.domain.enumeration.Brans;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Sinif.
 */
@Entity
@Table(name = "sinif")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Sinif implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "sinif_adi")
    private String sinifAdi;

    @Column(name = "sinif_kodu")
    private String sinifKodu;

    @Enumerated(EnumType.STRING)
    @Column(name = "brans")
    private Brans brans;

    @JsonIgnoreProperties(value = { "sinif" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private Ogretmen ogretmen;

    @ManyToOne
    @JsonIgnoreProperties(value = { "sinifs" }, allowSetters = true)
    private Ogrenci ogrenci;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Sinif id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSinifAdi() {
        return this.sinifAdi;
    }

    public Sinif sinifAdi(String sinifAdi) {
        this.setSinifAdi(sinifAdi);
        return this;
    }

    public void setSinifAdi(String sinifAdi) {
        this.sinifAdi = sinifAdi;
    }

    public String getSinifKodu() {
        return this.sinifKodu;
    }

    public Sinif sinifKodu(String sinifKodu) {
        this.setSinifKodu(sinifKodu);
        return this;
    }

    public void setSinifKodu(String sinifKodu) {
        this.sinifKodu = sinifKodu;
    }

    public Brans getBrans() {
        return this.brans;
    }

    public Sinif brans(Brans brans) {
        this.setBrans(brans);
        return this;
    }

    public void setBrans(Brans brans) {
        this.brans = brans;
    }

    public Ogretmen getOgretmen() {
        return this.ogretmen;
    }

    public void setOgretmen(Ogretmen ogretmen) {
        this.ogretmen = ogretmen;
    }

    public Sinif ogretmen(Ogretmen ogretmen) {
        this.setOgretmen(ogretmen);
        return this;
    }

    public Ogrenci getOgrenci() {
        return this.ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Sinif ogrenci(Ogrenci ogrenci) {
        this.setOgrenci(ogrenci);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sinif)) {
            return false;
        }
        return id != null && id.equals(((Sinif) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Sinif{" +
            "id=" + getId() +
            ", sinifAdi='" + getSinifAdi() + "'" +
            ", sinifKodu='" + getSinifKodu() + "'" +
            ", brans='" + getBrans() + "'" +
            "}";
    }
}
