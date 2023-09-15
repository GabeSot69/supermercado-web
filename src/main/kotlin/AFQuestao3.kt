class AFQuestao3 {
    companion object {
        fun main() {
            val supermercadoSPW = SupermercadoWeb()
            val estoque = supermercadoSPW.getEstoque()
            var leiteBarato: Produto? = null
            var achocolatadoBarato: Produto? = null
            var presuntoBarato: Produto? = null

            for (item in estoque.getItens(Leite())) {
                val produto = item.getProduto()
                if (leiteBarato == null || produto.getPreco() < leiteBarato.getPreco()) {
                    leiteBarato = produto
                }
            }

            for (item in estoque.getItens(Presunto())) {
                val produto = item.getProduto()
                if (presuntoBarato == null || produto.getPreco() < presuntoBarato.getPreco()) {
                    presuntoBarato = produto
                }
            }

            for (item in estoque.getItens(Achocolatado())) {
                val produto = item.getProduto()
                if (achocolatadoBarato == null || produto.getPreco() < achocolatadoBarato.getPreco()) {
                    achocolatadoBarato = produto
                }
            }

            println("Leite: ")
            if (leiteBarato != null) {
                println("O leite mais barato é: ${leiteBarato.getNome()} de ${String.format("R\$%.2f", leiteBarato.getPreco())}")
            } else {
                println("Não há leite no estoque!")
            }

            println("Achocolatado: ")
            if (achocolatadoBarato != null) {
                println("O achocolatado mais barato é: ${achocolatadoBarato.getNome()} de ${String.format("R\$%.2f", achocolatadoBarato.getPreco())}")
            } else {
                println("Não há achocolatado no estoque!")
            }

            println("Presunto: ")
            if (presuntoBarato != null) {
                println("O presunto mais barato é: ${presuntoBarato.getNome()} de ${String.format("R\$%.2f", presuntoBarato.getPreco())}")
            } else {
                println("Não há presunto no estoque!")
            }

        }
    }
}

fun main(){
    AFQuestao3.main()
}