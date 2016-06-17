package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestException;
import java.security.MessageDigest;


public class CopyFile {
	private File file = null ;
	private String Md5Sum = null ;
	private String SHA1Sum = null ;
	private Long Size = null ;
	
	public CopyFile(File file) {
		this.file = file ;
		this.Md5Sum = setMd5SHA1("MD5") ;
		this.SHA1Sum = setMd5SHA1("SHA-1");
		this.Size = getSize();
	}
	
	public String getMd5Sum() {
		return Md5Sum;
	}
	
	public String getSHA1Sum() {
		return SHA1Sum;
	}
	
	
	public Long getSize() {
		return Size ;
	}


	public long setSize() {
		if (!file.exists() || !file.isFile()) {
			System.out.println(file.toString() + "open error!!");
			return 0L ;
		}
		return file.length();
	
	}


	public String setMd5SHA1 (String algorithm) {
		byte buffer[] = new byte[8192] ;
		int len ;
		BigInteger bigInt = null ;
		FileInputStream in = null ;
		String Alg = algorithm ;
		
		try {
			MessageDigest digest = MessageDigest.getInstance(Alg) ;
			in = new FileInputStream(file) ;
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer,0,len);
			}
			bigInt = new BigInteger(1,digest.digest());
			return bigInt.toString(16);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		} finally {
			try {
				in.close() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
