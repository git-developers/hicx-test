<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
    
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<style>
		body {font-family: Arial, Helvetica, sans-serif;}
		* {box-sizing: border-box;}
		
		input[type=text], select, textarea {
		  width: 100%;
		  padding: 12px;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		  margin-top: 6px;
		  margin-bottom: 16px;
		  resize: vertical;
		}
		
		input[type=submit] {
		
			/*
		  background-color: #4CAF50;
		  color: white;
		  padding: 12px 20px;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		  */
		  
			all: unset;
            margin-top: 2.4em;
            background: transparent;
            border: 2px solid white;
            padding: 1em 4em;
            border-radius: 50px;
            cursor: pointer;
            display: inline-block;
            font-weight: 700;
            position: relative;
            transition: all 300ms ease;
		}
		
		input[type=submit]:hover {
		  background-color: #45a049;
		}
		
		.container {
		  border-radius: 5px;
		  background-color: #2bb24c;
		  padding: 20px;
		  margin:30px;
		  
		  position: absolute;
		  left: 25%;
		  right: 25%;
		  top: 0%;
		}
	</style>
    
    </head>
    <body >
    
		<div class="container" data-example-id="basic-forms">
		
			<h3>Hicx: Data analysis</h3>
		
		    <form:form method="POST" action="/Hicx/main-submit" modelAttribute="fileStored">
		    
		      <div class="form-group">
		        <form:label path="path"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Path</form:label>
		        <form:input path="path" class="form-control" required="required" autocomplete="off" />
		      </div>
		      
		      <input type="submit" class="btn btn-default pull-right" value="Submit" />
		    
		    </form:form>
		  </div>
        
    </body>
</html>