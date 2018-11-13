package datastructure;

/*
 * 数组实现队列
 */
public class Queue
{
	int[] elements;
	public Queue()
	{
		elements=new int[0];
	}
	//入队
	public void add(int element)
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
	//出队
	public int poll()
	{
		//把数组中的第0个取出来
		int element=elements[0];
		//创建一个新数组
		int[] newArray=new int[elements.length-1];
		for(int i = 0; i < newArray.length; i++)
		{
			//新数组的第i个等于原数组的第i+1个
			newArray[i]=elements[i+1];
		}
		//替换数组
		elements=newArray;
		return element;
	}
	//判断队列是否为空
	public boolean isEmpty() {
		return elements.length == 0;
	}
}
