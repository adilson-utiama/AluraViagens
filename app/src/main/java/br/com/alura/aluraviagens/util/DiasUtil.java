package br.com.alura.aluraviagens.util;

import android.support.annotation.NonNull;

import br.com.alura.aluraviagens.model.Pacote;

/**
 * Created by Adilson on 19/03/2018.
 */

public class DiasUtil {

    public static final String SINGULAR = " dia";
    public static final String PLURAL = " dias";

    @NonNull
    public static String formataEmTexto(int quantidadeDeDias) {
        if(quantidadeDeDias > 1) {
            return quantidadeDeDias + PLURAL;
        }
        return quantidadeDeDias + SINGULAR;

    }
}
