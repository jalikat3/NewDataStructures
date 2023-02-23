# Lab 14: BinaryTrees- Two by Two

## Purpose

This lab explores the design and implementation of an array implementation of a Binary Tree.  At the completion of the lab you will have:

1.  Created a binary tree package.
2.  Implemented a binary tree using a linked structure.
3.  Printed the binary tree using an in-order traversal.

##  Creating an Implementation of a Binary Tree

Do the following:

1.  Clone the lab repo.
2.  The design of the BianryTreeADT<T> is given in the following design.  The code for the interface is complete in the lab repo.  Your task is to clean up the documentation for each method.  ***Do this before moving to the next step.***
![Design for Binary Tree](https://github.com/MCS-Drury/Lab12-BinaryTrees/blob/master/ReadmeImages/binarytreedesign.png?raw=true)
3.  Complete the BinaryTree<T> class as defined in the diagram above by replacing the TODO comments with the appropriate code or comments. Note the declaration of the class uses protected visibility for instance variables as follows:  
  ```
  public class BinaryTree<T> implemets BinaryTreeADT<T> {
    protected T root;              // root data in the tree
    protected int size;            // the number of nodes in tree
    protected BinaryTree<T> left;  // left subtree
    protected BinaryTree<T> right; // right subtree
  ```
  
To implement the TreeIterator class you will need to complete the iteratorInOrder method.   We use the approach of creating a class to house the iterator, save the nodes in the tree in the correct order in an array, and maintaining the index of the current array element.   The code for this class is included in the repo.  You will need to code the heart of the inorder traversal as directed in the *TODO* comment in the *inOrderTrav* method.

## Testing the Binary Tree

Complete the code for the BinaryTreeTest class as indicated in the TODO comments in the class.   The idea in the testing class is to create the tree given in the figure on the top of the next page.  You will have to create the tree from the leaves up to the root using the appropriate constructors to combine trees.

![Test Tree](https://github.com/MCS-Drury/Lab12-BinaryTrees/blob/master/ReadmeImages/binarysearchtreeexdiagram.png?raw=true)

Use the *iteratorInOrder* to traverse the tree and print the names as they are retrieved from binTree.  The easy way to do this is to use a foreach loop.  When your program is working call your instructor over and demonstrate it.
Submit your completed code to your repository.

(**Note**)  The code for the *TreeIterator class* can be found in the repo's src folder.  Follow the comments in the body of the *inOrderTrav* method to complete the class.
