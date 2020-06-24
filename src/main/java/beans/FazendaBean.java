package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import dao.DaoGeneric;
import model.Fazenda;

@ViewScoped
@ManagedBean(name = "fazendaBean")
public class FazendaBean {
	
	// INSTANCIAÇÃO DA ENTIDADE
	private Fazenda fazenda = new Fazenda();
	// INSTANCIAÇÃO DE LISTA PARA ARMAZENAR ENTIDADES (PARA EXIBIÇÃO)
	private List<Fazenda> fazendas = new ArrayList<Fazenda>();
	// INSTANCIAÇÃO DOS MÉTODOS DE PERSISTÊNCIA
	private DaoGeneric<Fazenda> daoGeneric = new DaoGeneric<Fazenda>();
	// INSTANCIAÇÃO DA ENTIDADE
	private Fazenda fazendaSelecionada = new Fazenda();
	
	// EVENTO ACIONADO AO SELECIONAR UMA LINHA DO DATATABLE
    public void onRowSelect(SelectEvent event) {
    	fazenda = fazendaSelecionada;
    }
       
    // EVENTO ACIONADO AO REMOVER A SELEÇÃO DE UMA LINHA DO DATATABLE
    public void onRowUnSelect(SelectEvent event) 
    {
    	
    }
	
	public String novoCadastro() {
		fazenda = new Fazenda();
		return "";
	}
	
	public String salvar() {
		daoGeneric.salvar(fazenda);
		fazenda = new Fazenda();
		carregarFazendas();
		return ""; // REDIRECIONA PARA A INDEX
	}
	
	@PostConstruct
	public void carregarFazendas() {
		fazendas = daoGeneric.getListEntity(Fazenda.class);
	}
	
	public String excluir() {
    	daoGeneric.deleteById(fazendaSelecionada);
		fazenda = new Fazenda();
		carregarFazendas();
		return "";
	}

	public Fazenda getFazenda() {
		return fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

	public DaoGeneric<Fazenda> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Fazenda> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Fazenda> getFazendas() {
		return fazendas;
	}
	
	public Fazenda getFazendaSelecionada() {
		return fazendaSelecionada;
	}

	public void setFazendaSelecionada(Fazenda fazendaSelecionada) {
		this.fazendaSelecionada = fazendaSelecionada;
	}
	

}
