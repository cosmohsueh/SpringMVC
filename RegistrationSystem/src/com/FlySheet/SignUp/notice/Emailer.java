package com.FlySheet.SignUp.notice;

import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import config.Configuration;

public final class Emailer extends Thread {

	private static final Logger LOGGER = LoggerFactory.getLogger(Emailer.class);
	
	private final String MAIL_CONFIG = "/config/mailconfig.properties";

	private String server = "";
	private String port = "25";
	private String username = "";
	private String password = "";
	private String from = "";
	private String protocol = "smtp";
	private String debug;
	private String htmlTextMessage;
	private String subject;
	private String to;
	
	public Emailer() {
        Configuration cfg = new Configuration(MAIL_CONFIG);
        setServer(cfg.get("server").trim());
        setPort(cfg.get("port").trim());
        setUsername(cfg.get("username").trim());
        setPassword(cfg.get("password").trim());
        setFrom(cfg.get("from").trim());
        setProtocol(cfg.get("protocol").trim());
        setDebug(cfg.get("debug").trim());
    }

	public void sendEmail() throws Exception {

		if (checkString(to) && checkString(from)) {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", protocol);

			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.user", username);
			props.put("mail.smtp.host", server);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.quitwait", "false");

			Session session = null;

			if (username != null && username.length() > 0 
			        && password != null && password.length() > 0) {
				Authenticator authenticator = new javax.mail.Authenticator() {
					@Override
					public javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(username, password);
					}
				};
				session = Session.getInstance(props, authenticator);
			} else {
				session = Session.getInstance(props, null);
			}
			
			if (debug.equalsIgnoreCase("true")) {
                session.setDebug(true);
            }

			MimeMessage message = new MimeMessage(session);
			message.setSubject(subject, "UTF-8");
			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO, loadAddresses(to));

			MimeMultipart multipart = new MimeMultipart();

			if (htmlTextMessage != null) {
				try {
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					String processedContent = processString(htmlTextMessage);
					messageBodyPart.setContent(processedContent, "text/html");
					messageBodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
					messageBodyPart.setHeader("Content-Transfer-Encoding", "base64");
					multipart.addBodyPart(messageBodyPart);
				} catch (MessagingException ex) {
					ex.printStackTrace();
				}
			}

			message.setContent(multipart);

			try {
				Transport trans = session.getTransport(protocol);
//				trans.connect(server, Integer.parseInt(port), username, password);
//				Transport.send(message);
				trans.close();
				LOGGER.info("mail to:" + to + " subject:" + subject + " content:" + htmlTextMessage);
			} catch (javax.mail.MessagingException sslHandshake) {
				LOGGER.error(sslHandshake.getMessage(), sslHandshake);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}

		}
	}

	@Override
	public void run() {
		try {
			sendEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean checkString(String arg0) {
		boolean rv = false;
		if (arg0 != null && arg0.length() > 0) {
			rv = true;
		}
		return rv;
	}

	private Address[] loadAddresses(String emails) throws AddressException {
		StringTokenizer tokenizer = new StringTokenizer(emails, ";");
		Address[] array = new InternetAddress[tokenizer.countTokens()];
		int idx = 0;
		while (tokenizer.hasMoreTokens()) {
			array[idx] = new InternetAddress(tokenizer.nextToken().trim());
			idx++;
		}
		return array;
	}

	private String processString(String arg0) {
		String returnValue = "";
		for (int i = 0; i < arg0.length(); ++i) {
			String checkArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+-*/|\\=-09*&^%$#@!><.,';:\"? ";
			char value = arg0.charAt(i);
			if (checkArray.indexOf(value) == -1) {
				returnValue = returnValue + "&#" + arg0.codePointAt(i) + ";";
			} else {
				returnValue = returnValue + value;
			}
		}

		return returnValue;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String isDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public String getHtmlTextMessage() {
		return htmlTextMessage;
	}

	public void setHtmlTextMessage(String htmlTextMessage) {
		this.htmlTextMessage = htmlTextMessage;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
