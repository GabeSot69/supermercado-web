abstract class Genero(protected var nome: String) {

    abstract fun getNomeGenero(): String
    abstract fun setNomeGenero(nome: String)
}

// Subclasses de Genero
class Leite(nome: String = "Leite") : Genero(nome) {
    override fun getNomeGenero(): String {
        return this.nome
    }

    override fun setNomeGenero(nome: String) {
        this.nome = nome
    }
}

class Presunto(nome: String = "Presunto") : Genero(nome) {
    override fun getNomeGenero(): String {
        return this.nome
    }

    override fun setNomeGenero(nome: String) {
        this.nome = nome
    }

}

class Achocolatado(nome: String = "Achocolatado") : Genero(nome) {
    override fun getNomeGenero(): String {
        return this.nome
    }

    override fun setNomeGenero(nome: String) {
        this.nome = nome
    }
}
