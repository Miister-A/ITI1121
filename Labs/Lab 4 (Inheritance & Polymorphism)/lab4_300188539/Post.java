import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {
	protected int likes;
	private Date timeStamp;
	private String userName;

	public Post(String userName) {
		this.userName = userName;
		timeStamp = Calendar.getInstance().getTime();
	}
	
	public String getUserName() {
		
		return userName;
	}
	
	public Date getTimeStamp() {
		
		return timeStamp;
	}
	
	@Override
	public String toString() {
		
		String str = new String();
		str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
		return str;
	}
	
	@Override
	public int compareTo(Post other){
		int delta = other.getLikes() - likes;
		return delta == 0 ? timeStamp.compareTo(other.getTimeStamp()) : delta;
	}
	
	public boolean isPopular(){
		
		return likes > 100;
	}
	
	@Override
	public void like() {
		
		likes++;
	}
	
	@Override
	public int getLikes() {
		
		return likes;
	}
}
