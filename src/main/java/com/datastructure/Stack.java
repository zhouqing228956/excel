package datastructure;

/*
 * 数组实现栈
 */
public class Stack
{
	//栈的底层使用数组来存储数据
	int[] elements;
	 public Stack()
	{
		elements=new int[0];
	}
	
	
	
	//压入元素，是数组元素的加入（最后一个元素）
	public void push(int element)
	{
		//创建一个新数组
		int[] newArray=new int[elements.length+1];
		for(int i = 0; i < elements.length; i++)
		{
			//把原数组中的元素赋值给新的数组
			newArray[i]=elements[i];
		}
		//新数组加入element
		newArray[elements.length]=element;
		//替换数组
		elements=newArray;
	}
	//取出栈顶元素,pop
	public int pop()
	{
		if (elements.length == 0)
		{
			throw new RuntimeException("栈为空");
		}
		//取出数组的最后一个元素
		int element=elements[elements.length-1];
		int[] newArray=new int[elements.length-1];
		for(int i = 0; i < elements.length-1; i++)
		{
			newArray[i]=elements[i];	
		}
		//替换数组
		elements=newArray;
		//返回栈顶元素
		return element;
	}
	//查看栈顶元素
	public int peek()
	{
		if (elements.length == 0)
		{
			throw new RuntimeException("栈为空");
		}
		return elements[elements.length-1];
	}
	//查看栈是否为空
	public boolean isEmpty()
	{
		return elements.length == 0;
	}
	//查看栈元素
	public void stack() {
		for(int i = 0; i < elements.length; i++)
		{
			System.out.print(elements[i]);
		}
		System.out.println("");
	}
	

}
