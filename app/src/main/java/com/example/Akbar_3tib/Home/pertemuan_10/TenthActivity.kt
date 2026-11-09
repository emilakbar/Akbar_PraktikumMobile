package com.example.Akbar_3tib.Home.pertemuan_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.Akbar_3tib.R
import com.example.Akbar_3tib.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Pertemuan 10"

        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Inisialisasi adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // Pasang adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // Hubungkan TabLayout dan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when (position) {
                0 -> {
                    tab.text = "Promo"
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_home
                    )

                    // Badge jumlah promo aktif
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 1
                }

                1 -> {
                    tab.text = "Tentang"
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_message
                    )
                }

                2 -> {
                    tab.text = "Menu"
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_more
                    )
                }
            }

        }.attach()
    }
}