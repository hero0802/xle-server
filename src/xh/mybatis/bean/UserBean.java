package xh.mybatis.bean;

public class UserBean {
	private int UserID;//用户ID
	private int GameID;//游戏ID
	private int SpreaderID;//代理ID
	private String Accounts;//账户
	private String NickName;//昵称
	private int PlayTimeCount=0;//游戏时间
	private int OnLineTimeCount=0;//在线时长
	private int Score=0;//总盈利
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getGameID() {
		return GameID;
	}
	public void setGameID(int gameID) {
		GameID = gameID;
	}
	public int getSpreaderID() {
		return SpreaderID;
	}
	public void setSpreaderID(int spreaderID) {
		SpreaderID = spreaderID;
	}
	public String getAccounts() {
		return Accounts;
	}
	public void setAccounts(String accounts) {
		Accounts = accounts;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public int getPlayTimeCount() {
		return PlayTimeCount;
	}
	public void setPlayTimeCount(int playTimeCount) {
		PlayTimeCount = playTimeCount;
	}
	public int getOnLineTimeCount() {
		return OnLineTimeCount;
	}
	public void setOnLineTimeCount(int onLineTimeCount) {
		OnLineTimeCount = onLineTimeCount;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	
	

}
