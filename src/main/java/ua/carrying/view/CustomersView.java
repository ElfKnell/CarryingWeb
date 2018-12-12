package ua.carrying.view;

public class CustomersView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###orderCustom###-->", indexSingleton.getOrder());
    }
}
