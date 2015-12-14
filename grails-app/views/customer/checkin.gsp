
<!doctype html>
<html>

<head>
	%{--<meta name="layout" content="main">--}%
	<title>Kiosk</title>
	%{--<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">--}%
	%{--<script src="js/respond.js"></script>--}%
</head>

<body>
	<g:form url="[resource:customerInstanceAsAllElmentsFromForm, action:'customerLookup']" >
			<g:render template="kioskForm"/>
	</g:form>
	
	
	<g:javascript library="jquery"/>
	%{--<script src="js/bootstrap.min.js"></script>--}%
</body>
</html>

<asset:javascript src="jquery-2.1.3.js"/>

<asset:javascript src="bootstrap-all.js"/>
<asset:stylesheet src="bootstrap-all.css"/>
<asset:stylesheet src="font-awesome-all.css"/>