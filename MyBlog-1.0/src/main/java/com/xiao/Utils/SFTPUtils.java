
package com.xiao.Utils;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * 
 * @ClassName: SFTPUtils
 * @Description: sftp连接工具类
 * @date 2017年5月22日 下午11:17:21
 * @version 1.0.0
 */
public class SFTPUtils {
	private transient Logger log = LoggerFactory.getLogger(this.getClass());

	private ChannelSftp sftp;

	private Session session;
	/** FTP 登录用户名 */
	private String username;
	/** FTP 登录密码 */
	private String password;
	/** 私钥 */
	private String privateKey;
	/** FTP 服务器地址IP地址 */
	private String host;
	/** FTP 端口 */
	private int port;

	/**
	 * 构造基于密码认证的sftp对象
	 * 
	 * @param userName
	 * @param password
	 * @param host
	 * @param port
	 */
	public SFTPUtils(String username, String password, String host, int port) {
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}

	/**
	 * 构造基于秘钥认证的sftp对象
	 * 
	 * @param userName
	 * @param host
	 * @param port
	 * @param privateKey
	 */
	public SFTPUtils(String username, String host, int port, String privateKey) {
		this.username = username;
		this.host = host;
		this.port = port;
		this.privateKey = privateKey;
	}

	public SFTPUtils() {
	}

	/**
	 * 连接sftp服务器
	 * 
	 * @throws Exception
	 */
	public void login() {
		try {
			JSch jsch = new JSch();
			if (privateKey != null) {
				jsch.addIdentity(privateKey);// 设置私钥
				log.info("sftp connect,path of private key file：{}", privateKey);
			}
			log.info("sftp connect by host:{} username:{}", host, username);

			session = jsch.getSession(username, host, port);
			log.info("Session is build");
			if (password != null) {
				session.setPassword(password);
			}
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");

			session.setConfig(config);
			session.connect();
			log.info("Session is connected");

			Channel channel = session.openChannel("sftp");
			channel.connect();
			log.info("channel is connected");

			sftp = (ChannelSftp) channel;
			log.info(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port));
		} catch (JSchException e) {
			log.error("Cannot connect to specified sftp server : {}:{} \n Exception message is: {}",
					new Object[] { host, port, e.getMessage() });
		}
	}

	/**
	 * 关闭连接 server
	 */
	public void logout() {
		if (sftp != null) {
			if (sftp.isConnected()) {
				sftp.disconnect();
				log.info("sftp is closed already");
			}
		}
		if (session != null) {
			if (session.isConnected()) {
				session.disconnect();
				log.info("sshSession is closed already");
			}
		}
	}

	/**
	 * 将输入流的数据上传到sftp作为文件
	 * 
	 * @param directory
	 *            上传到该目录
	 * @param sftpFileName
	 *            sftp端文件名
	 * @param in
	 *            输入流
	 * @throws SftpException
	 * @throws Exception
	 */
	public void upload(String directory, String sftpFileName, InputStream input) throws SftpException {
		try {
			sftp.cd(directory);
		} catch (SftpException e) {
			log.warn("directory is not exist");
			sftp.mkdir(directory);
			sftp.cd(directory);
		}
		sftp.put(input, sftpFileName);
		log.info("file:{} is upload successful", sftpFileName);
	}

}
