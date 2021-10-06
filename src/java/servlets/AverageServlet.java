package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get the current session
        HttpSession session = request.getSession();

        // capture the operation parameter if the user wants to reset the form
        String operation = request.getParameter("operation");
        if( operation != null && operation.equals("reset") ){
            session.invalidate();
            session = request.getSession();
        }
        
        
        
        // get the list of numbers from the session
        ArrayList<Integer> numberList = (ArrayList<Integer>)session.getAttribute("numberList");
        // if there is no list of numbers in the session, create the list of numbers
        // singleton pattern
        if( numberList == null ){
            numberList = new ArrayList<>();
        }
        
        // get the number that the user entered
        // if there is a number, add it to the list
        if( request.getParameter("incoming_number") != null ){
            int number = Integer.parseInt( request.getParameter("incoming_number") );
            numberList.add(number);
            
            // store the list back in to the session
            session.setAttribute("numberList", numberList);
        }
        
        // math time!
        double average = 0.0;
        for( int number : numberList ){
            average += number;
        }
        if( numberList.size() > 0 ){
            average /= numberList.size();
        }
        
        
        // store the average in the request object
        // averge will need to be recalculated for each request (page view)
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request,response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
