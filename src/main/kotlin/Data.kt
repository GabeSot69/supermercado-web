import java.util.Calendar

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {
    fun setData(dia: Int, mes: Int, ano: Int) {
        this.dia = dia
        this.mes = mes
        this.ano = ano
    }

    fun antes(outraData: Data): Boolean {
        if (this.ano < outraData.ano) return true
        if (this.ano == outraData.ano && this.mes < outraData.mes) return true
        return this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia
    }

    fun depois(outraData: Data): Boolean {
        if (this.ano > outraData.ano) return true
        if (this.ano == outraData.ano && this.mes > outraData.mes) return true
        return this.ano == outraData.ano && this.mes == outraData.mes && this.dia > outraData.dia
    }

    fun igual(outraData: Data): Boolean {
        return dia == outraData.dia && mes == outraData.mes && ano == outraData.ano
    }

    override fun toString(): String {
        return String.format("%02d/%02d/%04d", dia, mes, ano)
    }

    companion object {
        fun dataHoje(): Data {
            val cal = Calendar.getInstance()
            return Data(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR))
        }
    }

    fun getDia(): Int{
        return this.dia
    }

    fun getMes(): Int{
        return this.mes
    }

    fun getAno(): Int{
        return this.ano
    }

}