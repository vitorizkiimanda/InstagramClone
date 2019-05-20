package id.codepanda.instagramclone.mainfragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import id.codepanda.instagramclone.R
import id.codepanda.instagramclone.StoryActivity
import org.jetbrains.anko.support.v4.startActivity

class HomeFragment : Fragment() {

    lateinit var mButtonStory : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.home_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        bindingView(view)
        onClick()
        return view
    }

    private fun bindingView(view: View){
        mButtonStory = view.findViewById(R.id.button_story)
    }

    private fun onClick(){
        mButtonStory.setOnClickListener { startActivity<StoryActivity>() }
    }


}
