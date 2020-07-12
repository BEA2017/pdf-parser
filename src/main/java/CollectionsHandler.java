import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionsHandler {

	public static List<Integer> getIntersection(Map<String, Set<Integer>> map){
		List<Integer> result=new ArrayList<Integer>();
		Map.Entry<String, Set<Integer>> shortestSetEntry=getShortestSet(map);
		
		Set<Integer> minSet=map.get(shortestSetEntry.getKey());
		map.remove(shortestSetEntry.getKey());
		
		Collection<Set<Integer>> setsToIntersect=map.values();
		Iterator<Integer> setIterator=minSet.iterator();
		
		while(setIterator.hasNext()) {
			
			Integer value=setIterator.next();
			result.add(value);
			Iterator<Set<Integer>> iterator=setsToIntersect.iterator();
			while(iterator.hasNext()) {
				Set<Integer> concreteSet=iterator.next();
				if(!concreteSet.contains(value)) {
					result.remove(value);
					break;
				}
			}
			
		}
		result.sort(null);
		return result;
		
	}
	
	public static Map.Entry<String, Set<Integer>> getShortestSet(Map<String, Set<Integer>> map) {
		Iterator<Entry<String, Set<Integer>>> iterator=map.entrySet().iterator();
		Map.Entry<String, Set<Integer>> shortestSetEntry=null;
		int minLength=Integer.MAX_VALUE;
		
		while(iterator.hasNext()) {
			Map.Entry<String, Set<Integer>> entry=(Map.Entry<String, Set<Integer>>)iterator.next();
			int length=entry.getValue().size();
			if(length<minLength) {
				minLength=length;
				shortestSetEntry=entry;
			}
		}
		return shortestSetEntry;
	}
	
}
