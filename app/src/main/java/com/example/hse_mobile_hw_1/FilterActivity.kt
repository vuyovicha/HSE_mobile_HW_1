package com.example.hse_mobile_hw_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.filter_main.*

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filter_main)

        this.title = getString(R.string.filter_titile)

        filterRecycler.adapter = FilterAdapter()
        filterRecycler.layoutManager = LinearLayoutManager(this)

        applyButton.setOnClickListener {
            finish()
        }
    }
}
