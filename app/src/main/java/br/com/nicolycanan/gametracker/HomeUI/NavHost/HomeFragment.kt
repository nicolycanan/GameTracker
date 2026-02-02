package br.com.nicolycanan.gametracker.NavHost

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.nicolycanan.gametracker.NewsManager.News
import br.com.nicolycanan.gametracker.NewsManager.NewsAdapter
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NewsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

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
