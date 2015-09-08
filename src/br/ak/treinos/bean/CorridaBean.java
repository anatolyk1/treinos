package br.ak.treinos.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ak.treinos.dao.DAO;
import br.ak.treinos.modelo.Corrida;
import br.ak.treinos.modelo.Local;

@ManagedBean
@ViewScoped
public class CorridaBean {

	private Corrida corrida = new Corrida();
	private Integer localId;

	public Integer getLocalId() {
		return localId;
	}

	public void setLocalId(Integer localId) {
		this.localId = localId;
	}

	public Corrida getCorrida() {
		return corrida;
	}
	
	public List<Corrida> getCorridas() {
		return new DAO<Corrida>(Corrida.class).listaTodos(); 
	}
	
	public List<Local> getLocares() {
		return new DAO<Local>(Local.class).listaTodos(); 
	}
	
	public List<Local> getLocalDaCorrida() {
		return this.corrida.getLocares();
	}
	
	public void gravarLocal() {
		Local local = new DAO<Local>(Local.class).buscaPorId(this.localId); 
		this.corrida.adicionaLocal(local); 
		System.out.println("Livro escrito por: " + local.getNome()); 
	}

	public void gravar() {
		System.out.println("Gravando corrida " + this.corrida.getLugar());

		/*if (corrida.getLocares().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("corrida",
					new FacesMessage("Corrida deve ter pelo menos um Local."));
			return;
		}*/

		new DAO<Corrida>(Corrida.class).adiciona(this.corrida);
		this.corrida = new Corrida();
	}
	
	public String formLocal() {
		System.out.println("Chamando o formulario do Local");
		return "local?faces-redirect=true";
	}

}
