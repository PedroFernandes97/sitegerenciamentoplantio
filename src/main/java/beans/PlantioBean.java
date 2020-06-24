package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import dao.DaoGeneric;
import model.Fazenda;
import model.Plantio;
import model.Setor;

@ViewScoped
@ManagedBean(name = "plantioBean")
public class PlantioBean {
	
	// INSTANCIAÇÃO DA ENTIDADE
	private Plantio plantio = new Plantio();
	// INSTANCIAÇÃO DE LISTA PARA ARMAZENAR ENTIDADES (PARA EXIBIÇÃO)
	private List<Setor> setores = new ArrayList<Setor>();
	private List<Fazenda> fazendas = new ArrayList<Fazenda>();
	private List<Plantio> plantios = new ArrayList<Plantio>();
	// INSTANCIAÇÃO DOS MÉTODOS DE PERSISTÊNCIA
	private DaoGeneric<Setor> daoSetor = new DaoGeneric<Setor>();
	private DaoGeneric<Plantio> daoPlantio = new DaoGeneric<Plantio>();

	// INSTANCIAÇÃO DA ENTIDADE
	private Plantio plantioSelecionado = new Plantio();
	
	// EVENTO ACIONADO AO SELECIONAR UMA LINHA DO DATATABLE
    public void onRowSelect(SelectEvent event) {
    	plantio = plantioSelecionado;
    }
       
    public Plantio getPlantioSelecionado() {
		return plantioSelecionado;
	}

	public void setPlantioSelecionado(Plantio plantioSelecionado) {
		this.plantioSelecionado = plantioSelecionado;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	// EVENTO ACIONADO AO REMOVER A SELEÇÃO DE UMA LINHA DO DATATABLE
    public void onRowUnSelect(SelectEvent event) 
    {
    	
    }
	
	public String novoCadastro() {
		plantio = null;
		plantio = new Plantio();
		return "";
	}
	
	public String salvar() {
		daoPlantio.merge(plantio);
		plantio = new Plantio();
		carregarInformacoes();
		return ""; // REDIRECIONA PARA A INDEX
	}
	
	@PostConstruct
	public void carregarInformacoes() {
		setores = daoSetor.getListEntity(Setor.class);
		plantios = daoPlantio.getListEntity(Plantio.class);
	}	
	
	public DaoGeneric<Setor> getDaoSetor() {
		return daoSetor;
	}

	public void setDaoSetor(DaoGeneric<Setor> daoSetor) {
		this.daoSetor = daoSetor;
	}

	public DaoGeneric<Plantio> getDaoPlantio() {
		return daoPlantio;
	}

	public void setDaoPlantio(DaoGeneric<Plantio> daoPlantio) {
		this.daoPlantio = daoPlantio;
	}

	public String excluir() {
		daoPlantio.deleteById(plantioSelecionado);
		plantio = new Plantio();
		carregarInformacoes();
		return "";
	}

	public Plantio getPlantio() {
		return plantio;
	}

	public void setPlantio(Plantio Plantio) {
		this.plantio = Plantio;
	}

	public DaoGeneric<Setor> getDaoGeneric() {
		return daoSetor;
	}

	public void setDaoGeneric(DaoGeneric<Setor> daoGeneric) {
		this.daoSetor = daoGeneric;
	}
	

	public List<Setor> getSetores() {
		return setores;
	}
	
	public Plantio getplantioSelecionado() {
		return plantioSelecionado;
	}

	public void setplantioSelecionado(Plantio plantioSelecionado) {
		this.plantioSelecionado = plantioSelecionado;
	}

	public List<Fazenda> getFazendas() {
		return fazendas;
	}

	public void setFazendas(List<Fazenda> fazendas) {
		this.fazendas = fazendas;
	}

	public List<Plantio> getPlantios() {
		return plantios;
	}

	public void setPlantios(List<Plantio> plantios) {
		this.plantios = plantios;
	}
	

}
