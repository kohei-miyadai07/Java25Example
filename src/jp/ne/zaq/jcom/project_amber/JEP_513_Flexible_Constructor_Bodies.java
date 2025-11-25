package jp.ne.zaq.jcom.project_amber;

public class JEP_513_Flexible_Constructor_Bodies {

	class Parent {
		Parent(int value) {
			if (value < 0) {
				throw new IllegalArgumentException("Negative value: " + value);
			}
		}
	}

	class Child extends Parent {
		Child(int a, int b) {
			// super() の前に引数 b の検証を実行できる。
			if (b < 0) {
				throw new IllegalArgumentException("b must be non-negative.");
			}

			// これが可能になりました。
			super(a + b);

			IO.println(getClass().getName() + " constructed with a=" + a + ", b=" + b);
		}
	}

	public void main() {
		new Child(10, 20);
		new Child(10, -5);
	}

}
