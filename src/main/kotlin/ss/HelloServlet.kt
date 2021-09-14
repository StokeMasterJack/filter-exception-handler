package ss

import java.beans.IntrospectionException
import java.lang.NumberFormatException
import java.sql.SQLException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", value = ["/hello"])
class HelloServlet : HttpServlet() {


    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"

        when (request.getParameter("x")) {
           null -> {
                val out = response.writer
                out.println("<html><body>")
                out.println("<h4>OK</h4>")
                out.println("</body></html>")
            }
            "ExpiredException" -> {
                throw ExpiredException()
            }
            "NotAllowedException" -> {
                throw NotAllowedException()
            }
            "SQLException" -> {
                throw SQLException()
            }
            "InterruptedException" -> {
                throw InterruptedException()
            }
            else -> {
                throw Exception()
            }
        }

    }

    override fun destroy() {
    }
}