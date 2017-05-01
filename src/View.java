import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;

public class View extends JFrame{
	JPanel panel = new JPanel();
	JButton pridat = new JButton("Pridaj z·znam");
	JButton vymaz = new JButton("Vymaû z·znam");
	JButton updatuj = new JButton("Updatuj z·znam");
	JButton menu = new JButton("Sp‰ù do menu");
	JButton pridat_zaznam = new JButton("Pridaù");
	JButton vymaz_zaznam = new JButton("Vymazaù");
	JButton zobrazkonkretny = new JButton("Zobraziù detaily o z·zname");
	JButton zobrazit = new JButton("Zobraziù");
	JButton makefilter = new JButton("Filtruj");
	JButton filtrovanie = new JButton("Filter");
	JButton spat = new JButton("Sp‰ù");
	JTextField idhodnota = new JTextField("ID");
	JTextField idzobrazit = new JTextField("ID");
	JTextField hodnota = new JTextField("Hodnota po update");
	JTextField stavpridaj = new JTextField("Stav");
	JTextField nazovpridaj = new JTextField("N·zov");
	JTextField cenapridaj = new JTextField("Cena");
	JTextField hodnotafilter = new JTextField("Hodnota");
	JButton updatuj_zoznam = new JButton("Update");
	JButton vypis = new JButton ("VypÌsaù zoznam");
	JButton urobvypis = new JButton ("VypÌsaù");
	JComboBox choosedelete = new JComboBox(new String[]{"ID:INT","»as vystavenia:TIMESTAMP"});
	JComboBox vyberfilter = new JComboBox(new String[]{"Priorita:STRING","»as vystavenia:TIMESTAMP"});
	JTextField hodnotadelete= new JTextField("Hodnota na vymazanie");
	JTextField ID = new JTextField("ID");
	JComboBox priorita = new JComboBox(new String[]{"Vysok·", "Stredn·", "NÌzka"});
	JComboBox chooseupdate = new JComboBox(new String[]{"Priorita:STRING", "»as vystavenia:TIMESTAMP"});
	JTextField rok_vystavenia = new JTextField("Rok vystavenia");
	JTextField mesiac_vystavenia = new JTextField("Mesiac vystavenia");
	JTextField den_vystavenia = new JTextField("DeÚ vystavenia");
	JTextField hodina_vystavenia = new JTextField("Hodina vystavenia");
	JTextField minuta_vystavenia = new JTextField("Min˙ta vystavenia");
	JTextArea zobrazenie = new JTextArea(40, 40);
	JTextArea zobrazenie2 = new JTextArea(40, 40);
	JTextArea zobrazenie3 = new JTextArea(40, 40);
	JScrollPane zobrazeniee2 = new JScrollPane(zobrazenie2); 
	JScrollPane zobrazeniee3 = new JScrollPane(zobrazenie3); 
	
	
	public View(){
		zaciatok();
	}
	
	public void zaciatok(){
		panel.removeAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		panel.add(pridat);
		panel.add(vymaz);
		panel.add(updatuj);
		panel.add(zobrazkonkretny);
		panel.add(vypis);
		//panel.add(zobrazenie);
		add(panel);
		pack();	
		setVisible(true);
	}
	
	public void pridaj(){
	panel.removeAll();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	panel.add(rok_vystavenia);
	panel.add(mesiac_vystavenia);
	panel.add(den_vystavenia);
	panel.add(hodina_vystavenia);
	panel.add(minuta_vystavenia);
	//panel.add(stavpridaj);
	panel.add(nazovpridaj);
	panel.add(cenapridaj);
	panel.add(priorita);
	panel.add(pridat_zaznam);
	panel.add(menu);
	
	add(panel);
	pack();	
	setVisible(true);
		
	}
	
	public void update(){
	panel.removeAll();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	panel.add(idhodnota);
	panel.add(chooseupdate);
	panel.add(hodnota);		
	panel.add(updatuj_zoznam);
	panel.add(menu);	
	
	add(panel);
	pack();	
	setVisible(true);
		
	}
	
	public void vymazat(){
	panel.removeAll();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	//panel.add(choosedelete);
	panel.add(hodnotadelete);
	panel.add(vymaz_zaznam);
	
	panel.add(menu);
	
	add(panel);
	pack();	
	setVisible(true);
		
		
	}
	public void konkretny(){
	panel.removeAll();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());	
	panel.add(idzobrazit);
	panel.add(zobrazit);
	panel.add(menu);
	panel.add(zobrazenie);
	
	add(panel);
	pack();	
	setVisible(true);
		
	}
	
	public void vypisat(){
		panel.removeAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		panel.add(urobvypis);
		panel.add(menu);
		panel.add(filtrovanie);
		panel.add(zobrazeniee2);
		
		add(panel);
		pack();	
		setVisible(true);
		
	}
	public void filter(){
		panel.removeAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		panel.add(vyberfilter);
		panel.add(hodnotafilter);
		panel.add(makefilter);
		panel.add(spat);
		panel.add(zobrazeniee3);
		
		add(panel);
		pack();	
		setVisible(true);
	}
	
	
}
