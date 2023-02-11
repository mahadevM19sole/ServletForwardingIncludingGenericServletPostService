import java.io.*;
import javax.servlet.*;
public class WelcomeServlet extends GenericServlet
{
   public void service(ServletRequest req,ServletResponse res)
   {
     try{
           String s=req.getParameter("uname");
            PrintWriter pw=res.getWriter();
             pw.println("<html><body bgcolor=orange text=blue><center><h1>");
             pw.println("Wellcome ="+s);
             pw.println("</h1></center></body></html>");
        }
        catch(Exception e)
        {
         System.out.println(e);
        }
   }

}