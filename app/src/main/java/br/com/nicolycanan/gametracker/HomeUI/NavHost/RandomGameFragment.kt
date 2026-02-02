package br.com.nicolycanan.gametracker.homeui.navhost

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.databinding.FragmentRandomGameBinding

class RandomGameFragment : Fragment(R.layout.fragment_random_game) {

    private var _binding: FragmentRandomGameBinding? = null
    private val binding get() = _binding!!

    private val games = mutableListOf<Game>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRandomGameBinding.bind(view)

        mockGames()

        binding.btnRandomGame.setOnClickListener {
            showRandomGame()
        }
    }

    private fun mockGames() {
        games.addAll(
            listOf(
                Game(1, "The Witcher 3"),
                Game(2, "God of War"),
                Game(3, "Hades"),
                Game(4, "Cyberpunk 2077")
            )
        )
    }

    private fun showRandomGame() {
        if (games.isEmpty()) {
            Toast.makeText(requireContext(), "Lista de jogos vazia", Toast.LENGTH_SHORT).show()
            return
        }

        val randomGame = games.random()
        binding.txtGameName.text = randomGame.name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
