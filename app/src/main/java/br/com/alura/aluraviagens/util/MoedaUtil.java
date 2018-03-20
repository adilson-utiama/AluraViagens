package br.com.alura.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.model.Pacote;

/**
 * Created by Adilson on 19/03/2018.
 */

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_DESEJADO = "R$ ";

    public static String formataParaMoedaBrasileira(BigDecimal valor) {
        NumberFormat formatadorMoeda = DecimalFormat
                .getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatadorMoeda.format(valor).replace(FORMATO_PADRAO, FORMATO_DESEJADO);
    }
}
