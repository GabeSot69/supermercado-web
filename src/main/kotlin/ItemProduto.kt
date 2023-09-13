class ItemProduto(
    private val codigo: Long,
    private val validade: Data,
    private val produto: Produto
) {
    fun valido(): Boolean {
        val dataAtual = Data.dataHoje()
        return this.validade.depois(dataAtual)
    }

    fun getProduto(): Produto{
        return this.produto
    }

    fun getValidade(): Data {
        return validade
    }

    fun getCodigo(): Long{
        return this.codigo
    }
}