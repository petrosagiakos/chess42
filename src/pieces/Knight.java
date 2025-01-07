package pieces;

import javax.swing.JPanel;
import java.awt.*;
public class Knight extends Piece{
    public Knight(int l, String src,int c){
        super(l,src, c);
    }
    
    public void draw(int posx, int posy, JPanel surface, Graphics g){
        Toolkit t= Toolkit.getDefaultToolkit();  
        Image image = t.getImage(getClass().getResource(this.imageSrc));
        g.drawImage(image, posx,posy,50,50,surface);
       
        
    }
    public boolean CanMove(int ppx, int ppy, int posx, int posy, int[][] map){
        if((posx==ppx+1 && posy==ppy+2) || (posx==ppx+2 && posy==ppy+1) || (posx==ppx-2 && posy==ppy-1) || 
        (posx==ppx-1 && posy==ppy-2) || (posx==ppx-1 && posy==ppy+2) || 
        (posx==ppx+2 && posy==ppy-1) || (posx==ppx-2 && posy==ppy+1) || (posx==ppx+1 && posy==ppy-2)){
            if(map[posy][posx]!=-1 && ((map[posy][posx]>=6 && map[ppy][ppx]==2) || (map[posy][posx]<6 && map[ppy][ppx]==8)) ){
                return true;
            }else if(map[posy][posx]==-1){
                return true;
            }
        }
        
        return false;
    }
}
