class Fibonacci {

    /**
     * 
     */
    public static void printNextNumber(long first, long second, int times ) {
        long third = first + second;
        System.out.print( " " + third );

        if( times > 1 ) {
            printNextNumber( second, third, times - 1 );
        }
        return;
    }

    /**
     * main
     */
    public static void main( String args[] ) {
        int num = 64;
        System.out.print("1 1");
        printNextNumber( 1, 1, num - 2 );
        System.out.print( "\n" );
    }
}
