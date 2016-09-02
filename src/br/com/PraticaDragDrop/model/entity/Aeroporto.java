/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author OCTI01
 */
@Entity
@Table(name = "aeroporto")
@NamedQueries({
    @NamedQuery(name = "Aeroporto.findAll", query = "SELECT a FROM Aeroporto a")})
public class Aeroporto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaembarque")
    private Double taxaembarque;
    @JoinColumn(name = "cidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade cidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private Collection<Trajeto> trajetoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origem")
    private Collection<Trajeto> trajetoCollection1;

    public Aeroporto() {
    }

    public Aeroporto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTaxaembarque() {
        return taxaembarque;
    }

    public void setTaxaembarque(Double taxaembarque) {
        this.taxaembarque = taxaembarque;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Collection<Trajeto> getTrajetoCollection() {
        return trajetoCollection;
    }

    public void setTrajetoCollection(Collection<Trajeto> trajetoCollection) {
        this.trajetoCollection = trajetoCollection;
    }

    public Collection<Trajeto> getTrajetoCollection1() {
        return trajetoCollection1;
    }

    public void setTrajetoCollection1(Collection<Trajeto> trajetoCollection1) {
        this.trajetoCollection1 = trajetoCollection1;
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
        if (!(object instanceof Aeroporto)) {
            return false;
        }
        Aeroporto other = (Aeroporto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.PraticaDragDrop.model.entity.Aeroporto[ id=" + id + " ]";
    }
    
}
