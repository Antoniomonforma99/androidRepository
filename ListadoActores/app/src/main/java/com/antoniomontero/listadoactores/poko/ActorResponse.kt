package com.antoniomontero.listadoactores.poko

data class ActorResponse(
    val page: Int,
    val actors: List<Actor>,
    val total_pages: Int,
    val total_results: Int
)