package br.com.portifolio.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.portifolio.modelo.Curso;

@ManagedBean(name="cursosBean")
@SessionScoped
public class CursosBean {
	private List<Curso> cursos = new ArrayList<Curso>();
	private Curso curso = new Curso();
	
	
	public void adicionarCurso(){
		this.cursos.add(this.curso);
		
		this.curso = new Curso();
	}
	
	public void removerCurso(int index){
		this.cursos.remove(index);
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
	
}
