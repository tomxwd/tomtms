package top.tomxwd.tms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UpLoadUtils {
	
	@Value("${FTP_HOST}")
	private String FTP_HOST;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USER}")
	private String FTP_USER;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_URL}")
	private String FTP_BASE_URL;
	@Value("${USER_HEADIMG}")
	private String USER_HEADIMG;
	@Value("${DRIVER_HEADIMG}")
	private String DRIVER_HEADIMG;
	@Value("${CAR_IMG}")
	private String CAR_IMG;
	@Value("${NOTIC_IMG}")
	private String NOTIC_IMG;
	@Value("${ACESS_BASE_URL}")
	private String ACESS_BASE_URL;
	
	public String UpLoadNoticeImg(MultipartFile file) {
		return this.uploadNormal(NOTIC_IMG, file);
	}
	
	public String UpLoadCarImg(MultipartFile file) {
		return this.uploadNormal(CAR_IMG, file);
	}
	
	public String UpLoadUserHeadImg(MultipartFile file) {
		return this.uploadNormal(USER_HEADIMG, file);
	}
	
	public String UpLoadDriverHeadImg(MultipartFile file) {
		return this.uploadNormal(DRIVER_HEADIMG, file);
	}
	
	private String uploadNormal(String dir,MultipartFile file) {
		String newFileName = "";
		String returnFileName = "";
		//1.建立和服务端的链接
		FTPClient client = new FTPClient();
		try {
			client.connect(FTP_HOST, FTP_PORT);
			//2.身份认证
			client.login(FTP_USER, FTP_PASSWORD);
			//3.改变上传路径
			client.changeWorkingDirectory(FTP_BASE_URL+dir);
			//4.指定文件上传的方式 二进制字节
			client.setFileType(FTP.BINARY_FILE_TYPE);
			//5.指定被动模式上传
			client.enterLocalPassiveMode();
			String fileName = UUID.randomUUID().toString().replaceAll("-", "");
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());// jpg , png 等等
			// 创建新的文件名称
			newFileName = "tomxwd"+fileName + "." + extension;
			boolean flag = client.storeFile(newFileName, file.getInputStream());
			if(flag) {
				System.out.println("上传成功");
				returnFileName = ACESS_BASE_URL+dir+"/"+newFileName;
			}else {
				System.out.println("上传失败");
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnFileName;
	}
	
	
	/**
	 * 传入一个位置，以及需要上传的文件
	 * @param headFiles
	 * @return
	 */
	public static String[] UpLoadFile(String savePath,MultipartFile[] headFiles) {
//		String savePath = ""+System.getProperty("user.dir")+"/src/main/webapp/resources/upload";
		String[] nameArray = new String[headFiles.length];
		// 创建一个磁盘目录用于保存文件
		File destFile = new File(savePath);
		if (!destFile.exists()) {
			destFile.mkdir();
		}
		for (int i = 0; i < headFiles.length; i++) {
			MultipartFile headFile = headFiles[i];
			// 使用uuid作为文件随机名称
			String fileName = UUID.randomUUID().toString().replaceAll("-", "");
			// 使用FileNameUtils获取上传文件名的后缀
			String extension = FilenameUtils.getExtension(headFile.getOriginalFilename());// jpg , png 等等
			if(extension.equals("")) {
				continue;
			}
			// 创建新的文件名称
			String newFileName = "tomxwd"+fileName + "." + extension;
			// 创建要保存文件的File对象
			File file = new File(destFile, newFileName);
			// 保存文件到本地磁盘
			try {
				headFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			nameArray[i]=newFileName;
		}
		return nameArray;
	}
	
	
	/**
	 * 单个文件上传
	 */
	public static String UpLoadFile(String savePath,MultipartFile headFile) {
//		String savePath = ""+System.getProperty("user.dir")+"/src/main/webapp/";
		String newFileName =null;
		/*String[] nameArray = new String[headFile.length];*/
		// 创建一个磁盘目录用于保存文件
		File destFile = new File(savePath);
		if (!destFile.exists()) {
			destFile.mkdir();
		}
			// 使用uuid作为文件随机名称
			String fileName = "tomxwd"+UUID.randomUUID().toString().replaceAll("-", "");
			// 使用FileNameUtils获取上传文件名的后缀
			String extension = FilenameUtils.getExtension(headFile.getOriginalFilename());// jpg , png 等等
	
			// 创建新的文件名称
			 newFileName = fileName + "." + extension;
			// 创建要保存文件的File对象
			File file = new File(destFile, newFileName);
			// 保存文件到本地磁盘
			try {
				headFile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		return newFileName;
	}
	
	
//	@RequestMapping(value="/fileUpLoadTest",method=RequestMethod.POST)
//	@ResponseBody
//	public MsgObj fileUpLoadTest(HttpServletRequest req) {
//		//判断req是否合法，表单为Post，contentType必须为multipart/开头
//		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
//		if(isMultipart) {
//			try {
//				//创建一个处理FileItem的工程对象，可以处理基本磁盘（不能处理文件上传）
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//				//创建一个新的文件上传处理器（基于基本的工厂对象）：装饰者（包装）设计模式
//				ServletFileUpload fileUpload = new ServletFileUpload(factory);
//				//解析请求
//				List<FileItem> list = fileUpload.parseRequest(req);
//				for (FileItem item : list) {
//					if(item.isFormField()) {
//						//普通表单元素
//						String value = item.getString("utf-8");
//					}else {
//						//文件上传
//						//System.out.println("file:"+item);
//						//获取文件的名称
//						String name = item.getName();
//						String extension = FilenameUtils.getExtension(name);
//						//用UUID来生成32位随机数，全球唯一
//						String targetName = ("tomxwd"+UUID.randomUUID().toString()+"."+extension).replaceAll("-", "");
//						//获取文件的输入流
//						InputStream inputStream = item.getInputStream();
//						//确定磁盘上是否有这个路径文件夹
//						File target = new File("/Users/xieweicong/Desktop/上传文件");
//						if(!target.exists()) {
//							target.mkdir();
//						}
//						
//						//创建一个输出流
//						FileOutputStream outputStream = new FileOutputStream(new File(target,targetName));
//						//将流保存到另一个位置
//						int copy = IOUtils.copy(inputStream, outputStream);
//					}
//				}
//				
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
//		
//		return null;
//	}
	
}
