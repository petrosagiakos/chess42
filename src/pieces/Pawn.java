package pieces;
import javax.swing.*;
import java.awt.*;
public class Pawn extends Piece {
    public Pawn(int l, String src,int c){
        super(l,src,c);
    }
    
    public void draw(int posx, int posy, JPanel surface, Graphics g){
        Toolkit t= Toolkit.getDefaultToolkit();  
        Image image = t.getImage(getClass().getResource(this.imageSrc));
        g.drawImage(image, posx,posy,50,50,surface);
       
        
    }
    public boolean CanMove(int ppx, int ppy, int posx, int posy, int[][] map){
        if(super.getC()==1){
            
            
            if(ppx==posx && posy==ppy+1 && map[posy][posx]==-1){
                return true;
            }
            if((ppx==posx+1 || ppx==posx-1) && posy==ppy+1 && map[posy][posx]!=-1 && map[posy][posx]>=6){
                return true;
            }
            if(ppy==1 && ppx==posx && posy==ppy+2 && map[posy][posx]==-1){
                return true;
            }
        }
        if(super.getC()==0){
            if(ppx==posx && posy==ppy-1 && map[posy][posx]==-1){
                return true;
            }
            if((ppx==posx+1 || ppx==posx-1) && posy==ppy-1 && map[posy][posx]!=-1 && map[posy][posx]<6){
                return true;
            }
            if(ppy==6 && ppx==posx && posy==ppy-2 && map[posy][posx]==-1){
                return true;
            }
        }
        return false;
    }
}

