import kotlin.random.Random

class SupermercadoWeb {
    private lateinit var estoque: Estoque
    private lateinit var carrinho: Carrinho
    private lateinit var carrinhoA: Carrinho
    private lateinit var carrinhoB: Carrinho
    private lateinit var generos: List<Genero>
    private lateinit var marcas: List<Marca>
    private lateinit var produtos: List<Produto>

    init {
        iniciaSupermercado()
    }

    private fun iniciaSupermercado(){
        this.estoque = Estoque()
        this.carrinho = Carrinho()
        this.carrinhoA = Carrinho()
        this.carrinhoB = Carrinho()
        this.generos = listOf(
            Leite(),
            Achocolatado(),
            Presunto()
        )
        this.marcas = listOf(
            Marca("Fazenda"),
            Marca("Itambé"),
            Marca("Nestlé"),
            Marca("3Corações"),
            Marca("ABF"),
            Marca("Sadia"),
            Marca("Perdigão"),
            Marca("Seara")
        )
        this.produtos = criarProdutos()
        criarItensEstoque()
    }

    private fun criarProdutos(): List<Produto>{
        val produtos: MutableList<Produto> = mutableListOf()
        val precoMinimo = 5.0
        val precoMaximo = 60.0

        val marcasLeite = this.marcas.subList(0, 3)
        val produtosLeite = listOf("Tio Joca", "Leite em Pó", "Ninho")

        val marcasAchocolatado = this.marcas.subList(2, 5)
        val produtosAchocolatado = listOf("Nescau", "Chocolate em pó", "Ovomaltine")

        val marcasPresunto = this.marcas.subList(5, 8)
        val produtosPresunto = listOf("Salsichon", "Presunto Defumado", "Presunto Gourmet")

        val totalMarcas = listOf(marcasLeite, marcasAchocolatado, marcasPresunto)
        val totalProdutos = listOf(produtosLeite, produtosAchocolatado, produtosPresunto)
        var codigo = 1

        // Itera por todas as marcas de cada genero criando um produto pra cada marca de forma alternada
        // Por exemplo: o primeiro produto do gênero Leite é da marca Fazenda, o segundo é da marca Itambé etc.
        for ((indiceGenero, genero) in this.generos.withIndex()) {
            val marcasGenero = totalMarcas[indiceGenero]
            val produtosGenero = totalProdutos[indiceGenero]
            for ((indiceMarca, marca) in marcasGenero.withIndex()) {
                produtos.add(
                    Produto(
                        codigo,
                        produtosGenero[indiceMarca],
                        Random.nextDouble(precoMinimo, precoMaximo),
                        marca,
                        genero
                    )
                )
                codigo += 1
            }
        }

        return produtos
    }

    private fun criarItensEstoque() {
        val produtosLeite = this.produtos.filter { it.getGenero() is Leite }
        val produtosAchocolatado = this.produtos.filter { it.getGenero() is Achocolatado }
        val produtosPresunto = this.produtos.filter { it.getGenero() is Presunto }

        // Pra cada gênero 10 itens são criados alternando o produto a cada iteração
        // Por exemplo: O primeiro item do Gênero Leite é do produto Tio Joca, o segundo é do produto Leite em Pó etc.
        for (produtos in listOf(produtosLeite, produtosAchocolatado, produtosPresunto)) {
            var indiceProduto = 0
            for (vezes in 1..10) {
                val dataValidade = Data(
                    dia = Random.nextInt(1, 31),
                    mes = Random.nextInt(1, 13),
                    ano = Random.nextInt(2023, 2025)
                )
                val codigoBarras = this.estoque.qtdItens() + 1
                val item = ItemProduto(codigoBarras, dataValidade, produtos[indiceProduto])
                this.estoque.entraItem(item)
                if (indiceProduto < produtos.size - 1) {
                    indiceProduto += 1
                } else{
                    indiceProduto = 0
                }
            }
        }
    }

    fun getEstoque(): Estoque {
        return estoque
    }

    fun getCarrinho(): Carrinho {
        return carrinho
    }

    fun getCarrinhoA(): Carrinho {
        return carrinho
    }

    fun getCarrinhoB(): Carrinho {
        return carrinho
    }
}