import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionsHandler {

	public static List<Integer> getIntersection(Map<String, List<Integer>> map){
		List<Integer> result=new ArrayList<Integer>();
		Map.Entry<String, List<Integer>> shortestListEntry=getShortestList(map);
		
		List<Integer> minList=map.get(shortestListEntry.getKey());
		map.remove(shortestListEntry.getKey());
		
		Collection<List<Integer>> listsToIntersect=map.values();
		
		for(int i=0;i<minList.size();i++) {
			Integer value=minList.get(i);
			result.add(value);
			Iterator<List<Integer>> iterator=listsToIntersect.iterator();
			while(iterator.hasNext()) {
				List<Integer> concreteList=iterator.next();
				if(!concreteList.contains(value)) {
					result.remove(value);
					break;
				}
			}
			
		}
		result.sort(null);
		return result;
		
	}
	
	public static Map.Entry<String, List<Integer>> getShortestList(Map<String, List<Integer>> map) {
		Iterator<Entry<String, List<Integer>>> iterator=map.entrySet().iterator();
		Map.Entry<String, List<Integer>> shortestListEntry=null;
		int minLength=Integer.MAX_VALUE;
		
		while(iterator.hasNext()) {
			Map.Entry<String, List<Integer>> entry=(Map.Entry<String, List<Integer>>)iterator.next();
			int length=entry.getValue().size();
			if(length<minLength) {
				minLength=length;
				shortestListEntry=entry;
			}
		}
		return shortestListEntry;
	}
	
}
