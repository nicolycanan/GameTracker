package br.com.nicolycanan.gametracker.NavHost

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.nicolycanan.gametracker.model.Launch
import br.com.nicolycanan.gametracker.adapters.LaunchAdapter
import br.com.nicolycanan.gametracker.model.News
import br.com.nicolycanan.gametracker.adapters.NewsAdapter
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var launchAdapter: LaunchAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NewsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        val launches = listOf(
            Launch(R.drawable.valorant, "Valorant"),
            Launch(R.drawable.csgocapa, "CS:GO"),
            Launch(R.drawable.valorant, "Valorant 2"),
            Launch(R.drawable.csgocapa, "CS:GO 2")
        )

        launchAdapter = LaunchAdapter(launches) { launch ->
            Toast.makeText(requireContext(), "Clicou: ${launch.title}", Toast.LENGTH_SHORT).show()
        }

        val recyclerLaunches = view.findViewById<RecyclerView>(R.id.rvLaunches)
        recyclerLaunches.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerLaunches.adapter = launchAdapter




        // lista inicial
        val newsList = mutableListOf(
            News("Valorant Update", "Novo patch lançado", R.drawable.valorant),
            News("CS2 Patch", "Mudanças no mapa", R.drawable.csgocapa)
        )

        // adapter
        adapter = NewsAdapter(newsList)

        // recyclerView
        val recycler = view.findViewById<RecyclerView>(R.id.rvNews)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
