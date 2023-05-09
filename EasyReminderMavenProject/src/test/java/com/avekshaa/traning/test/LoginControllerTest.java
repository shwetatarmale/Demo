package com.avekshaa.traning.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.avekshaa.training.Servlet.LoginController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private LoginController loginController;

    @Before
    public void setUp() throws SQLException {
    	 MockitoAnnotations.initMocks(this);
        loginController = new LoginController();
        
        // Mocking the necessary method calls for database interaction
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void testDoPost() throws ServletException, IOException, SQLException {
        // Provide the test credentials
        String username = "shweta.tarmale@gmail.com";
        String password = "Shweta";
        
        // Set up the request parameters
        when(request.getParameter("username")).thenReturn(username);
        when(request.getParameter("password")).thenReturn(password);
        
        // Set up the ResultSet to return a row
        //when(resultSet.next()).thenReturn(true);
        
        // Perform the doPost() method call
        loginController.doPost(request, response);
        //when(resultSet.next()).thenReturn(true);
        
        // Verify that the appropriate methods were called
        verify(response).sendRedirect("success.jsp");
//        verify(resultSet).getString("username");
//        verify(resultSet).getString("password");
//        verify(request, times(1)).getParameter("username");
//        verify(request, times(1)).getParameter("password");
//        verify(connection, times(1)).prepareStatement(anyString());
//        verify(preparedStatement, times(1)).setString(1, "shweta.tarmale@gmail.com");
//        verify(preparedStatement, times(1)).setString(2, "Shweta");
//        verify(preparedStatement, times(1)).executeQuery();
//        verify(resultSet, times(1)).next();
//        verify(resultSet, times(1)).getString("username");
//        verify(resultSet, times(1)).getString("password");
//        verify(response, times(1)).sendRedirect("success.jsp");
//
//        // Assert the expected values
//        assertEquals("shweta.tarmale@gmail.com", resultSet.getString("username"));
//        assertEquals("Shweta", resultSet.getString("password"));
        verifyNoMoreInteractions(response, resultSet);
        
    }
}
