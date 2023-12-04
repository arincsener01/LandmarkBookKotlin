package com.arincdogansener.landmarkbookkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.arincdogansener.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colosseum)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val londonBridge = Landmark("London Bridge", "England", R.drawable.londonbridge)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkList.map { landmark ->  landmark.name})

        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)
        }
    }
}