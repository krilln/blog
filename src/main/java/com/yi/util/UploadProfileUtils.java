package com.yi.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadProfileUtils {
	
	
	public static String uploadFile(String uploadProfilePath, //upload경로
									String originalName,//파일이름
									byte[] fileData) throws IOException {//파일데이터
		
		UUID uid = UUID.randomUUID();//중복되지 않는 고유한 키값을 만듬
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadProfilePath);
		File target = new File(uploadProfilePath + savedPath +"/" + savedName);
		FileCopyUtils.copy(fileData, target);
		
		
		//-----------------------------
		//thumbnail이미지
		//-----------------------------
		
		String thumPath = makeThumbnail(uploadProfilePath, savedPath, savedName);
		
		return thumPath;
	}
	
	
	
	private static String makeThumbnail(String uploadProfilePath,// c:/zzz/upload
										String path, // 2019/02/13
										String fileName) throws IOException {//원본파일이름
		
		//원본 이미지의 데이터를 가져와서 가상 이미지를 만듬
		BufferedImage sourceImg = ImageIO.read(new File(uploadProfilePath + path, fileName));
		
		//세로 100크기에 고정하여 가로 너비는 자동 조절하도록 하여 thumbnail데이터를 만듬
		BufferedImage destImg = Scalr.resize(sourceImg,
											Scalr.Method.AUTOMATIC,
											Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		//thumbnail 파일명을 만듬(s_를 붙임)
		String thumbnailName = uploadProfilePath + path + "/" + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		//만들어진 빈 thumbnail 파일에 destImg 데이터를 넣음
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return path + "/" + "s_" + fileName;//thumbnail을 파일 주소로 넘김
	}
	
	private static String calcPath(String uploadProfilePath) {
		String proPath = "/profile";
		
		//2019/02/13
		makeDir(uploadProfilePath, proPath);
		
		return proPath;//2019/02/13
		
	}
	
	
	private static void makeDir(String uploadProfilePath, String... paths) {
		for(String path:paths) {
			File dirPath = new File(uploadProfilePath + path);
			if(dirPath.exists() == false) {
				dirPath.mkdir();
			}
		}
	}
}
