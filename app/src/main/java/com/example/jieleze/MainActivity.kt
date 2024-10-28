package com.example.jieleze

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1Button: Button = findViewById(R.id.fragment1Button)
        val fragment2Button: Button = findViewById(R.id.fragment2Button)
        val fragment3Button: Button = findViewById(R.id.fragment3Button)

        fragment2Button.setOnClickListener {
            val popup = PopupMenu(this, it)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.popup_action_share -> {
                        // Handle share action
                        true
                    }
                    R.id.popup_action_favorite -> {
                        // Handle favorite action
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }

        fragment3Button.setOnClickListener {
            loadFragment(Fragment3())
        }
        registerForContextMenu(fragment1Button)  // Register this button for the context menu
    }

    private fun loadFragment(fragment: Fragment) {
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    //Options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_fragment1 -> {
                loadFragment(Fragment1())  // Load Fragment 1
                true
            }
            R.id.action_fragment2 -> {
                loadFragment(Fragment2())  // Load Fragment 2
                true
            }
            R.id.action_fragment3 -> {
                loadFragment(Fragment3())  // Load Fragment 3
                true
            }
            R.id.action_activity_a -> {
                val intent = Intent(this, ActivityA::class.java)
                startActivity(intent)  // Navigate to Activity A
                true
            }
            R.id.action_activity_b -> {
                val intent = Intent(this, ActivityB::class.java)
                startActivity(intent)  // Navigate to Activity B
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Context menu on fragment 1 button
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_action_edit -> {
                // Handle edit action
                true
            }
            R.id.context_action_delete -> {
                // Handle delete action
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}