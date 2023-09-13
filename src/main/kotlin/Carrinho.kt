class Carrinho {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        val itemEstoque = estoque.saiItem(item)
        if (itemEstoque != null) {
            itens.add(itemEstoque)
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itens.contains(item)) {
            itens.remove(item)
            estoque.entraItem(item)
        }
    }

    fun totalAPagar(): Double {
        return itens.sumOf { it.getProduto().getPreco() }
    }

    fun getItens(): List<ItemProduto> {
        return itens
    }
}