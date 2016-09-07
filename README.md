#A DSL for questionnaires, called QL. QL allows you to define simple forms with conditions and computed values.
Antlr 4.0 grammar-based parser generator is used and the Java programming language.
This project was part of the course 'Software Construction' during Msc of Software Engineering

The assignment: Questionnaire Language (QL)

Forms-based software for data collection has found application in various areas, including
scientific surveys, online course-ware and guidance material to support the auditing
process. As an overall term for this kind of software applications we use the term
"questionnaire". 

In this LWC’13 assignment the goal is to create a simple DSL, called QL, for
describing questionnaires. Such questionnaires are characterized by conditional entry fields
and (spreadsheet-like) dependency-directed computation

An example questionnaire is the file sampleQuestionnaire_2 in the root directory of the project.

****************
QL Requirements
****************
    Questions are enabled and disabled when different values are entered.

    The type checker detects:
        reference to undefined questions
        duplicate question declarations with different types
        conditions that are not of the type boolean
        operands of invalid type to operators
        cyclic dependencies between questions
        duplicate labels (warning)

    The language supports booleans, integers and string values.

    Different data types in QL map to different (default) GUI widgets.
***********************************
Requirements on the implementation:
***********************************

    The parser of the DSL is implemented using a grammar-based parser generator.

    The internal structure of a DSL program is represented using abstract syntax trees.

    QL programs are executed as GUI programs, not command-line dialogues.

    QL programs are executed by interpretation, not code generation.


More info about QL can be found here: http://www.languageworkbenches.net/wp-content/uploads/2013/11/Ql.pdf
