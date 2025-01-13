package api;


import java.io.IOException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.adventurersguild.stuff.User;


public class Retro {
    public static Retrofit retrofit;
    public static User user;
    public static String token;
    public static GuildAPI api;

    static {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                if(token == null) return chain.proceed(chain.request());
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        "Bearer " + token);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.6:8080")
                .addConverterFactory(JacksonConverterFactory.create()).client(okHttpClient)
                .build();

        api = retrofit.create(GuildAPI.class);
    }

}
