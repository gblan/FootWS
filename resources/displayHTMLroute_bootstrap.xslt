<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- output -->
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/route">

		<html>
			<head>
				<title>
					<xsl:value-of select="teamName" />
					's route
				</title>
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
					<h1>FIFA World Cup 2014 (Brazil)</h1>
					<h2>
						<xsl:value-of select="teamName" />'s route
					</h2>
					<xsl:variable name="flagURL">
						<xsl:value-of select="flagURL" />
					</xsl:variable>
					<img src="{$flagURL}" />
				</div>
				<div>
					<h3 style="margin-left: 3%">Informations about the country</h3>
					<hr></hr>
				</div>

				<div style="margin-left: 5%;">
					<p>
						Coach :
						<xsl:value-of select="coachName" />
					</p>
					<p>
						Number of participations in the Fifa World Cup :
						<xsl:value-of select="nbParticipation" />
					</p>
				</div>

				<div>
					<h3 style="margin-left: 3%">Country's route</h3>
					<hr></hr>


					<xsl:variable name="teamNameVar">
						<xsl:value-of select="teamName" />
					</xsl:variable>
					
					<xsl:for-each select="matches/match">

						<div style="text-align: center;">
							<div style="width: 80%; display: inline-block;">
								<table class="table">
									<tbody style="border-bottom: 1px solid #ddd;">
										<tr>
											<td>
												Match n°
												<xsl:value-of select="idMatch" />
											</td>
											<td>
												<xsl:value-of select="competitionPhase" />
											</td>
											<xsl:choose>
												<xsl:when test="team1=$teamNameVar">
													<td style="color: blue;">
														<xsl:value-of select="team1" />
													</td>
												</xsl:when>
												<xsl:otherwise>
													<td>
														<xsl:value-of select="team1" />
													</td>
												</xsl:otherwise>
											</xsl:choose>
											<td>
												<xsl:value-of select="finalScore" />
											</td>
											<td>
												<xsl:choose>
													<xsl:when test="team2=$teamNameVar">
														<td style="color: blue;">
															<xsl:value-of select="team2" />
														</td>
													</xsl:when>
													<xsl:otherwise>
														<td>
															<xsl:value-of select="team2" />
														</td>
													</xsl:otherwise>
												</xsl:choose>
											</td>
											<td>
												<xsl:variable name="stadiumMapsURL">
													<xsl:value-of select="stadiumMapsURL" />
												</xsl:variable>
												<a href="{$stadiumMapsURL}"><xsl:value-of select="stadiumName" /> (<xsl:value-of select="stadiumCity" />)</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div>
								<xsl:choose>
									<xsl:when test="goals/goal">
									<div style="display: inline-block;" class="panel panel-default">
										<div class="panel-heading" style="text-align: center;">Strikers</div>
										<table class="table">
											<tbody>
												<xsl:for-each select="goals/goal">
													<tr>
														<th>
															<xsl:value-of select="minutes" />'
														</th>
														<td>
															<xsl:value-of select="goalTeam" />
														</td>
														<td>
															(<xsl:value-of select="striker" />)
														</td>
													</tr>
												</xsl:for-each>
											</tbody>
										</table>
									</div>
									</xsl:when>
								</xsl:choose>
								
								<xsl:choose>
									<xsl:when test="cards/card">
										<div style="display: inline-block;" class="panel panel-default">
											<div class="panel-heading" style="text-align: center;">Cards</div>
											<table class="table">
												<tbody>
													<xsl:for-each select="cards/card">
														<tr>
															<xsl:choose>
																<xsl:when test="color='Yellow Card'">
																	<td>
																		<span class="glyphicon glyphicon-stop" aria-hidden="true"
																			style="color:yellow;"></span>
																	</td>
																</xsl:when>
																<xsl:otherwise>
																	<td>
																		<span class="glyphicon glyphicon-stop" aria-hidden="true"
																			style="color:red"></span>
																	</td>
																</xsl:otherwise>
															</xsl:choose>
															<td>
																<xsl:value-of select="player" />
															</td>
															<td>
																(<xsl:value-of select="goalTeam" />)
															</td>
														</tr>
													</xsl:for-each>
												</tbody>
											</table>
										</div>
									</xsl:when>
								</xsl:choose>
							</div>
						</div>
					</xsl:for-each>
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