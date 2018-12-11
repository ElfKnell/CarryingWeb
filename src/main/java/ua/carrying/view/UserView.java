package ua.carrying.view;

public class UserView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###login###-->", indexSingleton.getRegister());
    }
}
