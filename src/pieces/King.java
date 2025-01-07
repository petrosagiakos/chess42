package pieces;

import javax.swing.JPanel;

import java.awt.*;
public class King extends Piece{
    public King(int l, String src,int c){
        super(l,src,c);
    }
   
    public void draw(int posx, int posy, JPanel surface, Graphics g){
        Toolkit t= Toolkit.getDefaultToolkit();  
        Image image = t.getImage(getClass().getResource(this.imageSrc));
        g.drawImage(image, posx,posy,50,50,surface);
       
        
    }
    public boolean CanMove(int ppx, int ppy, int posx, int posy, int[][] map){
        if((posx==ppx+1 && posy==ppy) || (posx==ppx && posy==ppy+1) ||
           (posx==ppx-1 && posy==ppy) || (posx==ppx && posy==ppy-1) || 
           (posx==ppx+1 && posy==ppy+1) || (posx==ppx-1 && posy==ppy+1) ||
           (posx==ppx+1 && posy==ppy-1) || (posx==ppx-1 && posy==ppy-1)){
            if(map[posy][posx]!=-1 && ((map[posy][posx]>=6 && map[ppy][ppx]==4) || (map[posy][posx]<6 && map[ppy][ppx]==10)) ){
                return true;
            }else if(map[posy][posx]==-1){
                return true;
            }
        }
        return false;
    }

    

}
