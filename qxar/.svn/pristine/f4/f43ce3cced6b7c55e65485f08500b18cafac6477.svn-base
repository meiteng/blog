package com.qx.ar.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.qx.ar.base.OSSConfig;

public class OSSUtil {

	/**
	 * 普通文件上传
	 * 
	 * @param filepath
	 *            文件路径: 2017/1/test.txt
	 * @param file
	 *            File文件
	 * @return 图片访问路径:
	 *         http://qxartest.oss-cn-shanghai.aliyuncs.com/2017/1/test.txt
	 */
	public String uploadFile(String filepath, File file) {
		try {
			OSSClient ossClient = new OSSClient(OSSConfig.endpoint, OSSConfig.accessKeyId, OSSConfig.accessKeySecret);
			boolean exists = ossClient.doesBucketExist(OSSConfig.bucketName);
			if (!exists) {// 没有Bucket创建
				ossClient.createBucket(OSSConfig.bucketName);
			}
			ossClient.putObject(new PutObjectRequest(OSSConfig.bucketName, filepath, file));
			ossClient.shutdown();
			return OSSConfig.url + "/" + filepath;
		} catch (OSSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * MultipartFile文件上传
	 * 
	 * @param filepath
	 *            文件路径: 2017/1/test.txt
	 * @param MultipartFile
	 *            MultipartFile文件
	 * @return 图片访问路径:
	 *         http://qxartest.oss-cn-shanghai.aliyuncs.com/2017/1/test.txt
	 */
	public String uploadFile(String filepath, MultipartFile file) {
		try {
			OSSClient ossClient = new OSSClient(OSSConfig.endpoint, OSSConfig.accessKeyId, OSSConfig.accessKeySecret);
			boolean exists = ossClient.doesBucketExist(OSSConfig.bucketName);
			if (!exists) {// 没有Bucket创建
				ossClient.createBucket(OSSConfig.bucketName);
			}
			ossClient.putObject(new PutObjectRequest(OSSConfig.bucketName, filepath, file.getInputStream()));
			ossClient.shutdown();
			return OSSConfig.url + "/" + filepath;
		} catch (OSSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
