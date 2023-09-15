import java.util.Scanner

class AP2Questao7 {
    companion object {
        fun main(args: Array<String>) {

            val spw = SupermercadoWeb()

            val estoque = spw.getEstoque()

            val scanner = Scanner(System.`in`)

            print("Digite o nome da marca: ")
            val nomeMarca = scanner.nextLine()

            val itensEncontrados = estoque.getItens(Marca(nomeMarca)).filter { it.valido() }

            println("%-20s %-20s %-10s".format("Nome do Produto", "Marca", "Preço"))

            for (item in itensEncontrados) {
                val produto = item.getProduto()
                println("%-20s %-20s R$%.2f".format(produto.getNome(), produto.getMarca().getNome(), produto.getPreco()))
            }

            println("\nQuantidade de Itens Encontrados: ${itensEncontrados.size}")
        }
    }
}

fun main(args: Array<String>) {
    AP2Questao7.main(args)
}