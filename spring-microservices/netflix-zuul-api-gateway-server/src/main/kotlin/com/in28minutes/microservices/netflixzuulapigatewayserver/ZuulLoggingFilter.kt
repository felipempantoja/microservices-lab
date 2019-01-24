package com.in28minutes.microservices.netflixzuulapigatewayserver

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class ZuulLoggingFilter : ZuulFilter() {

    private val LOGGER = LoggerFactory.getLogger(ZuulLoggingFilter::class.java)

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 0
    }

    override fun run(): Any? {
        val request: HttpServletRequest = RequestContext.getCurrentContext().request
        LOGGER.info("request -> {} request uri -> {}", request, request.requestURI)
        return null
    }

}