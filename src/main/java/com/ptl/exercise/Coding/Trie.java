package com.ptl.exercise.Coding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TrieNode {

    private static final int LENGTH = 'z' - 'A' + 1; //
    TrieNode[] children;
    boolean isLeaf; //check if current node has no children (all children null)

    public TrieNode() { //every node has 26 children, for instance, if current is A, children can be Aa, Ab, Ac... Az
        children = new TrieNode[LENGTH];
        isLeaf = false;
    }

}

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(); //root is always empty
    }

    public void add(String name) {
        TrieNode temp = root;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (temp.children[c - 'A'] == null) {
                temp.children[c - 'A'] = new TrieNode();
            }
            temp = temp.children[c - 'A'];
        }
        temp.isLeaf = true;
    }

    //find all strings match given prefix
    public List<String> search(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.children[c - 'A'] == null) {
                return result; //no found with prefix
            } else {
                temp = temp.children[c - 'A'];
            }
        }
        if (temp.isLeaf) { //no more children, only one word = prefix
            result.add(prefix);
        } else {
            //handle children
            List<String> tempResult = new ArrayList<>();
            printTrie(temp, tempResult, new StringBuilder());
            result = tempResult.stream().map(s -> prefix + s).collect(Collectors.toList());
        }
        return result;
    }

    public List<String> printAllTrie() {
        List<String> result = new ArrayList<>();
        printTrie(root, result, new StringBuilder());
        return result;
    }

    public void printTrie(TrieNode node, List<String> result, StringBuilder sb) {
        if (node.isLeaf) {
            result.add(sb.toString());
            return;
        }
        //should use queue
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                char c = (char) (i + 'A');
                sb.append(c);
                printTrie(node.children[i], result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void delete(String name) {
        if (name == null || name.length() == 0) {
            return;
        }
        List<String> nameAsPrefix = search(name);
        if (nameAsPrefix == null || nameAsPrefix.size() == 0 || !nameAsPrefix.contains(name)) {
            System.out.println("Not a valid name");
            return; //cannot find 'name' or 'name' is just prefix of other words, should not delete
        }

        TrieNode temp = root;
        TrieNode parentToDelete = root;
        char charToDelete = name.charAt(0);

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (getValidChildren(temp).size() > 1) {
                parentToDelete = temp;
                charToDelete = c;
            }
            temp = temp.children[c - 'A'];
        }

        parentToDelete.children[charToDelete - 'A'] = null;
    }

    public List<TrieNode> getValidChildren(TrieNode root) {
        List<TrieNode> notNullChildren = new ArrayList<>();
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                notNullChildren.add(root.children[i]);
            }
        }
        return notNullChildren;
    }


    public static void main(String[] args) {
        Trie myTrie = new Trie();
        myTrie.add("John");
        myTrie.add("Joe");
        myTrie.add("Jack");
        myTrie.add("Jane");
        myTrie.add("Russel");
        myTrie.delete("Rus");
        List<String> result = myTrie.printAllTrie();
        System.out.println(result);
    }

}
