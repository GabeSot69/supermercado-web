import kotlin.random.Random

class AFQuestao5 {
    fun main() {
        val supermercado = SupermercadoWeb()
        // 1. Mostrar o estoque e o carrinho vazio
        println("Estoque inicial:")
        mostrarEstoque(supermercado.getEstoque())
        println("Carrinho vazio:")
        mostrarCarrinho(supermercado.getCarrinho())

        // 2. Preencher o carrinho com dez itens aleatórios do estoque e mostrar o estoque e o carrinho
        preencherCarrinhoAleatoriamente(supermercado)
        println("\nEstoque após preencher o carrinho:")
        mostrarEstoque(supermercado.getEstoque())
        println("Carrinho após preencher com itens:")
        mostrarCarrinho(supermercado.getCarrinho())

        // 3. Colocar todos os itens do carrinho de volta no estoque e mostrar o estoque e o carrinho
        devolverItensAoEstoque(supermercado)
        println("\nEstoque após devolver itens do carrinho:")
        mostrarEstoque(supermercado.getEstoque())
        println("Carrinho após devolver itens ao estoque:")
        mostrarCarrinho(supermercado.getCarrinho())
    }

    private fun preencherCarrinhoAleatoriamente(supermercado: SupermercadoWeb) {
        val estoque = supermercado.getEstoque()
        val carrinho = supermercado.getCarrinho()
        val itensEstoque = estoque.getItens().toMutableList()
        repeat(10) {
            if (itensEstoque.isNotEmpty()) {
                val randomIndex = Random.nextInt(itensEstoque.size)
                val itemAleatorio = itensEstoque[randomIndex]
                carrinho.adicionaItem(itemAleatorio, estoque)
                itensEstoque.removeAt(randomIndex)
            }
        }
    }

    private fun devolverItensAoEstoque(supermercado: SupermercadoWeb) {
        val estoque = supermercado.getEstoque()
        val carrinho = supermercado.getCarrinho()
        val itensCarrinho = carrinho.getItens().toMutableList()

        for (item in itensCarrinho) {
            carrinho.removeItem(item, estoque)
        }
    }

    private fun mostrarEstoque(estoque: Estoque) {
        val itens = estoque.getItens()
        println("Total de itens no estoque: ${itens.size}")

        for (item in itens) {
            println("Código: ${item.getCodigo()}, Produto: ${item.getProduto().getNome()}, Preço: R\$ ${item.getProduto().getPreco()}, Data de Validade: ${item.getValidade()}")
        }
    }

    private fun mostrarCarrinho(carrinho: Carrinho) {
        val itens = carrinho.getItens()
        println("Total de itens no carrinho: ${itens.size}")
        for (item in itens) {
            println("Código: ${item.getCodigo()}, Produto: ${item.getProduto().getNome()}, Preço: R\$ ${item.getProduto().getPreco()}, Data de Validade: ${item.getValidade()}")
        }
    }
}

fun main() {
    val programa = AFQuestao5()
    programa.main()
}

