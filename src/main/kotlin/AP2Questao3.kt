class AP2Questao3 {
    companion object {
        fun main(args: Array<String>) {
            val supermercadoSPW = SupermercadoWeb()
            val estoque = supermercadoSPW.getEstoque()
            val itensEstoque = estoque.getItens()

            val generoMarcaMap = mutableMapOf<String, MutableMap<String, MutableList<ItemProduto>>>()

            for (item in itensEstoque) {
                if (item.valido()) {
                    val produto = item.getProduto()
                    val genero = produto.getGenero().getNomeGenero()
                    val marca = produto.getMarca().getNome()

                    val generoMap = generoMarcaMap.getOrPut(genero) { mutableMapOf() }
                    val marcaItens = generoMap.getOrPut(marca) { mutableListOf() }

                    marcaItens.add(item)
                }
            }

            println("###### ESTOQUE POR GÊNERO E NOME ######")
            println("CÓD   NOME             GENERO           MARCA        PREÇO          VALIDADE      VÁLIDO?")
            println("--- * -------------- * -------------- * ---------- * ------------ * ----------- * -------- * ---")

            for ((genero, marcaMap) in generoMarcaMap) {
                for ((marca, itens) in marcaMap) {
                    for (item in itens) {
                        println(
                            "%3d   %-16s %-16s %-9s %15s %12s %7s".format(
                                item.getCodigo(),
                                item.getProduto().getNome(),
                                genero,
                                marca,
                                String.format("R\$%.2f", item.getProduto().getPreco()),
                                item.getValidade(),
                                if (item.valido()) "sim" else "não"
                            )
                        )
                    }
                    println("TOTAL $genero - $marca: ${itens.size} itens.")
                }
            }

            val totalItens = itensEstoque.count { it.valido() }
            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main(args: Array<String>) {
    AP2Questao3.main(args)
}
