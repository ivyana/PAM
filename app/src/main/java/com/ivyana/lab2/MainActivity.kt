package com.ivyana.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf<Image>(
            Image(
                R.drawable.img1,
                "Pulp Fiction",
                "In the realm of underworld, a series of incidents intertwines the lives of two Los Angeles mobsters, a gangster's wife, a boxer and two small-time criminals."
            ),
            Image(
                R.drawable.img2,
                "Fight Club",
                "Discontented with his capitalistic lifestyle, a white-collared insomniac forms an underground fight club with Tyler, a careless soap salesman. The project soon spirals down into something sinister."
            ),
            Image(
                R.drawable.img3,
                "Léon: The Professional",
                "When 12-year-old Mathilda's family is killed, her neighbour Leon, who is a professional assassin, reluctantly takes her under his wing and teaches her the secrets of his trade."
            ),
            Image(
                R.drawable.img4,
                "Inception",
                "Cobb steals information from his targets by entering their dreams. Saito offers to wipe clean Cobb's criminal history as payment for performing an inception on his sick competitor's son."
            ),
            Image(
                R.drawable.img5,
                "Equilibrium",
                "In a world where every form of human emotion is prohibited, Preston, an officer responsible for implementing the law, decides to revolt against it."            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}
