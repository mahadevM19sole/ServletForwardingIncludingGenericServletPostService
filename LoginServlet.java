import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class LoginServlet extends GenericServlet
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
               
            String s1=request.getParameter("uname");        
            String s2=request.getParameter("pwd");    
             PreparedStatement pstmt=con.prepareStatement("select * from uinfo where uname=?  and pwd=?"); 
             pstmt.setString(1,s1);
             pstmt.setString(2,s2);
             ResultSet rs=pstmt.executeQuery();  
             ServletContext sc=getServletContext();
             
            if(rs.next())
            {
             RequestDispatcher rd=sc.getRequestDispatcher("/welcome");
              rd.forward(request,response);
             }
            else
             {
              PrintWriter pw=response.getWriter();
               pw.println("<font color=red>");
               pw.println("Invalid username and password</font>");
               RequestDispatcher rd=sc.getRequestDispatcher("/login.html");
               rd.include(request,response);
              }
              
          }
        catch(Exception e)
        {
          System.out.println(e);
        }

     }

}