package top.tomxwd.tms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FTPUtils {
	
	
	
	public static void main(String[] args) {
		//1.建立和服务端的链接
		FTPClient client = new FTPClient();
		try {
			client.connect("120.79.145.202", 21);
			//2.身份认证
			client.login("ftpuser", "0O0OToM");
			//3.改变上传路径
			client.changeWorkingDirectory("/home/ftpuser/tms/headImg/");
			File file = new File("/Users/xieweicong/Desktop/taxi.jpg");
			//4.指定文件上传的方式 二进制字节
			client.setFileType(FTP.BINARY_FILE_TYPE);
			//5.指定被动模式上传
			client.enterLocalPassiveMode();
			boolean flag = client.storeFile("test1.jpg", new FileInputStream(file));
			if(flag) {
				System.out.println("上传成功");
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
	}
}
