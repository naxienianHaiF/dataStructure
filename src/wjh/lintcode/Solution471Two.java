package wjh.lintcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @see Solution471
 * @author JHW
 *
 */
public class Solution471Two {

	  /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
    	if (words == null || words.length == 0) {
			return null;
		}
    	
    	Map<String, Integer> map = new HashMap<>();
    	for (String key: words) {
    		if (map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
    	}
    	
    	PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o1) - map.get(o2) == 0) {
					return o2.compareTo(o1);
				}
				return map.get(o1) - map.get(o2);
			}
		});
    	
    	for (String key : map.keySet()) {
    		System.out.println(key+","+map.get(key));
    		if (queue.size() < k) {
				queue.add(key);
			} else if (map.get(key).compareTo(map.get(queue.peek()))>0) {
				queue.poll();
				queue.add(key);
			} else if (map.get(key).compareTo(map.get(queue.peek())) == 0) {
				if (key != null && key.compareTo(queue.peek()) <0) {
					queue.poll();
					queue.add(key);
				}

			}
    	}
    	
    	String[] result = new String[k];
    	for (int i=0; i< k; i++) {
    		result[k-1-i] = queue.poll();
    	}
    	
    	System.out.println(">>>>>>>>");
    	for (String s: result) {
    		System.out.println(s);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		Solution471Two solution = new Solution471Two();
		
		int k = 10;
		String[] words = {"da","bd","cd","ce","fb","fb","af","dc","ca","bc","db","bc","ce","eb","db","fa","df","ca","df","bc","fd","bd","fa","be","de","cf","fb","ec","ea","ad","dc","cf","fc","ef","fa","ec","cf","df","df","eb","cb","ed","db","ed","ac","be","af","ab","cf","fd","af","ce","ae","fd","ce","ac","ae","db","bd","bf","be","fe","af","ea","cb","cf","dc","eb","cd","ea","fc","ed","ce","dc","ab","da","dc","fa","ed","ec","bd","bf","de","df","ab","cd","cd","da","bf","fb"};
		solution.topKFrequentWords(words, k);
	}
}
