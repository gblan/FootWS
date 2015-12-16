<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- output -->
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/country">

<html>
	<head>
		<title> (<xsl:value-of select="countryName" />) Country Information </title>
	</head>
	<body>
		<h1> Country information : <xsl:value-of select="countryName" /> </h1>
		<br/>
		<h3> Country located in <xsl:value-of select="continent" />, code(<xsl:value-of select="continentCode" />) </h3>
		<xsl:variable name="flagURL"><xsl:value-of select="flagURL"/></xsl:variable>
		<h3> Flag of <xsl:value-of select="countryName" /> : <img src="{$flagURL}"/> </h3>
		<h3> Capital of <xsl:value-of select="countryName" /> : <xsl:value-of select="administrativeCapital" /></h3>
		<h3> Currency of <xsl:value-of select="countryName" /> : <xsl:value-of select="currencyExchange" /></h3>
		<h3> Phone prefix of <xsl:value-of select="countryName" /> : <xsl:value-of select="phoneCodePrefix" /></h3>

		<h2> Main language(s) </h2>
		<xsl:for-each select="languages">
			<h4> <xsl:value-of select="language" /> , </h4>
		</xsl:for-each>
		
		<h2> Weather in <xsl:value-of select="meteoLocation/Location" /> </h2>
		<table border="1">
			<tr bgcolor="#9acd32">
				<th>Time</th>
				<th>Wind</th>
				<xsl:choose>
				    <xsl:when test="meteoLocation/skyConditions != null">
						<th>Sky Conditions</th>
				    </xsl:when>
				</xsl:choose>				
				<th>Temperature</th>
				<th>Relative Humidity</th>				
			</tr>
			<tr>
				<th><xsl:value-of select="meteoLocation/Time" /></th>
				<th><xsl:value-of select="meteoLocation/Wind" /></th>
				<xsl:choose>
				    <xsl:when test="meteoLocation/skyConditions != null">
						<th><xsl:value-of select="meteoLocation/skyConditions" /></th>
				    </xsl:when>
				</xsl:choose>					
				<th><xsl:value-of select="meteoLocation/Temperature" /></th>
				<th><xsl:value-of select="meteoLocation/RelativeHumidity" /></th>
			</tr>	
		</table>
	</body>
</html>
	</xsl:template>
</xsl:stylesheet>