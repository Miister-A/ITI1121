public class NewsFeed {
	
	private Post[] messages;
	private int size = 0;
	private int initialCapacity = 25;
	private int capacityIncrement = 25;
	
	public NewsFeed() {	
		messages = new Post[initialCapacity];
	}
	
	public NewsFeed(int initialCapacity, int capacityIncrement) {
		
		
		this.initialCapacity = initialCapacity;
		this.capacityIncrement = capacityIncrement;
		messages = new Post[initialCapacity];
	}
	
	public void add(Post message) {
		if (size >= initialCapacity) {
			System.out.println("size reached, dynamic array functionality currently commented out");
			return;
		}
		messages[size] = message;
		size++;
	}
	
	public Post get(int index) {
		return messages[index];
	}
	
	public int size() {
		return size;
	}
	
	public void sort(){
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}
			tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}
	}
	
	public NewsFeed getPhotoPost() {
		NewsFeed photos = new NewsFeed();
		for (int i = 0; i < size; i++) {
			if (messages[i] instanceof PhotoPost) {
				photos.add(messages[i]);
			}
		}
		return photos;
	}
	
	public NewsFeed plus(NewsFeed other) {
		NewsFeed feed = new NewsFeed();
		for (int i = 0; i < size; i++) {
			feed.add(messages[i]);
		}
		for (int i = 0; i < other.size(); i++) {
			feed.add(other.get(i));
		}
		feed.sort();
		return feed;
	}
}
