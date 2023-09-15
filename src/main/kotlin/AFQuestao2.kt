import java.text.SimpleDateFormat
import java.util.*

class AFQuestao2 {
    companion object {
        fun main() {

            val scanner  = Scanner(System.`in`)
            val supermercadoSPW = SupermercadoWeb()
            val estoque = supermercadoSPW.getEstoque()
            val itensEstoque = estoque.getItens()
            val data: String
            var totalItens = 0
            val lista = mutableListOf<String>()

            print("Informe uma data de validade: ")
            data = scanner.nextLine()
            var listaData = data.split("/").map { it.toInt() }
            var dia = listaData[0]
            var mes = listaData[1]
            var ano = listaData[2]
            var dataComparar: Data = Data(dia, mes, ano)

            for (item in itensEstoque){
                var listaData = item.getValidade().toString().split("/").map { it.toInt() }
                var dia = listaData[0]
                var mes = listaData[1]
                var ano = listaData[2]
                var dataFormatada: Data = Data(dia, mes, ano)

                if (dataFormatada.antes(dataComparar)){
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
                    lista.add(linha)
                }
            }

            println("###### ESTOQUE ######")
            println("CÓD NOME             GENERO        MARCA       PREÇO   VALIDADE   VÁLIDO?")
            println("--- ------------- ------------- --------- ------- ---------- -------")

            for(item in lista){
                println(item)
            }
            println("Total de itens: $totalItens")
        }
    }
}

fun main(){
    AFQuestao2.main()
}