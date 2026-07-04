import java.util.*;

public class TriesBasicOperations {
    //create Trie Node//
    static class TrieNode{
        TrieNode [] children = new TrieNode[26];
        boolean isEnd = false;
    }
    //create Trie//
    static class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
    
    //Insert//
    public void insert(String word){
        TrieNode curr =root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a' ;
            if(curr.children[idx] ==null){
                curr.children[idx] = new TrieNode();
            }
            curr =  curr.children[idx] ;
        }
        curr.isEnd = true;
    }
    //Search//
    public  boolean search(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a' ; 
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }
    //StartWIth//
    public  boolean StartWIth(String prifexString){
        TrieNode curr = root;
        for(char ch : prifexString.toCharArray()){
            int idx = ch - 'a' ;
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("apple");
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("ca"));
        System.out.println(trie.search("dog"));
        System.out.println();
        System.out.println(trie.StartWIth("ca"));
        System.out.println(trie.StartWIth("app"));
        System.out.println(trie.StartWIth("do"));
        
    }

}