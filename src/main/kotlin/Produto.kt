class Produto(
    private val codigo: Int,
    private val nome: String,
    private val preco: Double,
    private val marca: Marca,
    private val genero: Genero
) {
    fun getNome(): String {
        return nome
    }
    fun getPreco(): Double{
        return preco
    }
    fun getMarca(): Marca{
        return this.marca
    }
    fun getGenero(): Genero {
        return this.genero
    }
}
