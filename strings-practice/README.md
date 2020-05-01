# Core Java String Examples

## Create project using maven
```
mvn archetype:generate -DgroupId=com.string.practice -DartifactId=strings-practice -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Examples
* [String Examples](src/test/java/com/string/practice/StringPractice.java)
* [String Format Examples](src/test/java/com/string/practice/StringFormatPractice.java)
* [String Joiner Examples](src/test/java/com/string/practice/StringJoinerPractice.java)

## String formatter

Format Specifier    | Description   | Output
--------------------|---------------|----------------------
%a | floating point (except BigDecimal) | Returns Hex output of floating point number
%b                  | Any type  | "true" if non-null, "false" if null    
%c                  | character | Unicode character
%d                  | integer (incl. byte, short, int, long, bigint) | Decimal Integer
%e                  | floating point | decimal number in scientific notation
%f	                | floating point | decimal number
%g                  | floating point | decimal number, possibly in scientific notation depending on the precision and value
%h                  | any type | Hex String of value from hashCode() method
%n                  | none | Platform-specific line separator
%o                  | integer (incl. byte, short, int, long, bigint) | Octal number
%s                  | any type | String value
%t                  | Date/Time (incl. long, Calendar, Date and TemporalAccessor) | %t is the prefix for Date/Time conversions
%x                  | integer (incl. byte, short, int, long, bigint) | Hex string