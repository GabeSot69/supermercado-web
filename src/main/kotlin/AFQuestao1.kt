import java.util.Scanner

class AFQuestao1 {
    companion object {
        fun main() {
            val scanner = Scanner(System.`in`)
            val supermercadoSPW = SupermercadoWeb()
            val estoque = supermercadoSPW.getEstoque()
            val genero: String
            var totalItens = 0

            print("Informe um gênero de produto: ")
            genero = scanner.nextLine()
            println()

           val generoEscolhido = if (genero.equals("Leite")) Leite() else if (genero.equals("Presunto")) Presunto() else Achocolatado()

            println("###### ESTOQUE ######")
            println("CÓD NOME          GENERO        MARCA       PREÇO   VALIDADE   VÁLIDO?")
            println("--- ------------- ------------- --------- ------- ---------- -------")

            for (item in estoque.getItens(generoEscolhido)) {

                val codigo = item.getCodigo()
                val produto = item.getProduto()
                val nome = produto.getNome()
                val marca = produto.getMarca().getNome()
                val genero = produto.getGenero().getNomeGenero()
                val preco = String.format("R\$%.2f", produto.getPreco())
                val dataValidade = item.getValidade().toString()
                val valido = if (item.valido()) "sim" else "não"

                val linha = String.format(
                    "%3d %-13s %-13s %-10s %7s %10s %7s",
                    codigo,
                    nome,
                    genero,
                    marca,
                    preco,
                    dataValidade,
                    valido
                )

                totalItens++
                println(linha)
            }

            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main(){
    AFQuestao1.main()
}
