public class StructureTest {
	
	public static void use(Structure[] list1) {
		Structure item1 = list1[0];
		Structure item2 = list1[1];
		item1 = new IntegerStack(5);
		item1 = new IntegerPeekStack(4);
		list1[2] = new IntegerQueue(6);
		
	}
	public static void main (String[] args) {
		IntegerStack s1 = new IntegerStack(10);
		IntegerQueue q2 = new IntegerQueue(20);
		IntegerPeekStack ps1 = new IntegerPeekStack(10);
		//arrayListStack as1 = arrayListStack(3);
		
		IntegerStack test1; //declare parent
		test1 = new IntegerPeekStack(10); //create as a child (can't do other way around)
		//as long as you declare general and then create as specific (Child)
		
		//you can do other way around if you cast
		IntegerPeekStack test2 = (IntegerPeekStack) new IntegerStack(30);
		
		//point of interface is I can do this
		Structure test3 = new IntegerStack(20);
		Structure test4 = new IntegerPeekStack(20);
	}
}