package com.egorprok.ancientphilosophers

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.egorprok.ancientphilosophers.databinding.FragmentVityaBinding

class VityaFragment: Fragment(R.layout.fragment_vitya), PhraseAdapter.Listener {
    private lateinit var binding: FragmentVityaBinding
    private val adapter = PhraseAdapter(this)
    private var mediaPlayer: MediaPlayer? = null

    private val titleList = listOf("Жэээээня", "Багдасарян!!!",
        "Псина", "Псина в желтой майке))",
        "Металлической", "Миша лох)", "Твое место у параши",
        "Покупай себе гроб мразь", "На-на-на...", "Женя даун))",
        "В кого ты такое говнище?",
        "Я весь твой))", "Ноги поотрываю")
    private val mediaList = listOf(R.raw.zhenya, R.raw.bagdasaryan,
        R.raw.psinanana, R.raw.psinavmaike,
        R.raw.metallicheskoy, R.raw.mishalox,
        R.raw.mesto, R.raw.trup,
        R.raw.zhenyanana, R.raw.zhenyadaun,
        R.raw.govnische,
        R.raw.vestvoi, R.raw.ugroza)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVityaBinding.bind(view)
        binding.button.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer = null
            findNavController().popBackStack() }
        init()
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(activity, 2)
            recyclerView.adapter = adapter
            for (i in 0..12) {
                val phrase = Phrase(titleList[i])
                adapter.addPrikol(phrase)
            }
        }
    }

    override fun onClick(phrase: Phrase) {
        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer = null
        }
        if (mediaPlayer == null) {
            val id: Int = titleList.indexOf(phrase.title)
            mediaPlayer = MediaPlayer.create(activity, mediaList[id])
            mediaPlayer?.start()
        }
    }
}