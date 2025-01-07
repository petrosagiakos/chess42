package pieces;

public abstract class Piece{
    protected String imageSrc;
    protected int level;
    protected int color;
    public Piece(int l, String src, int c){
        this.level=l;
        this.imageSrc=src;
        this.color=c;
    }
    public int getC(){
        return this.color;
    }
    public abstract boolean CanMove(int posx,int posy,int ppx, int ppy, int[][] map);
}