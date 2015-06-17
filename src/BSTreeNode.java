//--------------------------------------------------------------------
//
//  Laboratory 12                                   BSTreeNode.jshl
//
//  (Shell) Class definitions for the linked implementation of the
//  Binary Search Tree ADT -- including the recursive partners of
//  the public member functions
//
//  Note:  the methods that implement an interface MUST BE 
//         declared public
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------

class BSTreeNode implements TreeNode {


    // Data members
    private Object element;         // Binary search tree element
    private TreeNode left,          // Reference to the left child
            right;          // Reference to the right child


    // Constructor
    BSTreeNode(Object elem, TreeNode leftPtr, TreeNode rightPtr) {
        setElement(new BSTreeElem());
        setLeft(leftPtr);
        setRight(rightPtr);
    }


    @Override
    public TreeNode getLeft() {
        return left;
    }


    @Override
    public TreeNode setLeft(TreeNode leftVal) {
        left = leftVal;
        return left;
    }


    @Override
    public TreeNode getRight() {
        return right;
    }


    @Override
    public TreeNode setRight(TreeNode rightVal) {
        right = rightVal;
        return right;
    }


    @Override
    public Object getElement() {
        return element;
    }


    @Override
    public Object setElement(Object elem) {
        element = elem;
        return elem;
    }

    // Class Methods used by client class
    // methods from interface TreeNode

} // class BSTreeNode
