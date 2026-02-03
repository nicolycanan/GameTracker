package br.com.nicolycanan.gametracker.NavHost

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.databinding.FragmentRandomGameBinding
import br.com.nicolycanan.gametracker.model.Game

class RandomGameFragment : Fragment(R.layout.fragment_random_game) {

    private var _binding: FragmentRandomGameBinding? = null
    private val binding get() = _binding!!

    private val games = mutableListOf<Game>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRandomGameBinding.bind(view)

        mockGames()
        showRandomGame()

        binding.btnRandomGame.setOnClickListener {
            showRandomGame()
        }
    }

    private fun mockGames() {
        games.addAll(
            listOf(
                Game(1, "Valorant", R.drawable.valorant, "jogo de tiro com poder"),
                Game(2, "CS GO", R.drawable.csgocapa, "jogo de tiro"),

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
        binding.imageRes.setImageResource(randomGame.imageRes)
        binding.txtGameDesc.text= randomGame.description

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
