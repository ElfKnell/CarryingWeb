package ua.carrying.view;


public class MainView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###login###-->", indexSingleton.getLogin())
                .replace("<!--###body###-->", indexSingleton.getBody());
    }
}
