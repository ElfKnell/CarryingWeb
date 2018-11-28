package ua.carrying.view;

public class MainView {

    private String htmlTop = "<html lang=\"en\"><head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
            "<meta name=\"description\" content=\"\">\n" +
            "<meta name=\"author\" content=\"\">\n" +
            "<link rel=\"icon\" href=\"../../../../favicon.ico\">\n" +
            "\n" +
            "<title>Jumbotron Template for Bootstrap</title>\n" +
            "\n" +
            "<!-- Bootstrap core CSS -->\n" +
            "<link href=\"/css/bootstrap.css\" rel=\"stylesheet\">\n" +
            "\n" +
            "<body>";

    private String htmlBottom = "<footer class=\"container\">\n" +
            "<p>© Company 2017-2018</p>\n" +
            "</footer>\n" +
            "\n" +
            "<!-- Bootstrap core JavaScript\n" +
            "        ================================================== -->\n" +
            "<!-- Placed at the end of the document so the pages load faster -->\n" +
            "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
            "<script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery-slim.min.js\"><\\/script>')</script>\n" +
            "<script src=\"/js/popper.min.js\"></script>\n" +
            "<script src=\"/js/bootstrap.js\"></script>\n" +
            "\n" +
            "\n" +
            "</body></html>\n";

    private String menu = "<nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\n" +
            "<a class=\"navbar-brand\" href=\"#\">Navbar</a>\n" +
            "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExampleDefault\" aria-controls=\"navbarsExampleDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
            "<span class=\"navbar-toggler-icon\"></span>\n" +
            "</button>\n" +
            "\n" +
            "<div class=\"collapse navbar-collapse\" id=\"navbarsExampleDefault\">\n" +
            "<ul class=\"navbar-nav mr-auto\">\n" +
            "<li class=\"nav-item active\">\n" +
            "<a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" +
            "</li>\n" +
            "<li class=\"nav-item\">\n" +
            "<a class=\"nav-link\" href=\"#\">Link</a>\n" +
            "</li>\n" +
            "<li class=\"nav-item\">\n" +
            "<a class=\"nav-link \" href=\"#\">Disabled</a>\n" +

            "</ul>\n" +
            "<a class=\"btn btn-sm btn-outline-success\" href=\"#\">Sign up</a>" +
            "</div>\n" +
            "</nav>\n" +
            "\n" +
            "<main role=\"main\">\n" +
            "\n" +
            "<!-- Main jumbotron for a primary marketing message or call to action -->\n" +
            "<div class=\"jumbotron\">\n" +
            "<div class=\"container\">\n" +
            "<h1 class=\"display-3\">Hello, world!</h1>\n" +
            "<p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>\n" +
            "<p><a class=\"btn btn-primary btn-lg\" href=\"#\" role=\"button\">Learn more »</a></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"container\">\n" +
            "<!-- Example row of columns -->\n" +
            "<div class=\"row\">\n" +
            "<div class=\"col-md-4\">\n" +
            "<h2>Heading</h2>\n" +
            "<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>\n" +
            "<p><a class=\"btn btn-secondary\" href=\"#\" role=\"button\">View details »</a></p>\n" +
            "</div>\n" +
            "<div class=\"col-md-4\">\n" +
            "<h2>Heading</h2>\n" +
            "<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>\n" +
            "<p><a class=\"btn btn-secondary\" href=\"#\" role=\"button\">View details »</a></p>\n" +
            "</div>\n" +
            "<div class=\"col-md-4\">\n" +
            "<h2>Heading</h2>\n" +
            "<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>\n" +
            "<p><a class=\"btn btn-secondary\" href=\"#\" role=\"button\">View details »</a></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<hr>\n" +
            "\n" +
            "</div> <!-- /container -->\n" +
            "\n" +
            "</main>";

    public String getHtmlTop() {
        return htmlTop;
    }

    public void setHtmlTop(String htmlTop) {
        this.htmlTop = htmlTop;
    }

    public String getHtmlBottom() {
        return htmlBottom;
    }

    public void setHtmlBottom(String htmlBottom) {
        this.htmlBottom = htmlBottom;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPaige() {
        return this.getHtmlTop() + this.getMenu() + this.getHtmlBottom();
    }

}





