package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import dao.DaoGeneric;
import model.Fazenda;
import model.Setor;

@ViewScoped
@ManagedBean(name = "setorBean")
public class SetorBean {
	
	// INSTANCIAÇÃO DA ENTIDADE
	private Setor setor = new Setor();
	// INSTANCIAÇÃO DE LISTA PARA ARMAZENAR ENTIDADES (PARA EXIBIÇÃO)
	private List<Setor> setores = new ArrayList<Setor>();
	private List<Fazenda> fazendas = new ArrayList<Fazenda>();
	// INSTANCIAÇÃO DOS MÉTODOS DE PERSISTÊNCIA
	private DaoGeneric<Setor> daoSetor = new DaoGeneric<Setor>();
	private DaoGeneric<Fazenda> daoFazenda = new DaoGeneric<Fazenda>();

	// INSTANCIAÇÃO DA ENTIDADE
	private Setor setorSelecionado = new Setor();
	
	// EVENTO ACIONADO AO SELECIONAR UMA LINHA DO DATATABLE
    public void onRowSelect(SelectEvent event) {
    	setor = setorSelecionado;
    }
       
    // EVENTO ACIONADO AO REMOVER A SELEÇÃO DE UMA LINHA DO DATATABLE
    public void onRowUnSelect(SelectEvent event) 
    {
    	
    }
	
	public String novoCadastro() {
		setor = null;
		setor = new Setor(null, "", 0);
		return null;
	}
	
	public String salvar() {
		daoSetor.merge(setor);
		carregarInformacoes();
		setor = new Setor();
		return ""; // REDIRECIONA PARA A INDEX
	}
	
	@PostConstruct
	public void carregarInformacoes() {
		setores = daoSetor.getListEntity(Setor.class);
		fazendas = daoFazenda.getListEntity(Fazenda.class);
	}	
	
	public DaoGeneric<Setor> getDaoSetor() {
		return daoSetor;
	}

	public void setDaoSetor(DaoGeneric<Setor> daoSetor) {
		this.daoSetor = daoSetor;
	}

	public DaoGeneric<Fazenda> getDaoFazenda() {
		return daoFazenda;
	}

	public void setDaoFazenda(DaoGeneric<Fazenda> daoFazenda) {
		this.daoFazenda = daoFazenda;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public String excluir() {
		daoSetor.deleteById(setorSelecionado);
		setor = new Setor();
		carregarInformacoes();
		return "";
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor Setor) {
		this.setor = Setor;
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
	
	public Setor getSetorSelecionado() {
		return setorSelecionado;
	}

	public void setSetorSelecionado(Setor SetorSelecionado) {
		this.setorSelecionado = SetorSelecionado;
	}

	public List<Fazenda> getFazendas() {
		return fazendas;
	}

	public void setFazendas(List<Fazenda> fazendas) {
		this.fazendas = fazendas;
	}
	

}
