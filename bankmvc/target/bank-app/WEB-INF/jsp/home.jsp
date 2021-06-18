<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>Zeitgeist Bank</title>
  </head>

<body>
    
    <div class="container">
      
      <div class="row">
       
          <div class="col-md-6">
              <div class="card">
               
                  <div class="box">
                    
                      <h2 style="color: aliceblue;">Welcome to Zeitgeist Bank</h2>
                      <p class="text-muted" style="color: white;"> At Zeitgeist Bank our direction is determined by the needs of our customers and the communities we serve.
                        Our focus is on our customers so we are fully committed to providing each with the specialized banking services they need.
                        Come see why more people are making Zeitgeist their bank of choice.
                      </p> 
                       
                       <form  action="/customerlogin" method="get">
                    <input type="submit"  value="Customer Login" >
                    </form>
                    <form action="/employeelogin" method="get">
                    <input type="submit"  value="Employee Login" >
                    
                   
                  </form>
              </div>
          </div>
      </div>
  </div>
  
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

  </body>
</html>