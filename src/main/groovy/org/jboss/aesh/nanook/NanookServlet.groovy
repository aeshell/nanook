package org.jboss.aesh.nanook

import groovy.transform.CompileStatic

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@CompileStatic
@WebServlet(name = 'nanook', urlPatterns = '/*')
public class NanookServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.writer.write('hail from nanook.')
  }
}
