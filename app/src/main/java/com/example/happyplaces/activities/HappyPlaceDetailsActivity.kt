package com.example.happyplaces.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happyplaces.databinding.ActivityHappyPlaceDetailsBinding
import com.example.happyplaces.models.HappyPlaceModel

class HappyPlaceDetailActivity : AppCompatActivity() {
    private var binding: ActivityHappyPlaceDetailsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHappyPlaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        var  happyPlaceDetailModel: HappyPlaceModel?=null
        if (intent.hasExtra(MainActivity.EXTRA_SPACE_DETAILS)) {
            happyPlaceDetailModel =
//                intent.getParcelableExtra(MainActivity.EXTRA_SPACE_DETAILS) as? HappyPlaceModel
                intent.getSerializableExtra(MainActivity.EXTRA_SPACE_DETAILS) as HappyPlaceModel
        }
        if(happyPlaceDetailModel != null){
            setSupportActionBar(binding?.toolbarHappyPlaceDetail)
            supportActionBar!!.title = happyPlaceDetailModel.title
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

            binding?.toolbarHappyPlaceDetail?.setNavigationOnClickListener {
                onBackPressed()
            }
            binding?.ivPlaceImage?.setImageURI(Uri.parse(happyPlaceDetailModel.image))
            binding?.tvDescription?.text = happyPlaceDetailModel.description
            binding?.tvLocation?.text = happyPlaceDetailModel.location

            binding?.btnViewOnMap?.setOnClickListener{
                val intent = Intent(this,MapActivity::class.java)
                intent.putExtra(MainActivity.EXTRA_SPACE_DETAILS,happyPlaceDetailModel)
                startActivity(intent)
            }
        }

    }
}