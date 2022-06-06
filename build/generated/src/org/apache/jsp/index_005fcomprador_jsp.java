package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fcomprador_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Uniajc CV</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilos/Style.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilos/footer.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\"/>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light \">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Uniajc CV</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp\">Inicio <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Sesion.jsp\">Registrarse </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Productos.jsp\">Productos </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                    <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Buscar\" aria-label=\"Search\"></input>\n");
      out.write("                    <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"card\" style=\"width: 40rem; margin-left:25%;margin-bottom:5%;margin-top: 5px\">\n");
      out.write("            <img src=\"https://encolombia.com/wp-content/uploads/2018/05/Claves-Aumentar-Ventas.png\" class=\"card-img-top\" alt=\"...\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <h5 class=\"card-title\">Productos Publicados.</h5>\n");
      out.write("                <p class=\"card-text\">Aqui podras consultar todo lo relacionado con tus productos publicados.</p>\n");
      out.write("                <!-- <a href=\"estadistica.php\" class=\"btn btn-primary\">Ver</a>-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table class=\"table\" >\n");
      out.write("            <thead class=\"thead-dark\" style=\"margin-bottom: 10px\">\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">ID</th>\n");
      out.write("                    <th scope=\"col\">Producto</th>\n");
      out.write("                    <th scope=\"col\"># Stock</th>\n");
      out.write("                    <th scope=\"col\">Administrar</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"row\">1</th>\n");
      out.write("                    <td>Mark</td>\n");
      out.write("                    <td>Otto</td>\n");
      out.write("                    <td>@mdo</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"row\">2</th>\n");
      out.write("                    <td>Jacob</td>\n");
      out.write("                    <td>Thornton</td>\n");
      out.write("                    <td>@fat</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"row\">3</th>\n");
      out.write("                    <td>Larry</td>\n");
      out.write("                    <td>the Bird</td>\n");
      out.write("                    <td>@twitter</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer class=\"site-footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12 col-md-6\">\n");
      out.write("                        <h6>About</h6>\n");
      out.write("                        <p class=\"text-justify\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In nec mattis est. Cras tellus nibh, consectetur sed volutpat quis, cursus at sem. Aliquam sollicitudin condimentum odio, in tristique libero volutpat sit amet. Cras ultricies tincidunt tortor eget vehicula. Quisque quis velit turpis. Curabitur porttitor, urna gravida vehicula efficitur, metus neque</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-xs-6 col-md-3\">\n");
      out.write("                        <h6>Categorias</h6>\n");
      out.write("                        <ul class=\"footer-links\">\n");
      out.write("                            <li><a href=\"celulares.xhtml\">Celulares</a></li>\n");
      out.write("                            <li><a href=\"celulares.xhtml\">Accesorios</a></li>\n");
      out.write("                            <li><a href=\"#\">Computadores</a></li>\n");
      out.write("                            <li><a href=\"#\">Componentes PC</a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-xs-6 col-md-3\">\n");
      out.write("                        <h6>Quick Links</h6>\n");
      out.write("                        <ul class=\"footer-links\">\n");
      out.write("                            <li><a href=\"http://scanfcode.com/about/\">Acerca De</a></li>\n");
      out.write("                            <li><a href=\"http://scanfcode.com/contact/\">Coontactos</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <hr></hr>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
