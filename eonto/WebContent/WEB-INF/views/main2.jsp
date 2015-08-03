<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eos</title>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><i>EOS	</i></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            

            <div class="col-md-9">

                <div class="row carousel-holder">

            
                    <!-- Jumbotron Header -->
        <h4><i>Assistente de busca EOS</i></h4>            
		<header class="jumbotron hero-spacer">
		    
            <p style="font-size:100%;">O Artigo é um(a) <select id="select_classes"></select> que possui as seguintes características</p>
            <p><table id="selectTable"></table></p>
            
            <p><a class="btn btn-primary btn-large" onclick="createQuery()">Buscar</a></p>
		</header>

                <div class="row" id="lista">
					
					                   

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyleft &copy; <i>EOS</i> Website 2015</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

<!-- Large modal -->
<div id=myModal class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog-lg">
    <div class="modal-content">

    <table border="1">
    	<tr height="450">
    		<td width="600" align="center">
    			<img id="imgModelo" >
    		</td>
    		<td width="350">
   
    			<table>
    				<tr id="articleColors" >
    				</tr>
    				<tr>
    					<td id="radioTamanho" style="font-family: Arial, Helvetica, sans-serif;"></td>
    				</tr>
    			</table>
    			
    		</td>
    	</tr>
    </table> 	
    </div>
  </div>
</div>


    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

	<!-- e-ontoSport Functions -->
	
	<script src="resources/js/modalModelos.js"></script>
	<script src="resources/js/cbox2/cbox2Beans.js"></script>
	<script src="resources/js/cbox2/cbox2Core.js"></script>
	<script src="resources/js/articleHTML.js"></script>
	<script src="resources/js/cbox2/cbox2Ajax.js"></script>
	<script src="resources/js/cbox2/cbox2Test.js"></script>
	<script src="resources/js/cbox2/sparqlQuery.js"></script>



<script>

init();

</script>

<style>

.carousel{
    position:absolute;
    left: 50px;
    top: 20px;
    width:300px; 
    height:400px;
} 
</style>

</body>
</html>