/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author OCTI01
 */
@Entity
@Table(name = "pacote")
@NamedQueries({
    @NamedQuery(name = "Pacote.findAll", query = "SELECT p FROM Pacote p")})
public class Pacote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fim")
    @Temporal(TemporalType.DATE)
    private Date fim;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "preco")
    private double preco;
    @JoinColumn(name = "tipoQuarto_id", referencedColumnName = "id")
    @ManyToOne
    private TipoQuarto tipoQuartoid;
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @ManyToOne
    private Hotel hotelId;
    @JoinColumn(name = "voo_id", referencedColumnName = "id")
    @ManyToOne
    private Voo vooId;

    public Pacote() {
    }

    public Pacote(Integer id) {
        this.id = id;
    }

    public Pacote(Integer id, double preco) {
        this.id = id;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoQuarto getTipoQuartoid() {
        return tipoQuartoid;
    }

    public void setTipoQuartoid(TipoQuarto tipoQuartoid) {
        this.tipoQuartoid = tipoQuartoid;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public Voo getVooId() {
        return vooId;
    }

    public void setVooId(Voo vooId) {
        this.vooId = vooId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacote)) {
            return false;
        }
        Pacote other = (Pacote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.PraticaDragDrop.model.entity.Pacote[ id=" + id + " ]";
    }
    
}
