package com.egorprok.ancientphilosophers

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.egorprok.ancientphilosophers.databinding.FragmentVolodyaBinding


class VolodyaFragment: Fragment(R.layout.fragment_volodya), PhraseAdapter.Listener {
    private lateinit var binding: FragmentVolodyaBinding
    private val adapter = PhraseAdapter(this)
    private var mediaPlayer: MediaPlayer? = null

    private val titleList = listOf("Я Володя", "Баклажан", "У Сани",
                                    "Что делать?", "Пить не буду", "Ляг поспи",
                                     "Правила", "Даниил Степанов",
                                    "Докурю", "Я машина",
                                    "Это ложь", "Честно!", "Козел",
                                    "Витя псина",  "Всех люблю")
    private val mediaList = listOf(R.raw.yavolodya, R.raw.baklajan, R.raw.baklajanit,
                                    R.raw.chtodelat, R.raw.nebudu, R.raw.pospi,
                                    R.raw.sport, R.raw.stepanov,
                                    R.raw.dokuru, R.raw.yamashina,
                                    R.raw.lozh, R.raw.chestno, R.raw.kozel,
                                    R.raw.vityapsina,  R.raw.lublu)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVolodyaBinding.bind(view)
        binding.button.setOnClickListener { findNavController().popBackStack() }
        init()
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(activity, 2)
            recyclerView.adapter = adapter
            for (i in 0..14) {
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