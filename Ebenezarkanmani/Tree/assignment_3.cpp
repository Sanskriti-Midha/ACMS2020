/* Print a given tree in level order */

using namespace std; 
  

class node  
{  
    public: 
    int data;  
    node* left, *right;  
};

void printGivenLevel(node* root, int level);  
int height(node* node);  
Node* insert(Node* root, int key) ;
node* newNode(int data); 
  
Node* insert(Node* root, int key) 
{ 
    if (root == NULL) 
        return NewNode(key); 
    if (key < root->data) 
        root->left = insert(root->left, key); 
    else
        root->right = insert(root->right, key); 
    return root; 
}  
 

void printLevelOrder(node* root)  
{  
    int h = height(root);  
    int i;  
    for (i = 1; i <= h; i++)  
        printGivenLevel(root, i);  
}  
  

void printGivenLevel(node* root, int level)  
{  
    if (root == NULL)  
        return;  
    if (level == 1)  
        cout << root->data << " ";  
    else if (level > 1)  
    {  
        printGivenLevel(root->left, level-1);  
        printGivenLevel(root->right, level-1);  
    }  
}  
  

int height(node* node)  
{  
    if (node == NULL)  
        return 0;  
    else
    {  
      
        int lheight = height(node->left);    // calc compute the height of each subtree
        int rheight = height(node->right);  
  
        
        if (lheight > rheight)  // Takes the larger one
            return(lheight + 1);  
        else return(rheight + 1);  
    }  
}  
  

node* newNode(int data)  
{  
    node* Node = new node(); 
    Node->data = data;  
    Node->left = NULL;  
    Node->right = NULL;  
  
    return(Node);  
}  
  

int main()  
{  
	Node* root = NULL; 
	int n,elements;
	cin >> n;
	for(int i=0;i<n;i++)
	{
		cin>>elements;
		root=insert(root,elements);
	}
  
    printLevelOrder(root);  
  
    return 0;  
}  
