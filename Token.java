/*
 * @(#)Token.java                        2.1 2003/10/07
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


public class Token  {

  public byte kind; //no pdf declara como byte,, mas aqui tem q ser int, devido a linha 30
  public String spelling;
  //protected SourcePosition position;

  public Token(byte kind, String spelling) {
      this.kind=kind;
      this.spelling = spelling;
        if (kind == Token.IDENTIFIER) {
          for(byte k=BEGIN; k<=WHILE; k++){
              if (spelling.equals(spellings[k])){
                  this.kind=k;
                  break;
              }
          }
        }
  }



  // Token classes...

  public final static byte
    // literals, identifiers, operators...
    INTLITERAL	= 0,
    IDENTIFIER	= 2,
          
    // reserved words - must be in alphabetical order...
    BEGIN		= 5,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    IF			= 13,
    THEN		= 19,
    TYPE		= 21,
    VAR			= 22,
    WHILE		= 23,
/*
    // punctuation...
    DOT			= 24,
    COLON		= 25,
    SEMICOLON	= 26,
    COMMA		= 27,
    BECOMES		= 28,
    IS			= 29,

    // brackets...
    LPAREN		= 30,
    RPAREN		= 31,
    LBRACKET	= 32,
    RBRACKET	= 33,
    LCURLY		= 34,
    RCURLY		= 35,

    // special tokens...
    EOT			= 36,
    ERROR		= 37,

*/
  
    //OPERATODORES
    ADIC = 38,
    SUBT = 39,
    LOG_OR = 40,
    MULT = 41,
    DIVI = 42,
    LOG_AND = 43,
    MENOR = 44,
    MAIOR = 45,
    MENORIG = 46,
    MAIORIG = 47,
    IGUAL = 48,
    DIF = 49,
    ARRO =50,
    HASHT = 51,
    RETIC= 52,
    EXCL = 53,
    EOT = 55,
    ERROR = 56;
  
  
  
  

  private final static String[] spellings = {
    "<integer-literal>",
    "<identifier>",
    "begin",
    "do",
    "else",
    "end",
    "if",
    "then",
    "type",
    "var",
    "while",
   "+",
   "-",
   "$",
   "*",
   "/",
   "&",
   "<",
   ">",
   "<=",
   ">=",
   "=",
   "<>",
   "@",
   "#",
   "...",
   "!",
    "",
    "<error>",
  };
          
}
