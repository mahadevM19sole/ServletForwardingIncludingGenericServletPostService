import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class RegServlet extends GenericServlet
{
     Connection con;
     public void init()
     {
       try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");

          }
        catch(Exception e)
        {
          System.out.println(e);
        }
     }
     public void service(ServletRequest request,ServletResponse response)
     {
       try{
            String s1=request.getParameter("fname");
            String s2=request.getParameter("lname");     
            String s3=request.getParameter("uname");        
            String s4=request.getParameter("pwd");    
             PreparedStatement pstmt=con.prepareStatement("insert into uinfo values(?,?,?,?)"); 
             pstmt.setString(1,s1);
             pstmt.setString(2,s2);
             pstmt.setString(3,s3);
             pstmt.setString(4,s4);
             pstmt.executeUpdate();
                 
            PrintWriter  pw=response.getWriter();
            pw.println("<html><body bgcolor=lightyellow text=red><center>");
            pw.println("<h1>You  have  register  Successfully </h1>");
            pw.println("<a href=login.html>LOGIN</a>");
            pw.println("</center></body></html>");
          }
        catch(Exception e)
        {
          System.out.println(e);
        }

     }

}