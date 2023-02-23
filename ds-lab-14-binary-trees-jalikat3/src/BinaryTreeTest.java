import java.util.Iterator;

/**
 * Driver application to test the binary tree
 *
 * @author J.Purcell
 * @version 4/27/2021
 */
public class BinaryTreeTest {

    public static void main(String[] args)
    {
        // tree building
        BinaryTree<String> bob = new BinaryTree<>("Bob");
        BinaryTree<String> erin = new BinaryTree<>("Erin");
        BinaryTree<String> don = new BinaryTree<>("Don", bob, erin);
        BinaryTree<String> phyllis= new BinaryTree<>("Phyllis",don,new BinaryTree<>());
        BinaryTree<String> april = new BinaryTree<>("April",new BinaryTree<>(), phyllis);
        BinaryTree<String> adam= new BinaryTree<>("Adam",new BinaryTree<>(), april);
        BinaryTree<String> tim = new BinaryTree<>("Tim", new BinaryTree<>(), new BinaryTree<>());
        BinaryTree<String> tom = new BinaryTree<>("Tom",tim, new BinaryTree<>());
        BinaryTree<String> sue = new BinaryTree<>("Sue", new BinaryTree<>(),tom);

        // root of the tree
        BinaryTree<String> tree = new BinaryTree<String>("Sally",adam,sue);

        // Iterate and print
        Iterator<String> it = tree.iteratorInOrder();
        while ( it.hasNext() ) {
            String next = it.next();
            System.out.println(next);
        }

    }
}
