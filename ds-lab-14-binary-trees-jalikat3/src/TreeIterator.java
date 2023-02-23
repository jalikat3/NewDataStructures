import java.util.Iterator;

/**
 * This class provides an iterator for Binary Trees.
 *
 * @J.Purcell
 * @4/27/2021
 *
 */

public class TreeIterator<T> implements Iterator<T>
{
    // current iterator
    private int current;

    // collection size
    private int count;

    // Linear collection of nodes
    private T[] collectionArray;

    // The binary tree collection
    private BinaryTree<T> collection;

    // Constructs a TreeIterator that iterates over the tree
    public TreeIterator(BinaryTree<T> collection, int size)
    {
        // set the initial iterator state
        current = 0;
        count = size;
        this.collection = collection;

        // make the collection
        collectionArray = (T []) new Object[count];

        // load the collectionArray
        inOrderTrav(this.collection);

        // reset current
        current = 0;
    } //end constructor

    // Method to check if more elements remain in the iteration
    public boolean hasNext()
    {
        return current < count;
    } // end hasNext

    // Method to return the next element in the iteration.
    public T next()
    {
        T retVal = collectionArray[current];
        current++;
        return retVal;
    } // end next

    // Not implemented but must be included.
    public void remove() {

    } // end remove

    // Private method to traverse the tree inorder, storing the nodes visited in the collectionArray.

    private void inOrderTrav(BinaryTree<T> tree)
    {
        if (tree.root == null)
            return;
        else {
                inOrderTrav(tree.left);
                collectionArray[current]=tree.root;
                current++;
                inOrderTrav(tree.right);

            }
            // Provided algorithm
            //  Traversal is recursive:
            //    if (tree is empty)
            //       return
            //    Traverse the left subtree
            //    Visit => Insert the root into collectionArray at current & increment current
            //    Traverse the right subtree
            }
    }

 
 
