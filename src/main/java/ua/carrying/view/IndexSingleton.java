package ua.carrying.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexSingleton {

    private String htmlPath;
    private String page;
    private String body;
    private String menu;
    private String login;
    private String register;
    private String orderIndex;
    private String orderForm;

    private static IndexSingleton ourInstance = new IndexSingleton();

    public static IndexSingleton getInstance() {
        return ourInstance;
    }

    private IndexSingleton() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = getPartialHtml(page);
    }

    public String getBody() {
        return body;
    }

    public String getMenu() {
        return menu;
    }

    public String getLogin() {
        return login;
    }

    public String getRegister() {
        return register;
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public String getOrderForm() {
        return orderForm;
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public void setHtmlPath(String htmlPath) {

        this.htmlPath = htmlPath;
        this.page = getPartialHtml("index.html");
        this.menu = getPartialHtml("menu.html");
        this.login = getPartialHtml("login.html");
        this.register = getPartialHtml("register.html");
        this.body = getPartialHtml("body.html");
        this.orderIndex = getPartialHtml("order-index.html");
        this.orderForm = getPartialHtml("order-form.html");
    }

    private String getPartialHtml(String filename){
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.htmlPath + filename);
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return strb.toString();
    }
}
