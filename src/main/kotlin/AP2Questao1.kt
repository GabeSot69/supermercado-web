class AP2Questao1 {
    companion object {
        fun main(args: Array<String>) {
            val supermercadoSPW = SupermercadoWeb()
            val estoque = supermercadoSPW.getEstoque()
            val itensEstoque = estoque.getItens()

            println("###### ESTOQUE ######")
            println("CÓD   NOME               GENERO           MARCA        PREÇO          VALIDADE      VÁLIDO?")
            println("--- * ---------------- * -------------- * ---------- * ------------ * ----------- * -------- * ---")

            for (item in itensEstoque) {
                val codigo = item.getCodigo()
                val produto = item.getProduto()
                val nome = produto.getNome()
                val marca = produto.getMarca().getNome()
                val genero = produto.getGenero().getNomeGenero()
                val preco = String.format("R\$%.2f", produto.getPreco())
                val dataValidade = item.getValidade().toString()
                val valido = if (item.valido()) "sim" else "não"

                val linha = String.format(
                    "%3d   %-18s %-16s %-9s %15s %12s %7s",
                    codigo,
                    nome,
                    genero,
                    marca,
                    preco,
                    dataValidade,
                    valido
                )
                println(linha)
            }

            val totalItens = estoque.qtdItens()
            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main(args: Array<String>) {
    AP2Questao1.main(args)
}
