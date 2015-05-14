PImage message, host, hidden, unhidden;
int bitsToHide = 2;
int hostMask = 0;  //bitmask for host image
int messMask = 0;  //bitmask for message image
boolean encrypted = false;

void setup() {
  host = loadImage( "host.jpg" );
  message = loadImage( "message.jpg" );
  
  size( host.width, host.height );
  
  // resize message
  if( (double)(message.width)/message.height == (double)(host.width)/host.height )  // same aspect ratio
    message.resize( host.width, host.height );
  else if( (double)(message.width)/message.height > (double)(host.width)/host.height )  // host taller
    message.resize( host.width, (int)( (double)(message.width)*host.height/host.width ) );
  else  // message taller
    message.resize( (int)( (double)(message.height)*host.width/host.height ), host.height );
  
  // create bitmasks
  hostMask = ~(int)( pow( 2, bitsToHide ) -1 ) & 0xFF;
  hostMask = hostMask + (hostMask << 8) + (hostMask << 16) + (hostMask << 24);
  messMask = ( (int)( pow( 2, bitsToHide ) -1 ) & 0xFF ) << (8 - bitsToHide);
  messMask = messMask + (messMask << 8) + (messMask << 16) + (messMask << 24);
  
  println( "hostMask: " + Integer.toHexString(hostMask) );
  println( "messMask: " + Integer.toHexString(messMask) ); 
  
  image( host, 0, 0 );
}

void draw() {
  
}

void mousePressed() {
  if( !encrypted ) {
    encrypt();
    encrypted = true;
  } else {
    decrypt();
    encrypted = false;
  }
}

void encrypt() {
  hidden = loadImage( "host.jpg" );
  for( int row = 0; row < message.height; row++ ) {
    for( int col = 0; col < message.width; col++ ) {
      hidden.set( col,
                  row,
                  ( host.get( col, row ) & hostMask ) + ( ( message.get( col, row ) & messMask ) >> (8 - bitsToHide ) ) );
    }
  }
  background(255);
  image( hidden, 0, 0 );
  hidden.save( "hidden.jpg" );
}

void decrypt() {
  unhidden = loadImage( "hidden.jpg" );
  for( int row = 0; row < unhidden.height; row++ ) {
    for( int col = 0; col < unhidden.width; col++ ) {
      unhidden.set( col, row, ( hidden.get( col, row ) << (8-bitsToHide) ) & messMask );
    }
  }
  background(255);
  image( unhidden, 0, 0 );
  unhidden.save( "unhidden.jpg" );
}
