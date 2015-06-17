package org.jboss.aesh.nanook

import groovy.transform.CompileStatic

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@CompileStatic
@WebServlet(name = 'nanook', urlPatterns = '/nanook')
class NanookServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    if (!req.session.getAttribute('aesh')) {
      req.session.setAttribute('aesh', new AeshHandler())
    }
    
    resp.writer.write('hail from nanook.')
  }
}
