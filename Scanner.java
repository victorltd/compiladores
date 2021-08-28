/*
 * @(#)Scanner.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


public  class Scanner {

  private SourceFile sourceFile;
  private boolean debug;

  private char currentChar;
  private StringBuffer currentSpelling;
  private boolean currentlyScanningToken;

  
  private void take(char expectedChar ){
      if (currentChar == expectedChar){
          currentSpelling.append(currentChar);
          currentChar= sourceFile.getSource();
      }else
          System.out.println("Erro lexico"); 
  }
  
  
private void takeIt() {
    //if (currentlyScanningToken)
    currentSpelling.append(currentChar);
    currentChar = sourceFile.getSource();
  }
          
          

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

// isOperator returns true iff the given character is an operator character.

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }


///////////////////////////////////////////////////////////////////////////////

  public Scanner(SourceFile source) {
    sourceFile = source;
    currentChar = sourceFile.getSource();
    debug = false;
  }

  public void enableDebugging() {
    debug = true;
  }

  // takeIt appends the current character to the current token, and gets
  // the next character from the source program.



  // scanSeparator skips a single separator.

  private void scanSeparator() {
    switch (currentChar) {
    case '!':
      {
        takeIt();
      }
        /*
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT))
          takeIt();
        if (currentChar == SourceFile.EOL)
          takeIt();
      }
      break;
*/
    case ' ': case '\n':
      takeIt();
      break;
    }
  }

  private byte scanToken() {

    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z':
      takeIt();
      while (isLetter(currentChar) || isDigit(currentChar))
        takeIt();
      return Token.IDENTIFIER;

    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':
      takeIt();
      while (isDigit(currentChar))
        takeIt();
      return Token.INTLITERAL;

    
      
    case '+':
        takeIt();
        return Token.ADIC;

     case '-':
        takeIt();
        return Token.SUBT;
        
     case '$':
        takeIt();
        return Token.LOG_OR;    
        
     case '*':
        takeIt();
        return Token.MULT;
        
     case '/':
        takeIt();
        return Token.DIVI;
        
     case '&':
        takeIt();
        return Token.LOG_AND;
        
     case '<':
        takeIt();
        if (currentChar == '='){
            takeIt();
            return Token.MENORIG;
        }
        if (currentChar == '>'){
                 return Token.DIF;
        }
        else
        return Token.MENOR;
        
     case '>':  
        takeIt();
        if (currentChar == '='){ //>=
            takeIt();
            return Token.MAIORIG;
        }
        else
        return Token.MAIOR;
    
     case '=':
        takeIt();
        return Token.IGUAL;
        
     case '@':
        takeIt();
        return Token.ARRO;
        
     case '#':
        takeIt();
        return Token.HASHT;
     
     case '.':  
        takeIt();
        if (currentChar == '.'){ 
            takeIt();
            if (currentChar == '.'){ 
                takeIt();
                return Token.RETIC;
            }   
        }
        else
        return Token.ERROR;
        
     case '!':
        takeIt();
        return Token.EXCL;
        
        
    case SourceFile.EOT:
      return Token.EOT;

    default:
      takeIt();
      return Token.ERROR;
    }
  }

  public Token scan () {
    Token tok;
    SourcePosition pos;
    byte currentKind;

    //currentlyScanningToken = false;
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n')
      scanSeparator();
    currentSpelling = new StringBuffer("");
    currentKind = scanToken();
    return new Token(currentKind, currentSpelling.toString());
    
  }

}
