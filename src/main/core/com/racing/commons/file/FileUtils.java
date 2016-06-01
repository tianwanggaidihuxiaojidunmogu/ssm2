package com.racing.commons.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

import org.springframework.util.StringUtils;

/**
 * 文件操作
 * 
 * @author Panda
 * 
 */
public class FileUtils {
	/**
	 * 字节读取，ByteArrayOutputStream
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static String readFile2Path(String path) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
		String readLine;
		String data = "";
		while ((readLine = br.readLine()) != null) {
			if (!StringUtils.isEmpty(readLine)) {
				data += readLine + "\r\n";
			}
		}
		return data;
	}

	/**
	 * 字节读取，ByteArrayOutputStream
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static byte[] readFile(File file) throws IOException {
		FileInputStream fis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(file);
			byte[] buff = new byte[1024];
			int byteRead = 0;
			while (-1 != (byteRead = fis.read(buff, 0, buff.length))) {
				baos.write(buff, 0, byteRead);
				System.out.println(baos);
			}
		} catch (IOException e) {
			throw new IOException("读取文件：" + file.getName() + " 出错了.");
		} finally {
			fis.close();
		}
		return baos.toByteArray();
	}

	/**
	 * 字节读取，ByteArrayOutputStream
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String readFile2String(File file) throws IOException {
		FileInputStream fis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(file);

			byte[] buff = new byte[1024];
			int byteRead = 0;

			while (-1 != (byteRead = fis.read(buff, 0, buff.length))) {
				baos.write(buff, 0, byteRead);
			}
		} catch (IOException e) {
			throw new IOException("读取文件：" + file.getName() + " 出错了.");
		} finally {
			fis.close();
		}
		return baos.toString();
	}

	/**
	 * 字节读取2，BufferedInputStream
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static byte[] readFile2(File file) throws IOException {
		FileInputStream fileInputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedInputStream bis = null;
		fileInputStream = new FileInputStream(file);
		bis = new BufferedInputStream(fileInputStream);
		int byteRead = 0;
		byte[] buff = new byte[1024];
		while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
			baos.write(buff, 0, byteRead);
			System.out.println(baos);
		}

		fileInputStream.close();
		bis.close();

		return baos.toByteArray();
	}

	/**
	 * 字节读取，ByteArrayOutputStream
	 * 
	 * @param pathname
	 *            文件绝对路径
	 * @return
	 * @throws Exception
	 */
	public static String readFile2String(String pathname) throws IOException {
		File file = new File(pathname);
		return readFile2String(file);
	}

	/**
	 * 将文件字节以‘.bak’备份，FileOutputStream
	 * 
	 * @param file
	 * @throws Exception
	 */
	public static void bakFile(File file) throws IOException {
		FileInputStream fiStream = null;
		FileOutputStream fos = null;

		fiStream = new FileInputStream(file);
		fos = new FileOutputStream(file.getPath() + file.getName() + ".bak");
		byte[] buff = new byte[1024];
		int byteRead = 0;
		while (-1 != (byteRead = fiStream.read(buff, 0, buff.length))) {
			fos.write(buff, 0, byteRead);
		}

		fiStream.close();
		fos.close();

	}

	/**
	 * 将文件以字节‘.bak’备份2,用随机写入方式！BufferedOutputStream
	 * 
	 * @param file
	 * @throws Exception
	 */
	public static void bakFile2(File file) throws IOException {
		FileInputStream fiStream = null;
		FileOutputStream fos = null;
		BufferedOutputStream boStream = null;
		fiStream = new FileInputStream(file);
		fos = new FileOutputStream(file.getName() + ".bak");
		boStream = new BufferedOutputStream(fos);
		byte[] buff = new byte[1024];
		int buffRead = 0;
		while (-1 != (buffRead = fiStream.read(buff, 0, buff.length))) {
			boStream.write(buff, 0, buffRead);
		}

		fiStream.close();
		fos.close();
		boStream.flush();
		boStream.close();

	}

	/**
	 * 新建文件,大小为1M
	 * 
	 * @param filepath
	 * @throws Exception
	 */
	public static void createFile(String filepath) throws IOException {
		File file = new File(filepath);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.setLength(1024 * 1024);
		raf.close();
	}

	/**
	 * 任意指定当前多件指针位置
	 * 
	 * @param filePath
	 * @param bytes
	 * @param readLength
	 * @param FinishedFileSize
	 * @throws Exception
	 */
	public static void writeIntoFile(String filePath, byte[] bytes, int readLength, int FinishedFileSize) throws IOException {
		File file = new File(filePath);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(FinishedFileSize);
		raf.write(bytes, 0, readLength);
		raf.close();
	}

	/**
	 * 以字节形式装文件sourceFile复制到文件destFile
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void copyFile(String sourceFile, String destFile) throws IOException {
		FileInputStream source_file = null;
		FileOutputStream dest_file = null;
		byte[] buffer = null;
		source_file = new FileInputStream(sourceFile);
		dest_file = new FileOutputStream(destFile);
		buffer = new byte[1024];
		int byteRead = 0;
		while (-1 != (byteRead = source_file.read(buffer, 0, buffer.length))) {
			dest_file.write(buffer, 0, byteRead);
		}
	}

	/**
	 * 根据路径删除文件
	 * 
	 * @param filePath
	 * @throws Exception
	 */
	public static void deleteFiles(String filePath) throws IOException {
		File file = new File(filePath);// 获取文件路径
		// 判断是文件还是目录
		if (file.exists() && file.isDirectory()) {
			if (file.listFiles().length == 0) {
				// 若没有文件可直接删除目录
				file.delete();
				System.out.println("直接删除目录：" + file.getPath() + file.getName());
			} else {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						// 递归调用删除方法并获取子目录
						System.out.println("归调用删除方法并获取子目录：" + files[i].getAbsolutePath());
						deleteFile(files[i].getAbsolutePath());
					}
					System.out.println("循环删除文件：" + files[i].getPath() + files[i].getName());
					files[i].delete();// 删除文件
				}
			}
			System.out.println("直接删除文件：" + file.getPath() + file.getName());
			deleteFiles(filePath);// 递归调用
		}
	}

	public static void deleteFile(String filePath) throws IOException {
		File file = new File(filePath);// 获取文件路径
		file.delete();
	}

	/**
	 * 拷文件以目录的方式
	 * 
	 * @param sourceFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyDirectory(String sourceFile, String destFile) throws IOException {
		File df = new File(destFile);
		File sf = new File(sourceFile);
		// 如果不存在就新建
		if (!df.exists()) {
			df.mkdirs();// 可新建多个目录
		}
		if (sf.isFile()) {
			FileInputStream fiStream = new FileInputStream(sf);
			FileOutputStream fos = new FileOutputStream(destFile + "/" + sf.getName());
			byte[] buffer = new byte[1024 * 5];
			int bufferRead = 0;
			while (-1 != (bufferRead = fiStream.read(buffer))) {
				fos.write(buffer, 0, bufferRead);
			}
			fos.flush();
			fos.close();
			fiStream.close();
		} else {
			File[] files = new File(sourceFile).listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
				if (files[i].isFile()) { // 如果是文件，复制文件到目录
					FileInputStream fiStream = new FileInputStream(files[i]);
					FileOutputStream fos = new FileOutputStream(destFile + "/" + files[i].getName());
					byte[] buffer = new byte[1024 * 5];
					int bufferRead = 0;
					while (-1 != (bufferRead = fiStream.read(buffer))) {
						fos.write(buffer, 0, bufferRead);
					}
					fos.flush();
					fos.close();
					fiStream.close();
				}
				if (files[i].isDirectory()) { // 如果是目录，，递归调用
					copyDirectory(sourceFile + "/" + files[i].getName(), destFile + "/" + files[i].getName());
				}
			}
		}
	}

	/**
	 * 获取目录占用的空间大小
	 * 
	 * @param pathName
	 * @return 字节数
	 */
	public static long getDirSize(String pathName) throws IOException {
		long size = -1;
		File file = new File(pathName);
		if (file.isFile()) {
			return file.length();
		} else {
			File[] childFiles = file.listFiles();
			for (int i = 0; i < childFiles.length; i++) {
				size += getDirSize(childFiles[i].getPath());
			}
			return size;
		}
	}

	public static void writeFileByMsg(String path, String fileName, String msg) throws IOException {
		FileWriter fw = new FileWriter(path + fileName);
		fw.write(msg, 0, msg.length());
		fw.flush();
		fw.close();
	}

	public static void writeFile2Content(String fileName, String content, String encoding) throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName,true), encoding);
		out.write(content);
		out.flush();
		out.close();
	}
}