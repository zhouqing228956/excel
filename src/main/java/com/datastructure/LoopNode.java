package datastructure;

public class LoopNode
{
	//节点内容
	int data;
	//循环链表与单链表不同
	LoopNode next=this;
	//初始化节点
	public LoopNode(int data)
	{
		this.data=data;	
	}
	
	//获取值
	public int getData()
	{
		return this.data;
	}
	//获取下一个节点
	public LoopNode next()
	{
		return this.next;
	}
	//删除下一个节点
	public void removeNext()
	{
		//取出下下一个节点
		LoopNode newNext=this.next.next;
		//把下下一个节点追加为当前节点的下一个节点
		this.next=newNext;
	}
	//显示所有节点信息
	public void show()
	{
		LoopNode currentNode=this;
		while(true)
		{
			System.out.print(currentNode.data+"");
			//取出下一个节点
			currentNode=currentNode.next;
			//如果是最后一个节点
			if (currentNode == null)
			{
				break;
			}
		}
		System.out.println("");
	}	
	//插入节点（其中一个节点之后;作为当前节点的下一个节点）
	public void after(LoopNode node)
	{
		//取出下一个节点作为下下一个节点
		LoopNode nextnext=this.next;
		//把新节点作为当前节点的下一个节点
		this.next=node;
		//把下下一个节点设置为新节点的下一个节点
		node.next=nextnext;
	}
	//当前节点是否是最后一个节点
	public boolean isLast()
	{
		return this.next == null;
	}
}
