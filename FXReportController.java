package esprit.petrofactory.interfaces;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ListView;

import javafx.scene.input.MouseEvent;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.Report;
import tn.esprit.petroFact.services.FuelServiceRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXReportController implements Initializable{
	@FXML
	private ListView l1;
	@FXML
	private TextField id_meter;
	@FXML
	private TextField tf_date;
	@FXML
	private TextField tf_type;
	@FXML
	private TextField tf_ia;
	@FXML
	private TextField tf_fa;
	@FXML
	private TextField tf_gain;
	@FXML
	private TextField id_man;
	@FXML
	private Button btn_add;
	@FXML
	private TableView<Report> tab_rep;
	@FXML
	private TableColumn <Report, String>id_type;
	@FXML
	private TableColumn <Report, Float>id_ia;
	@FXML
	private TableColumn <Report, Float>id_fa;
	@FXML
	private TableColumn <Report, Double>id_gain;
	@FXML
	private TableColumn <Report, Date>id_date;

	
	
	/*@FXML
    public void changeTypeCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException, NamingException{
     Report discussionselected = tab_rep.getSelectionModel().getSelectedItem();
     //DiscussionService ds= new DiscussionService();
     Context ic;
	 ic = new InitialContext();
	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
     discussionselected.setType(edditedCell.getNewValue().toString());
     proxy.updateType( discussionselected.getType(),discussionselected.getIdR());
	}
	*/
	
	
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<Report> data= FXCollections.observableArrayList(proxy.reports());
	    	 tab_rep.setItems(data);
			 id_type.setCellValueFactory(new PropertyValueFactory<Report, String>("type"));
			 id_ia.setCellValueFactory(new PropertyValueFactory<Report, Float>("initialAmount"));
			 id_fa.setCellValueFactory(new PropertyValueFactory<Report, Float>("finalAmount"));
		     id_gain.setCellValueFactory(new PropertyValueFactory<Report, Double>("gain"));
		     id_date.setCellValueFactory(new PropertyValueFactory<Report, Date>("date"));
	     }catch (Exception ex) {
	         System.out.println("exception");
	     }
		
	}
	
	// Event Listener on Button[#btn_add].onMouseClicked
	@FXML
	public void add_rep(MouseEvent event) throws NamingException, ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString = format.format( new Date() ); 
		Date date = format.parse ( "2009-12-31" );
		
		
		Report g=null;
		try {
			g = new Report(format.parse(tf_date.getText()),tf_type.getText(),Float.parseFloat(tf_ia.getText()),Float.parseFloat(tf_fa.getText()),Double.parseDouble(tf_gain.getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 InitialContext ic;
    	 ic = new InitialContext();
    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
    	 proxy.ajouterRep(g);
    	
	}


	// Event Listener on Button[#btn_del].onMouseClicked
	@FXML
	public void del_rep(MouseEvent event) throws NamingException {
		InitialContext ic;
   	 ic = new InitialContext();
   	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
        Report productselected = tab_rep.getSelectionModel().getSelectedItem();
        proxy.deleteRep(productselected.getIdR());
        ArrayList<Report> discussions = (ArrayList<Report>) proxy.reports();
            ObservableList obs= FXCollections.observableArrayList(discussions);
            tab_rep.setItems(obs);
            id_type.setCellValueFactory(new PropertyValueFactory<Report, String>("type"));
			 id_ia.setCellValueFactory(new PropertyValueFactory<Report, Float>("initialAmount"));
			 id_fa.setCellValueFactory(new PropertyValueFactory<Report, Float>("finalAmount"));
		     id_gain.setCellValueFactory(new PropertyValueFactory<Report, Double>("gain"));
		     id_date.setCellValueFactory(new PropertyValueFactory<Report, Date>("date"));
	}
@FXML
	public void changeTypeCellEvent(TableColumn.CellEditEvent edditedCell) throws NamingException {
		 Report discussionselected = tab_rep.getSelectionModel().getSelectedItem();
	     
	     Context ic;
		 ic = new InitialContext();
		 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	     discussionselected.setType(edditedCell.getNewValue().toString());
	     proxy.updateType( discussionselected.getType(),discussionselected.getIdR());
	}
}
