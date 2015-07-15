package br.com.portifolio.modelo;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
	
	private static List<Curso> cursos = new ArrayList<Curso>();
	private static String siteString = "http://www.k19.com.br/css/img/";
	
	static{
		
		cursos.add(new Curso(1L,"K01","Lógica de Programação", siteString+"k01-logo-small.png"));
		cursos.add(new Curso(2L,"K02","Desenvolvimento Web com HTML, CSS e Javascript", siteString+"k02-logo-small.png"));
		cursos.add(new Curso(3L,"K03","SQL e Modelo Relacional", siteString+"k03-logo-small.png"));
		cursos.add(new Curso(4L,"K11","Orientação a Objetos em Java",siteString+"k11-logo-small.png"));
		cursos.add(new Curso(5L,"K12","Desenvolvimento Web com JSF2 e JPA2",siteString+"k12-logo-small.png"));
		cursos.add(new Curso(6L,"K21","Persistência com JPA2 e Hibernate",siteString+"k21-logo-small.png"));
		cursos.add(new Curso(7L,"K22","Desenvolvimento Web Avançado com EJB, JSF e CDI",siteString+"k22-logo-small.png"));
		cursos.add(new Curso(8L,"K23","Integração de Sistemas com Webservices, JMS e EJB",siteString+"k23-logo-small.png"));
		cursos.add(new Curso(9L,"K31","C# e Orientação a Objetos",siteString+"k31-logo-small.png"));
		cursos.add(new Curso(10L,"K32","Desenvolvimento Web com ASP.NET MVC",siteString+"k32-logo-small.png"));
		cursos.add(new Curso(11L,"K41","Desenvolvimento Mobile com Android",siteString+"k41-logo-small.png"));
		cursos.add(new Curso(12L,"K51","Design Patterns em Java",siteString+"k51-logo-small.png"));
		cursos.add(new Curso(13L,"k52","Desenvolvimento Web com Struts",siteString+"k52-logo-small.png"));
	}
	
	public List<Curso> getCursos(){
		return cursos;
	}
}
