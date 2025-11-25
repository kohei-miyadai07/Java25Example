package jp.ne.zaq.jcom.project_amber;

public class JEP_507_Primitive_Types_in_Patterns {

	public static void process(Object o) {
		// 'o' が Integer 型かつ値が 100 の場合に特別な処理を行う
		String result = switch (o) {
		    // プリミティブ型パターン (Third Preview)
		    case Integer i when i == 100 -> "Special int: 100";
			case Integer i -> "int: " + i;
			case Double d -> "double: " + d;
			case Boolean b -> "boolean: " + b;
			case String s -> "String: " + s;
			default -> "unknown type"; 
		};
		IO.println(result);
	}

	public static void main() {
		process(100);          // Special int: 100
		process(42);           // int: 42
		process(3.14);         // double: 3.14
		process(true);         // boolean: true
		process("Hello");      // String: Hello
		process(new Object()); // unknown type
	}
}
