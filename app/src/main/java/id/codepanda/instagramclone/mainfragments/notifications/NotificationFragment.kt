package id.codepanda.instagramclone.mainfragments.notifications


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.codepanda.instagramclone.R

class NotificationFragment : Fragment() {


    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout

    private var activePager = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        viewpager = view.findViewById(R.id.viewpager)
        tabs = view.findViewById(R.id.tabs)

        viewpager.adapter = NotificationPagerAdapter(childFragmentManager)
        tabs.setupWithViewPager(viewpager)

        viewpager.currentItem = activePager

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activePager = viewpager.currentItem
    }
}
