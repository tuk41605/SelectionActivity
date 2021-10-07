package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity(), CustomAdapter.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val finalList = generateItemList()

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = CustomAdapter(finalList, this)
        recyclerView.layoutManager = GridLayoutManager(this, 4)
    }

    private fun generateItemList(): List<SpaceItem> {
        val itemList = ArrayList<SpaceItem>()

        itemList.add(SpaceItem(R.drawable.andromeda, "Andromeda Galaxy"))
        itemList.add(SpaceItem(R.drawable.black_hole, "Photo of a Black Hole"))
        itemList.add(SpaceItem(R.drawable.comet, "Halley's Comet"))
        itemList.add(SpaceItem(R.drawable.helix_nebula, "The Helix Nebula"))
        itemList.add(SpaceItem(R.drawable.hubble, "The Hubble Ultra Deep Field"))
        itemList.add(SpaceItem(R.drawable.io, "Jovian moon Io"))
        itemList.add(SpaceItem(R.drawable.jupiter, "Jupiter, with the red spot visible"))
        itemList.add(SpaceItem(R.drawable.milky_way, "The Milky Way Galaxy"))
        itemList.add(SpaceItem(R.drawable.pillars_of_creation, "The Pillars of Creation Nebula"))
        itemList.add(SpaceItem(R.drawable.supernova, "A supernova, a dying star"))
        itemList.add(SpaceItem(R.drawable.triangulum, "The Triangulum Galaxy, 2.723 million lightyears away"))
        itemList.add(SpaceItem(R.drawable.vela_pulsar, "The Vela Pulsar"))

        return itemList
    }

    override fun onClick(retrieved: SpaceItem) {
        val image = retrieved.image
        val text = retrieved.name
        val intent = Intent(this, DisplayActivity::class.java).apply {
            putExtra("IMAGE", image)
            putExtra("DESCRIPTION", text)
        }
        startActivity(intent)
    }
}