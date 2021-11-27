package com.tef.dccomics.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.tef.dccomics.databinding.FragmentListBinding
import com.tef.dccomics.model.Superheroe
import com.tef.dccomics.model.SuperheroeItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listSuperheroes: ArrayList<SuperheroeItem>
    private lateinit var superHeroesAdapter: SuperHeroesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listSuperheroes = loadMockSuperHeroesFromJson()
        superHeroesAdapter = SuperHeroesAdapter(listSuperheroes, onItemClicked = { onSuperheroeClicked(it) } )


    }

    private fun onSuperheroeClicked(superheroe: SuperheroeItem) {
        // TODO program function onClicked
    }

    private fun loadMockSuperHeroesFromJson(): ArrayList<SuperheroeItem> {
        val superHeroesString: String = context?.assets?.open("superheroes.json")?.bufferedReader().use { it!!.readText() } //TODO reparar !!
        val gson = Gson()
        val superHeroesList = gson.fromJson(superHeroesString, Superheroe::class.java)
        return superHeroesList
    }
}