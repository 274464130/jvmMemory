package com.example.demo.tree;

public class NodeTree {

    private Node  node;

    /**
     * 初始化树
     */
    private  NodeTree (){};

    public NodeTree(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * 二叉树的清空
     * 首先需要提供一个节点 ，以某个节点为根节点，清空子树的方法，即递归删除每个节点
     * 接着提供一个删除树的方法，直接通过第一种删除到根节点就可以
     * @param node
     */
    public  void  clean(Node  node){
        if(node!=null){
            clean(node.getLeft());
            clean(node.getRight());
            node=null;
        }
    }

    /**
     * 删除树
     */
    public  void  clean(){
        clean(node);
    }

    /**
     * 获取树二叉树的高度
     */
    public  int  height(Node node){

        return  height(node);
    }
}
