class AP2Questao5 {
    companion object {
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            val estoque = spw.getEstoque()
            val carrinho = spw.getCarrinho()

            val itensImpares = mutableListOf<ItemProduto>()

            for (item in estoque.getItens()) {
                if (item.getCodigo() % 2 != 0L) {
                    itensImpares.add(item)
                }
            }

            println("%-20s %-20s %-10s %-10s".format("Produto", "Marca", "Preço", "Quantidade"))

            for (item in itensImpares) {
                carrinho.adicionaItem(item, estoque)
                val produto = item.getProduto()
                val precoFormatado = String.format("%.2f", produto.getPreco())
                println("%-20s %-20s %-10s %d".format(produto.getNome(), produto.getMarca().getNome(), "R$$precoFormatado", 1))
            }

            val totalAPagar = String.format("%.2f", carrinho.totalAPagar())
            println("\nTotal a pagar: R$$totalAPagar")

            val itensRestantes = estoque.getItens()
            println("\nItens restantes no estoque:")
            for (item in itensRestantes) {
                val produto = item.getProduto()
                val precoFormatado = String.format("%.2f", produto.getPreco())
                println("%-20s %-20s %-10s %d".format(produto.getNome(), produto.getMarca().getNome(), "R$$precoFormatado", 1))
            }
            println("Total de itens no estoque: ${itensRestantes.size}")
        }
    }
}

fun main(args: Array<String>) {
    AP2Questao5.main(args)
}
