## Generics Notes

### Erasure
* After compilation generics will be removed
```
List<string>, List<Integer> , List<List<Integer>> -> List
List<String>[] - List[]
T without bounds -> Object
T extends Foo -> Foo
```
* Compilation Error
```
public void print(List<String> list) { --} 
public void print(List<Integer> list) { --} 
This will throw compile error - both methods have same erasure
```
	* Above error because, after compilation both List<String> and List<Integer> will be converted to List as explained in Erasure