public class BinaryTree {
    private Node root;
    private int data;

    public boolean isBigger(int n1, int n2){
        if(n1 >= n2)
            return true;
        return false;
    }

    /*public boolean ternario(int n, int j){
         return (n > j) ? true: false;
    }*/

    public Node getRoot() {
        return root;
    }

    public void insert(int data, Node root){
        if(this.root == null){
            this.root = new Node(data);
        }
        else if(root == null){
            root = new Node(data);
        }else{
            if(isBigger(data, root.getData())){
                if(root.getRight() == null){
                    root.setRight(new Node(data));
                }else{
                    insert(data, root.getRight());
                }
            }else{
                if(root.getLeft() == null){
                    root.setLeft(new Node(data));
                }else{
                    insert(data, root.getLeft());
                }
            }
        }
        verifyBalance(this.root);
    }

    public void remove(int data, Node root){
        if(exists(data, root) != null){
            Node n = exists(data, root);
            if(n == getRoot() && n.getRight() == null && n.getLeft() == null){
                this.root = null;
            }else if(n == getRoot() && n.getRight() == null && n.getLeft() != null){
                this.root = n.getLeft();
                n.setLeft(null);
            }else if(n == getRoot() && n.getLeft() == null && n.getRight() != null){
                this.root = n.getRight();
                n.setRight(null);
            }else if(n.getLeft() == null && n.getRight() == null){//isLeaf
                Node dad = getDad(n, root);
                if(n == dad.getLeft()){
                    dad.setLeft(null);
                }else{
                    dad.setRight(null);
                }
            }else if(n.getLeft() != null && n.getRight() == null){//hasLeftKid
                Node k = n.getLeft();
                n.setLeft(null);
                n = getDad(n, root);
                n.setLeft(k);
            }else if(n.getLeft() == null && n.getRight() != null) {//hasRightKid
                Node k = n.getRight();
                n.setRight(null);
                n = getDad(n, root);
                n.setRight(k);
            }else if(getDad(n, root) == null){//Removing main root
                Node bk = n.getLeft();
                while(bk.getRight() != null){
                    bk = bk.getRight();
                }
                Node dad = getDad(bk, root);
                if(dad.getRight() == bk){
                    dad.setRight(null);
                }else{
                    dad.setLeft(null);
                }
                bk.setRight(n.getRight());
                bk.setLeft(n.getLeft());
                this.root = bk;
            }else{
                Node bk = n.getLeft();// bk = biggerKid
                n.setLeft(null);
                while(bk.getRight() != null){
                    bk = bk.getRight();
                }
                bk.setRight(n.getRight());
                n.setRight(null);
                Node dad = getDad(n, root);
                if(n == dad.getLeft()){
                    dad.setLeft(bk);
                }else{
                    dad.setRight(bk);
                }
            }
        }else{
            System.out.println("Valor não encontrado ");
        }
        verifyBalance(this.root);
    }

    public Node exists(int data, Node root) throws NullPointerException{
        if(root == null)
            return null;
        if(root.getData() == data)
            return root;
        if(!isBigger(data, root.getData())){
            return exists(data, root.getLeft());
        }
        return exists(data, root.getRight());
    }

    public Node getDad(Node n, Node root) throws NullPointerException{
        if(root == null)
            return null;
        if(root.getLeft() == n || root.getRight() == n)
            return root;
        if(!isBigger(n.getData(), root.getData())){
            return getDad(n, root.getLeft());
        }
        return getDad(n, root.getRight());
    }

    public int height(Node root){
        if(root == null){
            return -1;
        }
        return 1 + (height(root.getLeft()) > height(root.getRight()) ? height(root.getLeft()) : height(root.getRight()));
    }

    public int isBalanced(Node root){
        return height(root.getLeft()) - height(root.getRight());
    }

    public Node rotateRight(Node root){
        Node newRoot = root.getLeft();
        Node tmp = newRoot.getRight();
        newRoot.setRight(root);
        root.setLeft(tmp);
        return newRoot;
    }

    public Node rotateLeft(Node root){
        Node newRoot = root.getRight();
        Node tmp = newRoot.getLeft();
        newRoot.setLeft(root);
        root.setRight(tmp);
        return newRoot;
    }

    public Integer verifyBalance(Node root) {
        if (root == null) {
            return null;
        }

        verifyBalance(root.getLeft());
        verifyBalance(root.getRight());

        if (isBalanced(root) == 2 && isBalanced(root.getLeft()) == 1 || isBalanced(root) == 2 && isBalanced(root.getLeft()) == 0) {//rotate right
            if(root == this.root){//main root rotation
                this.root = rotateRight(root);
            }else{
                Node dad = getDad(root, getRoot());
                if(dad.getRight() == root){
                    dad.setRight(root = rotateRight(root));
                }else{
                    dad.setLeft(root = rotateRight(root));
                }
            }
            return isBalanced(root);
        }else if(isBalanced(root) == 2 && isBalanced(root.getLeft()) == -1){//double rotate right
            if(root== this.root){
                this.root.setLeft(rotateLeft(root.getLeft()));
                this.root = rotateRight(root);
            }else{
                root.setLeft(rotateLeft(root.getLeft()));
                Node dad = getDad(root, this.root);
                if(dad.getRight() == root){
                    dad.setRight(root = rotateRight(root));
                }else{
                    dad.setLeft(root = rotateRight(root));
                }
            }
            return isBalanced(root);
        }
        else if(isBalanced(root) == -2 && isBalanced(root.getRight()) == -1 || isBalanced(root) == -2 && isBalanced(root.getRight()) == 0){//rotate left
            if(root == this.root){// main root rotation
                this.root = rotateLeft(root);
            }else{
                Node dad = getDad(root, getRoot());
                if(dad.getRight() == root){
                    dad.setRight(root = rotateLeft(root));
                }else{
                    dad.setLeft(root = rotateLeft(root));
                }
            }
            return isBalanced(root);
        }else if(isBalanced(root) == -2 && isBalanced(root.getRight()) == 1){//double rotate left
            if(root == this.root){//main root rotation
                this.root.setRight(rotateRight(root.getRight()));
                this.root = rotateLeft(root);
            }else{
                root.setRight(rotateRight(root.getRight()));
                Node dad = getDad(root, this.root);
                if ((dad.getRight() == root)) {
                    dad.setRight(root = rotateLeft(root));
                } else {
                    dad.setLeft(root = rotateLeft(root));
                }
            }
            return isBalanced(root);
        }
        return null;
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.getData() + " ");
            if(root.getLeft() != null)
                preOrder(root.getLeft());
            if(root.getRight() != null)
                preOrder(root.getRight());
        }else{
            System.out.println("Árvore está vazia");
        }

    }

    public void inOrder(Node root){
        if(root != null){
            if (root.getLeft() != null)
                inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            if(root.getRight() != null)
                inOrder(root.getRight());
        }else{
            System.out.println("Árvore está vazia");
        }
    }

    public void postOrder(Node root){
        if(root != null){
            if (root.getLeft() != null)
                postOrder(root.getLeft());
            if(root.getRight() != null)
                postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }else {
            System.out.println("Árovre está vazia");
        }
    }
}