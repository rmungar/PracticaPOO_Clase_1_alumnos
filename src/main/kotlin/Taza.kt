class Taza (val color: Color = Color.BLANCO, var capacidad:Int = 50) {

    init {
        val capacidades = listOf<Int>(50, 75, 100)
        capacidad = capacidades.random()
    }

    var cantidad:Int = 0
        set(value){
            comprobarCantidad(field)
            field = value
            // field = if (value > this.capacidad) this.capacidad else value
        }


    fun comprobarCantidad(field: Int): Int{
        return if (field > capacidad){
            capacidad
        } else{
            field
        }
    }

    /**
     * Llena la taza a maxima capacidad, al igual que Cafetera.llenar()
     */
    fun llenar(){
        cantidad = capacidad
    }

    /**
     * Es muy parecida a la función anterior, pero esta permite llenar la cantidad que el usuario quiera
     * @param Int: Int  cantidad que ingresa el usuario
     */
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