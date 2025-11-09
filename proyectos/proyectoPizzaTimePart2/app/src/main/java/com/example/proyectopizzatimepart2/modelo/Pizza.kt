package com.example.proyectopizzatimepart2.modelo

enum class TipoPizza { ninguno, barbacoa, romana, margarita }
enum class TamanoPizza { ninguno, pequena, mediana, grande }
enum class SubTipoPizza { ninguno, carne_de_cerdo, carne_de_pollo, carne_de_ternera, con_pina, sin_pina, vegana, no_vegana, con_champinones, sin_chapinones }
data class Pizza(
    val idPizza: Int = 0,
    val tipoPizza: TipoPizza = TipoPizza.ninguno,
    val subTipoPizza: SubTipoPizza = SubTipoPizza.ninguno,
    val tamanoPizza: TamanoPizza = TamanoPizza.mediana,
)
