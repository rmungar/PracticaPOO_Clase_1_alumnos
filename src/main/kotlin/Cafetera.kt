class Cafetera (var ubicacion: String) {



    var capacidad: Int = 0
        set(value) {
            comprobarCapacidad(value)
            field = value
        }

    var cantidad: Int = 0
    fun comprobarCapacidad(capacidad: Int): Int{
        if (capacidad > 1000){
            return 1000
        }
        else if (capacidad < 0){
            return 0
        }
        else {
            return capacidad
        }
    }
    constructor(ubicacion: String,capacidad: Int) : this(ubicacion){
        this.ubicacion = ubicacion
        this.capacidad = capacidad
    }
    init {
        this.cantidad = this.capacidad
    }

    constructor(ubicacion: String, capacidad: Int, cantidad: Int): this (ubicacion, capacidad){
        this.cantidad = cantidad
        this.capacidad = capacidad
        this.ubicacion = ubicacion
    }

    fun llenar(){
        cantidad = capacidad
        println("Cafetera llenada")
    }
    fun servirTaza(taza: Taza) {
        do {
            if (cantidad >= 50) {
                cantidad -= taza.capacidad
                println("Sirviendo taza...")
                println("Taza servida")
                taza.cantidad = taza.capacidad
            } else {
                if (cantidad < taza.capacidad) {
                    println("Cantidad insuficiente para una taza completa...")
                    taza.cantidad = cantidad
                    cantidad = 0
                    println("Taza servida")

                } else {
                    println("Cafetera vacía, por favor rellene el deposito de café...")
                    readln()
                }
            }
        } while (cantidad > 0)
    }

        fun vaciar(){
        cantidad = 0
        println("Cafetera vacía")
    }
    fun llenar(Int: Int){
        if (cantidad+Int == capacidad){
            println("Cafetera a máxima capacidad")
            cantidad = capacidad
        }
        else if (cantidad+Int > capacidad){
            println("Cafetera se ha llenado a maxima capacidad")
            println("Por favor recoge el sobrante...")
            cantidad = capacidad
            readln()
        }
        else{
            println("Cafetera llenada al ${(cantidad+Int*100)/capacidad}%")
            cantidad += Int
        }
    }

    override fun toString(): String {
        return "Cafetera en ${this.ubicacion}, capacidad = ${this.capacidad}c.c. y con una cantidad de ${this.cantidad}c.c."
    }

}