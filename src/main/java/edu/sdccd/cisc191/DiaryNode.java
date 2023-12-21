package edu.sdccd.cisc191;

import java.io.Serializable;

public class DiaryNode implements Serializable {

    private Diary Entry;
    private DiaryNode left;
    private DiaryNode right;



    public DiaryNode(Diary page){
        this.Entry = page;
        this.left = null;
        this.right = null;
    }

    public Diary getEntry(){
        return Entry;
    }


    public DiaryNode getLeft(){
        return left;
    }

    public void setLeft(DiaryNode left) {
        this.left = left;
    }

    public DiaryNode getRight() {
        return right;
    }

    public void setRight(DiaryNode right) {
        this.right = right;
    }
    public void add(DiaryNode child){
        String childMood = child.getEntry().getMood();
        String parentMood = this.getEntry().getMood();
        if(childMood.compareTo(parentMood)>0) {
            setRight(child);
        }
        else setLeft(child);

    }
}
