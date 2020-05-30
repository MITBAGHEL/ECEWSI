package com.ecewsi.utils;

import java.io.File;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class Basemethods {

	public static String getUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		return userName;
	}

	public static String generateOTP() {

		int n = 8;
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public static String uploadFileIntoS3(String fileName, String filePath, String key1) {
		String link = "";

		final String file = filePath + fileName;
		File f = new File(file);

		final String key = "document/" + key1 + "/" + f.getName();

		final String ACCESSKEY = "AKIAYUVRYVGNBHZMJ2UR";
		final String SECRETKEY = "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";
		final String bucketname = "baghelsm";

		try {
			System.out.println("-------file uploading from basemethod------");
			AmazonS3Client s3Client = new AmazonS3Client(new BasicAWSCredentials(ACCESSKEY, SECRETKEY));

			PutObjectRequest request = new PutObjectRequest(bucketname, key, f);
			request.setCannedAcl(CannedAccessControlList.PublicRead);
			s3Client.putObject(request);

			link = s3Client.getUrl(bucketname, key).toString();
			System.out.println("::::::::::File uploaded from basemethod:::::::::::::");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return link;
	}

}
