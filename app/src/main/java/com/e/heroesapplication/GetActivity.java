package com.e.heroesapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.e.heroesapplication.API.HeroesAPI;
import com.e.heroesapplication.Model.Heroes;
import com.e.heroesapplication.URL.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetActivity extends AppCompatActivity {
    private final static String BASE_URL="http://10.0.2.2:3000/";
    private TextView tvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        tvdata =findViewById(R.id.tvdata);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeroesAPI heroesapi=retrofit.create(HeroesAPI.class);
        Call<List<Heroes>> listCall=heroesapi.getHero();

        listCall.enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {
                if (!response.isSuccessful()){
                    tvdata.setText("Code:"+response.code());
                    return;
                }

                List<Heroes>heroesList=response.body();
                for (Heroes heroes:heroesList){
                    String content="";
                    content +="name:"+heroes.getName()+ "\n";
                    content +="desc:"+heroes.getDesc()+ "\n";

                    tvdata.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Heroes>> call, Throwable t) {
                tvdata.setText("error :" +t.getMessage());
            }
        });
    }
}
