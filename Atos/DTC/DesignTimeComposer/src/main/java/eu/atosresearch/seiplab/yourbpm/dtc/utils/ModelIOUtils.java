/**
 * 
 * Copyright (C) 2006-2010 ATOS ORIGIN
 * http://www.atosorigin.com
 *
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of the license LGPL.
 *
 * Authors :
 * Jesus Gorronogoitia. Atos Research and Innovation, Atos Origin SAE
 * @email jesus.gorronogoitia@atosresearch.eu
 * Mateusz Radzimski. Atos Research and Innovation, Atos Origin SAE
 * @email mateusz.radzimski@atosresearch.eu
 */
package eu.atosresearch.seiplab.yourbpm.dtc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.soa4all.lpml.Process;

import eu.atosresearch.seiplab.yourbpm.dtc.DTComposerImpl;
import eu.atosresearch.seiplab.yourbpm.dtc.common.utils.jar.JarResources;
import eu.atosresearch.seiplab.yourbpm.dtc.common.utils.rdf.LPMLXMLMapper;
import eu.atosresearch.seiplab.yourbpm.dtc.designmodel.DesignModel;

public class ModelIOUtils {

	public static Process loadModel(URL sourceProcessModelURL)
			throws URISyntaxException {
		// Process process = new RDFSMapper().mapFromRDFS(modelURL);
		return new LPMLXMLMapper().mapFromXMLFile(sourceProcessModelURL);
	}
	
	public static Process loadModelFromJar(String jarfile, String modelFile)
		throws URISyntaxException {
		String modelAsString = new String (loadFileInJar (jarfile, modelFile));
		
		return new LPMLXMLMapper().mapFromXML(modelAsString);
	}

	private static byte[] loadFileInJar (String jarfile, String file){
		JarResources jr = new JarResources (jarfile);
		byte[] r = jr.getResource (file);
		return r;
	}
	
	public static Process loadModelFromXML(String xml)
			throws URISyntaxException {
		// Process process = new RDFSMapper().mapFromRDFS(modelURL);
		return new LPMLXMLMapper().mapFromXML(xml);
	}

	public static String loadModelAsString (URL sourceProcessModelURL)
			throws URISyntaxException {
		// Process process = new RDFSMapper().mapFromRDFS(modelURL);
		return loadModelasXML(sourceProcessModelURL);
	}
	
	public static URL resolveURL(String sourceProcessModel)
	throws URISyntaxException, MalformedURLException {
		URL sourceProcessModelURL;
		if (sourceProcessModel.startsWith("file:")){ //Loaded from file system URL
			sourceProcessModelURL = new URL (sourceProcessModel);
		} else { //Trying from class path
			sourceProcessModelURL = ModelIOUtils.class.getClassLoader().getResource(sourceProcessModel);
		}
		return sourceProcessModelURL;
}

	public static Process loadModel(URI sourceProcessModelURI)
			throws URISyntaxException, MalformedURLException {
		// Process process = new RDFSMapper().mapFromRDFS(modelURL);
		return new LPMLXMLMapper()
				.mapFromXMLFile(sourceProcessModelURI.toURL());
	}

	public static Process loadModel(String modelLocation)
			throws URISyntaxException {
		// Process process = new RDFSMapper().mapFromRDFS(modelURL);
		return new LPMLXMLMapper().mapFromXMLFile(modelLocation);
	}

	public static URL saveSolutionModel(DesignModel solutionDesignModel)
			throws IOException {
		// Checking output directory:
		String output = DTComposerImpl.getInstance().getConfiguration()
		.getOUTPUT_MODELS_URL();
		File outputdir = new File (output);
//		if (!outputdir.exists()){
//			createDirectory (outputdir);
//		}
		
		URL outputUrl = new URL(DTComposerImpl.getInstance().getConfiguration()
				.getOUTPUT_MODELS_URL()
				+ solutionDesignModel.getName() + ".xml");
		// processMapper.mapToRDFS(solutionDesignModel.getDesignStructure(),
		// outputUrl);
		LPMLXMLMapper xmlMapper = new LPMLXMLMapper();
		xmlMapper.mapToXML((Process)solutionDesignModel.getDesignStructure(), outputUrl);

		return outputUrl;
	}

	private static void createDirectory(File outputdir) throws IOException {
		String path = outputdir.getCanonicalPath();
		try {
			outputdir.createNewFile();
		} catch (IOException e) {
			createDirectory (new File (path.substring(0, path.lastIndexOf(File.separatorChar))));
		}
		if (!outputdir.exists()){
			outputdir.createNewFile();
		}
	}

	public static URL saveTemporalModel(DesignModel solutionDesignModel)
			throws IOException, URISyntaxException {
		// URL outputUrl = new URL
		// (DesignTimeComposer.getInstance().getConfiguration().getTEMP_DIR_URL()
		// + solutionDesignModel.getName() + ".rdfs");
		URL outputUrl = new URL(DTComposerImpl.getInstance().getConfiguration()
				.getTEMP_URL()
				+ solutionDesignModel.getName() + ".xml");
		LPMLXMLMapper xmlMapper = new LPMLXMLMapper();
		xmlMapper.mapToXML((Process)solutionDesignModel.getDesignStructure(), outputUrl);
		// RDFSMapper processMapper = new RDFSMapper();
		// processMapper.mapToRDFS(solutionDesignModel.getDesignStructure(),
		// outputUrl);
		return outputUrl;
	}

	public static void saveModel(URI outputURI, Process process)
			throws MalformedURLException {
		LPMLXMLMapper xmlMapper = new LPMLXMLMapper();
		xmlMapper.mapToXML(process, outputURI.toURL());
		// RDFSMapper processMapper = new RDFSMapper();
		// processMapper.mapToRDFS(process, outputURL);

	}

	public static void saveModel(URL outputURL, Process process)
			throws MalformedURLException {
		LPMLXMLMapper xmlMapper = new LPMLXMLMapper();
		xmlMapper.mapToXML(process, outputURL);
		// RDFSMapper processMapper = new RDFSMapper();
		// processMapper.mapToRDFS(process, outputURL);

	}

	public static void saveProcessForDebug(Process process) throws IOException {
		URL outputUrl = new URL(DTComposerImpl.getInstance().getConfiguration()
				.getTEMP_URL()
				+ "DEBUG-" + process.getID() + ".xml");
		LPMLXMLMapper xmlMapper = new LPMLXMLMapper();
		xmlMapper.mapToXML(process, outputUrl);
		// RDFSMapper processMapper = new RDFSMapper();
		// processMapper.mapToRDFS(process, outputURL);

	}

	public static void createDir(String directory) {
		System.out.println("Creating directory " + directory);
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdirs();
		}

	}

	private static String loadModelasXML(URL file) {
		String xml = new String();

		try {
			BufferedReader input = null;
			if (file.getProtocol().equalsIgnoreCase("http")) {
				input = new BufferedReader(new InputStreamReader(file
						.openConnection().getInputStream()));
			} else if (file.getProtocol().equalsIgnoreCase("file")) {
				input = new BufferedReader(new FileReader(URLDecoder.decode(
						file.getPath(), "UTF-8")));
			}

			String line = null;
			try {
				while ((line = input.readLine()) != null) {
					xml = xml.concat(line);
					xml = xml.concat(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return xml;
	}

	public static void saveModel(URL outputURL, String processXml)
			throws MalformedURLException {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(URLDecoder.decode(outputURL
					.getFile(), "UTF-8")));
			out.write(processXml);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("XML file write error.");
			if (out != null) {
				try {
					out.close();
				} catch (IOException e1) {
				} // Ignored
			}
		}
	}

	public static Process loadTemplate(URI templateURI)
			throws URISyntaxException, IOException {
		Process result = null;
		if (DTComposerImpl.getInstance().getConfiguration()
				.getTemplate_storage_method().equalsIgnoreCase("storage")) {
			// loading templates from storage service
			result = loadTemplateFromStorage(getTemplateName(templateURI));
		} else { // Default: loading templates from file system
			result = loadTemplateFromFileSystem(templateURI);
		}
		
		saveProcessForDebug(result);

		return result;
	}

	private static Process loadTemplateFromFileSystem(URI templateURI)
			throws URISyntaxException, MalformedURLException {
		System.out.println("Loading template " + templateURI);
		
		URL templateURL = getTemplateURL(templateURI);
		
		
		
		Process template = null;
	
		if (templateURL != null && !templateURL.toString().startsWith("jar")) {// Loading from URL
			template = ModelIOUtils.loadModel(templateURL);
		} else if (templateURL != null && templateURL.toString().startsWith("jar")){ // Loading from aar classpath
			//jar:file:/tmp/axis2-tmp-7015303672753799025.tmp/axis25120490073326377102DesignTimeComposer-1.0-SNAPSHOT.aar!/models/templates/AdaptAirportTemplate.xml
			
			String jarfile = templateURL.toString().substring(templateURL.toString().indexOf("/"), templateURL.toString().indexOf("!"));
			
			template = ModelIOUtils.loadModelFromJar(jarfile, templateURL.toString().substring(templateURL.toString().lastIndexOf("!") + 2));
		} else { // Loading from local classpath
			template = ModelIOUtils.loadModel(getTemplateLocation(templateURI));
		}

		// Bug fixed: replace Identifiers in Process Element to ensure a unique
		// template
//		LPMLProxy.renewIdentifiers(template);

		return template;
	}

	private static Process loadTemplateFromStorage(String templateName)
			throws URISyntaxException, IOException {

		Process template = null;
		String storate_url = DTComposerImpl.getInstance().getConfiguration()
		.getStorage_url();
		String template_repository = DTComposerImpl.getInstance().getConfiguration()
		.getTemplate_repository();
		
		String templateAsString = getFile (template_repository, templateName, storate_url);
		LPMLXMLMapper xmlMapper = new LPMLXMLMapper();
		template = xmlMapper.mapFromXML (templateAsString);
		
		// Bug fixed: replace Identifiers in Process Element to ensure a unique
		// template
//		LPMLProxy.renewIdentifiers(template);
		
		return template;
	}
	
	private static String getFile(String repoID, String fileName, String STORAGE_SERVICE_ENDPOINT) throws IOException {
        
        String requestURL = STORAGE_SERVICE_ENDPOINT 
                            + "/repositories/"
                            + repoID
                            + "/files/"
                            + fileName;
            
        System.out.println("Request URL: " + requestURL);
        GetMethod getMtd = new GetMethod(requestURL);
        HttpClient httpclient = new HttpClient();
        String fileDataAsString = null;
        
        try {
            int result = httpclient.executeMethod(getMtd);
            System.out.println("Response status code: " + result);
            if (result != 200) {
                System.out.println("Error message: ");
                System.out.println(getMtd.getResponseHeader("Error"));
            }
            else {
                System.out.println("Response OK");
                System.out.println(getMtd.getResponseHeader("Content-Type"));
                fileDataAsString = getMtd.getResponseBodyAsString();
//                System.out.println((fileDataAsString.length() <= 500) ? fileDataAsString 
//                        : fileDataAsString.substring(0, 500) + " ... ");
            }
        } finally {
            getMtd.releaseConnection();
        }
        
        return fileDataAsString;
    }

	private static URL getTemplateURL(URI templateURI) {
		String templateName = getTemplateName(templateURI);
		URL url = null;
		
		try {
			//trying first from classpath, 
			String stemplate = DTComposerImpl.getInstance().getConfiguration().getTEMPLATES_URL();
			URL templateURL = ModelIOUtils.class.getClassLoader().getResource( stemplate + templateName);
		
			//otherwise from filesystem.
			if (templateURL == null){
				templateURL = new URL(DTComposerImpl.getInstance().getConfiguration()
					.getTEMPLATES_URL()
					+ templateName);
			}

			System.out.println ("loading template " + templateName + " from template URL " + templateURL);
			url = templateURL;
			
		} catch (Exception e) {
			// Trying to resolve locally templateURI
			if (url == null){
				File f = new File (templateURI);
				if (f.exists()){
					try {
						url = new URL (templateURI.toString());
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		} // Ignored

		return url;
	}

	private static String getTemplateName(URI templateURI) {
		return templateURI.getPath().substring(
				templateURI.getPath().lastIndexOf("/") + 1);
	}

	private static String getTemplateLocation(URI templateURI)
			throws MalformedURLException {
		return DTComposerImpl.getInstance().getConfiguration()
				.getTEMPLATES_URL()
				+ templateURI.getFragment();
	}
}
