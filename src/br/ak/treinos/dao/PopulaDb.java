package br.ak.treinos.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.ak.treinos.modelo.Corrida;
import br.ak.treinos.modelo.Local;

public class PopulaDb {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Local pkc = geraLocal("Park da Cidade");
		Local pac = geraLocal("Park Aguas Claras");
		
		em.persist(pkc);
		em.persist(pac);
		
		Corrida ag = geraCorrida("Aguas Claras", 4.29, "29m e 28s", "08/08/2015", pac);
		Corrida ag1 = geraCorrida("Aguas Claras", 6.02, "42m 41s", "16/08/2015", pac);
		Corrida ag2 = geraCorrida("Aguas Claras", 6.01, "41m 57s", "23/08/2015", pac);
		
		em.persist(ag);
		em.persist(ag1);
		em.persist(ag2);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	private static Local geraLocal(String nome) {
		Local local = new Local();
		local.setNome(nome);
		return local;
	}
	
	private static Corrida geraCorrida(String lugar, double km, String tempo, String data, Local local) {
		Corrida corrida = new Corrida();
		corrida.setLugar(lugar);
		corrida.setKm(km);
		corrida.setTempo(tempo);
		corrida.setDataCorrida(parseData(data));
		corrida.adicionaLocal(local);
		return corrida;
	}

	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
