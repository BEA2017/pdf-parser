import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	PdfHandler handler;
	
	public Main(String path) {
		handler=new PdfHandler(path);
		
	}

	public static void main(String[] args) throws IOException {
		
		System.out.println("Insert path to a file");
		Scanner scanner=new Scanner(System.in);
		String path=scanner.nextLine();
		
		Main parser=new Main(path);
		
		System.out.println("Enter search criteria in the following format: Маршрут изменен, Окрашивание");
		String queries=scanner.nextLine();
		List<String> queryList=StringHandler.getListFromString(queries, ",");
			
		Map<String, List<Integer>> cardsMap=parser.getAllCardsContaining(queryList);
			
		List<Integer> result=CollectionsHandler.getIntersection(cardsMap);
		
		System.out.println("Total count: "+result.size());
		System.out.println(result);	
		
	}
	
	public Map<String, List<Integer>> getAllCardsContaining(List<String> queryList){

		Map<String, List<Integer>> queryResult=new HashMap<String, List<Integer>>();
		
		int numPages=handler.getNumPages();
		
		for(int i=1;i<=numPages;i++) {
			
			String pageText=handler.getStringFromPdf(i);
			
			for(int j=0;j<queryList.size();j++) {
				String query=queryList.get(j);
				
				if(CardHandler.contains(query, pageText)) {
					Integer cardNum=CardHandler.getCardNumber(pageText);
					List<Integer> resultsMatchingConcreteQuery=queryResult.get(query);
					if(resultsMatchingConcreteQuery==null) {
						resultsMatchingConcreteQuery=new ArrayList<Integer>();
					}
					resultsMatchingConcreteQuery.add(cardNum);
					resultsMatchingConcreteQuery.sort(null);
					queryResult.put(query, resultsMatchingConcreteQuery);
						
				}
			}
							
		}
		return queryResult;
	}
	

}
