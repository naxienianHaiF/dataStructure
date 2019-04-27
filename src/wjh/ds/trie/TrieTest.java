package wjh.ds.trie;

public class TrieTest {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("abc");
		trie.add("bc");
		
		System.out.println(trie.contains("ac"));
	}
}
