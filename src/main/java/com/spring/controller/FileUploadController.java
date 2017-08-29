package com.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	ResourceLoader resourceLoader;

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
				String contentType = file.getContentType();
				System.out.println("File Name: " + fileName);
				System.out.println("Content Type: " + contentType);
				// Creating the directory to store file
				/* duong dan 1 */

				//String rootPath = System.getProperty("catalina.home");
				
				String rootPath=System.getenv("OPENSHIFT_DATA_DIR");
				File dir = new File(rootPath + File.separator + "images");
				System.out.println(dir.getAbsolutePath());

				/* duong dan 2 */
				/*
				 * File dir = new File("D:" + File.separator +
				 * "clothesshopimages");
				 */

				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	@RequestMapping(value = "/uploadFile1", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler1(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				file.transferTo(resourceLoader.getResource("resources/images/" + name + ".png").getFile());
				System.out.println(
						resourceLoader.getResource("resources/images/" + name + ".png").getFile().getAbsolutePath());
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
		return null;

	}
}
