package br.com.empresa.nextdestination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.empresa.nextdestination.adapter.RecentDestinationAdapter
import br.com.empresa.nextdestination.api.DestinationCall
import br.com.empresa.nextdestination.constants.ApiConstants
import br.com.empresa.nextdestination.model.DestinationModel
import br.com.empresa.nextdestination.adapter.TopDestinationAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var rvRecentDestinations: RecyclerView
    lateinit var rvTopDestinations: RecyclerView

    lateinit var recentDestinationAdapter: RecentDestinationAdapter
    lateinit var topDestinationAdapter: TopDestinationAdapter

    lateinit var cardProfile: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rvRecentDestinations = findViewById(R.id.rv_main_recents)
        rvTopDestinations = findViewById(R.id.rv_main_top_places)

        cardProfile = findViewById(R.id.card_profile)

        setRecentDestinations()
        setToptDestinations()

        cardProfile.setOnClickListener {
            val i = Intent(this, ProfileActivity::class.java)
            startActivity(i)
        }
    }

//    override fun onResume() {
//
//        setRecentDestinations()
//        setToptDestinations()
//
//        super.onResume()
//    }

    fun setRecentDestinations() {
        recentDestinationAdapter =
            RecentDestinationAdapter(this)
        rvRecentDestinations.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvRecentDestinations.adapter = recentDestinationAdapter
        loadRecentDestinations()
    }

    fun setToptDestinations() {
        topDestinationAdapter =
            TopDestinationAdapter(this)
        rvTopDestinations.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTopDestinations.adapter = topDestinationAdapter
        loadRecentDestinations()
    }

    fun loadRecentDestinations(): List<DestinationModel> {

        var destinos : List<DestinationModel>? = listOf<DestinationModel>()

        // Retrofit Builder
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Instancia da interface
        val destinationCall = retrofit.create(DestinationCall::class.java)
        val call = destinationCall.getDestinations()

        call.enqueue(object : Callback<List<DestinationModel>> {
            override fun onFailure(call: Call<List<DestinationModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "erro!!", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<DestinationModel>>,
                response: Response<List<DestinationModel>>
            ) {
                destinos = response.body()
                recentDestinationAdapter.updateDestinationList(destinos!!)
                topDestinationAdapter.updateTopDestinationList(destinos!!)
            }

        })

//        call.enqueue(object : Callback<List<DestinationModel>>{
//            override fun onFailure(call: Call<List<DestinationModel>>, t: Throwable) {
//
//                Log.d("MainActivity", t.message.toString())
//                Toast.makeText(applicationContext, "Falhou", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<DestinationModel>>,
//                response: Response<List<DestinationModel>>
//            ) {
//
//                response.body().let {
//                    destinos = it
//                    recentDestinationAdapter.updateDestinationList(destinos!!)
//                    topDestinationAdapter.updateTopDestinationList(destinos!!)
//                    Log.d("XXX", destinos!!.size.toString())
//                }
//
//                if (response.code() != 200) {
//                    Toast.makeText(applicationContext, "Funcionou", Toast.LENGTH_LONG).show()
//                    return
//                }
//            }
//
//        })

        //return recentDestinations
        Log.d("XXX", "Return " + destinos!!.size.toString())
        return destinos!!

    }
}