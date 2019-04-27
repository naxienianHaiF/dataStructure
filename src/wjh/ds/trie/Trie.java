package wjh.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie树，又叫字典树、前缀树（Prefix Tree）、单词查找树 或 键树， 是一种多叉树结构。
 * 
 * @author JHW
 * @version 1.0.0
 */
public class Trie {

	private Node root;

	public Trie() {
		root = new Node();
	}

	public void add(String string) {
		Node cur = root;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
	}

	public boolean contains(String word) {
		boolean flag = true;
		Node cur = root;
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		
		return flag;
	}
	
	class Node {
		Map<Character, Node> next;

		public Node() {
			next = new HashMap<>();
		}

	}
}
