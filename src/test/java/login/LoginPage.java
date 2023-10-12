package login;

import cadastros.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import util.PageObject;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        driver.navigate().to(URL_LOGIN);
    }

    public void preencheFormularioDeLogin(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage efetuaLogin() {
        driver.findElement(By.id("login-form")).submit();
        return new LeiloesPage(driver);
    }

    public boolean isPaginaDeLogin() {
        return driver.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean isPaginaDeLoginComDadosInvalidos() {
        return driver.getCurrentUrl().equals(URL_LOGIN + "?error");
    }

    public Object getNomeUsuarioLogado() {
        try {
            return driver.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.driver.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }
}
