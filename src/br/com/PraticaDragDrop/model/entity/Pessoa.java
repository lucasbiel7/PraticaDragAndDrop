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
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "senha")
    private String senha;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(mappedBy = "pessoa")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idioma", referencedColumnName = "id")
    @ManyToOne
    private Idioma idioma;
    @JoinColumn(name = "papel", referencedColumnName = "id")
    @ManyToOne
    private Papel papel;
    @OneToMany(mappedBy = "pessoa")
    private Collection<Marcacao> marcacaoCollection;
    @OneToMany(mappedBy = "criador")
    private Collection<Evento> eventoCollection;
    @OneToMany(mappedBy = "pessoa")
    private Collection<Reserva> reservaCollection;
    @OneToMany(mappedBy = "autor")
    private Collection<Convite> conviteCollection;
    @OneToMany(mappedBy = "convidado")
    private Collection<Convite> conviteCollection1;
    @OneToMany(mappedBy = "pessoa")
    private Collection<Passagem> passagemCollection;
    @OneToMany(mappedBy = "pessoa")
    private Collection<Comentario> comentarioCollection;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public Collection<Marcacao> getMarcacaoCollection() {
        return marcacaoCollection;
    }

    public void setMarcacaoCollection(Collection<Marcacao> marcacaoCollection) {
        this.marcacaoCollection = marcacaoCollection;
    }

    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Collection<Convite> getConviteCollection() {
        return conviteCollection;
    }

    public void setConviteCollection(Collection<Convite> conviteCollection) {
        this.conviteCollection = conviteCollection;
    }

    public Collection<Convite> getConviteCollection1() {
        return conviteCollection1;
    }

    public void setConviteCollection1(Collection<Convite> conviteCollection1) {
        this.conviteCollection1 = conviteCollection1;
    }

    public Collection<Passagem> getPassagemCollection() {
        return passagemCollection;
    }

    public void setPassagemCollection(Collection<Passagem> passagemCollection) {
        this.passagemCollection = passagemCollection;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.PraticaDragDrop.model.entity.Pessoa[ id=" + id + " ]";
    }
    
}
