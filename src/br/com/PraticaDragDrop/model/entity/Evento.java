/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author OCTI01
 */
@Entity
@Table(name = "evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "fim")
    @Temporal(TemporalType.DATE)
    private Date fim;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(mappedBy = "evento")
    private Collection<Marcacao> marcacaoCollection;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private CategoriaEvento categoria;
    @JoinColumn(name = "criador", referencedColumnName = "id")
    @ManyToOne
    private Pessoa criador;
    @OneToMany(mappedBy = "evento")
    private Collection<Convite> conviteCollection;
    @OneToMany(mappedBy = "evento")
    private Collection<Comentario> comentarioCollection;

    public Evento() {
    }

    public Evento(Integer id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Collection<Marcacao> getMarcacaoCollection() {
        return marcacaoCollection;
    }

    public void setMarcacaoCollection(Collection<Marcacao> marcacaoCollection) {
        this.marcacaoCollection = marcacaoCollection;
    }

    public CategoriaEvento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEvento categoria) {
        this.categoria = categoria;
    }

    public Pessoa getCriador() {
        return criador;
    }

    public void setCriador(Pessoa criador) {
        this.criador = criador;
    }

    public Collection<Convite> getConviteCollection() {
        return conviteCollection;
    }

    public void setConviteCollection(Collection<Convite> conviteCollection) {
        this.conviteCollection = conviteCollection;
    }

    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.PraticaDragDrop.model.entity.Evento[ id=" + id + " ]";
    }
    
}
