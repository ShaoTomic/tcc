package br.com.portifolio.modelo;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.column.Column;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean(name="megaMenuBean")
public class MegaMenuBean {
	private MenuModel menuModel;
	
	public MegaMenuBean(){
		this.menuModel = new DefaultMenuModel();
		
			Submenu esporteMenu = new Submenu();
			esporteMenu.setLabel("Esportes");
			
			Submenu futebolMenu = new Submenu();
			futebolMenu.setLabel("Futebol");
			
			MenuItem item = new MenuItem();
			item.setValue("Brasileiro");
			item.setUrl("#");
			futebolMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Europeu");
			item.setUrl("#");
			futebolMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Japonês");
			item.setUrl("#");
			futebolMenu.getChildren().add(item);
			
			Submenu voleiMenu = new Submenu();
			voleiMenu.setLabel("Volei");
			
			item = new MenuItem();
			item.setValue("Liga Mundial");
			item.setUrl("#");
			voleiMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Eliminatórias da Copa");
			item.setUrl("#");
			voleiMenu.getChildren().add(item);
			
			Submenu automobilismoMenu = new Submenu();
			automobilismoMenu.setLabel("Automobilismo");
			
			item = new MenuItem();
			item.setValue("Fórmula 1");
			item.setUrl("#");
			automobilismoMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Fórmula 3");
			item.setUrl("#");
			automobilismoMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Fotos");
			item.setUrl("#");
			automobilismoMenu.getChildren().add(item);
			
			Column esporteColuna1 = new Column();
			esporteColuna1.getChildren().add(futebolMenu);
			esporteColuna1.getChildren().add(voleiMenu);
			esporteMenu.getChildren().add(esporteColuna1);
			
			Column esporteColuna2 = new Column();
			esporteColuna2.getChildren().add(automobilismoMenu);
			esporteMenu.getChildren().add(esporteColuna2);
			
			this.menuModel.addSubmenu(esporteMenu);
			
			Submenu noticiaMenu = new Submenu();
			noticiaMenu.setLabel("Notícias");
			
			Submenu economiaMenu = new Submenu();
			economiaMenu.setLabel("Economia");
			
			item  = new MenuItem();
			item.setValue("Brasil");
			item.setUrl("#");
			economiaMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Mundo");
			item.setUrl("#");
			economiaMenu.getChildren().add(item);
			
			Submenu tecnologiaMenu = new Submenu();
			tecnologiaMenu.setLabel("Tecnologia");
			
			item = new MenuItem();
			item.setValue("Segurança");
			item.setUrl("#");
			tecnologiaMenu.getChildren().add(item);
			
			item = new MenuItem();
			item.setValue("Negócios em TI");
			item.setUrl("#");
			tecnologiaMenu.getChildren().add(item);
			
			Submenu educacaoMenu = new Submenu();
			educacaoMenu.setLabel("Educação");
			
			item = new MenuItem() ;
			item.setValue("Vestibular") ;
			item.setUrl("#") ;
			educacaoMenu.getChildren().add( item ) ;
			
			item = new MenuItem() ;
			item.setValue("ENEM") ;
			item.setUrl("#") ;
			educacaoMenu.getChildren().add( item ) ;
			
			item = new MenuItem() ;
			item.setValue("ProUni") ;
			item.setUrl("#") ;
			educacaoMenu.getChildren().add( item ) ;
			
			Column noticiaColuna1 = new Column() ;
			noticiaColuna1.getChildren().add( economiaMenu ) ;
			noticiaColuna1.getChildren().add( tecnologiaMenu ) ;
			noticiaMenu.getChildren().add( noticiaColuna1 ) ;
			
			Column noticiaColuna2 = new Column() ;
			noticiaColuna2.getChildren().add( educacaoMenu ) ;
			noticiaMenu.getChildren().add( noticiaColuna2 ) ;
			this.menuModel.addSubmenu( noticiaMenu ) ;
		
		}
		
		public MenuModel getMenuModel() {
			return menuModel ;
		}

}
