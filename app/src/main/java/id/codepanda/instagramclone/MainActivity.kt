package id.codepanda.instagramclone

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import id.codepanda.instagramclone.mainfragments.HomeFragment
import id.codepanda.instagramclone.mainfragments.notifications.NotificationFragment
import id.codepanda.instagramclone.mainfragments.ProfileFragment
import id.codepanda.instagramclone.mainfragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var itemHome: MenuItem
    lateinit var itemSearch: MenuItem
    lateinit var itemUpload: MenuItem
    lateinit var itemFavourite : MenuItem
    lateinit var itemProfile : MenuItem
    private val mHomeFragment: Fragment = HomeFragment()
    private val mSearchFragment: Fragment = SearchFragment()
    private val mNotificationFragment: Fragment =
        NotificationFragment()
    private val mProfileFragment: Fragment = ProfileFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        menuIconReset()
        when (item.itemId) {
            R.id.navigation_home -> {
                item.icon = getDrawable(R.drawable.ic_home)
                commitFragment(mHomeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search-> {
                item.icon = getDrawable(R.drawable.ic_search_bold)
                commitFragment(mSearchFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_upload-> {
                item.icon = getDrawable(R.drawable.ic_add_circle)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notification-> {
                item.icon = getDrawable(R.drawable.ic_favorite)
                commitFragment(mNotificationFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile-> {
                item.icon = getDrawable(R.drawable.ic_person)
                commitFragment(mProfileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        menuItemBinding()
        navigation.selectedItemId = R.id.navigation_home
    }

    private fun menuItemBinding(){
        itemHome= navigation.menu.findItem(R.id.navigation_home)
        itemSearch= navigation.menu.findItem(R.id.navigation_search)
        itemUpload= navigation.menu.findItem(R.id.navigation_upload)
        itemFavourite = navigation.menu.findItem(R.id.navigation_notification)
        itemProfile= navigation.menu.findItem(R.id.navigation_profile)

        //default icon
        itemHome.icon = getDrawable(R.drawable.ic_home)
    }

    private fun menuIconReset(){
        itemHome.icon = getDrawable(R.drawable.ic_home_border)
        itemSearch.icon = getDrawable(R.drawable.ic_search)
        itemUpload.icon = getDrawable(R.drawable.ic_add_circle_outline)
        itemFavourite.icon = getDrawable(R.drawable.ic_favorite_border)
        itemProfile.icon = getDrawable(R.drawable.ic_person_outline)
    }

    private fun commitFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }
}
