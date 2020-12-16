package com.example.submoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private String jsonPokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.jsonPokemonList = b.getString("pokemons");
            pokemons = new Gson().fromJson(jsonPokemonList, new TypeToken<ArrayList<Pokemon>>(){}.getType());
            System.out.println(pokemons);
        }

        ListView listaDePokemon = (ListView) findViewById(R.id.lista);

        AdapterListaPokemon adapter = new AdapterListaPokemon(pokemons, this);

        listaDePokemon.setAdapter(adapter);

    }

    public void goToNewActivity(View view){

        Intent intent = new Intent(MainActivity.this, AdicionarPokemon.class);
        String pokemonListString = new Gson().toJson(pokemons);
        Bundle b = new Bundle();
        b.putString("pokemons",pokemonListString);
        intent.putExtras(b);
        startActivity(intent);
    }
    }

