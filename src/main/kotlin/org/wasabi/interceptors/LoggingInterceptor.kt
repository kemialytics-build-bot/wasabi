package org.wasabi.interceptors

import org.wasabi.protocol.http.Request
import org.wasabi.protocol.http.Response
import org.slf4j.LoggerFactory
import org.wasabi.routing.RouteHandler
import org.wasabi.app.AppServer
import org.wasabi.routing.InterceptOn

public class LoggingInterceptor: Interceptor() {
    override fun intercept(request: Request, response: Response): Boolean {
        var logger = LoggerFactory.getLogger(LoggingInterceptor::class.java)
        logger!!.info("[${request.method.toString()}] - ${request.uri}")
        return true
    }

}

public fun AppServer.logRequests() {
    intercept(LoggingInterceptor(), "*", InterceptOn.PreExecution)
}