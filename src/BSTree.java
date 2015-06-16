//--------------------------------------------------------------------
//
//  Laboratory 12                                         BSTree.jshl
//
//  (Shell) Class definitions for the linked implementation of the
//  Binary Search Tree ADT -- including the recursive partners of
//  the public member functions
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------

class BSTree
{
    // Data member
    private TreeNode root;          // Reference to the root node
    
    // Constructor
    public BSTree ( )
    {
        clear();
    }
    
    // Binary search tree manipulation methods
    public void insert ( TreeElem newElement )      // Insert element
    {
        if(isEmpty()) root = new BSTreeNode(newElement,null, null);
    }

    public TreeElem retrieve ( int searchKey )      // Retrieve element
    {
    }

    public void remove ( int deleteKey )            // Remove element
    {
    }

    public void writeKeys ( )                       // Output keys
    {
    }

    public void clear ( )                           // Clear tree
    {
        root = null;
    }

    public boolean isEmpty ( )                      // Is tree empty?
    {
        if(root ==null) return true;
        else return false;
    }

    public boolean isFull ( )                       // Is tree full?
    // Java throws an OutOfMemoryError when no more memory remains,
    //   so here false is always naively returned.
    {
        return false;
    }

    public void showStructure ( )
    // Outputs the keys in a binary search tree. The tree is output
    // rotated counterclockwise 90 degrees from its conventional
    // orientation using a "reverse" inorder traversal. This operation is
    // intended for testing and debugging purposes only.
    {
        if ( root == null )
            System.out.println("Empty tree");
        else
        {
            System.out.println( );
            showSub(root, 1);
            System.out.println( );
        }
    }

    //--------------------------------------------------------------------
    //
    //                         In-lab operations
    //
    //--------------------------------------------------------------------

    public void writeLessThan ( int searchKey )     // Output keys
                                                    //   < searchKey
    {
    }

    public int height ( )                           // Height of tree
    {
    }

    // Recursive partners of the public member methods
    // ----- insert these methods here.

    private void showSub ( TreeNode p, int level )
    // Recursive partner of the showStructure( ) method. Outputs the
    // subtree whose root node is pointed to by p. Parameter level is the
    // level of this node within the tree.
    {
        int j;                                      // Loop counter
        
        if ( p == null )
            return;

        TreeElem q = (TreeElem)p.getElement( );     // Cast Object to TreeElem

        showSub(p.getRight( ), level + 1);          // Output right subtree
        for ( j = 0 ; j < level ; j++ )             // Tab over to level
            System.out.print("\t");
        System.out.print(" " + q.key( ));           // Output key
        if ( ( p.getLeft( ) != null ) &&            // Output "connector"
             ( p.getRight( ) != null ) )
            System.out.print("<");
        else if ( p.getRight( ) != null )
            System.out.print("/");
        else if ( p.getLeft( ) != null )
            System.out.print("\\");
        System.out.println( );
        showSub(p.getLeft( ), level + 1);           // Output left subtree
    }

} // class BSTree