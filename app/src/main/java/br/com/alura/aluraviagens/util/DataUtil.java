package br.com.alura.aluraviagens.util;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Adilson on 21/03/2018.
 */

public class DataUtil {

    public static final String DIA_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar datavolta = Calendar.getInstance();
        datavolta.add(Calendar.DATE, dias);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DIA_MES);
        String dataFormatadaIda = dateFormat.format(dataIda.getTime());
        String dataFormatadaVolta = dateFormat.format(datavolta.getTime());
        return dataFormatadaIda
                + " - " + dataFormatadaVolta + " de "
                + datavolta.get(Calendar.YEAR);
    }
}
