package com.racing.commons.socket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.racing.commons.file.FileUtils;

public class SocketClient {
	private static Logger logger = Logger.getLogger(SocketClient.class);

	private String host;
	private int port;

	public SocketClient(String _host, int _port) {
		host = _host;
		port = _port;
	}

	public String sendMsg(String pathName, String msg) throws UnknownHostException, IOException, InterruptedException {
		File file=new File(pathName);
		if(file.exists())
			file.delete();
		
		logger.info("发送报文信息：\n" + msg);
		String message = null;
		Socket socket = new Socket(host, port);
		socket.setSoTimeout(12000);
		OutputStream socketOut = socket.getOutputStream();
		socketOut.write(msg.getBytes("UTF-8"));
		BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
		int iLen = -1;
		int Itry = 0;
		// 每秒递增获得数据,尝试30次
		while (Itry < 30) {
			iLen = in.available();
			if (iLen <= -1)
				break;
			if (iLen >= 8) {
				byte[] b = new byte[8];
				in.read(b, 0, 8);
				String result = new String(b);
				logger.info("code:"+result);
				int receiveLen = Integer.parseInt(result);
				if (receiveLen <= 0) {
					logger.info("Nothing receive!");
					break;
				} else {
					byte[] c = new byte[receiveLen];
					in.read(c, 0, receiveLen);
					String receiveStr = new String(c, "UTF-8");;
					logger.info("content:"+receiveStr);
					FileUtils.writeFile2Content(pathName, receiveStr, "GBK");
					message=receiveStr;
					socket.close();
					break;
				}
			}
			TimeUnit.SECONDS.sleep(1);
			Itry++;
			logger.info("循环获取报文返回数据中...");
		}
		socket.close();
		return message;
	}
	
	public String sendMsg(String pathName, String msg,int ItryMax) throws UnknownHostException, IOException, InterruptedException {
		File file=new File(pathName);
		if(file.exists())
			file.delete();
		
		logger.info("发送报文信息：\n" + msg);
		String message = null;
		Socket socket = new Socket(host, port);
		socket.setSoTimeout(12000);
		OutputStream socketOut = socket.getOutputStream();
		socketOut.write(msg.getBytes("UTF-8"));
		BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
		int iLen = -1;
		int Itry = 0;
		// 每秒递增获得数据,尝试30次
		while (Itry < ItryMax) {
			iLen = in.available();
			if (iLen <= -1)
				break;
			if (iLen >= 8) {
				byte[] b = new byte[8];
				in.read(b, 0, 8);
				String result = new String(b);
				logger.info("code:"+result);
				int receiveLen = Integer.parseInt(result);
				if (receiveLen <= 0) {
					logger.info("Nothing receive!");
					break;
				} else {
					byte[] c = new byte[receiveLen];
					in.read(c, 0, receiveLen);
					String finalResult = new String(c);
					String receiveStr = new String(finalResult.getBytes(), "UTF-8");
					logger.info("content:"+receiveStr);
					FileUtils.writeFile2Content(pathName, receiveStr, "GBK");
					message=receiveStr;
					socket.close();
					break;
				}
			}
			TimeUnit.SECONDS.sleep(1);
			Itry++;
			logger.info("循环获取报文返回数据中...");
		}
		socket.close();
		return message;
	}
}
