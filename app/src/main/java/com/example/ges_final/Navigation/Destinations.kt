package com.example.ges_final.Navigation

import com.example.ges_final.R

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: Int ?= null
    ) {
    object Event : Destinations("Event","Partidos", R.drawable.baseline_sports_baseball_24)
    object Profile : Destinations("Profile", "Mi Perfil", R.drawable.baseline_person_24)
    object SearchEvents : Destinations("SearchEvent", "Busca Partido")
}
