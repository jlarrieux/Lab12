//--------------------------------------------------------------------
//
//  Laboratory 12                                       TreeNode.java
//
//  TreeNode Interface:  will allow declaration of any kind of TreeNode
//   object as long as the tree variant class 'implements TreeNode'
//
//--------------------------------------------------------------------

public interface TreeNode                // Constants & Methods common to tree ADTs
{
    // Class Methods used by client class
    TreeNode getLeft( );                    // Return reference to left element
    TreeNode setLeft( TreeNode leftVal );   // Set reference to left element
                                            //  & return that reference
    TreeNode getRight( );                   // Return reference to right element
    TreeNode setRight( TreeNode rightVal ); // Set reference to right element
                                            //  & return that reference
    Object getElement( );                   // Return the element in the current node
    Object setElement(Object elem);         // Set value of the element in the current node
                                            //  & return that value
} // interface TreeNode