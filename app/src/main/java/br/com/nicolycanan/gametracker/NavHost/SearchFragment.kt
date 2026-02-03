package br.com.nicolycanan.gametracker.NavHost

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.databinding.FragmentHomeBinding
import br.com.nicolycanan.gametracker.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSearchBinding.bind(view)

        // Exemplo
        // binding.textTitle.text = "Home"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
