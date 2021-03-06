package com.vatestkot.my_application_w_nit.ui

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import com.vatestkot.my_application_w_nit.R
import com.vatestkot.my_application_w_nit.Weather
import com.vatestkot.my_application_w_nit.feature.search.SearchFragment
import com.vatestkot.my_application_w_nit.ui.FavoritiesFragment.Companion.newInstance
import com.vatestkot.my_application_w_nit.ui.WeatherDetailsFragment.Companion.newInstance
import kotlinx.android.synthetic.main.fragment_top_weather.*

class TopWeatherFragment : Fragment(R.layout.fragment_top_weather) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = Weather("Челябинск", "-7", "Ясно","Снег")

        btnGoToSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                    .replace(R.id.container, SearchFragment())
                    .addToBackStack("SearchFragment")
                    .commit()
        }

        btnGoToDetails.setOnClickListener{
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, WeatherDetailsFragment.newInstance(weather))
                .addToBackStack("WeatherDetailsFragment")
                .commit()
        
        }
        btnGoToFavorities.setOnClickListener {
            requireFragmentManager().beginTransaction()
                    .replace(R.id.container,FavoritiesFragment.newInstance(weather))
                    .addToBackStack("FavoritiesFragment")
                    .commit()
        }
    }
}
