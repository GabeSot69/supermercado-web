class AFQuestao4 {
    fun main() {
        val supermercado = SupermercadoWeb()
        // 1. Calcular o lucro com a venda de todos os itens do estoque
        val estoqueInicial = supermercado.getEstoque()
        val lucroTotal = calcularLucro(estoqueInicial)
        println("Estoque com todos os itens:")
        mostrarEstoque(estoqueInicial)
        println("Lucro com a venda de todos os itens: R\$ ${String.format("R\$%.2f", lucroTotal)}")

        // 2. Retirar os itens vencidos do estoque e calcular o prejuízo
        val prejuizo = retirarItensVencidos(estoqueInicial)
        println("\nEstoque sem os itens vencidos:")
        mostrarEstoque(estoqueInicial)
        println("Prejuízo com a retirada dos itens vencidos: R\$ ${String.format("R\$%.2f", prejuizo)}")

        // 3. Calcular o lucro real considerando o prejuízo
        val lucroReal = lucroTotal - prejuizo
        println("\nLucro real considerando o prejuízo: R\$ ${String.format("R\$%.2f", lucroReal)}")
    }

    private fun calcularLucro(estoque: Estoque): Double {
        val itens = estoque.getItens()
        val lucroTotal = itens.sumOf { it.getProduto().getPreco() }
        return lucroTotal
    }

    private fun retirarItensVencidos(estoque: Estoque): Double {
        val itens = estoque.getItens()
        var prejuizo = 0.0
        val itensVencidos = mutableListOf<ItemProduto>()

        for (item in itens) {
            if (!item.valido()) {
                prejuizo += item.getProduto().getPreco()
                itensVencidos.add(item)
            }
        }

        for (item in itensVencidos) {
            estoque.saiItem(item)
        }

        return prejuizo
    }

    private fun mostrarEstoque(estoque: Estoque) {
        val itens = estoque.getItens()
        println("Total de itens no estoque: ${itens.size}")
        for (item in itens) {
            println(
                "Código: ${item.getCodigo()}, Produto: ${item.getProduto().getNome()}, " +
                        "Preço: R\$ ${String.format("R\$%.2f", item.getProduto().getPreco())}, " +
                        "Data de Validade: ${item.getValidade()}"
            )
        }
    }
}

fun main() {
    val programa = AFQuestao4()
    programa.main()
}