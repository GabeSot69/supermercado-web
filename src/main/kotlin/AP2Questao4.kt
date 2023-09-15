class AP2Questao4 {
    companion object {
        fun main(){
            
            val supermercadoWeb = SupermercadoWeb()
            val estoque = supermercadoWeb.getEstoque()

            val itens = estoque.getItens()
            val quantidadeItens = itens.size
            println("Quantidade de itens no estoque: $quantidadeItens")

            val itensValidos = itens.filter { it.valido() }
            val quantidadeItensValidos = itensValidos.size
            println("Quantidade de itens válidos: $quantidadeItensValidos")

            val itensVencidos = itens.filter { !it.valido() }
            val quantidadeItensVencidos = itensVencidos.size
            println("Quantidade de itens vencidos: $quantidadeItensVencidos")

            val soma = quantidadeItensValidos + quantidadeItensVencidos
            println("A soma de itens validos e vencidos: $soma")

            val somaEIgualAoTotal = soma == quantidadeItens
            val mensagem = if (somaEIgualAoTotal) {
                "A soma é igual ao total de itens"
            } else {
                "A soma não é igual ao total de itens"
            }

            println(mensagem)

        }

    }
}

fun main(){
    AP2Questao4.main()
}