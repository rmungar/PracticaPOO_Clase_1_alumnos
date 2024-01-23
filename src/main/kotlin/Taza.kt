class Taza () {

    var color: String = "Blanco"
    var capacidad:Int = 50
    init {
        val capacidades = listOf<Int>(50, 75, 100)
        val colores = listOf<String>("blanco", "negro", "gris", "azul", "verde")

        color = colores.random()
        capacidad = capacidades.random()
    }

    var cantidad:Int = 0
        set(value){
            comprobarCantidad(field)
            field = value
        }


    fun comprobarCantidad(field: Int): Int{
        return if (field > capacidad){
            capacidad
        } else{
            field
        }
    }

    fun llenar(){
        cantidad = capacidad
    }

    fun llenar(Int: Int){
        if (Int< capacidad){
            println("Llenando taza...")
            readln()
            println("Taza llenada con $Int c.c.")
        }
        else if (Int == capacidad){
            println("Llenando taza...")
            readln()
            println("Taza llenada a máxima capacidad")
        }
        else{
            println("Llenando taza...")
            readln()
            println("Carga de taza excesiva, llenada a máxima capacidad para evitar sobrantes...")
        }
    }


    override fun toString(): String {
        return "Taza de color ${this.color}, ${this.capacidad}c.c. de capacidad y con cantidad de ${this.cantidad}c.c."
    }

}