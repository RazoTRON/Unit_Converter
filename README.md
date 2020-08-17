The main units of temperature used today are degrees Celsius (CC), degrees Fahrenheit (FF), and kelvins (KK).

Converting these units is somewhat different from dealing with length or weight. 0 kelvin is not equal to 0 degrees Celsius nor 0 degrees Fahrenheit, and neither is 0 degrees Celsius equal to 0 degrees Fahrenheit.

Below are all the formulas for converting one unit of temperature to another. In these, the letter

KK stands for kelvin,

CC stands for degrees Celsius and

FF means degrees Fahrenheit.

To convert Celsius to Fahrenheit and vice versa, use the following formulas:

C = (F - 32) * 5 / 9C=(F−32)∗5/9

F = C * 9 / 5 + 32F=C∗9/5+32

To convert kelvins to Celsius or vice versa, use these formulas:

K = C + 273.15K=C+273.15

C = K - 273.15C=K−273.15

To convert between degrees Fahrenheit and kelvins, use these formulas:

F = K * 9 / 5 - 459.67F=K∗9/5−459.67

K = (F + 459.67) * 5 / 9K=(F+459.67)∗5/9

The program should allow the following notations:

For degrees Celsius, the user can input "degree Celsius", "degrees Celsius", "celsius" "dc", or "c".
For degrees Fahrenheit, the user can input "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", or "f".
For kelvins, the user can input "kelvin", "kelvins", or "k".
At this stage, if the user attempts to perform an impossible conversion, such as meters to kilograms, or if one of the input units is not recognized, the program should output an appropriate error message.

If you cannot determine the unit, output "???" instead (obviously, it would be inside an error message). Don't forget that in the error message, both measurement types should be written in the plural, not singular.

If the user wants to convert weight from one to another but inputs a negative amount, you should print Weight shouldn't be negative. The same is true for length, and the message should be Length shouldn't be negative.

What to do if a query is bad? Handle this! Try to parse the following parts:

<number> +
<(unit name) or (degree + unit name) or (degrees + unit name)> +
<random word like "to" or "in"> +
<(unit name) or (degree + unit name) or (degrees + unit name)>
If there is an error, output Parse error.

