package br.com.nicolycanan.gametracker.NavHost

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.databinding.FragmentHomeBinding
import br.com.nicolycanan.gametracker.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProfileBinding.bind(view)

        // Exemplo
        // binding.textTitle.text = "Perfil"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
