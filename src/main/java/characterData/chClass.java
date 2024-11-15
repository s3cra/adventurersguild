package characterData;

import characterData.classes.*;
import characterData.races.Orc;

public abstract class chClass {

    static String className;
    int level = 1;


    public static chClass getByName(String name){

        switch (name){
            case "Fighter":
                return new Fighter();
            case "Wizard":
                return new Wizard();
            default:
                return new Fighter();
        }
    }

    public String getClassName(){
        return "";
    }
    public int getLevel(){
        return this.level;
    }

}
