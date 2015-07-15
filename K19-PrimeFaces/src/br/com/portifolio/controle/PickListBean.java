package br.com.portifolio.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.portifolio.modelo.Curso;
import br.com.portifolio.modelo.CursoRepository;

@ManagedBean(name="pickListBean")
public class PickListBean {
	
	private DualListModel<Curso> cursos;
	
	public PickListBean(){
		List<Curso> source = new CursoRepository().getCursos();
		ArrayList<Curso> target = new ArrayList<Curso>();
		
		this.cursos = new DualListModel<Curso>(source, target);
	}
	
	public void onTransfer(TransferEvent event){
		StringBuilder builder = new StringBuilder();
		
		for(Object obj : event.getItems()){
			Integer id = Integer.valueOf(obj.toString());
			Curso c  = this.cursos.getSource().get(id-1);
			builder.append(c.getNome()).append("<br/>");
		}
	
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		if(event.isAdd()){
			msg.setSummary("Cursos Selecionados");
		}else{
			msg.setSummary("Cursos Removidos");
		}
		
		msg.setDetail(builder.toString());
		
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}

	public DualListModel<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(DualListModel<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
