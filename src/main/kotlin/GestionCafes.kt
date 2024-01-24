import kotlin.random.Random

class GestionCafes {
    companion object{

        /**
         * Crea una lista de tazas obteniendo tanto el color como la capacidad de forma aleatoria y lo retorna
         * @param num: Int Número de tazas a crear
         */
        fun crearListaTazas(num:Int = 20):List<Taza>{
            return mutableListOf<Taza>().apply {
                for(i in 1..num){
                    val capacidadAleatoria = when(Random.nextInt(3)){
                        0 -> 50
                        1 -> 75
                        else -> 100
                    }
                    val taza = Taza(Color.entries.toTypedArray().random(), capacidadAleatoria)
                    add(taza)
                }
            }.toList()
        }

        /**
         * Va a imprimir la informacion de todas las tazas
         * @param tazas: List<Taza> Lista que contiene todas las tazas creadas previamente
         */
        fun mostrarTazas(tazas: List<Taza>){
            tazas.forEach { taza -> println(taza.toString()) }
        }

        /**
         * Va a imprimir la informacion de todas las cafeteras
         * @param cafeteras: List<Cafeteras> Lista que contiene todas las cafeteras creadas previamente
         */
        fun mostrarCafeteras(cafeteras: List<Cafetera>){
            cafeteras.forEach { cafetera -> println(cafetera.toString()) }
        }


        fun servirTazas(tazas: List<Taza>, cafeteras: List<Cafetera>){
            for (taza in tazas){
                for (cafetera in cafeteras){
                    if (cafetera.cantidad > 0){
                        cafetera.servirTaza(taza)
                        break
                    }
                }
            }
        }
    }
}