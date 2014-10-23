<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE xsl:stylesheet SYSTEM "xhtml-math11-f.dtd">
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema">

	<xsl:output method="html" encoding="UTF-8"
		doctype-public="-//W3C//DTD XHTML 1.1 plus MathML 2.0//EN"
		doctype-system="xhtml-math11-f.dtd" indent="yes" standalone="no"
		omit-xml-declaration="yes" escape-uri-attributes="yes" />

	<xsl:template match="/">

				<h1>Synthèse des flux</h1>
				<xsl:apply-templates select="*|text()|processing-instruction()" />

	</xsl:template>

	<xsl:template match="list">
		<ul>
			<xsl:apply-templates select="model.Article" />
		</ul>
	</xsl:template>

	<xsl:template match="model.Article">
		<li>
			<strong>titre du flux :</strong>
			<xsl:value-of select="titre" /><br/>
			<strong>description :</strong>
			<xsl:value-of select="description" /><br/>
			<strong>date :</strong>
			<xsl:value-of select="date" /><br/>
			<strong>createur :</strong>
			<xsl:value-of select="createur" /><br/>
		</li><br/><br/>
	</xsl:template>
</xsl:stylesheet>