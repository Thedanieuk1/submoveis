package com.example.submoveis;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListaPokemon extends BaseAdapter {

    private final ArrayList<Pokemon> pokemons;
    private final Activity act;

    public AdapterListaPokemon(ArrayList<Pokemon> pokemons, Activity act) {
        this.pokemons = pokemons;
        this.act = act;
    }

    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.lista_pokemon_personalizada, parent, false);

        Pokemon pokemon = pokemons.get(position);

        TextView nome = (TextView) view.findViewById(R.id.lista_pokemon_personalizada_nome);
        TextView tipoPrimario = (TextView) view.findViewById(R.id.lista_pokemon_personalizada_tipoPrimario);
        TextView tipoSecundario = (TextView) view.findViewById(R.id.lista_pokemon_personalizada_tipoSecundario);

        nome.setText(pokemon.getNome());
        tipoPrimario.setText(pokemon.getTipoPrimario());
        tipoSecundario.setText(pokemon.getTipoSecundario());

        return view;
    }
}
