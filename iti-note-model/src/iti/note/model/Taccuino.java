package iti.note.model;

import iti.note.jpa.DAOHelper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Taccuino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String titolo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Nota> note = new ArrayList<Nota>();

	public Taccuino() {
		// TODO Auto-generated constructor stub
	}

	public Taccuino(String titolo) {
		super();
		this.titolo = titolo;
	}

	public void addNota(Nota nota) {
		note.add(nota);
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Taccuino save() {
		return DAOHelper.save(this);
	}

	public static Taccuino findById(long id) {
		return DAOHelper.findById(id, Taccuino.class);
	}

	public static List<Taccuino> findAll() {
		return DAOHelper.findAll(Taccuino.class);
	}
}