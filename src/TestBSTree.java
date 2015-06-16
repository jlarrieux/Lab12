//--------------------------------------------------------------------
//
//  Laboratory 12                                    TestBSTree.java
//
//  Test program for the operations in the Binary Search Tree ADT
//
//--------------------------------------------------------------------

import java.io.*;

class TestBSTree
{
    public static void main(String args[ ]) throws IOException 
    {
        BSTree testTree = new BSTree( );            // Test binary search tree
        BSTreeElem testElement = new BSTreeElem( ); // Binary search tree element
        int inputKey = 0;                           // User input key
        char cmd;                                   // Input command

        //-----------------------------------------------------------------
        // Need to read 'tokens' (namely priority values) input from the keyboard.
        //   In Java this takes instantiation of several classes.  
        //
        // Initialize reader - To read a character at a time
        InputStreamReader reader = new InputStreamReader(System.in);
        
        // Initialize the tokenizer -
        //   To read tokens (words and numbers separated by whitespace)
        StreamTokenizer tokens = new StreamTokenizer(reader);
        
        // Note: use the nextToken( ) method to step through a stream of tokens. 
        //   Use tokenizer's nval to obtain the number read.
        //   Since nval is of type double, cast it to an int.

        System.out.println( );
        System.out.println("Commands:");
        System.out.println("  +key : Insert (or update) element");
        System.out.println("  ?key : Retrieve element");
        System.out.println("  -key : Remove element");
        System.out.println("  K    : Write keys in ascending order");
        System.out.println("  C    : Clear the tree");
        System.out.println("  E    : Empty tree?");
        System.out.println("  F    : Full tree?");
        System.out.println("  H    : Height                      (Inactive : "
                           + "In-lab Exercise 1)");
        System.out.println("  <key : Write keys that are < key   (Inactive : "
                           + "In-lab Exercise 2)");
        System.out.println("  Q    : Quit the test program");
        System.out.println( );

        do
        {
            testTree.showStructure( );                    // Output tree

            System.out.println( );
            System.out.print("Command: ");                  // Read command
            cmd = (char)reader.read( );
            while (Character.isWhitespace(cmd))           // ignore whitespace
                cmd = (char)reader.read();
            if ( cmd == '+'  ||  cmd == '?'  ||
                 cmd == '-'  ||  cmd == '<'     )
            {
                tokens.nextToken( );
                inputKey = (int)tokens.nval;
            }

            switch ( cmd )
            {
            case '+' :                                  // insert
                testElement = new BSTreeElem( );
                testElement.setKey(inputKey);
                System.out.println("Insert : key = " + testElement.key( ));
                testTree.insert(testElement);
                break;

            case '?' :                                  // retrieve
                testElement = (BSTreeElem)testTree.retrieve(inputKey);
                if ( testElement != null )
                    System.out.println("Retrieved : key = " + testElement.key( ));
                else
                    System.out.println("Not found");
                break;

            case '-' :                                  // remove
                System.out.println("Trying to Remove: " + inputKey);
                testTree.remove(inputKey);
                break;

            case 'K' : case 'k' :                       // writeKeys
                System.out.println("Keys:");
                testTree.writeKeys();
                break;

            case 'C' : case 'c' :                       // clear
                System.out.println("Clear the tree");
                testTree.clear( );
                break;

            case 'E' : case 'e' :                       // empty
                if ( testTree.isEmpty( ) )
                    System.out.println("Tree is empty");
                else
                    System.out.println("Tree is NOT empty");
                break;

            case 'F' : case 'f' :                       // full
                if ( testTree.isFull() )
                    System.out.println("Tree is full");
                else
                    System.out.println("Tree is NOT full");
                break;

            case 'H' : case 'h' :                   // In-lab Exercise 1
                System.out.println("Tree height = " + testTree.height( ));
                break;

            case '<' :                              // In-lab Exercise 2
                System.out.println("Keys < " + inputKey + " : ");
                testTree.writeLessThan(inputKey);
                System.out.println( );
                break;

            case 'Q' : case 'q' :                   // Quit test program
                break;

            default :                               // Invalid command
                System.out.println("Inactive or invalid command");
            }
        } while ( ( cmd != 'Q' ) && ( cmd != 'q' ) );

    } // main
    
} // class TestBSTree