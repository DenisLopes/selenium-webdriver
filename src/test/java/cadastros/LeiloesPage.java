package cadastros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.PageObject;

public class LeiloesPage extends PageObject {

    private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
    private static final String URL_LEILOES = "http://localhost:8080/leiloes";

    public LeiloesPage(WebDriver driver) {
        super(driver);
    }

    public CadastroLeilaoPage carregaFormulario() {
        this.driver.navigate().to(URL_CADASTRO_LEILOES);
        return new CadastroLeilaoPage(driver);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement linhaDaTabela = this.driver.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome)
                && colunaDataAbertura.getText().equals(data)
                && colunaValorInicial.getText().equals(valor);
    }
    public boolean isPaginaAtual() {
        return driver.getCurrentUrl().equals(URL_LEILOES);
    }
}
