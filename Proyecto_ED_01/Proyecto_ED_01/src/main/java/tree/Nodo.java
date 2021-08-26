package tree;

public class Nodo<T> {
    
    private T content;
    private Tree<T> subArbol;

    public Nodo(T content) {
        this(content, new Tree<>());
    }

    public Nodo(T content, Tree<T> left) {
        this.content = content;
        this.subArbol = left;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Tree<T> getSubArbol() {
        return subArbol;
    }

    public void setSubArbol(Tree<T> left) {
        this.subArbol = left;
    }

    @Override
    public String toString() {
        return "Nodo{" + "content=" + content + '}';
    }
    
    
}
