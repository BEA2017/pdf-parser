
public class CardHandler {
	
	public static Integer getCardNumber(String pageText){
		String cardString=StringHandler.getSubstring(".+Сопроводительная карта № [0-9]+", pageText);
		Integer cardNum=Integer.valueOf(StringHandler.getSubstring("\\d+", cardString));
		return cardNum;
	}
	
	public static boolean contains(String word, String pageText) {
		return StringHandler.contains(word, pageText);
	}

}
