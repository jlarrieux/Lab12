//--------------------------------------------------------------------
//
//  Laboratory 12, In-lab Exercise 3                   AccountRec.java
//
//  Sample accounts database retrieval program
//
//--------------------------------------------------------------------

// Retrieves a record from an accounts database file.

//--------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;

//--------------------------------------------------------------------
//
// Definitions specifying the accounts database
//

class AccountRec
{
    // Constants
    public static final long BYTES_PER_RECORD = 38;  // Number of bytes used to store
                                                     //   each record in the accounts
                                                     //   database file
    // Data members
    private int acctID;                 // Account identifier
    private String firstName;           // Name of account holder
    private String lastName;
    private double balance;             // Account balance
    
    public static void main (String args[ ]) throws IOException 
    {
        AccountRec acctRec = new AccountRec( );         // Account record
        long recNum;                                    // User input record number
        String str,                                     // For reading a String
               name;

        // Need random access on the accounts database file; r = read only
        RandomAccessFile inFile =                       
            new RandomAccessFile("Accounts.dat", "r");
        
        // Also need tokenized input stream from keyboard
        BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer keybdTokens = new StreamTokenizer(reader); 
        
        // Get the record number to retrieve.
        System.out.println( );
        System.out.print("Enter record number: ");
        keybdTokens.nextToken( );
        recNum = (long)keybdTokens.nval;

        // Move to the corresponding record in the database file using the
        // seek( ) method in RandomAccessFile.
        inFile.seek(recNum * BYTES_PER_RECORD);

        str = inFile.readLine( );                          // Read the record

        if (str != null)
        {   
            // Need to tokenize the String read by readline( )
            StringTokenizer strTokens = new StringTokenizer(str);

            name = strTokens.nextToken( );                  // first String token
            acctRec.acctID = Integer.parseInt(name);        // Convert String to an int

            acctRec.firstName = strTokens.nextToken( );     // 2nd String token - firstName
            
            acctRec.lastName = strTokens.nextToken( );      // 3rd String token - lastName
            
            name = strTokens.nextToken( );                  // 4th String token
            acctRec.balance = Double.parseDouble(name);     // Convert String to a double
            
            // Display the record.
            System.out.println(recNum + " : " + acctRec.acctID + " "
                               + acctRec.firstName + " " + acctRec.lastName + " "
                               + acctRec.balance);
        }
        else
            System.out.println("Reached EOF");
        
        // Close the file streams
        inFile.close( );
        
    } // main
    
} // class AccountRec