package api;

import java.util.List;
import ru.adventurersguild.characterData.Character;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ru.adventurersguild.stuff.User;


public interface GuildAPI {
    @GET("/api/v1/characters")
    Call<List<Character>> getCharacters();
    @POST("/api/v1/characters/new")
    Call<Character> createCharacter(@Body Character character);
    @POST("/api/v1/users/login")
    Call<ResponseBody> signIn(@Body User user);

}
