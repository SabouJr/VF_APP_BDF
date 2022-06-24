package fr.example.bdf_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import fr.example.bdf_app.R

class AnecdoteDialogFragment(val content: String) : DialogFragment() {

    lateinit var anecdoteContent: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_radius_stoke_black)

        val view = inflater.inflate(R.layout.anecdote_dialog, container, false)

        anecdoteContent = view.findViewById(R.id.tvAnectodeContent)
        anecdoteContent.text = content

        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()

        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    companion object {
        const val TAG = "AnecdoteFragment"
    }

}