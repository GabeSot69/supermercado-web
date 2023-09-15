class AP2Questao2 {
    companion object {
        fun main(args: Array<String>) {
            val supermercadoSPW = SupermercadoWeb()
            val estoque = supermercadoSPW.getEstoque()
            val itensEstoque = estoque.getItens()

            val generoMap = mutableMapOf<String, MutableList<ItemProduto>>()

            for (item in itensEstoque) {
                val produto = item.getProduto()
                val genero = produto.getGenero().getNomeGenero()

                val generoItens = generoMap.getOrPut(genero) { mutableListOf() }
                generoItens.add(item)
            }

            println("###### ESTOQUE POR GÊNERO ######")
            println("CÓD   NOME               GENERO           MARCA        PREÇO          VALIDADE      VÁLIDO?")
            println("--- * ---------------- * -------------- * ---------- * ------------ * ----------- * -------- * ---")

            for ((genero, generoItens) in generoMap) {
                for (item in generoItens) {
                    println(
                        "%3d   %-18s %-16s %-9s %15s %12s %7s".format(
                            item.getCodigo(),
                            item.getProduto().getNome(),
                            genero,
                            item.getProduto().getMarca().getNome(),
                            String.format("R\$%.2f", item.getProduto().getPreco()),
                            item.getValidade(),
                            if (item.valido()) "sim" else "não"
                        )
                    )
                }
                println("TOTAL $genero: ${generoItens.size} itens.")
            }

            val totalItens = estoque.qtdItens()
            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main(args: Array<String>) {
    AP2Questao2.main(args)
}
