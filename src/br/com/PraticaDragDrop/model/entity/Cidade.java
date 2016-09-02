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
import javax.persistence.Lob;
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
@Table(name = "cidade")
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @JoinColumn(name = "estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estado estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private Collection<Aeroporto> aeroportoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private Collection<Empresa> empresaCollection;
    private boolean favorito;

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
    
    public Cidade() {
    }

    public Cidade(Integer id) {
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Collection<Aeroporto> getAeroportoCollection() {
        return aeroportoCollection;
    }

    public void setAeroportoCollection(Collection<Aeroporto> aeroportoCollection) {
        this.aeroportoCollection = aeroportoCollection;
    }

    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
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
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.PraticaDragDrop.model.entity.Cidade[ id=" + id + " ]";
    }
    
}
