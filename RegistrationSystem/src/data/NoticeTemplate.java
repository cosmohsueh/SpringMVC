package data;

import java.io.Serializable;

/**
 * 通知單範本
 * 
 * @author cosmo
 *
 */
public class NoticeTemplate implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer noticeId;
	private Integer sessionId;

	/**
	 * 1:報到通知 2:率取通知 3:行前通知
	 */
	private Integer noticeType;

	private String subject;

	private String content;

	public NoticeTemplate(Integer noticeId, Integer sessionId,
			Integer noticeType, String subject, String content) {
		this.noticeId = noticeId;
		this.sessionId = sessionId;
		this.noticeType = noticeType;
		this.subject = subject;
		this.content = content;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
