#include<stdio.h>
#include<stdlib.h>
int value1,value2,list_value,pre,sum=0;
struct Node
{
  	int data;
	  struct Node *next;
}*head,*newnode,*temp;

void insert(int element)
{
	  newnode=(struct Node*)malloc(sizeof(struct Node));
         newnode->data=element;
	  newnode->next=NULL;
	
	  if(head==NULL)
	  {
			head=temp=newnode;
	  }
	  else 
	  {
		  temp->next=newnode;
		  temp=newnode;
	  }
}

int display()
{
	while(temp!=NULL)
	{
	
		if(temp==head)
		{
			printf("%d",temp->data);
			pre=list_value=temp->data;	
		}
		else
		{
			printf(" -> %d",abs(temp->data));
			pre=temp->data; // Getting values together eg 1 -> 2 which results 12
			list_value=list_value*10;
			if(list_value<0)
			list_value=list_value-pre;
			else
			list_value=list_value+pre;
		}
		temp=temp->next;
	}
	printf("\n");
	return list_value;	
}

void add(int value1,int value2)
{
	sum=value1+value2;// Adding list values

	int remainder=0,rev=0;
	
	int count=0;
	while (sum != 0) //Reversing the sum value
	{
        remainder = sum % 10;
        rev = rev * 10 + remainder;
        sum /= 10;
        count++;
    }
    int c=count;
    remainder=0;
    while(count!=0) // inserting into list
    {
    	remainder = rev % 10;
    	rev /= 10;
    	insert(remainder);
		count--;	
	}
	temp=head;
	display();
	
}


int main()
{
 	
 	//Intial head with null data
 	head=NULL;
 	
	int element,list1,list2,i;
	//No.of elements in list 1
	scanf("\n%d",&list1);

	//List1 element are inserted at begginnig
	for(i=0;i<list1;i++)
	{
	
		scanf("%d",&element);
		insert(element);
	}
	temp=head;
	//prints list1 value 
	value1=display();
	
	head=NULL;
	//No.of elements in list 2
	scanf("\n%d",&list2);

	//List1 element are inserted at end
	for(i=0;i<list2;i++)
	{
	
		scanf("%d",&element);
		insert(element);
	}
	temp=head;
	//prints list1 value 
	value2=display();
	head =NULL;
	add(value1,value2);

}
