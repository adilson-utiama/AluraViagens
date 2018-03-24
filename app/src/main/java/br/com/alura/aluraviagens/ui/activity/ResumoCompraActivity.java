package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCAmpos(pacote);
        }
    }

    private void inicializaCAmpos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDataViagem(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacoteSaoPaulo) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaMoedaBrasileira(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDataViagem(Pacote pacoteSaoPaulo) {
        TextView dataViagem = findViewById(R.id.resumo_compra_data_viagem);
        String dataEmTexto = DataUtil.periodoEmTexto(pacoteSaoPaulo.getDias());
        dataViagem.setText(dataEmTexto);
    }

    private void mostraImagem(Pacote pacoteSaoPaulo) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacoteSaoPaulo) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacoteSaoPaulo.getLocal());
    }
}
