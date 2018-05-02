package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.ListBucketsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectAcl;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;

public class Test {
	private static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
	private static String accessKeyId = "LTAIcFqmxYf5WAgf";
	private static String accessKeySecret = "GEcPVHhRteETyYIRQNirRB6uUAdlCZ";
	private static String bucketName = "qxartest";
	private static String key = "test";
	// private static String url =
	// "http://qxartest.oss-cn-shanghai.aliyuncs.com";

	public static void main(String[] args) {
		try {
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			// 列举bucket
			List<Bucket> buckets = ossClient.listBuckets();
			for (Bucket bucket : buckets) {
				System.out.println(" - " + bucket.getName());

			}
			boolean exists = ossClient.doesBucketExist(bucketName);
			if (!exists) {// 没有Bucket创建
				ossClient.createBucket(bucketName);
			}
			System.out.println(exists);

			// System.out.println("Uploading a new object to OSS from a
			// file\n");
			// Date date = new Date();
			// String filename = "test.txt";
			// key = DateUtil.getYear(date) + "/" + DateUtil.getMonth(date) +
			// "/" + filename;
			// ossClient.putObject(new PutObjectRequest(bucketName, key,
			// createSampleFile()));
			//
			// System.out.println("URL: " + url + "/" + key);
			ossClient.deleteBucket(bucketName);
			// ossClient.deleteObject(bucketName, "2017/1/test.txt");
			ossClient.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main1(String[] args) throws IOException {
		/*
		 * Constructs a client instance with your account for accessing OSS
		 */
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		System.out.println("Getting Started with OSS SDK for Java\n");
		try {
			if (!ossClient.doesBucketExist(bucketName)) {
				System.out.println("Creating bucket " + bucketName + "\n");
				ossClient.createBucket(bucketName);
				CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
				createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
				ossClient.createBucket(createBucketRequest);
			}
			System.out.println("Listing buckets");
			ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
			listBucketsRequest.setMaxKeys(500);
			for (Bucket bucket : ossClient.listBuckets()) {
				System.out.println(" - " + bucket.getName());
			}
			System.out.println();

			/*
			 * Upload an object to your bucket
			 */
			System.out.println("Uploading a new object to OSS from a file\n");
			ossClient.putObject(new PutObjectRequest(bucketName, key, createSampleFile()));

			/*
			 * Determine whether an object residents in your bucket
			 */
			boolean exists = ossClient.doesObjectExist(bucketName, key);
			System.out.println("Does object " + bucketName + " exist? " + exists + "\n");

			ossClient.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);
			ossClient.setObjectAcl(bucketName, key, CannedAccessControlList.Default);

			ObjectAcl objectAcl = ossClient.getObjectAcl(bucketName, key);
			System.out.println("ACL:" + objectAcl.getPermission().toString());

			/*
			 * Download an object from your bucket
			 */
			System.out.println("Downloading an object");
			OSSObject object = ossClient.getObject(bucketName, key);
			System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
			displayTextInputStream(object.getObjectContent());

			/*
			 * List objects in your bucket by prefix
			 */
			System.out.println("Listing objects");
			ObjectListing objectListing = ossClient.listObjects(bucketName, "My");
			for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
				System.out.println(" - " + objectSummary.getKey() + "  " + "(size = " + objectSummary.getSize() + ")");
			}
			System.out.println();

			/*
			 * Delete an object
			 */
			System.out.println("Deleting an object\n");
			ossClient.deleteObject(bucketName, key);

		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message: " + oe.getErrorCode());
			System.out.println("Error Code:       " + oe.getErrorCode());
			System.out.println("Request ID:      " + oe.getRequestId());
			System.out.println("Host ID:           " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ce.getMessage());
		} finally {
			/*
			 * Do not forget to shut down the client finally to release all
			 * allocated resources.
			 */
			ossClient.shutdown();
		}
	}

	private static File createSampleFile() throws IOException {
		File file = File.createTempFile("oss-java-sdk-", ".txt");
		file.deleteOnExit();

		Writer writer = new OutputStreamWriter(new FileOutputStream(file));
		writer.write("abcdefghijklmnopqrstuvwxyz\n");
		writer.write("0123456789011234567890\n");
		writer.close();

		return file;
	}

	private static void displayTextInputStream(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;

			System.out.println("    " + line);
		}
		System.out.println();

		reader.close();
	}
}
