/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public enum Token {
    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT,
    PENUP,
    PENDOWN,
    HIDETURTLE,
    SHOWTURTLE,
    PENCOLOR,
    CLEARSCREEN,
    REPEAT,
    TO,
    RIGHT_BRACES,
    LEFT_BRACES,
    SEMI_COMMA,
    ID,
    NUM,
    EOF,
    UNKNOWN
}
