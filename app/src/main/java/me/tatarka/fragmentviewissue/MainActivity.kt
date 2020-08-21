package me.tatarka.fragmentviewissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        FragmentManager.enableNewStateManager(false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = MyFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.content, fragment)
                .commitNow()

            // sometime later
            Handler(Looper.getMainLooper()).post {
                supportFragmentManager.beginTransaction()
                    .setMaxLifecycle(fragment, Lifecycle.State.CREATED)
                    .commitNow()
            }
        }
    }
}

class MyFragment : Fragment(R.layout.fragment_main)
