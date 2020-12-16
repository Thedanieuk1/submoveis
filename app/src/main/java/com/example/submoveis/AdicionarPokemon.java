package com.example.submoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class AdicionarPokemon extends AppCompatActivity {
    private EditText edTxNomePokemon;
    private Spinner spTipoPrimario;
    private Spinner spTipoSecundario;

    private String jsonPokemonList;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pokemon);


        Bundle b = getIntent().getExtras();
        if (b != null) {
            this.jsonPokemonList = b.getString("pokemons");
            pokemons = new Gson().fromJson(jsonPokemonList, new TypeToken<ArrayList<Pokemon>>(){}.getType());
        }

        edTxNomePokemon = (EditText) findViewById(R.id.edTxtNomePokemon);
        spTipoPrimario = (Spinner) findViewById(R.id.tipoPrimario);
        spTipoSecundario = (Spinner) findViewById(R.id.tipoSecundario);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.pokemon_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spTipoPrimario.setAdapter(staticAdapter);
        spTipoSecundario.setAdapter(staticAdapter);


    }


    public void adicionarPokemon(View view) {
        if (edTxNomePokemon.length() > 0) {
            Pokemon p = new Pokemon(
                    edTxNomePokemon.getText().toString(),
                    spTipoPrimario.getSelectedItem().toString(),
                    spTipoSecundario.getSelectedItem().toString()
            );
            pokemons.add(p);

            goToNewActivity();

        }else{
            String erro = "Informe o nome do Pokemon";
            Toast.makeText(this, erro, Toast.LENGTH_LONG).show();
        }
    }

    public void goToNewActivity(){

        Intent intent = new Intent(AdicionarPokemon.this, MainActivity.class);
        String pokemonListString = new Gson().toJson(pokemons);
        Bundle b = new Bundle();
        b.putString("pokemons",pokemonListString);
        intent.putExtras(b);
        startActivity(intent);

        finish();
    }


}
