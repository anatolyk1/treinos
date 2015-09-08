package br.ak.treinos.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Corrida {

	@Id
	@GeneratedValue
	private Integer id;

	private String lugar;
	private double km;
	private String tempo;

	@Temporal(TemporalType.DATE)
	private Calendar dataCorrida = Calendar.getInstance();

	@ManyToMany
	private List<Local> locares = new ArrayList<Local>();
	
	public void adicionaLocal(Local local) {
		this.locares.add(local);
	}

	public Corrida() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public List<Local> getLocares() {
		return locares;
	}

	public void setLocares(List<Local> locares) {
		this.locares = locares;
	}

}
