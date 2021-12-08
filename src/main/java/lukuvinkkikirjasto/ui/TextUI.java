package lukuvinkkikirjasto.ui;

import lukuvinkkikirjasto.main.ReaderIO;
import lukuvinkkikirjasto.main.Tip;
import lukuvinkkikirjasto.main.TipHandler;
import lukuvinkkikirjasto.storage.Storage;


public class TextUI {


    private ReaderIO input;
    private TipHandler tipHandler;

    public TextUI(ReaderIO scanner, TipHandler tipHandler) {
        this.input = scanner;
        this.tipHandler = tipHandler;
    }

    public void run() {


        while (true) {

            this.input.println("1. List all tips.\n" +
                    "2. Create a new tip\n" +
                    "3. Search tips\n" +
                    "4. Edit tips\n" +
                    "5. Delete a tip\n" +
                    "0. Exit\n" +
                    "expected input (1/2/3/4/5/0)");

            String operation = this.input.nextLine();

            if (operation.equals("1")) {
                this.input.println("1");
                for (Tip tip : tipHandler.getAllTips()) {
                    this.input.println(tip.toString());
                }
            } else if (operation.equals("2")) {
                addTip();
            } else if (operation.equals("3")) {
                search();   // tähän uusi metodi + jatka muita komentoja
            } else if (operation.equals("0")) {
                break;
            }
        }
    }

    private void addTip() {

        String type = getTipType();

        this.input.println("Insert header");

        String header = this.input.nextLine();

        this.input.println("Insert a description:\n");

        String description = this.input.nextLine();

        this.input.println("Insert the creator´s name:\n");

        String creator = this.input.nextLine();

        this.input.println("Insert url:\n");

        String url = this.input.nextLine();

        this.input.println("Insert a tags and separate with a ',':\n");

        String tags = this.input.nextLine();

        this.input.println("Insert a comment:\n ");

        String comment = this.input.nextLine();

        this.input.println("Insert a courses and separate with a ',':\n");

        String courses = this.input.nextLine();

        this.tipHandler.createTip(header, description, creator, url, type, tags, comment, courses);
        
        this.input.println("Tip created!");
    }

   


    public String getTipType() {

        this.input.println("Let´s create a tip. \n\n" +
                "Select type:\n" +
                "1. Book \n" +
                "2. Video \n" +
                "3. Podcast \n" +
                "4. Blog \n");

        String type = input.nextLine();


        if (type.equals("1")) {
            type = "book";
        } else if (type.equals("2")) {
            type = "video";
        } else if (type.equals("3")) {
            type = "podcast";
        } else if (type.equals("4")) {
            type = "blog";
        }

        return type;
    }

    public void search() {
        
        this.input.println("1. Search by type.\n" +
                    "2. Search by title.\n" +
                    "3. Search by author.\n" +
                    "expected input (1/2/3/0)");

        String option = input.nextLine();

        if (option.equals("1")) {
            selectType();
        } else if (option.equals("2")) {
            selectTitle();
        } else if (option.equals("3")) {
            selectAuthor();
        } else {
            this.input.println("Select search option");
            search();
        }
    }

    public void selectType() {
        
    }

    public void selectTitle() {

    }

    public void selectAuthor() {
    
    }

}
