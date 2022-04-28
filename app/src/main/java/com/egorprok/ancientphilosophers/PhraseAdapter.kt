package com.egorprok.ancientphilosophers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorprok.ancientphilosophers.databinding.PhraseBinding

class PhraseAdapter(val listener: Listener): RecyclerView.Adapter<PhraseAdapter.PhraseHolder>() {
    val prikolList = ArrayList<Phrase>()

    class PhraseHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PhraseBinding.bind(item)
        fun bind(phrase: Phrase, listener: Listener) {
            binding.textView.text = phrase.title
            binding.root.setOnClickListener {
                listener.onClick(phrase)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhraseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.phrase, parent, false)
        return PhraseHolder(view)
    }

    override fun onBindViewHolder(holder: PhraseHolder, position: Int) {
        holder.bind(prikolList[position], listener)
    }

    override fun getItemCount(): Int {
        return prikolList.size
    }

    fun addPrikol(phrase: Phrase) {
        prikolList.add(phrase)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(phrase: Phrase)
    }
}