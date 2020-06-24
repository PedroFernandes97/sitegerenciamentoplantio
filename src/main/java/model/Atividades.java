package model;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "atividades")
@XmlRootElement
public class Atividades implements Serializable {

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
    @Column(name = "DataPlanejamento")
    @Temporal(TemporalType.DATE)
    private Date dataPlanejamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @Column(name = "DataFim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @JoinColumn(name = "CodPlantio", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Plantio codPlantio;
    @JoinColumn(name = "CodSetor", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Setor codSetor;

    public Atividades() {
    }

    public Atividades(Integer codigo) {
        this.codigo = codigo;
    }

    public Atividades(Integer codigo, String nome, Date dataPlanejamento, Date dataInicio, Date dataFim) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataPlanejamento = dataPlanejamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public Date getDataPlanejamento() {
        return dataPlanejamento;
    }

    public void setDataPlanejamento(Date dataPlanejamento) {
        this.dataPlanejamento = dataPlanejamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Plantio getCodPlantio() {
        return codPlantio;
    }

    public void setCodPlantio(Plantio codPlantio) {
        this.codPlantio = codPlantio;
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
        if (!(object instanceof Atividades)) {
            return false;
        }
        Atividades other = (Atividades) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sitegerenciamentoplantio.model.Atividades[ codigo=" + codigo + " ]";
    }
    
}
