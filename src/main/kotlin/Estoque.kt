class Estoque {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun entraItem(item: ItemProduto) {
        itens.add(item)
    }

    fun saiItem(item: ItemProduto): ItemProduto? {
        if (itens.contains(item)) {
            itens.remove(item)
            return item
        }
        return null
    }

    fun getItens(): List<ItemProduto> {
        return itens
    }

    fun getItens(marca: Marca): List<ItemProduto> {
        return itens.filter { it.getProduto().getMarca() == marca }
    }

    fun getItens(produto: Produto): List<ItemProduto> {
        return itens.filter { it.getProduto() == produto }
    }

    fun getItens(genero: Genero): List<ItemProduto> {
        return itens.filter { it.getProduto().getGenero() == genero }
    }

    fun qtdItens(): Long {
        return itens.size.toLong()
    }
}