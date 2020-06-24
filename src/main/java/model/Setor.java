/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "setor")
@XmlRootElement
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Area")
    private float area;
    @ManyToOne
    @JoinColumn(name = "CodFazenda", referencedColumnName = "Codigo")
    private Fazenda codFazenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSetor")
    private Collection<Plantio> plantioCollection;

    public Setor() {
    }

    public Setor(Integer codigo) {
        this.codigo = codigo;
    }

    public Setor(Integer codigo, String nome, float area) {
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Fazenda getCodFazenda() {
        return codFazenda;
    }

    public void setCodFazenda(Fazenda codFazenda) {
        this.codFazenda = codFazenda;
    }

    @XmlTransient
    public Collection<Plantio> getPlantioCollection() {
        return plantioCollection;
    }

    public void setPlantioCollection(Collection<Plantio> plantioCollection) {
        this.plantioCollection = plantioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sitegerenciamentoplantio.model.Setor[ codigo=" + codigo + " ]";
    }
    
}
