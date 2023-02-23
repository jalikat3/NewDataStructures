import java.util.Iterator;

/**
 * Implementation class of the Binary Tree ADT
 *
 * Iterates through the nodes of a tree and prints them in alphabetical order
 * by using the inOrderTrav method, which is called on when a new TreeIterator
 * is made in the iterateInOrder class.
 * @J.Purcell
 * @4/27/2021
 *
 */
public class BinaryTree<T> implements BinaryTreeADT<T>{
    protected T root; // root data of the tree
    protected int size;  // the number of nodes in the tree
    protected BinaryTree<T> left; // left subtree
    protected BinaryTree<T> right; // right subtree

    /**
     * Default constructor. Needed to construct empty subtrees.
     */
    public BinaryTree()
    {
        root = null;
        left = null;
        right = null;
        size = 0;
    }

    /**
     * "Leaf" constructor. Both subtrees are empty tree.
     * @param ele The data to insert into a leaf.
     */
    BinaryTree (T ele)
    {
        root = ele;
        left = new BinaryTree<>();
        right = new BinaryTree<>();
        size = 1;
    }


    /**
     * Constructor. Use this to build trees from leaves to root.
     * @param data Data to insert into the root of the tree.
     * @param leftChild The left subtree, possibly an empty tree.
     * @param rightChild The right subtree, possibly an empty tree.
     */
    public BinaryTree(T data, BinaryTree<T> leftChild, BinaryTree<T> rightChild)
    {
        root = data;
        this.left = leftChild;
        this.right = rightChild;
        size = leftChild.size + rightChild.size + 1;
    }

    /**
     * @return Returns the root of the tree
     */
    @Override
    public T root() {

        return null;
    }

    /**
     *@return True if the tree is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     *@return Returns the number of nodes in the tree
     */
    @Override
    public int size() {

        return 0;
    }

    /**
     * Retrieves the left subtree of this binary tree
     *
     * @return Returns null if the subtree is empty; otherwise returns the subtree rooted
     * in the left child of this tree.
     */
    @Override
    public BinaryTreeADT leftSubtree() {
        return null;
    }

    /**
     * Retrieves the right subtree of this binary tree
     * @return Returns null if the subtree is empty; otherwise returns the subtree rooted
     * in the right child of this tree.
     */
    @Override
    public BinaryTreeADT rightSubtree() {
        return null;
    }

    /**
     * Creates an in order iterator for the tree
     * @return new TreeIterator, a class created to traverse
     * through the tree and print the nodes in alphabetical order
     */
    @Override
    public Iterator iteratorInOrder() {
        return new TreeIterator(this,size);
    }
}
