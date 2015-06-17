//--------------------------------------------------------------------
//
//  Laboratory 12                                    BSTreeElem.java
//
// Definition for the BSTreeElem binary search tree element class
//
//--------------------------------------------------------------------

class BSTreeElem implements TreeElem {


    // Data members
    private int keyField;                // Key for the element


    // Constructor
    public BSTreeElem() {
        keyField = 0;
    }


    public void setKey(int newKey) {
        keyField = newKey;
    }              // Set the key


    public int key() {
        return keyField;
    }                // Returns the key

} // class TreeElem


