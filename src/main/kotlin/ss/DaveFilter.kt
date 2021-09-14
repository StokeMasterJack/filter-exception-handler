package ss

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletResponse


@WebFilter("/*")
class DaveFilter : Filter {

    override fun init(config: FilterConfig) {}

    override fun destroy() {}

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        response as HttpServletResponse
        try {
            chain.doFilter(request, response)
        } catch (e: ExpiredException) {
            response.sendError(401)
        } catch (e: NotAllowedException) {
            response.sendError(403)
        } catch (e: Exception) {
            e.printStackTrace()
            response.sendError(500)
        }
    }


}


