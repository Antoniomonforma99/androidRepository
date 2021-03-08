package com.antoniomontero.listadoactores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoniomontero.listadoactores.viewmodel.ActorListViewModel
import com.antoniomontero.listadoactores.adapter.MyActorRecyclerViewAdapter
import com.antoniomontero.listadoactores.poko.Actor

class ActorListFragment : Fragment() {

    var listaActor : List<Actor> = listOf()
    lateinit var listaAdapter: MyActorRecyclerViewAdapter
    lateinit var viewModel: ActorListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        viewModel = ViewModelProvider(this).get(ActorListViewModel::class.java)

        val v = view as RecyclerView

        listaAdapter = MyActorRecyclerViewAdapter(listaActor)
        v.layoutManager = LinearLayoutManager(context)
        v.adapter = listaAdapter

        viewModel.actor.observe(viewLifecycleOwner, Observer {
                actors -> listaActor = actores
            listaAdapter.setData(actores.sortedWith(compareBy({ it.name })))
        })

    }