package characterData.classes;

import characterData.chClass;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Fighter extends chClass {

    @JsonCreator
    public Fighter(int level){
        super("Fighter", level);
    }
}

