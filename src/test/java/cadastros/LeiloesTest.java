package cadastros;

import login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage leiloesPage;
    private CadastroLeilaoPage cadastroLeilaoPage;

    @BeforeEach
    public void beforeEach(){
        LoginPage loginPage = new LoginPage();
        loginPage.preencheFormularioDeLogin("fulano", "pass");
        this.leiloesPage = loginPage.efetuaLogin();
        this.cadastroLeilaoPage = leiloesPage.carregaFormulario();
    }

    @AfterEach
    public void afterEach() {
        this.leiloesPage.fechar();
    }

    @Test
    public void cadastraLeiloes() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje;
        String valor = "500.00";

        this.leiloesPage = cadastroLeilaoPage.cadastrarLeilao(nome, valor, hoje);
        Assert.assertTrue(leiloesPage.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void validarCadastroDeLeilao(){
        this.leiloesPage = cadastroLeilaoPage.cadastrarLeilao("", "", "");
        Assert.assertFalse(this.cadastroLeilaoPage.isPaginaAtual());
        Assert.assertTrue(this.leiloesPage.isPaginaAtual());
        Assert.assertTrue(this.cadastroLeilaoPage.isPaginaDeValidacaoVisiveis());

    }


}

