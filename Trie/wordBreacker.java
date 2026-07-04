import java.util.*;
public class wordBreacker {
    static class Node{
        Node[] children;
        boolean eow;
        Node(){
            children = new Node[26];
            for(int i = 0 ; i < children.length; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    //insert//
    static Node  root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i = 0 ; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
//Search//
public static boolean search(String key){
    Node curr = root;
        for(int i = 0 ; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
}
public static boolean wordBreak(String str){
    if(str.length()==0){
        return true;
    }
     for(int i = 1 ; i <= str.length() ; i++){
            String firstpart = str.substring(0,i);
            String secondpart = str.substring(i);
            if(search(firstpart) &&  wordBreak(secondpart)){
                return true ;
            }
        }
                return false;
}
    public static void main(String[] args) {
        String [] word = {"i","like","sam","samsung","mobile","ice"};
        String key ="ilikesamsung";
        for(int i = 0 ; i < word.length;i++){
            insert(word[i]);
        }
        System.out.println(wordBreak(key));
    }
}