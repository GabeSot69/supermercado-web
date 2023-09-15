class AFQuestao6 {
    fun main() {
        val supermercado = SupermercadoWeb()

        // 1. Preencher o carrinhoA com todos os itens válidos do estoque
        preencherCarrinhoComItensValidos(supermercado.getCarrinhoA(), supermercado.getEstoque())

        // 2. Preencher o carrinhoB com todos os itens inválidos do estoque
        preencherCarrinhoComItensInvalidos(supermercado.getCarrinhoB(), supermercado.getEstoque())

        // 3. Mostrar o estoque e os dois carrinhos
        println("Estoque:")
        mostrarEstoque(supermercado.getEstoque())
        println("\nCarrinho A:")
        mostrarCarrinho(supermercado.getCarrinhoA())
        println("\nCarrinho B:")
        mostrarCarrinho(supermercado.getCarrinhoB())
    }

    private fun preencherCarrinhoComItensValidos(carrinho: Carrinho, estoque: Estoque) {
        val itensEstoque = estoque.getItens().toMutableList()
        for (item in itensEstoque) {
            if (item.valido()) {
                carrinho.adicionaItem(item, estoque)
            }
        }
    }

    private fun preencherCarrinhoComItensInvalidos(carrinho: Carrinho, estoque: Estoque) {
        val itensEstoque = estoque.getItens().toMutableList()
        for (item in itensEstoque) {
            if (!item.valido()) {
                carrinho.adicionaItem(item, estoque)
            }
        }
    }

    private fun mostrarEstoque(estoque: Estoque) {
        val itens = estoque.getItens()
        println("Total de itens no estoque: ${itens.size}")
        for (item in itens) {
            println(
                "Código: ${item.getCodigo()}, " +
                        "Produto: ${item.getProduto().getNome()}, " +
                        "Preço: R\$ ${String.format("R\$%.2f", item.getProduto().getPreco())}, " +
                        "Data de Validade: ${item.getValidade()}"
            )
        }
    }

    private fun mostrarCarrinho(carrinho: Carrinho) {
        val itens = carrinho.getItens()
        println("Total de itens no carrinho: ${itens.size}")
        for (item in itens) {
            println(
                "Código: ${item.getCodigo()}, " +
                        "Produto: ${item.getProduto().getNome()}, " +
                        "Preço: R\$ ${String.format("R\$%.2f", item.getProduto().getPreco())}, " +
                        "Data de Validade: ${item.getValidade()}"
            )
        }
    }
}

fun main() {
    val programa = AFQuestao6()
    programa.main()
}

