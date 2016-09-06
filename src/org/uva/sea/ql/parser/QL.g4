grammar QL;

@parser::header
{
package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

questionnaire: form*;

form: 'form' Identifier block;

block: '{' statement* '}';


statement
  : 'if' '(' expression ')' ifBody = block #If
  | identi = questionIdentifier ':' label = questionLabel type = questionType '(' expr = expression ')' #QuestionCompute
  | identi = questionIdentifier ':' label = questionLabel  type = questionType  #QuestionNormal
  ;


questionIdentifier: Identifier;
questionLabel: StringLiteral;


questionType
  : 'int'       #TypeInt 
  | 'str'       #TypeStr 
  | 'boolean'   #TypeBool
  | 'double'	#TypeDouble
  ;

expression
  : '!'        expression                #ExprNot
  | '+'       expression                #ExprPositive
  | '-'      expression                #ExprNegative
  | left = expression '+'          right = expression  #ExprPlus
  | left = expression '-'         right = expression  #ExprMinus
  | left = expression '*'      right = expression  #ExprMultiply
  | left = expression '/'        right = expression  #ExprDivide
  | left = expression '&&'           right = expression  #ExprAnd
  | left = expression '||'            right = expression  #ExprOr
  | left = expression '=='         right = expression  #ExprEqual
  | left = expression '!='      right = expression  #ExprNotEqual
  | left = expression '>'       right = expression  #ExprGreater
  | left = expression '>=' right = expression  #ExprGreaterEqual
  | left = expression '<'          right = expression  #ExprLess
  | left = expression '<='    right = expression  #ExprLessEqual
  | '(' expression    ')' #ExprParentheses
  | literal                              #ExprLiteral
  ;

literal
  : Identifier       #LiteralId
  | IntegerLiteral   #LiteralInt
  | BooleanLiteral   #LiteralBool
  | StringLiteral    #LiteralStr
  ;


IntegerLiteral: [1-9][0-9]*;

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' .*? '"';

WhiteSpace: (' ' | '\t' | '\n' | '\r') -> skip;
MultiComment: '/*' .*? '*/' -> skip;
SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;