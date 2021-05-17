/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modele.Rapport;
import Modele.RapportDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.ListModel;


/**
 *
 * @author GODART
 */
public class cltClient {
    
    private RapportDAO rapDAO;
    private static Rapport rap;
    private static boolean source;
    
    public cltClient() throws SQLException{
        rapDAO = new RapportDAO();
    }
    public RapportDAO getRapDAO() {
        return rapDAO;
    }

    public void setRapDAO(RapportDAO rapDAO) {
        this.rapDAO = rapDAO;
    }

    public static Rapport getRap() {
        return rap;
    }

    public static void setRap(Rapport rapo) {
        rap = rapo;
    }
    public static boolean isSource() {
        return source;
    }

    public static void setSource(boolean source) {
        cltClient.source = source;
    }
   
    public ListModel<String> creeModel(ArrayList laList){
        DefaultListModel<String> leModel = new DefaultListModel();
        for(Object o : laList){
            leModel.addElement(o.toString());
        }
        return leModel;
    }
    public void creeComboModel(ArrayList laList, JComboBox jcombo){
        for(Object o : laList){
            jcombo.addItem(o.toString());
        }
    }
    
    public void selectRapport(JComboBox<String> jComboBox1) throws SQLException{
        String unTruc = jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString();
        String[] tabSplit = unTruc.split(" : ");
        rap = rapDAO.getUnRapport(Integer.parseInt(tabSplit[0]));
    }
}
