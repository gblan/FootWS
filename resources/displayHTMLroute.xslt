<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- output -->
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/route">

<html>
	<head>
		<title> (<xsl:value-of select="teamName" />) FIFA world cup 2014 </title>
	</head>
	<body>
		<h1> Route of <xsl:value-of select="teamName" /> during FIFA world cup 2014 </h1>
		<br/>
		<h3> Coach of <xsl:value-of select="teamName" /> : <xsl:value-of select="coachName" /> </h3>
		<xsl:variable name="flagURL"><xsl:value-of select="flagURL"/></xsl:variable>
		<h3> Flag of <xsl:value-of select="teamName" /> : <img src="{$flagURL}"/> </h3>
		<h3> <xsl:value-of select="nbParticipation" /> particiaption to FIFA World cup </h3>

		<h2> Matches </h2>
		<xsl:for-each select="matches/match">
			<table border="1">
				<tr bgcolor="#9acd32">
					<th>Match number</th>
					<th>Competition phase</th>
					<th>Team 1</th>
					<th>Score</th>
					<th>Team 2</th>
					<th>Stadium link</th>
				</tr>
				<tr>
					<th><xsl:value-of select="idMatch" /></th>
					<th><xsl:value-of select="competitionPhase" /></th>
					<th><xsl:value-of select="team1" /></th>
					<th><xsl:value-of select="finalScore" /></th>
					<th><xsl:value-of select="team2" /></th>
					<xsl:variable name="stadiumMapsURL"><xsl:value-of select="stadiumMapsURL"/></xsl:variable>
					<th><a href="{$stadiumMapsURL}">Maps of the stadium</a></th>
				</tr>				
			</table>			
			<h4> Goals </h4>
			<table border="1">
				<tr bgcolor="#9acd32">
					<th>Minutes</th>
					<th>Team</th>
					<th>Striker</th>
				</tr>
				<xsl:for-each select="goals/goal">
					<tr>
						<th><xsl:value-of select="minutes" /></th>
						<th><xsl:value-of select="goalTeam" /></th>
						<th><xsl:value-of select="striker" /></th>
					</tr>	
				</xsl:for-each>
			</table>
			<h4> Cards </h4>
			<table border="1">
				<tr bgcolor="#9acd32">
					<th>Card color</th>
					<th>Team</th>
					<th>Player</th>
				</tr>
				<xsl:for-each select="cards/card">
					<tr>
						<th><xsl:value-of select="color" /></th>
						<th><xsl:value-of select="goalTeam" /></th>
						<th><xsl:value-of select="player" /></th>
					</tr>	
				</xsl:for-each>
			</table>
			<hr/>		
		</xsl:for-each>
	</body>
</html>
	</xsl:template>
</xsl:stylesheet>