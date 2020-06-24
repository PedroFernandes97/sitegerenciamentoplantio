package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import dao.DaoGeneric;
import model.Atividades;
import model.Plantio;

@ViewScoped
@ManagedBean(name = "atividadesBean")
public class AtividadesBean {
	
	// INSTANCIAÇÃO DA ENTIDADE
	private Atividades atividade = new Atividades();
	// INSTANCIAÇÃO DE LISTA PARA ARMAZENAR ENTIDADES (PARA EXIBIÇÃO)
	private List<Plantio> plantios = new ArrayList<Plantio>();
	private List<Atividades> atividades = new ArrayList<Atividades>();
	// INSTANCIAÇÃO DOS MÉTODOS DE PERSISTÊNCIA
	private DaoGeneric<Plantio> daoPlantio = new DaoGeneric<Plantio>();
	private DaoGeneric<Atividades> daoAtividades = new DaoGeneric<Atividades>();

	// INSTANCIAÇÃO DA ENTIDADE
	private Atividades atividadeSelecionada = new Atividades();
	
	// EVENTO ACIONADO AO SELECIONAR UMA LINHA DO DATATABLE
    public void onRowSelect(SelectEvent event) {
    	atividade = atividadeSelecionada;
    }
       
    // EVENTO ACIONADO AO REMOVER A SELEÇÃO DE UMA LINHA DO DATATABLE
    public void onRowUnSelect(SelectEvent event) 
    {
    	
    }
	
	public void novoCadastro() {
		atividade = new Atividades();
	}
	
	public String salvar() {
		daoAtividades.merge(atividade);
		atividade = new Atividades();
		carregarInformacoes();
		return ""; // REDIRECIONA PARA A INDEX
	}
	
	@PostConstruct
	public void carregarInformacoes() {
		atividades = daoAtividades.getListEntity(Atividades.class);
		plantios = daoPlantio.getListEntity(Plantio.class);
	}	
	
	public String excluir() {
		daoAtividades.deleteById(atividadeSelecionada);
		atividade = new Atividades();
		carregarInformacoes();
		return "";
	}

	public Atividades getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividades Atividade) {
		this.atividade = Atividade;
	}

	public DaoGeneric<Atividades> getDaoGenericAtividades() {
		return daoAtividades;
	}

	public void setDaoGenericAtividadess(DaoGeneric<Atividades> daoGeneric) {
		this.daoAtividades = daoGeneric;
	}
	
	public DaoGeneric<Plantio> getDaoGenericPlantio() {
		return daoPlantio;
	}

	public void setDaoGenericPlantio(DaoGeneric<Plantio> daoGeneric) {
		this.daoPlantio = daoGeneric;
	}
	

	public List<Plantio> getPlantios() {
		return plantios;
	}
	
	public Atividades getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	public void setAtividadeSelecionada(Atividades atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

	public List<Atividades> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividades> atividades) {
		this.atividades = atividades;
	}

	public DaoGeneric<Plantio> getDaoPlantio() {
		return daoPlantio;
	}

	public void setDaoPlantio(DaoGeneric<Plantio> daoPlantio) {
		this.daoPlantio = daoPlantio;
	}

	public DaoGeneric<Atividades> getDaoAtividades() {
		return daoAtividades;
	}

	public void setDaoAtividades(DaoGeneric<Atividades> daoAtividades) {
		this.daoAtividades = daoAtividades;
	}

	public void setPlantios(List<Plantio> plantios) {
		this.plantios = plantios;
	}
	

}
