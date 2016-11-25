package com.hello.yarn.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Descriptor;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDescriptor;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.file.FileMetadataDescriptor;
import com.drew.metadata.file.FileMetadataDirectory;
import com.hello.yarn.vo.ImageMetaInfo;

@Component
public class ImageUtils {

	public Metadata loadToMetadata(File file) throws JpegProcessingException, IOException{
		return JpegMetadataReader.readMetadata(file);
	}
	
	public ImageMetaInfo setImgageMetaInfo(Metadata meta) throws MetadataException{
		if (meta == null) return null;
		
		ImageMetaInfo metainfo = new ImageMetaInfo();
		
		ExifIFD0Directory exifIFD0Directory = meta.getFirstDirectoryOfType(ExifIFD0Directory.class); 
		ExifSubIFDDirectory exifSubIFDDirectory = meta.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
		FileMetadataDirectory fileMetadataDirectory = meta.getFirstDirectoryOfType(FileMetadataDirectory.class);
		
		String make = exifIFD0Directory.getString(ExifIFD0Directory.TAG_MAKE);
		String model  = exifIFD0Directory.getString(ExifIFD0Directory.TAG_MODEL);
		
		long iso = exifSubIFDDirectory.getLong(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT);
		String date = exifSubIFDDirectory.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
		String shutterSpeed = exifSubIFDDirectory.getString(ExifSubIFDDirectory.TAG_SHUTTER_SPEED);
		String apertureValue = exifSubIFDDirectory.getString(ExifSubIFDDirectory.TAG_APERTURE);
		
		String imgWidth = exifSubIFDDirectory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH);
		String imgHeight = exifSubIFDDirectory.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT);
		
		String fileName = fileMetadataDirectory.getString(FileMetadataDirectory.TAG_FILE_NAME);
		String fileSize = fileMetadataDirectory.getString(FileMetadataDirectory.TAG_FILE_SIZE);
		
		metainfo.setBrand(make);
		metainfo.setModel(model);
		metainfo.setIso(iso);
		metainfo.setCreateDt(date);
		metainfo.setShutterSpeed(shutterSpeed);
		metainfo.setApertureValue(apertureValue);
		metainfo.setImgWidth(imgWidth);
		metainfo.setImgHeight(imgHeight);
		metainfo.setFileNm(fileName);
		metainfo.setFileSize(fileSize);
		
		
		return metainfo;
	}
	
	
	
}
