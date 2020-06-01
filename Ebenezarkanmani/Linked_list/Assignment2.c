/* Code with only function which copies the linked list */
struct Node
{
int data;
Node* next;
Node* temp;
};

// Should return the head of the copied linked list the
// output will be 1 if successfully copied
Node *copyList(Node *head)
{
    if (head == NULL) return head;

    Node *t = head;
    while (t != NULL)
    {
        // making an identical list merged with original list
        Node *n = new Node(t->data);
        n->next = t->next;
        t->next = n;
        t = n->next;
    }
    
    t = head;
    Node *head2 = head->next;   // variable to be returned
    while (t != NULL)
    {
        // setting the tempitary pointers of duplicate list
        if (t->temp == NULL)
            t->next->temp = NULL;
        else 
            t->next->temp = t->temp->next;
        
        t = t->next->next;
    }
    
    t = head;
    while (t != NULL)
    {
        // separating the 2 merged lists (duplicate and original)
        head = t->next->next;
        
        if(head) 
			t->next->next = head->next;
        else 
			t->next->next = NULL;
        
        t->next = head;
        t = head;
    }

    return head2;
}
