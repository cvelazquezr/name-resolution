SAXReader reader = new SAXReader();
reader.getDocumentFactory().setXPathNamespaceURIs(ImmutableMap.of("x", "DAV:"));
Document doc = reader.read(new StringReader(xmlContent));
doc.getRootElement().selectNodes("//x:response")