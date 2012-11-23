package a3solution;

//  COMP 250 - Introduction to Computer Science - Fall 2012
//  Assignment #3 -
//
//  A node in a Trie (prefix) tree.  
//  It contains an array of children: one for each possible character.
//  The ith child of a node corresponds to character (char)i
//  which is the UNICODE (and ASCII) value of i. 
//  Similarly the index of character c is (int)c.
//  So children[97] = children[ (int) 'a']  would contain the child for 'a' 
//  since (char)97 == 'a'   and  (int)'a' == 97.
//  References:
//  -For all unicode charactors, see http://unicode.org/charts
//   in particular, the ascii characters are listed at http://unicode.org/charts/PDF/U0000.pdf
//  -For ascii table, see http://www.asciitable.com/
//  -For basic idea of converting (casting) from one type to another, see 
//   any intro to Java book (index "primitive type conversions"), or google
//   that phrase.   We will cover casting of reference types when get to the
//   Object Oriented Design part of this course.

public class TrieNode
{
	// Highest allowable character index is NUMCHILDREN-1
	//  (assuming one-byte ASCII i.e. "extended ASCII")
	// NUMCHILDREN is constant (static and final).  
	// To access it, you need to say "TrieNode.NUMCHILDREN"
	
   public static final int NUMCHILDREN = 256;

   private TrieNode parent;
   private TrieNode[] children;
   private int depth; // 0 for root, 1 for root's children, 2 for their children, etc..
   private char indexInParent; // character associated with edge between node and its parent
   private boolean endOfKey; // set to true of prefix associated with node is also a key.
   
   // Construct new, empty node with NUMCHILDREN children.  All the children are null. 

   public TrieNode()
   {
      children = new TrieNode[NUMCHILDREN];
      endOfKey = false;
      depth = 0; 
      indexInParent = (char)0; 
   }

   // Add a child to current node.  The child is associated with the character specified 
   // the index argument.  

   public TrieNode createChild(char index) 
   {	   
	  TrieNode child       = new TrieNode();

     // ADD YOUR CODE BELOW HERE

	 //  The child node must have a reference back to the node itself.  
	 //  First set the edges/references, then the fields.
	  
      child.parent = this; 
      children[ index ] = child;   //  conversion (int) index happens automatically
           
      child.depth         = depth + 1;
      child.indexInParent = index;
      
      // ADD YOUR CODE ABOVE HERE
      
      return child;
   }

   // Get the child node associated with a given character, i.e. that character is on 
   // the edge from this node to the child.  The child could be null.  

   public TrieNode getChild(char index) 
   {
      return children[ (int) index];
   }

   // Test whether the path from the root to this node is a key in the trie.  
   // Return true if it is, false if it is prefix but not a key.

   public boolean isEndOfKey() 
   {
      return endOfKey;
   }
   
   // Set to true for the node associated with the last character of an input word

   public void setEndOfKey(boolean endOfKey)
   {
      this.endOfKey = endOfKey;
   }

   // Depth of node (distance from root).

   public int getDepth() 
   {
      return depth;
   }

   // Get the parent

   public TrieNode getParent() 
   {
      return parent;
   }

   // Returns x such that parent.getChild(x) == this. 

   public char getIndexInParent()
   {
      return indexInParent;
   }

   /* Return the prefix (as a String) associated with this node.  This prefix
    is defined by descending from the root to this node.  However, you may
    find it is easier to implement by backtracking from the node to the root,
    composing the prefix string from last character to first.  
    
   * ADDED:  Nov. 9.   If this method is called by the root node, then the 
   * empty string should be returned.  The original specification was to 
   * return null.  (This specification was not given here, but rather was given
   * in the Autocomplete.java file.)  If your solution uses this specification, 
   * you will NOT lose any points.  
   */
 
   public String toString()
   {
	// ADD YOUR CODE BELOW HERE
	   
	    if (parent != null)
	    	return parent.toString() + indexInParent;
	    else
	    	return "";
	    
	 // ADD YOUR CODE ABOVE HERE
   }
}
