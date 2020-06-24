/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "plantio")
@XmlRootElement
public class Plantio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Safra")
    private String safra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataInicioSafra")
    @Temporal(TemporalType.DATE)
    private Date dataInicioSafra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataFimSafra")
    @Temporal(TemporalType.DATE)
    private Date dataFimSafra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cultura")
    private String cultura;
    @JoinColumn(name = "CodFazenda", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Fazenda codFazenda;
    @JoinColumn(name = "CodSetor", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Setor codSetor;

    public Plantio() {
    }

    public Plantio(Integer codigo) {
        this.codigo = codigo;
    }

    public Plantio(Integer codigo, String nome, String safra, Date dataInicioSafra, Date dataFimSafra, String cultura) {
        this.codigo = codigo;
        this.nome = nome;
        this.safra = safra;
        this.dataInicioSafra = dataInicioSafra;
        this.dataFimSafra = dataFimSafra;
        this.cultura = cultura;
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

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public Date getDataInicioSafra() {
        return dataInicioSafra;
    }

    public void setDataInicioSafra(Date dataInicioSafra) {
        this.dataInicioSafra = dataInicioSafra;
    }

    public Date getDataFimSafra() {
        return dataFimSafra;
    }

    public void setDataFimSafra(Date dataFimSafra) {
        this.dataFimSafra = dataFimSafra;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public Fazenda getCodFazenda() {
        return codFazenda;
    }

    public void setCodFazenda(Fazenda codFazenda) {
        this.codFazenda = codFazenda;
    }

    public Setor getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(Setor codSetor) {
        this.codSetor = codSetor;
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
        if (!(object instanceof Plantio)) {
            return false;
        }
        Plantio other = (Plantio) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sitegerenciamentoplantio.model.Plantio[ codigo=" + codigo + " ]";
    }
    
}
