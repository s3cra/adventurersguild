package characterData;


import characterData.races.*;

public abstract class chRace {
    statGrid stats;
    Size size;
    int speed;
    boolean darkVision;
    Language[] langs;


    protected chRace(statGrid stats, Size size, int speed, boolean darkVision, Language[] langs){
        this.stats = stats;
        this.size = size;
        this.speed = speed;
        this.darkVision = darkVision;
        this.langs = langs;
    }

    public static chRace getByName(String name){

        switch (name){
            case "Orc":
                return new Orc();
            case "Elf":
                return new Elf();
            default:
                return  new Orc();
        }
    }

    public String getRaceName(){
        return "";
    };
}
