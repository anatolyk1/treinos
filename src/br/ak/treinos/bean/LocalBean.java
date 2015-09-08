package br.ak.treinos.bean;

import javax.faces.bean.ManagedBean;

import br.ak.treinos.dao.DAO;
import br.ak.treinos.modelo.Local;

@ManagedBean
public class LocalBean {
	
	private Local local = new Local();

	public Local getLocal() {
		return local;
	}
	
	public String gravar() {
		System.out.println("Gravando local " + this.local.getNome());
		
		new DAO<Local>(Local.class).adiciona(this.local);
		this.local = new Local();
		
		return "corrida?faces-redirect=true";
	}

}
