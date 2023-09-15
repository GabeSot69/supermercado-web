class AP2Questao6 {
    companion object {
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            val estoque = spw.getEstoque()
            val carrinho = spw.getCarrinho()

            val itensValidos = mutableListOf<ItemProduto>()
            for (item in estoque.getItens()) {
                if (item.valido()) {
                    itensValidos.add(item)
                }
            }

            val random = java.util.Random()
            val quantidadeItensNoCarrinho = random.nextInt(1, itensValidos.size+1)
            val itensSelecionados = mutableListOf<ItemProduto>()

            for (i in 1..quantidadeItensNoCarrinho) {
                if (itensValidos.isNotEmpty()) {
                    val indiceAleatorio = random.nextInt(itensValidos.size)
                    val itemSelecionado = itensValidos[indiceAleatorio]
                    carrinho.adicionaItem(itemSelecionado, estoque)
                    itensSelecionados.add(itemSelecionado)
                    itensValidos.removeAt(indiceAleatorio)
                }
            }

            println("%-20s %-20s %-10s".format("Produto", "Marca", "Preço"))

            val itensCarrinho = carrinho.getItens()
            for (item in itensCarrinho) {
                val produto = item.getProduto()
                println("%-20s %-20s R$%.2f".format(produto.getNome(), produto.getMarca().getNome(), produto.getPreco()))
            }
            println("\nQuantidade de Itens no Carrinho: ${itensCarrinho.size}")

            val itensRestantes = estoque.getItens()
            println("\nItens Restantes no Estoque:")
            for (item in itensRestantes) {
                val produto = item.getProduto()
                println("%-20s %-20s R$%.2f".format(produto.getNome(), produto.getMarca().getNome(), produto.getPreco()))
            }
            println("Total de Itens no Estoque: ${itensRestantes.size}")
        }
    }
}

fun main(args: Array<String>) {
    AP2Questao6.main(args)
}