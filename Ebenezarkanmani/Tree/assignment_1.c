
/* 1) Find ‘n’th smallest element in a given set of numbers */

#include <iostream> 
using namespace std; 
  
struct Node { 
    int data; 
    Node *left, *right; 
    Node(int x) 
    { 
        data = x; 
        left = right = NULL; 
    } 
}; 
  
// Recursive function to insert an key into BST 
Node* insert(Node* root, int x) 
{ 
    if (root == NULL) 
        return new Node(x); 
    if (x < root->data) 
        root->left = insert(root->left, x); 
    else if (x > root->data) 
        root->right = insert(root->right, x); 
    return root; 
} 
  

Node* kthSmallest(Node* root, int& count, int k) 
{ 
    
    if (root == NULL) 
        return NULL; 
  
   
    Node* left = kthSmallest(root->left, count, k); // left subtree
  
    
    if (left != NULL) 
        return left; // found in left subtree
  
     
    count++; 
    if (count == k) 
        return root; 
  
    
    return kthSmallest(root->right, count, k); // right subtree
} 
  
// Function to find k'th largest element in BST 
void printSmallest(Node* root, int k) 
{ 
    
    int count = 0; 
    Node* res = kthSmallest(root, count, k); 
    if (res != NULL) 
        cout << "K-th Smallest Element is " << res->data; 
} 
  

int main() 
{ 
    Node* root = NULL; 
	  
    int n;
	  cin >> n;
	
    int keys[n];
    for(int i=0;i<n;i++)
		  cin >> keys[i];
		
    for (int x : keys) 
        root = insert(root, x); 
  
    printSmallest(root, n); 
    return 0; 
} 
