
package splaytreegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
 
public class SplayTreeGUI extends JFrame implements ActionListener{

    int countNodes = 0;
    String InOrder;                     //String to contain inorder traversal
    String PostOrder;                  //String to contain postorder traversal
    String PreOrder;                  //String to contain preorder traversal
    String MaxValue;                //String to contain leaf nodes
    String MinValue;            //String to contain nonleaf nodes
    String NumberOfNodes;
    
    Node Root = null;             //Global root node for the tree
    
    
    int[][] NodeCoOrdinates = new int[500][3];  //array to store the coodinates of the nodes of the tree
    int Counter = 0;
    
    boolean TreePainted = false;      //boolean variable to indicate that the tree has been painted
    
    //buttons for the various tree functions, exit, reset etc.
    private JButton tree = new JButton("Tree");                                 
    private JButton inOrder = new JButton("In-Order");
    private JButton postOrder = new JButton("Post-Order");
    private JButton preOrder = new JButton("Pre-Order");
    private JButton maxValue = new JButton("Maximum Value");
    private JButton minValue = new JButton("Minimum Value");
    private JButton numberOfNodes = new JButton("Number Of Nodes in Tree");
    private JButton search = new JButton("Search");
    private JButton delete = new JButton("Delete");
    private JButton rePaint = new JButton("RePaint");
    private JButton reset = new JButton("Reset");
    private JButton exit = new JButton("Exit");
    
    //text fields for the various tree functions
    private JTextField f1 = new JTextField(15);//Constructs a new empty TextField with the specified number of columns
    private JTextField f2 = new JTextField(15);
    private JTextField f3 = new JTextField(15);
    private JTextField f4 = new JTextField(15);
    private JTextField f5 = new JTextField(15);
    private JTextField f6 = new JTextField(15);
    private JTextField f7 = new JTextField(15);
    private JTextField f8 = new JTextField(15);
    private JTextField f9 = new JTextField(15);
    
    //Panel contains the buttons
    private JPanel buttonPanel = new JPanel();
    
    //Panel contains the text fields
    private JPanel fieldPanel = new JPanel();
    Font font = new Font("Verdana", Font.BOLD, 20);
    
    private JLabel Label = new JLabel();
    private JLabel Label2 = new JLabel();
    
    //Panel to display the tree
    private Tree view = new Tree(); 
    
    public SplayTreeGUI()
    {
        GridLayout GL1 = new GridLayout(2,1); // (rows, columns)
        setLayout(GL1);
        
        //Constructor to create the GUI of the class
        setTitle("Splay Tree");
        setBackground(Color.white);
        
        //Adding the tree view panel to the frame, setting border and size
        add(view);
        view.setBorder(new TitledBorder("Tree View"));
        view.setPreferredSize(null);
        view.setVisible(true);
        view.setBackground(Color.BLACK);
        
        add(Label);
        
        //Layout for ButtonPanel and FieldPanel
        GridLayout GL2 = new GridLayout(1,2); // (rows, columns)
        
        Label.setLayout(GL2);
        
        //Adding panels containing the buttons and textfields
        Label.add(buttonPanel);
        Label.add(fieldPanel);
        
         //Setting layouts for the button panel and field panel
        buttonPanel.setLayout(new GridLayout(10,1));  //GridLayout(9-Rows, 1-Columns) in buttonPanel
        fieldPanel.setLayout(new GridLayout(10,1));  //GridLayout(9-Rows, 1-Columns) in fieldPanel
        
        //Setting the color scheme for the buttons and adding the text fields and buttons
        tree.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(tree);
        fieldPanel.add(f1);
        f1.setBackground(Color.WHITE);
        
        inOrder.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(inOrder);
        fieldPanel.add(f2);
        f2.setBackground(Color.WHITE);
        
        postOrder.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(postOrder);
        fieldPanel.add(f3);
        f3.setBackground(Color.WHITE);
        
        preOrder.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(preOrder);
        fieldPanel.add(f4);
        f4.setBackground(Color.WHITE);
        
        maxValue.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(maxValue);
        fieldPanel.add(f5);
        f5.setBackground(Color.WHITE);
        
        minValue.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(minValue);
        fieldPanel.add(f6);
        f6.setBackground(Color.WHITE);
        
        numberOfNodes.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(numberOfNodes);
        fieldPanel.add(f7);
        f7.setBackground(Color.WHITE);
        
        search.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(search);
        fieldPanel.add(f8);
        f8.setBackground(Color.WHITE);
        
        delete.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(delete);
        fieldPanel.add(f9);
        f9.setBackground(Color.WHITE);
        
        rePaint.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(rePaint);
        
        add(Label2);
        
        //Layout for Reset and Exit buttons
        GridLayout GL3 = new GridLayout(1,2); // (rows, columns)
        
        Label2.setLayout(GL3);
        
        fieldPanel.add(Label2);
        
        reset.setBackground(Color.black);
        Label2.add(reset);
        reset.setForeground(Color.white);
        
        exit.setBackground(Color.black);
        Label2.add(exit);
        exit.setForeground(Color.white);
        
        //Adding ActionListeners to all the buttons
        tree.addActionListener(this);
        inOrder.addActionListener(this);
        postOrder.addActionListener(this);
        preOrder.addActionListener(this);
        maxValue.addActionListener(this);
        minValue.addActionListener(this);
        numberOfNodes.addActionListener(this);
        search.addActionListener(this);
        delete.addActionListener(this);
        rePaint.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);
        
        //All buttons other than Tree, Reset and Exit are disabled by default
        inOrder.setEnabled(false);
        postOrder.setEnabled(false);
        preOrder.setEnabled(false);
        maxValue.setEnabled(false);
        minValue.setEnabled(false);
        numberOfNodes.setEnabled(false);
        search.setEnabled(false);
        delete.setEnabled(false);
        rePaint.setEnabled(false);
        f2.setEditable(false);
        f3.setEditable(false);
        f4.setEditable(false);
        f5.setEditable(false);
        f6.setEditable(false);
        f7.setEditable(false);
        
        //Finishing up
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();         //????
        setExtendedState(JFrame.MAXIMIZED_BOTH);    //????
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == tree)
        {
            String str = f1.getText();
            try
            {
                //Input is split using "," and is parsed
                String[] treeSplit = str.split(",");
                countNodes = treeSplit.length;

                //Root node created
                Node temp = new Node(Integer.parseInt(treeSplit[0]));

                //Iterate through the split input and add nodes to the tree
                for(int i=1; i<treeSplit.length;i++)
                {
                    temp = InsertNode(temp, Integer.parseInt(treeSplit[i]) );            
                }

                //Set root to temp
                Root = temp;

                //Paint the tree on the panel
                view.paintTree();

                //Indicate that the tree has been painted
                TreePainted = true;

                //Enable Splay tree function buttons
                inOrder.setEnabled(true);
                postOrder.setEnabled(true);
                preOrder.setEnabled(true);
                maxValue.setEnabled(true);
                minValue.setEnabled(true);
                numberOfNodes.setEnabled(true);
                search.setEnabled(true);
                delete.setEnabled(true);
                rePaint.setEnabled(true);
            }
            catch (Exception exception)
            { 
                JOptionPane.showMessageDialog(null, "Input not in correct format\nCorrect format eg. 1,7,3,9");
                f1.setText("");
            }
        }
        //Perform inorder traversal and display it
        else if(e.getSource() == inOrder)
        {
            InOrder = "";
            InOrder(Root);
            f2.setText(InOrder);
        }
        //Perform postorder traversal and display it
        else if(e.getSource() == postOrder)
        {
            PostOrder = "";
            PostOrder(Root);
            f3.setText(PostOrder);
        }
        //Perform preorder traversal and display it
        else if(e.getSource() == preOrder)
        {    
            PreOrder = "";
            PreOrder(Root);
            f4.setText(PreOrder);
        }
        //calculate leaf nodes and display them
        else if(e.getSource() == maxValue)
        {    
            MaxValue = "";
            MaximumValue(Root);
            f5.setText(MaxValue);
        }
        //calculate nonleafnodes and display them
        else if(e.getSource() == minValue)
        {
            MinValue = "";
            MinimumValue(Root);
            f6.setText(MinValue);
        }
        else if(e.getSource() == numberOfNodes)
        {
            NumberOfNodes = "";
            NumberOfNodes = NumberOfNodes + countNodes;
            MinimumValue(Root);
            f7.setText(NumberOfNodes);
        }
        //search element in tree
        else if(e.getSource() == search)
        {
            if(f8.getText() != null)
            {
                try
                {
                    //Parse search value
                    int x = Integer.parseInt(f8.getText()); 
                    view.paintTree();

                    //Search value in the tree
                    if(SearchTree(Root,x))
                    {
                        //if value is found, inform user
                        f8.setFont(font);
                        f8.setForeground(Color.green);
                        f8.setText(x + " is in the Tree");
                    }
                    else
                    {
                        //if value is not found, inform user
                        f8.setFont(font);
                        f8.setForeground(Color.red);
                        f8.setText(x + " is not in the Tree");
                    }
                }
                catch(Exception ex) 
                { 
                    JOptionPane.showMessageDialog(null, "Incorrect input format"); 
                }
            }
        }
        //delete element from tree
        else if(e.getSource() == delete)
        {
            if(f9.getText() != null)
            {
                try
                {
                    int x = Integer.parseInt(f9.getText());
                    Delete(x);
                    view.repaint();     //clear the treeview panel after deletion
                }
                catch(Exception ex) 
                {
                    JOptionPane.showMessageDialog(null, "Incorrect input format");
                }
            }
        }
        //repaint the tree, must repaint after deletion an element
        else if(e.getSource() == rePaint)
        {
            view.paintTree();
        }
        else if(e.getSource() == reset)
        {
            dispose();  //Reset the program
            new SplayTreeGUI();
        }
        else if(e.getSource() == exit) 
        {    
            dispose();  ////Exit from the program
        }   
    }
    public Node InsertNode(Node root,int d)
    {
        Node temp1 = root;
        Node par = null;
        
        while(temp1 != null)
        {
            par = temp1;
            if(d > par.data)
            {
                temp1 = temp1.right;
            }
            else
            {
                temp1 = temp1.left;
            }
        }
        
        Node temp2 = new Node();
        temp2.data = d;
        temp2.parent = par;
        
        if(par == null)
        {
            root = temp2;
        }
        else if(d > par.data)
        {
            par.right = temp2;
        }
        else
        {
            par.left = temp2;
        }
        Splay(temp2);
        
        return temp2;
    }
    
    public void Splay(Node node)
    {
        while(node.parent != null)
        {
            Node Parent = node.parent;
            Node GParent = Parent.parent;
            
            if(GParent == null)
            {
                if (node == Parent.left)
                {
                    //Zig Rotation (Left case)
                    makeLeftChildParent(node, Parent);  //(Right Rotation)
                }
                else
                {
                    //Zag Rotation (Right case)
                    makeRightChildParent(node, Parent); //(Left Rotation)
                }                
            }
            else
            {
                if(node == Parent.left)
                {
                    if(Parent == GParent.left)
                    {
                        //Zig-Zig Rotation (Left Left case)
                        makeLeftChildParent(Parent, GParent);   //(Right Rotation)
                        makeLeftChildParent(node, Parent);     //(Right Rotation)
                    }
                    else 
                    {
                        //Zag-Zig Rotation (Right Left case)
                        makeLeftChildParent(node, node.parent);    //(Right Rotation)
                        makeRightChildParent(node, node.parent);  //(Left Rotation)
                    }
                }
                else 
                {
                    if(Parent == GParent.left)
                    {
                        //Zig-Zag Rotation (Left Right case) 
                        makeRightChildParent(node, node.parent);    //(Left Rotation)
                        makeLeftChildParent(node, node.parent);    //(Right Rotation)
                    } 
                    else 
                    {
                        //Zag-Zag Rotation (Right Right case)
                        makeRightChildParent(Parent, GParent);  //(Left Rotation)
                        makeRightChildParent(node, Parent);    //(Left Rotation)
                    }
                }
            }
        }
        Root = node;
    }
    public void makeLeftChildParent(Node Chi, Node Par)
    {
        if (Par.parent != null)
        {
            if (Par == Par.parent.left)
            {
                Par.parent.left = Chi;
            }
            else 
            {
                Par.parent.right = Chi;
            }
        }
        
        if(Chi.right != null)
        {
            Chi.right.parent = Par;
        }
        
        Chi.parent = Par.parent;
        Par.parent = Chi;
        Par.left = Chi.right;
        Chi.right = Par;
    }
    public void makeRightChildParent(Node Chi, Node Par)
    {
        if (Par.parent != null)
        {
            if (Par == Par.parent.left)
            {
                Par.parent.left = Chi;
            }
            else
            {
                Par.parent.right = Chi;
            }
        }
        
        if (Chi.left != null)
        {
            Chi.left.parent = Par;
        }
        
        Chi.parent = Par.parent;
        Par.parent = Chi;
        Par.right = Chi.left;
        Chi.left = Par;
    }
    
    public void Delete(int d)
    {
        Node node = FindDeletedNode(d);
        
        if (node == null)
        {
            return;
        }
        
        Splay(node);
        
        if( (node.left != null) && (node.right !=null) )
        { 
            Node min = node.left;
            
            while(min.right!=null)
            {
                min = min.right;
            }

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            Root = node.left;
        }
        else if (node.right != null)
        {
            node.right.parent = null;
            Root = node.right;
        } 
        else if( node.left !=null)
        {
            node.left.parent = null;
            Root = node.left;
        }
        else
        {
            Root = null;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        
        countNodes--;
    }
    
    public Node FindDeletedNode(int d)
    {
        Node deletedNode = Root;
        
        while(deletedNode != null)
        {
            if(d < deletedNode.data)
            {
                deletedNode = deletedNode.left;
            }
            else if (d > deletedNode.data)
            {
                deletedNode = deletedNode.right;
            }
            else
            {
                return deletedNode;
            }
        }
        return null;
    }
    
    //Function to compute the Maximum Value in Splay Tree
    public  void MaximumValue(Node node) 
    {
        while(node.right != null)
        {
            node = node.right;
        }
        MaxValue = MaxValue + node.data;
    }
    
    //Function to compute the Minimum Value in Splay Tree
    public void MinimumValue(Node node) 
    {
        while(node.left != null)
        {
            node = node.left;
        }
        MinValue = MinValue + node.data;
    }
    
    //Function to determine if passed node is a leaf
    public static boolean isLeaf(Node node) 
    {
        if( node != null && node.left == null && node.right == null )
        {
            return true;
        }
        return false;
    }
    
    //Function to perform the inorder traversal of a Splay tree
    public void InOrder(Node root)
    {
        if(root != null)
        {   InOrder(root.left);
            InOrder += root.data + " ";
            InOrder(root.right);
        }
    }
    
    //Function to perform the preorder traversal of a Splay tree
    public void PreOrder(Node root)
    {    
        if(root != null)
        {           
            PreOrder += root.data + " ";
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
    
    //Function to perform the postoder traversal of a Splay tree
    public void PostOrder(Node root)
    {    
        if(root != null)
        {
            PostOrder(root.left);
            PostOrder(root.right);
            PostOrder += root.data + " ";
        }        
    }
    
    //Recursive function to perform search of passed data on a Splay Tree
    //If data is found, returns true else false
    private boolean SearchTree(Node node, int data)
    {    
        Graphics g = getGraphics();
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) 
        {
            Logger.getLogger(SplayTreeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(node == null)
        { 
            return false; 
        }
        
        //if data is found, its node is found and is changed to green color
        if (data == node.data)
        { 
            int[] temp = SearchInCoords(node.data);
            if(temp[0] != 0 && temp[1] != 0)
            {
                g.setColor(Color.green);         
                //g.fillOval(x-coOrd, y-coOrd, width, height)
                g.fillOval(temp[0] + 8, temp[1] + 31, 30, 30);
                
                g.setColor(Color.black);
                //g.fillOval(string , x-coOrd, y-coOrd)
                g.drawString(node.data + "", temp[0] + 20, temp[1] + 50);   
            }
            return true; 
        } 
        
        //if data is not found, the current node is changed to yellow color and the search is called recursively
        //on the left subtree since data is smaller than current node data
        else if (data<node.data)
        { 
            int[] temp = SearchInCoords(node.data);
            if(temp[0] != 0 && temp[1] != 0)
            {
                g.setColor(Color.yellow);     
                //g.fillOval(x-coOrd, y-coOrd, width, height)
                g.fillOval(temp[0] + 8, temp[1] + 31, 30, 30);
                
                g.setColor(Color.black);
                //g.fillOval(string , x-coOrd, y-coOrd)
                g.drawString(node.data + "", temp[0] + 20, temp[1] + 50);   
            }
            return SearchTree(node.left, data); 
        } 
        
        //if data is not found, the current node is changed to yellow color and the search is called recursively
        //on the right subtree since data is greater than current node data
        else 
        { 
            int[] temp = SearchInCoords(node.data);
            if(temp[0] != 0 && temp[1] != 0) 
            {
                g.setColor(Color.yellow);
                //g.fillOval(x-coOrd, y-coOrd, width, height)
                g.fillOval(temp[0] + 8, temp[1] + 31, 30, 30);
                
                g.setColor(Color.black);
                    //g.fillOval(string , x-coOrd, y-coOrd)
                g.drawString(node.data + "", temp[0] + 20, temp[1] + 50);   
            }
            return SearchTree(node.right, data); 
        } 
    }
    
    //Search for the coordinates of the passed value
    //used to find the node coordinates for passed data
    private int[] SearchInCoords(int x) 
    {
        for(int i=0; i<NodeCoOrdinates.length; i++)
        {
            if(x == NodeCoOrdinates[i][2]) 
            {
                int[] temp = {NodeCoOrdinates[i][0], NodeCoOrdinates[i][1]};//moving (x,y) co-ordinate to temp array
                return temp;
            }
        }
        return new int[2];
    }
    
    class Tree extends JPanel{
        
        private int circleRadius = 15;          //node radius
        private int verticalSeperation = 45;   //Vertical Gap between two nodes in a Splay Tree
        
        protected void paintTree()
        {
            Graphics g = getGraphics();
            if(Root != null) 
            {                
                displayTree(g, Root, getWidth()/2, 35, getWidth()/4);        
            }
        }
        
        private void displayTree(Graphics g, Node node, int x, int y, int horizatalSeperation)
        {
            //Function to display a subtree with root as x,y        
            g.setColor(Color.red);
            //g.fillOval(x-coOrd, y-coOrd, width, heigth)
            g.fillOval(x - circleRadius, y - circleRadius, 2 * circleRadius, 2 * circleRadius);
            
            //Store the coordinates of the node, to be used for searching
            NodeCoOrdinates[Counter][0] = x - circleRadius;
            NodeCoOrdinates[Counter][1] = y - circleRadius;
            NodeCoOrdinates[Counter][2] = node.data;
            
            Counter++;      //count number of nodes
            
            //Write the data value on the node
            g.setColor(Color.green);
            g.drawString(node.data + "", x - 6, y + 4);
            
            if (node.left != null) 
            {
                //using drawLine to draw line to the left node
                if(!TreePainted) 
                {
                    try
                    {              
                        Thread.sleep(500);
                    }
                    catch(InterruptedException ex) 
                    {
                        Logger.getLogger(SplayTreeGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                //draw the line between two nodes at left subtree
                drawLineBetween2Circles(g, x - horizatalSeperation, y + verticalSeperation, x-14, y);     

                //recursively draw the left subtree
                //decrease the horizontal and vertical gaps
                displayTree(g, node.left, x - horizatalSeperation, y + verticalSeperation, horizatalSeperation/2);        
            }
            if (node.right != null) 
            {
                //using drawLine to draw line to the right node
                if(!TreePainted) 
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(SplayTreeGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                //draw the line between two nodes at right subtree
                drawLineBetween2Circles(g, x + horizatalSeperation, y + verticalSeperation, x+14, y);         
                
                //recursively draw the right subtree
                //decrease the horizontal and vertical gaps
                displayTree(g, node.right, x + horizatalSeperation, y + verticalSeperation, horizatalSeperation/2);          
            }
        }
        
        //Function to draw a line between two circles centered at x1,y1 and x2,y2
        //Upper node co-ordinate is (x2,y2)
        //Lower node co-ordinate is (x1,y1)
        private void drawLineBetween2Circles(Graphics g, int x1, int y1, int x2, int y2) 
        {
            //Draw line between adjusted coordinates
            g.drawLine(x1, y1, x2, y2);
        }
    }
    
    public static void main(String[] args) {

        new SplayTreeGUI();
    }
}