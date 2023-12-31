package cadastros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.PageObject;

public class CadastroLeilaoPage extends PageObject {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
   // private static final String URL_LEILOES = "http://localhost:8080/leiloes";


    public CadastroLeilaoPage(WebDriver driver) {
        super(driver);
    }

    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.driver.findElement(By.id("nome")).sendKeys(nome);
        this.driver.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.driver.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.driver.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(driver);
    }

    public boolean isPaginaAtual() {
        return driver.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }

    public boolean isPaginaDeValidacaoVisiveis() {
        String pageSource = driver.getPageSource();
        return pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("não deve estar em branco")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
