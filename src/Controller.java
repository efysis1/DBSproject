import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;	

public class Controller {
	private View theView;
	private Model theModel;
	Connection c = null;
	Statement stmt = null;
	int countZakazka;
	int countProduktZakazky;
	int countProdukt;
	int count;
	
	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		theView.pridat.addActionListener(new theHandler());
		theView.vymaz.addActionListener(new theHandler());
		theView.updatuj.addActionListener(new theHandler());
		theView.menu.addActionListener(new theHandler());
		theView.pridat_zaznam.addActionListener(new theHandler());
		theView.updatuj_zoznam.addActionListener(new theHandler());
		theView.vymaz_zaznam.addActionListener(new theHandler());
		theView.zobrazkonkretny.addActionListener(new theHandler());
		theView.zobrazit.addActionListener(new theHandler());
		theView.vypis.addActionListener(new theHandler());
		theView.urobvypis.addActionListener(new theHandler());
		theView.filtrovanie.addActionListener(new theHandler());
		theView.makefilter.addActionListener(new theHandler());
		theView.spat.addActionListener(new theHandler());
		theView.rok_vystavenia.addMouseListener(new theHandler());
		theView.mesiac_vystavenia.addMouseListener(new theHandler());
		theView.den_vystavenia.addMouseListener(new theHandler());
		theView.hodina_vystavenia.addMouseListener(new theHandler());
		theView.minuta_vystavenia.addMouseListener(new theHandler());
		theView.nazovpridaj.addMouseListener(new theHandler());
		theView.cenapridaj.addMouseListener(new theHandler());
		theView.idhodnota.addMouseListener(new theHandler());
		theView.hodnota.addMouseListener(new theHandler());
		theView.hodnotadelete.addMouseListener(new theHandler());
		theView.idzobrazit.addMouseListener(new theHandler());
		theView.hodnotafilter.addMouseListener(new theHandler());
	}
	class theHandler extends MouseAdapter implements ActionListener {
		//@Override
		
		public void mouseClicked(MouseEvent e) {
	          if (e.getSource() == theView.rok_vystavenia) {
	        	  theView.rok_vystavenia.setText("");
	          } else if (e.getSource() == theView.mesiac_vystavenia) {
	        	  theView.mesiac_vystavenia.setText("");
	          } else if (e.getSource() == theView.den_vystavenia) {
	        	  theView.den_vystavenia.setText("");
	          } else if (e.getSource() == theView.hodina_vystavenia) {
	        	  theView.hodina_vystavenia.setText("");
	          } else if (e.getSource() == theView.minuta_vystavenia) {
	        	  theView.minuta_vystavenia.setText("");
	          } else if (e.getSource() == theView.nazovpridaj) {
	        	  theView.nazovpridaj.setText("");
	          } else if (e.getSource() == theView.cenapridaj) {
	        	  theView.cenapridaj.setText("");
	          } else if (e.getSource() == theView.idhodnota) {
	        	  theView.idhodnota.setText("");
	          } else if (e.getSource() == theView.hodnota) {
	        	  theView.hodnota.setText("");
	          } else if (e.getSource() == theView.hodnotadelete) {
	        	  theView.hodnotadelete.setText("");
	          } else if (e.getSource() == theView.idzobrazit) {
	        	  theView.idzobrazit.setText("");
	          } else if (e.getSource() == theView.hodnotafilter) {
	        	  theView.hodnotafilter.setText("");
	          }
	      }
		@Override
		public void actionPerformed(ActionEvent arg0) {
	try{
		Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Databaza","postgres", "asdfgh");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        
        if (arg0.getSource() == theView.pridat){
        	theView.pridaj();
        	ResultSet rs = stmt.executeQuery( "SELECT ID from Zakazka ORDER BY ID DESC limit 1;" );
        	rs.next();
        	countZakazka = rs.getInt(1);
        	countZakazka++;
        	
        	ResultSet ps = stmt.executeQuery( "SELECT ID from Produkt_zakazky ORDER BY ID DESC limit 1;" );
        	ps.next();
        	countProduktZakazky = ps.getInt(1);
        	countProduktZakazky++;
        	
        	ResultSet ds = stmt.executeQuery( "SELECT ID from Produkt ORDER BY ID DESC limit 1;" );
        	ds.next();
        	countProdukt = ds.getInt(1);
        	countProdukt++;
        	
        	
        	//System.out.println("cislo: " + count);
        	
        }
        if (arg0.getSource() == theView.pridat_zaznam){
        	try{
        	String prior = null;
        	System.out.println("cislo: " + countZakazka);
        	System.out.println("cislo: " + countProduktZakazky);
        	System.out.println("cislo: " + countProdukt);
        	if (theView.priorita.getSelectedIndex() == 0){
        		prior = "Vysoka";
        		System.out.println(prior);
        	}
        	else if (theView.priorita.getSelectedIndex() == 1){
        		prior = "Stredna";
        		System.out.println(prior);
        	}
        	else if (theView.priorita.getSelectedIndex() == 2){
        		prior = "Nizka";
        		System.out.println(prior);
        	}
        	
        	String rok = theView.rok_vystavenia.getText();
        	String mesiac = theView.mesiac_vystavenia.getText();
        	String den = theView.den_vystavenia.getText();
        	String hodina = theView.hodina_vystavenia.getText();
        	String minuta = theView.minuta_vystavenia.getText();
        	String stav = "Nevybavene";
        	String nazov = theView.nazovpridaj.getText();
        	String cena = theView.cenapridaj.getText();
        	
        	String cas = rok + "-" + mesiac + "-" + den + " " + hodina + ":" + minuta + ":00";
        	System.out.println(cas);
        	                	
        	String sql = "INSERT INTO Produkt(ID,nazov,cena)" + "VALUES ('" + countProdukt + "', '" + nazov + "', '" + cena + "');";
        	stmt.executeUpdate(sql);
        	
        	sql = "INSERT INTO Zakazka(ID,priorita,cas_vystavenia)" + "VALUES ('" + countZakazka + "','" + prior + "','" + cas + "');";
        	stmt.executeUpdate(sql);
        	
        	sql = "INSERT INTO Produkt_zakazky(ID,zakazka_id,produkt_id,stav_objednavky)" + "VALUES('" + countProduktZakazky
        			+ "', '" + countZakazka + "', '" + countProdukt + "', '" + stav + "');";
        	stmt.executeUpdate(sql);
        	c.commit();
        	}
        	catch (SQLException e ) {
                //JDBCTutorialUtilities.printSQLException(e);
        		//System.err.print("A");
                if (c != null) {
                    try {
                        System.err.print("Transaction is being rolled back");
                        c.rollback();
                    } catch(SQLException excep) {
                        //JDBCTutorialUtilities.printSQLException(excep);
                    	//System.err.print("B");
                    }
                }
        }
        }
        if (arg0.getSource() == theView.updatuj){
        	theView.update();       	        	        	
        }
        if (arg0.getSource() == theView.updatuj_zoznam){
        	try{
        	if (theView.chooseupdate.getSelectedIndex() == 0){
        		String id = theView.idhodnota.getText();
        		String prior = theView.hodnota.getText();
        		String sql = "UPDATE Zakazka set priorita = '" + prior + "' where ID = '" + id + "' ;";
        		stmt.executeUpdate(sql);
        	}
        	else if(theView.chooseupdate.getSelectedIndex() == 1){
        		String id = theView.idhodnota.getText();
        		String cas = theView.hodnota.getText();
        		String sql = "UPDATE Zakazka set cas_vystavenia = '" + cas + "' where ID = '" + id + "' ;";
        		stmt.executeUpdate(sql);       		
           	}   
        	c.commit();
        	}
        	catch (SQLException e ) {
                //JDBCTutorialUtilities.printSQLException(e);
        		//System.err.print("A");
                if (c != null) {
                    try {
                        System.err.print("Transaction is being rolled back");
                        c.rollback();
                    } catch(SQLException excep) {
                        //JDBCTutorialUtilities.printSQLException(excep);
                    	//System.err.print("B");
                    }
                }
        }
        	
        }
        if (arg0.getSource() == theView.vymaz){
        	theView.vymazat();       	
        	
        }
        if (arg0.getSource() == theView.vymaz_zaznam){
        	try{
        	String hodnota = theView.hodnotadelete.getText();
        	System.out.println(hodnota);        	
        	
        	ResultSet rs = stmt.executeQuery( "SELECT produkt_id from produkt_zakazky where zakazka_id = '" + hodnota + "';" );
        	rs.next();
        	int DEL = rs.getInt(1);

        		String sql = "DELETE from Produkt_zakazky where zakazka_id = '" + hodnota + "';";
            	stmt.executeUpdate(sql);
            	
            	sql = "DELETE from Produkt where ID =  '" + DEL + "';";
        		stmt.executeUpdate(sql);
        		
        		sql = "DELETE from Zakazka where ID =  '" + hodnota + "';";
        		stmt.executeUpdate(sql);
        		   
        	c.commit();
        	}
        	catch (SQLException e ) {
                //JDBCTutorialUtilities.printSQLException(e);
        		//System.err.print("A");
                if (c != null) {
                    try {
                        System.err.print("Transaction is being rolled back");
                        c.rollback();
                    } catch(SQLException excep) {
                        //JDBCTutorialUtilities.printSQLException(excep);
                    	//System.err.print("B");
                    }
                }
        }
        }
        
        if (arg0.getSource() == theView.menu){
        	theView.zaciatok();
        }
        if (arg0.getSource() == theView.zobrazkonkretny){        	
        	theView.konkretny();
        	theView.zobrazenie.setText("");
        }
        if (arg0.getSource() == theView.zobrazit){
        	String cislo = theView.idzobrazit.getText();
        	theView.zobrazenie.setText("");
        	// SELECT NA VYBER VSETKEHO Z TYCH TROCH TABULIEK
        	ResultSet rs = stmt.executeQuery("SELECT * from Produkt_zakazky prod JOIN Produkt pr ON (prod.produkt_id = pr.id) JOIN Zakazka za ON (prod.id = za.id) where prod.id = '" + cislo + "';");
        	while(rs.next()){
        	int zakazka_id = rs.getInt("zakazka_id");
        	int produkt_id = rs.getInt("produkt_id");
        	String stav = rs.getString("stav_objednavky");
        	String priorita = rs.getString("priorita");
        	String cas_vystavenia = rs.getString("cas_vystavenia");
        	String nazov = rs.getString("nazov");
        	int cena = rs.getInt("cena");
        	
        	theView.zobrazenie.append("ID produktu zákazky: " + cislo + "\n ID zákazky: " + zakazka_id + "\n ID produktu: " + produkt_id +
        			"\n Stav objednávky: " +stav+ "\n Priorita objednávky: " + priorita + "\n Èas vystavenia objednávky: " + cas_vystavenia + 
        			"\n Názov produktu: " + nazov + "\n Cena produktu: " + cena);
        	}
        	
        	
        }
        if (arg0.getSource() == theView.vypis){
        	theView.vypisat();
        	theView.zobrazenie2.setText("");
        }
        
        if (arg0.getSource() == theView.urobvypis){
        	theView.zobrazenie2.setText("");
        	ResultSet rs = stmt.executeQuery("SELECT cas_vystavenia, COUNT(*) AS pocet_vyskytov FROM Zakazka GROUP BY cas_vystavenia ORDER BY pocet_vyskytov DESC;");
        	theView.zobrazenie2.append("Èas vystavenia:   Poèet výskytov\n");
        while (rs.next()){
        	String cas_vystavenia = rs.getString("cas_vystavenia");
        	int pocet_vyskytov = rs.getInt("pocet_vyskytov");
        	
        	if (pocet_vyskytov >5)
        	theView.zobrazenie2.append(cas_vystavenia + "     " + pocet_vyskytov + "\n");
        	
        }
	
        }
        if (arg0.getSource() == theView.filtrovanie){
        	theView.filter();
        	theView.zobrazenie3.setText("");
        }
        
        if (arg0.getSource() == theView.makefilter){
        	theView.zobrazenie3.setText("");
        	if (theView.vyberfilter.getSelectedIndex() == 0){
        		String priorita = theView.hodnotafilter.getText();
        		ResultSet rs = stmt.executeQuery("SELECT * from Zakazka where priorita = '" + priorita + "' ORDER BY ID limit 10 ;");
        		
        		theView.zobrazenie3.append("ID | priorita | èas vystavenia\n");
        		while(rs.next()){
                	priorita = rs.getString("priorita");
                	String cas_vystavenia = rs.getString("cas_vystavenia");
                	int id = rs.getInt("ID");
                	
                	theView.zobrazenie3.append(id + "    " + priorita + "    " + cas_vystavenia + "\n");
                	}
        	}
        	
        	else if (theView.vyberfilter.getSelectedIndex() == 1){
        		String cas_vystavenia = theView.hodnotafilter.getText();
        		ResultSet rs = stmt.executeQuery("SELECT * from Zakazka where cas_vystavenia = '" + cas_vystavenia + "' ORDER BY ID limit 10 ;");
        		
        		theView.zobrazenie3.append("ID | priorita | èas vystavenia\n");
        		while(rs.next()){
                	String priorita = rs.getString("priorita");
                	cas_vystavenia = rs.getString("cas_vystavenia");
                	int id = rs.getInt("ID");
                	
                	theView.zobrazenie3.append(id + "    " + priorita + "    " + cas_vystavenia + "\n");
                	}
        	}
        	
        	
        }
        if (arg0.getSource() == theView.spat){
        	theView.vypisat();
        }
        
        
        stmt.close();
        c.close();

	}catch (Exception e){
		System.err.println( e.getClass().getName()+": "+ e.getMessage() );
       // System.exit(0);
	}
		}
	}
}
	
