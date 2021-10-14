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

        itemList.add(SpaceItem(R.drawable.andromeda, getString(R.string.andromeda)))
        itemList.add(SpaceItem(R.drawable.black_hole, getString(R.string.black_hole)))
        itemList.add(SpaceItem(R.drawable.comet, getString(R.string.comet)))
        itemList.add(SpaceItem(R.drawable.helix_nebula, getString(R.string.helix_nebula)))
        itemList.add(SpaceItem(R.drawable.hubble, getString(R.string.hubble)))
        itemList.add(SpaceItem(R.drawable.io, getString(R.string.io)))
        itemList.add(SpaceItem(R.drawable.jupiter, getString(R.string.jupiter)))
        itemList.add(SpaceItem(R.drawable.milky_way, getString(R.string.milky_way)))
        itemList.add(SpaceItem(R.drawable.pillars_of_creation, getString(R.string.pillars_of_creation)))
        itemList.add(SpaceItem(R.drawable.supernova, getString(R.string.supernova)))
        itemList.add(SpaceItem(R.drawable.triangulum, getString(R.string.triangulum)))
        itemList.add(SpaceItem(R.drawable.vela_pulsar, getString(R.string.vela_pulsar)))

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