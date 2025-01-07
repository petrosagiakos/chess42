package pieces;

import javax.swing.JPanel;
import java.awt.*;
public class Queen extends Piece{
    public Queen(int l, String src,int c){
        super(l,src,c);
    }
   
    public void draw(int posx, int posy, JPanel surface, Graphics g){
        Toolkit t= Toolkit.getDefaultToolkit();  
        Image image = t.getImage(getClass().getResource(this.imageSrc));
        g.drawImage(image, posx,posy,50,50,surface);
       
        
    }
    public boolean CanMove(int ppx, int ppy, int posx, int posy, int[][] map){
        if(Math.abs(posx-ppx)==Math.abs(posy-ppy)){
            if(posx>ppx && posy>ppy){
                for(int i=ppx+1, j=ppy+1;i<posx;i++,j++){
                    if(map[j][i]!=-1){
                        return false;
                    }
                }
            }
            if(posx>ppx && posy<ppy){
                for(int i=ppx+1, j=ppy-1;i<posx;i++,j--){
                    if(map[j][i]!=-1){
                        return false;
                    }
                }
            }
            if(posx<ppx && posy<ppy){
                for(int i=ppx-1, j=ppy-1;i>posx;i--,j--){
                    if(map[j][i]!=-1){
                        return false;
                    }
                }
            }if(posx<ppx && posy>ppy){
                for(int i=ppx-1, j=ppy+1;i>posx;i--,j++){
                    if(map[j][i]!=-1){
                        return false;
                    }
                }
            }
            if(map[posy][posx]!=-1 && ((map[posy][posx]>=6 && map[ppy][ppx]==5) || (map[posy][posx]<6 && map[ppy][ppx]==11)) ){
                return true;
            }else if(map[posy][posx]==-1){
                return true;
            }
            
        }
        if(ppx==posx){
            
            for(int i=ppy+1;i<posy;i++){
                System.out.println(map[i][posx]);
                if(map[i][posx]!=-1){
                    return false;
                }
            }
            for(int i=ppy-1;i>posy;i--){
                System.out.println(map[i][posx]);
                if(map[i][posx]!=-1){
                    return false;
                }
            }
            if(map[posy][posx]!=-1 && ((map[posy][posx]>=6 && map[ppy][ppx]==5) || (map[posy][posx]<6 && map[ppy][ppx]==11))){
                return true;
            }else if(map[posy][posx]==-1){
                return true;
            }
            return false;
        }
        if(ppy==posy){
            for(int i=ppx+1;i<posx;i++){
                System.out.println(map[posy][i]);
                if(map[posy][i]!=-1){
                    return false;
                }
            }
            for(int i=ppx-1;i>posx;i--){
                System.out.println(map[posy][i]);
                if(map[posy][i]!=-1){
                    return false;
                }
            }
                
                if(map[posy][posx]!=-1 && ((map[posy][posx]>=6 && map[ppy][ppx]==5) || (map[posy][posx]<6 && map[ppy][ppx]==11)) ){
                    return true;
                }else if(map[posy][posx]==-1){
                    return true;
                }
                return false;
            
            
        }
    
        return false;
    }
}