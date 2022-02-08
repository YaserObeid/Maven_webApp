<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- local CSS -->
    <link rel="stylesheet" type="text/css" href="asset/css/main.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Test</title>
  </head>
  <body>
  <div class="container">
  <div class="card m-5 p-5">
  
     <h1 id="demo" class="text-center my-3">Test Page</h1>

    <button class="btn- btn-outline-success" onclick="changeText()">Change the text above</button>
 
   
   <table class="table mt-5">
   <caption  class="h5 text-danger "><i>Database infos</i></caption>
   <tr>
   <td ">User</td>
   <td>${User}</td>
   </tr>
   <tr>
   <td>Pass</td>
   <td>${Pass}</td>
   </tr>
   <tr>
   <td>Url</td>
   <td>${Url}</td>
   </tr>
   </table>
   </div>
   </div>
  



	<!--local javascript-->
    <script src="asset/js/main.js"></script>
	<!-- Bootstrap JavaScript-->    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

  </body>
</html>
