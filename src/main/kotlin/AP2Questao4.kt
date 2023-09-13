class AP2Questao4 {
    companion object {
        fun main(){
            val supermercadoWeb = SupermercadoWeb()
            val estoque = supermercadoWeb.getEstoque()

            val itens = estoque.getItens()
            val quantidadeItens = itens.size
            println("Quantidade de itens em estoque: $quantidadeItens")

            // (1) Contar quantos itens válidos (não vencidos) há no estoque
            val itensValidos = itens.filter { it.valido() }
            val quantidadeItensValidos = itensValidos.size
            println("Quantidade de itens em estoque validos: $quantidadeItensValidos")

            // (2) Contar quantos itens vencidos há no estoque;
            val itensVencidos = itens.filter { !it.valido() }
            val quantidadeItensVencidos = itensVencidos.size
            println("Quantidade de itens em estoque vencidos: $quantidadeItensVencidos")

            // (3) Somar os dois valores e verificar se o resultado é igual ao total de itens no estoque.
            val soma = quantidadeItensValidos + quantidadeItensVencidos
            println("A soma de itens validos e vencidos: $soma")

            val somaEIgualAoTotal = soma == quantidadeItens
            println("A soma de itens validos e vencidos ${if (somaEIgualAoTotal) "é igual" else "não é igual"}" +
                    " ao total de itens em estoque")

        }

    }
}

fun main(){
    AP2Questao4.main()
}