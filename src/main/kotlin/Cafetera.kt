class Cafetera (val ubicacion: String) {

    var capacidad: Int = 1000
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
        this.capacidad = capacidad
    }
    init {
        this.cantidad = this.capacidad
    }

    constructor(ubicacion: String, capacidad: Int, cantidad: Int): this (ubicacion, capacidad){
        this.cantidad = if (capacidad > cantidad) capacidad else cantidad  //Haciendo esto me ahorro el init, al contrario que arriba
        this.capacidad = capacidad
    }

    /**
     * Llena la cafetera a la capacidad máxima igualando la cantidad a la capacidad (BIEN)
     */
    fun llenar(){
        this.cantidad = this.capacidad
        println("Cafetera llenada")
    }

    /**
     * Llena una taza pasada por parámetro a su capacidad máxima en caso de que
     * @param taza: Taza objeto taza pasado por parámetro
     */
    fun servirTaza(taza: Taza) {
        if (cantidad > 0) {
            taza.llenar()
            cantidad -= taza.capacidad
            println("Taza servida")
            // taza.cantidad = taza.capacidad               DEBERIA DE HABER SIDO COMO EN LA LINEA INFERIOR

        } else {
            if (cantidad < taza.capacidad) {
                // taza.cantidad = cantidad                 DEBERIA DE HABER SIDO COMO EN LA LINEA INFERIOR
                taza.llenar(cantidad)
                cantidad = 0
                println("Taza servida")

            } else {
                println("Cafetera vacía, por favor rellene el deposito de café...")
                vaciar()
            }
        }
    }

    /**
     * Vacía la cafetera igualando la cantidad a 0 (BIEN)
     */
    fun vaciar(){
        cantidad = 0
        println("Cafetera vacía")
    }

    /**
     * Añade la cantidad de café especificada por el usuario, comprobando la cantidad en el momento anterior a llenar.
     */
    fun agregarCafé(Int: Int){ //No deberias haber cambiado el nombre, en vez de haber desarrollado el método deberias haber empleado llenar()
        if (cantidad+Int == capacidad){
            println("Cafetera a máxima capacidad")
            cantidad = capacidad
        }
        else if (cantidad+Int > capacidad){
            println("Cafetera se ha llenado a maxima capacidad")
            println("Por favor recoge el sobrante...")
            cantidad = capacidad
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