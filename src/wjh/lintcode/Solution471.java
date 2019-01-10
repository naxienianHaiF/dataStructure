package wjh.lintcode;

import java.util.HashMap;
import java.util.Map;

import wjh.ds.queue.PriorityMyQueue;

/**
 * <a>https://www.lintcode.com/problem/top-k-frequent-words/description</a>
 * 
 * @author JHW
 *
 */
public class Solution471 {

	class Word implements Comparable<Word>{
		String key;
		int feq;
		
		public Word() {}

		public Word(String key, int feq) {
			super();
			this.key = key;
			this.feq = feq;
		}

		//如果当前值的频率小于 o， 则返回大于0的值
		//让最小的值在堆顶
		@Override
		public int compareTo(Word o) {
			if (o.feq == this.feq) {
				return this.key.compareTo(o.key);
			}
			return o.feq - this.feq;
		}
		
	}
	
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
    	
    	PriorityMyQueue<Word> queue = new PriorityMyQueue<>(Word.class, words.length);
    	for (String key : map.keySet()) {
    		System.out.println(key+","+map.get(key));
    		if (queue.size() < k) {
				queue.add(new Word(key, map.get(key)));
			} else if (queue.peek().feq < map.get(key)) {
				queue.poll();
				queue.add(new Word(key, map.get(key)));
			} else if (queue.peek().feq - map.get(key) == 0) {
				if (key != null && key.compareTo(queue.peek().key) < 0) {
					queue.poll();
					queue.add(new Word(key, map.get(key)));
				}
			}
    	}
    	String[] result = new String[k];
    	for (int i=0; i< k; i++) {
    		result[k-1-i] = queue.poll().key;
    	}
    	System.out.println(">>>>>>>>");
    	for (String s: result) {
    		System.out.println(s);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		Solution471 solution = new Solution471();
		
		int k = 10;
		String[] words = {"da","bd","cd","ce","fb","fb","af","dc","ca","bc","db","bc","ce","eb","db","fa","df","ca","df","bc","fd","bd","fa","be","de","cf","fb","ec","ea","ad","dc","cf","fc","ef","fa","ec","cf","df","df","eb","cb","ed","db","ed","ac","be","af","ab","cf","fd","af","ce","ae","fd","ce","ac","ae","db","bd","bf","be","fe","af","ea","cb","cf","dc","eb","cd","ea","fc","ed","ce","dc","ab","da","dc","fa","ed","ec","bd","bf","de","df","ab","cd","cd","da","bf","fb"};
//		String[] words = {"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"};
		solution.topKFrequentWords(words, k);
	}
}
