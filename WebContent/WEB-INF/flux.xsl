<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="utf-8" indent="yes"
		doctype-public="-//W3C//DTD XHTML 1.1 plus MathML 2.0//EN"
		doctype-system="xhtml-math11-f.dtd" standalone="no" />

	<xsl:template match="/">
	<xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html&gt;</xsl:text>
		<h2>Synthèse des flux</h2>
		<xsl:apply-templates select="*|text()|processing-instruction()" />

	</xsl:template>

	<xsl:template match="list">
		<ul class="syntheseFlux">
			<xsl:apply-templates select="model.Article" />
		</ul>
	</xsl:template>

	<xsl:template match="model.Article">
		<li>
			<p>
				<strong>Titre du flux :</strong>
				<xsl:value-of select="titre" />
			</p>
			<p>
				<strong>Description :</strong>
				<xsl:value-of select="description" />
			</p>
			<p>
				<strong>Date :</strong>
				<xsl:value-of select="date" />
			</p>
			<p>
				<strong>Createur :</strong>
				<xsl:value-of select="createur" />
			</p>
		</li>
	</xsl:template>
</xsl:stylesheet>