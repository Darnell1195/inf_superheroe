package com.example.inf_superheroe

import java.io.Serializable

data class Superheores(
    var id: Int,
    var idname: String,
    var iddescripcion: String,
    var idfoto: Int
) : Serializable
