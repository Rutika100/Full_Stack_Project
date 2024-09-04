<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; 
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
            width: 300px;
            text-align: center;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
        }
        
        input[type=text],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        input[type=submit] {
            background-color: #007bff; /* Blue submit button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        
        input[type=submit]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>

<form action="RechargeController">
        <label for="regNo">Reg No:</label>
        <input type="text" id="regNo" name="regNo"><br><br>
        
        <label for="mobNo">Mobile No:</label>
        <input type="text" id="mobNo" name="mobno"><br><br>
        
        <label for="serviceProvider">Service Provider:</label>
        <select id="serviceProvider" name="ser">
            <option value="Airtel">Airtel</option>
            <option value="Jio">Jio</option>
            <option value="Idea">Idea</option>
        </select><br><br>
        
        <label for="rechargeAmount">Recharge Amount:</label>
        <select id="rechargeAmount" name="ramt">
            <option value="499">499</option>
            <option value="719">719</option>
            <option value="311">311</option>
        </select><br><br>
        
        <input type="submit" value="Recharge">
    </form>
</body>
</html>


