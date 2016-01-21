package nju.swi.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {
	
	/**
	 * qiniu base url
	 */
	public static final String QINIU_BASE_URL = "http://7xpxna.com1.z0.glb.clouddn.com/";
	
	public static final String QINIU_FILE_KEY_FORMAT = "vivian_studio/cdn/material/%s/%s";
	
	/**
	 * auth related variables
	 */
	private static final String ACCESS_KEY = "jdehlDjbrvYqct_kSCPBPYY7mlcsPz_gsW10Mm1H";
	private static final String SECRET_KEY = "phttiiASC_BxIx2Lgy3um68uu9YKjfP-pyPgTYZV";
	private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	
	/**
	 * qiniu bucket
	 */
	public static final String DEFAULT_BUCKET = "vivianstudio";
	
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(QiniuUtil.class);
	
	/**
	 * qiniu UploadManager
	 */
	private static UploadManager uploadManager = new UploadManager();
	
	/**
	 * qiniu operation manager
	 */
	@SuppressWarnings("unused")
	private static OperationManager operationManager = new OperationManager(auth);
	
	/**
	 * qiniu bucket manager
	 */
	private static BucketManager bucketManager = new BucketManager(auth);

	
	private static final String MIME_TYPE_JPEG = "image/jpeg";
	private static final String MIME_TYPE_DOC = "application/msword";
	private static final String MIME_TYPE_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	private static final String MIME_TYPE_XLS = "application/vnd.ms-excel";
	private static final String MIME_TYPE_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String MIME_TYPE_PPT = "application/vnd.ms-powerpoint";
	private static final String MIME_TYPE_PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
	
	private static Map<String, String> mimeTypeMap = new HashMap<String, String>();
	
	static {
		mimeTypeMap.put("jpg", MIME_TYPE_JPEG);
		mimeTypeMap.put("jpeg", MIME_TYPE_JPEG);
		mimeTypeMap.put("doc", MIME_TYPE_DOC);
		mimeTypeMap.put("docx", MIME_TYPE_DOCX);
		mimeTypeMap.put("xls", MIME_TYPE_XLS);
		mimeTypeMap.put("xlsx", MIME_TYPE_XLSX);
		mimeTypeMap.put("ppt", MIME_TYPE_PPT);
		mimeTypeMap.put("pptx", MIME_TYPE_PPTX);
	}
	
	public static String genPrivateUrl(String srcUrl) throws Exception {
		// default 24 hours expire
		return auth.privateDownloadUrl(srcUrl, 3600 * 24);
	}
	
	// 同步方法
	public static String uploadFile(String uuid, String originName, File file, String mimeType) throws QiniuException {
		String resourceKey = String.format(QINIU_FILE_KEY_FORMAT, uuid, originName);
		upload(file, resourceKey, getUpToken(DEFAULT_BUCKET, resourceKey), mimeType);
		return QINIU_BASE_URL + resourceKey;
	}
	
	public static String uploadData(String uuid, String originName, byte[] data, String mimeType) throws QiniuException {
		String resourceKey = String.format(QINIU_FILE_KEY_FORMAT, uuid, originName);
		upload(data, resourceKey, getUpToken(DEFAULT_BUCKET, resourceKey), mimeType);
		return QINIU_BASE_URL + resourceKey;
	}
	
	public static void deleteFile(String url) throws QiniuException {
		if(StringUtils.isBlank(url) || !url.startsWith(QINIU_BASE_URL)) {
			return;
		}
		String resourceKey = url.substring(QINIU_BASE_URL.length());
		bucketManager.delete(DEFAULT_BUCKET, resourceKey);
	}
	
	public static String getMimeTypeBySuffix(String suffix) {
		return mimeTypeMap.get(suffix.toLowerCase());
	}
	
	private static String upload(File file, String key, String upToken, String mimeType) throws QiniuException {
		Response response = uploadManager.put(file, key, upToken, null, mimeType, false);
		if(response.isOK()) {
			return response.url();
		}else {
			logger.error(response.bodyString(), response);
		}
		return null;
	}
	
	private static String upload(byte[] data, String key, String upToken, String mimeType) throws QiniuException {
		Response response = uploadManager.put(data, key, upToken, null, mimeType, false);
		if(response.isOK()) {
			return response.url();
		}else {
			logger.error(response.bodyString(), response);
		}
		return null;
	}
	
	private static String getUpToken(String bucket, String key) {
		return auth.uploadToken(bucket, key);
	}
//	
//	public static String uploadVideo(String collegeSymbol, int courseId, String fileName, byte[] fileContent, String format) throws QiniuException {
//		String resourceKey = String.format(VIDEO_URL_FORMAT, collegeSymbol, courseId, fileName, format);
//		try {
//			upload(fileContent, resourceKey, getUpTokenWithCallback(DEFAULT_BUCKET, resourceKey, collegeSymbol, UPLOAD_CALLBACK_URL), MIME_TYPE_VIDEO);
//		} catch (IOException e) {
//			logger.error(e.getMessage());
//		}
//		return resourceKey;
//	}
//	
//	public static String transformVideo(String collegeSymbol, int courseId, String fileName, String format) throws QiniuException {
//		String resourceKey = String.format(VIDEO_URL_FORMAT, collegeSymbol, courseId, fileName, format);
//		if(!fileName.contains(".") || !fileName.toLowerCase().endsWith("." + DEFAULT_VIDEO_DEST_FORMAT)) {
//			return tranform(DEFAULT_BUCKET, resourceKey, getUpToken(DEFAULT_BUCKET, resourceKey), DEFAULT_VIDEO_DEST_FORMAT, ConfigManager.globalSetting().getSettingValue("NotifyBaseUrl") + "/" + collegeSymbol + TRANSFORM_CALLBACK_URL);
//		}
//		return null;
//	}
//	
//	public static String tranform(String bucket, String key, String upToken, String destFormat, String notifyURL) throws QiniuException {
//		boolean force = true;
//		String pipeline = "";
//		
//		destFormat = StringUtils.isBlank(destFormat) ? DEFAULT_VIDEO_DEST_FORMAT : destFormat.trim();
//		
//		int lastDotIndex = key.lastIndexOf(".");
//		String newKey = key.substring(0, lastDotIndex) + "." + destFormat;
//		
//		StringMap params = new StringMap().putNotEmpty("notifyURL", notifyURL)
//				.putWhen("force", 1, force).putNotEmpty("pipeline", pipeline);
//		
//		String fops = "avthumb/" + destFormat + "/vcodec/libx264/acodec/libfaac/stripmeta/1";
//		fops += "|saveas/" + UrlSafeBase64.encodeToString(DEFAULT_BUCKET + ":" + newKey);
//		
//		String id = operationManager.pfop(bucket, key, fops, params);
//		logger.info("transform return id: " + id);
//		
//		try {
//			// delete src format resource
//			deleteResource(bucket, key);
//			
//		} catch (QiniuException e) {
//			Response response = e.response;
//			logger.error(response.toString());
//			try {
//				logger.error(response.bodyString());
//			} catch (QiniuException e1) {
//				
//			}
//		}
//		
//		return id;
//	}
//	

//	
//	public static String upload(byte[] data, String key, String upToken, String mimeType) throws QiniuException {
//		Response response = uploadManager.put(data, key, upToken, null, mimeType, false);
//		if(response.isOK()) {
//			return response.url();
//		}else {
//			logger.error(response.bodyString());
//		}
//		return null;
//	}
//	
//	public static void deleteCourseXml(String collegeSymbol, int courseId) throws QiniuException {
//		String resourceKey = String.format(XML_URL_FORMAT, collegeSymbol, courseId);
//		deleteResource(DEFAULT_BUCKET, resourceKey);
//	}
//	
//	public static void deleteVideo(String collegeSymbol, int courseId, String fileNameWithoutForamt, String format) throws IOException {
//		String resourceKey = String.format(VIDEO_URL_FORMAT, collegeSymbol, courseId, fileNameWithoutForamt, format);
//		if(format.toLowerCase().equals("m3u8")) {
//			deleteTsInM3u8(resourceKey);
//		}
//		deleteResource(DEFAULT_BUCKET, resourceKey);
//	}
//	
//	public static void deleteResource(String bucket, String key) throws QiniuException {
//		bucketManager.delete(bucket, key);
//	}
//	
//	public static void renameVideo(String collegeSymbol, int courseId, String srcName, String destName, String format) {
//		String srcKey = String.format(VIDEO_URL_FORMAT, collegeSymbol, courseId, srcName, format);
//		String destKey = String.format(VIDEO_URL_FORMAT, collegeSymbol, courseId, destName, format);
//		moveResource(DEFAULT_BUCKET, srcKey, DEFAULT_BUCKET, destKey);
//	}
//	
//	public static void moveResource(String bucket, String key, String destBucket, String destKey) {
//		try {
//			bucketManager.move(bucket, key, destBucket, destKey);
//		} catch (QiniuException e) {
//			try {
//				logger.error(e.response.bodyString());
//			} catch (QiniuException e1) {
//				
//			}
//		}
//	}
//	
//	public static void createEmptyFile(String buceket, String collegeSymbol, int courseId, String format) {
//		String resourceKey = String.format(EMPTY_FILE_FORMAT, collegeSymbol, courseId, format);
//		try {
//			upload(new byte[]{}, resourceKey, getUpTokenWithCallback(DEFAULT_BUCKET, resourceKey, collegeSymbol, UPLOAD_CALLBACK_URL), MIME_TYPE_VIDEO);
//		} catch (IOException e) {
//			logger.error(e.getMessage());
//		}
//	}
//	

//	
//	private static String getUpTokenWithCallback(String bucket, String key, String collegeSymbol, String callbackUrl) {
//		return auth.uploadToken(bucket, key, 3600, new StringMap()
//								.put("callbackUrl", ConfigManager.globalSetting().getSettingValue("NotifyBaseUrl") + "/" + collegeSymbol + callbackUrl)
//								.put("callbackBody", "key=$(key)&hash=$(etag)&persistentId=$(persistentId)"));
//	}
//	
//	
//	public static String sliceAndEncrypt(String bucket, String key, String collegeSymbol, int courseId, String m3u8Name, String notifyURL) throws QiniuException {
//		boolean force = true;
//		
//		StringMap params = new StringMap().putNotEmpty("notifyURL", notifyURL)
//				.putWhen("force", 1, force);
//		String fops = "avthumb/m3u8/segtime/15/hlsKey/" + UrlSafeBase64.encodeToString("1234567890abcdef") + "/hlsKeyUrl/" 
//				+ UrlSafeBase64.encodeToString(HLS_KEY_URL) + "/video_240k";
//		fops += "|saveas/" + UrlSafeBase64.encodeToString(DEFAULT_BUCKET + ":" + String.format(M3U8_URL_FORMAT, collegeSymbol, courseId, m3u8Name));
//		
//		String id = operationManager.pfop(bucket, key, fops, params);
//		return id;
//	}
//	
//	public static long calculateM3u8Size(String bucket, String key) throws IOException {
//		// 1. get tsKeys
//		List<String> tsKeyList = new ArrayList<String>();
//		String urlSigned = auth.privateDownloadUrl(QINIU_BASE_URL_STRING + key);
//		URL url = new URL(urlSigned);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setConnectTimeout(10000);
//		connection.setReadTimeout(30000);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		String line = null;
//		while((line = reader.readLine()) != null) {
//			if(line.startsWith("#EXTINF")) {
//				line = reader.readLine();
//				if(null != line) {
//					tsKeyList.add(line.substring(QINIU_BASE_URL_STRING.length(), line.length()));
//				}
//			}
//		}
//		
//		// 2. calculate size
//		if(tsKeyList.isEmpty()) {
//			return 0l;
//		}
//		
//		long totalSize = 0l;
//		for(String tsKey : tsKeyList) {
//			FileInfo fileInfo = bucketManager.stat(bucket, tsKey);
//			totalSize += fileInfo.fsize;
//		} 
//		
//		return totalSize;
//	}
//	
//	public static void deleteTsInM3u8(String key) throws IOException {
//		List<String> tsList = getTsList(key);
//		deleteTsList(tsList);
//	}
//	
//	private static List<String> getTsList(String key) throws IOException {
//		List<String> tsKeyList = new ArrayList<String>();
//		String urlSigned = auth.privateDownloadUrl(QINIU_BASE_URL_STRING + key);
//		URL url = new URL(urlSigned);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setConnectTimeout(10000);
//		connection.setReadTimeout(30000);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		String line = null;
//		while((line = reader.readLine()) != null) {
//			if(line.startsWith("#EXTINF")) {
//				line = reader.readLine();
//				if(null != line) {
//					tsKeyList.add(line.substring(QINIU_BASE_URL_STRING.length(), line.length()));
//				}
//			}
//		}		
//		return tsKeyList;
//	}
//
//	private static void deleteTsList(List<String> tsList) throws QiniuException {
//		for(String ts : tsList) {
//			deleteResource(DEFAULT_BUCKET, ts);
//		}
//	}

}
