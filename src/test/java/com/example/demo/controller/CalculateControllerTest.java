package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import com.example.demo.service.CalculateService;

class CalculateControllerTest {
	@Test
    void testAddition() {
        // Arrange
        double num1 = 5;
        double num2 = 3;
        String operation = "addition";
        double expectedResult = 8.0;
       
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.add(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act        
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");      

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
    }
	
	@Test
    void testAdditionNegativeNumber() {
        // Arrange
        double num1 = -5;
        double num2 = 3;
        String operation = "addition";
        double expectedResult = -2.0;
       
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.add(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act        
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");        

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
        
    }
	
	@Test
    void testAdditionLargeNumberAndOne() {
        // Arrange
        double num1 = Double.MAX_VALUE;
        double num2 = 1;
        String operation = "addition";
        double expectedResult = Double.MAX_VALUE;
       
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.add(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act        
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");        

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
        
    }
	
	@Test
    void testAdditionLargeNumbers() {
        // Arrange
        double num1 = Double.MAX_VALUE;
        double num2 = Double.MAX_VALUE;
        String operation = "addition";
        double expectedResult = Double.POSITIVE_INFINITY;
       
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.add(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act        
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");        

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
        
    }


    @Test
    void testSubtraction() {
        // Arrange
        double num1 = 5;
        double num2 = 3;
        String operation = "subtraction";
        double expectedResult = 2.0;
        
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.subtract(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");     

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMultiplication() {
        // Arrange
        double num1 = 5;
        double num2 = 3;
        String operation = "multiplication";
        double expectedResult = 15.0;
        
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.multiply(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result"); 

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void testMultiplicationSmallNumbers() {
        // Arrange
        double num1 = Double.MIN_VALUE;
        double num2 = Double.MIN_VALUE;
        String operation = "multiplication";
        double expectedResult = 0.0;
       
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.multiply(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act        
        String viewName = controller.calculate(num1, num2, operation, model);
//        System.out.println("model attribute "+ model.asMap());
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");        

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
        
    }

    @Test
    void testDivision() {
        // Arrange
        double num1 = 10;
        double num2 = 2;
        String operation = "division";
        double expectedResult = 5.0;
        
        Model model = mock(Model.class);
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.divide(num1, num2)).thenReturn(expectedResult);
        CalculateController controller = new CalculateController(calculateService);

        // Act
        String viewName = controller.calculate(num1, num2, operation, model);
        
        // Verify
        verify(model).addAttribute("result", expectedResult);
        
        when(model.getAttribute("result")).thenReturn(expectedResult);
        
        Double actualResult = (double) model.getAttribute("result");

        // Assert
        assertEquals("result", viewName);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDivisionByZero() {
        // Arrange
        double num1 = 10;
        double num2 = 0;
//        String operation = "division";
//        double expectedResult = Double.POSITIVE_INFINITY;
//        
//        Model model = mock(Model.class);
        CalculateService calculateService = new CalculateService();

     // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculateService.divide(num1, num2);
        });
    }
    
    @Test
    void testDivisionByZeroByZero() {
        // Arrange
        double num1 = 0;
        double num2 = 0;
//        String operation = "division";
//        double expectedResult = Double.NaN;
//        
//        Model model = mock(Model.class);
        CalculateService calculateService = new CalculateService();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculateService.divide(num1, num2);
        });
    }


}
