package lukuvinkkikirjasto.main;

import lukuvinkkikirjasto.main.Tip;
import lukuvinkkikirjasto.storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;

public class TipHandler implements TipHandlerI {
    private Storage storage;
    private ArrayList<Tip> tipsList;
    private HashMap<String, String> tipOptions;   


    public TipHandler(Storage storage) {
        this.storage = storage;
	this.tipOptions = new HashMap<>();
        this.tipOptions.put("1", "book");
        this.tipOptions.put("2", "video");
        this.tipOptions.put("3", "podcast");
        this.tipOptions.put("4", "blog");
    }

    // createTip tänne, koska sen oleminen UI:ssä rikkoo single principle -periaatetta.
    // myöskin UI:n vaihtaminen esimerkiksi JavaFX:ksi onnistuu helpommin, jos 
    // UI-olio kutsuu ainoastaan handleria

    public void createTip(String header, String description, String creator, String url, 
                          String type, String tags, String comment, String courses) {

        Tip newTip = new Tip(header, description, creator, url, type, tags, comment, courses);
        storage.addToStorage(newTip);
    }


    public ArrayList<Tip> getAllTips() {
        ArrayList<Tip> tipsList = storage.getStorage();
        return tipsList;
    }

    public String listAllTips() {
	String input = "";
	ArrayList<Tip> tipsList = storage.getStorage();
	input += "\n" + tipsList.size() + " tips found.\n\n";
        for (Tip tip : tipsList) {
    	    input += tip.toString();
	}
	return input;
    }

    public String searchTipsByType(String column, String value) {
	String input = "";
	ArrayList<Tip> tipsByTerm = storage.getTipsWithSearchTerm(column, tipOptions.get(value));
	input += "\n" + tipsByTerm.size() + " tips found.\n\n";
	for (Tip tip : tipsByTerm) {
	    input += tip.toString();
	}
	return input;
    }

    public String searchTipsByTerm(String column, String value) {
	String input = "";
	ArrayList<Tip> tipsByTerm = storage.getTipsWithSearchTerm(column, value);
	input += "\n" + tipsByTerm.size() + " tips found.\n\n";
	for (Tip tip : tipsByTerm) {
	    input += tip.toString();
	}
	return input;
    }

    public ArrayList<Tip> getTipsByTerm(String column, String value) {
	ArrayList<Tip> tipsByTerm = storage.getTipsWithSearchTerm(column, value);
	return tipsByTerm;
    }

    



    public void deleteTip(String id) {
        // storage.deleteTip(id);
    }

   
}