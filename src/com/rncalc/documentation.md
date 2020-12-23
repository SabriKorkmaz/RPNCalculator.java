# Project-1: RPN Calculator
[swe510](https://www.cmpe.boun.edu.tr/tr/courses/swe510)
2020 Fall by
[bingol](https://www.cmpe.boun.edu.tr/~bingol)


v2020-12-04




## due 2020-12-23T23:00 by Moodle

See [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) @wikipedia.




## Description

Develop an RPN calculator for 4- arithmetic operations (+, -, *, /).

- _RPN_ stands for _Reverse Polish Notation_
    - See [RPN](https://en.wikipedia.org/wiki/Reverse_Polish_notation) @wikipedia.
    - In addition to binary operations there is an "enter" operation, denoted by `^`.
    - Note that there is no equal `=`.
- Examples

meaning | input | output
---|---|---:
`2^3+`|`2+3=`|`5`
`2^3-`|`2-3=`|`-1`
`2^3^4++`|`2+(3+4)=`|`9`
`2^3^4+-`|`2-(3+4)=`|`-5`
`2^3^5+*`|`2*(3+5)=`|`16`
`2^3^5*+`|`2+(3*5)=`|`17`
`1^2+3+4+`|`1+2+3+4=`|`10`
`2c^3c-`|`-2-(-3)=`|`1`
`+=`|`+`|`ERROR`
`+2=`|`2+`|`ERROR`
`1-2+=`|`1^2-+`|`ERROR`




## Specification

- Your program reads the expression to be evaluated `System.in`.
- Writes the result to `System.out`.
- It should work with integers as well as float.
  That is, `2.1^3.05+` evaluates to `5.15`.
- Negative numbers are represented as unsigned number followed by "change sign" `c`.

input|meaning
---|---:
`1c`|`-1`
`1cc`|`1`
`1ccc`|`-1`
`1.2c`|`-1.2`

- The decimal and thousands separators are `.` and `,`, respectively.

input|meaning
---:|---:
`1,234.567`|`1234.567`
`12,345.67c`|`12345.67`




## Bonus points

You get

- 20% bonus,
  if your calculator works with a graphical user interface (GUI).
  See [HP41](https://en.wikipedia.org/wiki/HP-41C)  for a possible GUI.
- 5% bonus,
  if the calculator, in addition to reading unseparated inputs, understands
  inputs with thousands separated and
  always produces results with thousands separated.




## Related Concepts

- [stack](https://en.wikipedia.org/wiki/Stack_(abstract_data_type)) (LIFO)
- [RPN](https://en.wikipedia.org/wiki/Reverse_Polish_notation)
- postfix




## Deliverables

- The code (60%)
- Testing suit (20%)
- Documentation (20%).
  (Note that we are talking about a couple of pages not more than 10 in total.)
    - Installation manual
    - User manual
    - Maintenance manual
- Upload to Moodle by 2020-12-23T23:00.
- Prepare a 5-minute presentation on 2020-12-24 during lecture hours.

