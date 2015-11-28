/////////////////////////
// old servlet source code for command execution.
/////////////////////////
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        AeshHandler aesh = getAeshHandler(req);
//
//        if (req.getParameter("customCommand") != null) {
//            aesh.run(req.getParameter("customCommand"));
//        }
//        else {
//            aesh.run(req.getParameter("command"));
//        }
//
//        String result = aesh.getResult();
//        result = result.replaceAll("@", " ");
//        result = result + "@" + aesh.getCurrentDirectory();
//        resp.getWriter().write(result);
//        aesh.reset();
//    }
//
//    private AeshHandler getAeshHandler(HttpServletRequest req) {
//        if (req.getSession().getAttribute("aesh") == null) {
//            req.getSession().setAttribute("aesh", new AeshHandler());
//        }
//        return (AeshHandler) req.getSession().getAttribute("aesh");
//    }
/////////////////////////

var AeshHandler = Java.type('org.jboss.aesh.nanook.util.AeshHandler');
var aesh = new AeshHandler();

$undertow.onGet("/",
    {headers: {"content-type": "text/plain"}},
    [
    function($exchange) {
      aesh.run('ls');
      return aesh.getResult();
    }
    ]);