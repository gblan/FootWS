<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- output -->
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/country">

<html>
	<head>
	<title><xsl:value-of select="countryName" />'s information</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta charset="UTF-8" />
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
		crossorigin="anonymous" />

	<link
		href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
		rel="stylesheet" />
	</head>
	
	<body>
		<div style="text-align: center;">
			<h1>Country Information</h1>
			<h2><xsl:value-of select="countryName" /></h2>
			<xsl:variable name="flagURL"><xsl:value-of select="flagURL"/></xsl:variable>
			<img src="{$flagURL}"/>
		</div>
		
		<div>
			<h3 style="margin-left: 3%">Country's information</h3>
			<hr></hr>
		</div>
		
		<div style="margin-left: 5%;">
			<p>Capital : <xsl:value-of select="administrativeCapital" /></p>
			<p>Continent : <xsl:value-of select="continent" /> (<xsl:value-of select="continentCode" />)</p>
			<p>Currency : <xsl:value-of select="currencyExchange" /></p>
			<p>Phone prefix : +<xsl:value-of select="phoneCodePrefix" /></p>
			<p>Language(s) : 
				<xsl:for-each select="languages">
					<xsl:value-of select="language" /> 
				</xsl:for-each>
			</p>
		</div>
		
		<div>
			<h3 style="margin-left: 3%">Weather</h3>
			<hr></hr>
		</div>
		<div style="margin-left: 5%;">
			<p>City : <xsl:value-of select="meteoLocation/Location" /></p>
			<p>Time : <xsl:value-of select="meteoLocation/Time" /></p>
			<p>Wind : <xsl:value-of select="meteoLocation/Wind" /></p>
			<p>Temperature : <xsl:value-of select="meteoLocation/Temperature" /></p>
			<p>Humidity : <xsl:value-of select="meteoLocation/RelativeHumidity" /></p>
			<xsl:choose>
				<xsl:when test="meteoLocation/skyConditions != null">
					<p>Sky Conditions : <xsl:value-of select="meteoLocation/skyConditions" /></p>
				</xsl:when>
			</xsl:choose>
		</div>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
			integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
			crossorigin="anonymous"></script>
	</body>
</html>
	</xsl:template>
</xsl:stylesheet>