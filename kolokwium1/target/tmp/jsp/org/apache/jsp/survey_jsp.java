package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class survey_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Survey</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h1>Please take a minute to complete a survey about our Bed Store</h1>\n");
      out.write("<form action=\"sign-survey\">\n");
      out.write("    <label for=\"user_name\">User Name:</label>\n");
      out.write("    <input type=\"text\" name=\"user_name\" id=\"user_name\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sess_news.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("\n");
      out.write("    <label for=\"date_from\">Date from:</label>\n");
      out.write("    <input type=\"text\" name=\"date_from\" id=\"date_from\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sess_news.from}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("\n");
      out.write("    <label for=\"date_to\">Date to:</label>\n");
      out.write("    <input type=\"text\" name=\"date_to\" id=\"date_to\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sess_news.to}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("\n");
      out.write("    <br><label>Frequency:</label><br>\n");
      out.write("    <input type=\"radio\" name=\"frequency\" value=\"every 10 days\">Every 10 days<br>\n");
      out.write("    <input type=\"radio\" name=\"frequency\" value=\"every 20 days\">Every 10 days<br>\n");
      out.write("    <input type=\"radio\" name=\"frequency\" value=\"every 60 days\">Every 60 days<br>\n");
      out.write("    <input type=\"radio\" name=\"frequency\" value=\"more than 60 days\">More than 60 days<br>\n");
      out.write("\n");
      out.write("    <br><label >Your comments:</label><br>\n");
      out.write("    <input type=\"checkbox\" name=\"comments\" value=\"comment1\">Not satisfying<br>\n");
      out.write("    <input type=\"checkbox\" name=\"comments\" value=\"comment2\">Satisfying<br>\n");
      out.write("    <input type=\"checkbox\" name=\"comments\" value=\"comment3\">Very satisfying<br>\n");
      out.write("    <input type=\"checkbox\" name=\"comments\" value=\"comment4\">No opinion<br><br>\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Leave your opinion!\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
