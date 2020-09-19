# String

## Create project using maven
```
mvn archetype:generate -DgroupId=com.string.practice -DartifactId=strings-practice -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Examples
* [String Examples](src/test/java/com/string/practice/StringPractice.java)
* [String Format Examples](src/test/java/com/string/practice/StringFormatPractice.java)
* [String Joiner Examples](src/test/java/com/string/practice/StringJoinerPractice.java)

## String formatter
* Refer - [StringFormatPractice.java](src/test/java/com/string/practice/StringFormatPractice.java)

Format Specifier    | Description   | Output
--------------------|---------------|----------------------
%a | floating point (except BigDecimal) | Returns Hex output of floating point number
%b | Any type  | "true" if non-null, "false" if null    
%c | character | Unicode character
%d | integer (incl. byte, short, int, long, bigint) | Decimal Integer
%e or %eE | floating point | decimal number in scientific notation
%f | floating point | decimal number
%g | floating point | decimal number, possibly in scientific notation depending on the precision and value
%h | any type | Hex String of value from hashCode() method
%n | none | Platform-specific line separator
%o | integer (incl. byte, short, int, long, bigint) | Octal number
%s | any type | String value
%t | Date/Time (incl. long, Calendar, Date and TemporalAccessor) | %t is the prefix for Date/Time conversions
%x or %xX | integer (incl. byte, short, int, long, bigint) | Hex string
0 | Zero padding | Zero padding
\- | Left justify | Left justify
, | group |
space | leave space for positive number |
\+ | always show sign |
\( | enclose negative values in parenthesis |