package main;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import pieces.*;
import java.awt.*;

public class Board extends JPanel {
    int[][] map = {{1,2,3,4,5,3,2,1},
                {0,0,0,0,0,0,0,0},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {6,6,6,6,6,6,6,6},
                {7,8,9,10,11,9,8,7}};
    Piece[] Pieces = new Piece[12];
    int posx = -1;
    int posy = -1;
    int ppx=-1;//holding the previous click
    int ppy=-1;
    int cnt=0;
    
   
    String path="data/images/";
    
    public Board(){
        
        this.PiecesInit();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Get the mouse click position
                int x = e.getX();
                int y = e.getY();
                //if mouse is clicked and reset
                
        
                // Show a message with the click position
                int ttx=x/50;
                int tty=y/50;

                
                if(ppx==-1 && ppy==-1){
                    ppx=ttx;
                    ppy=tty;
                    if(map[ppy][ppx]==-1){
                        ppx=-1;
                        ppy=-1;
                    }
                }else{
                    posx=ttx;
                    posy=tty;
                    boolean cm=false;
                   
                    if(map[ppy][ppx]==0 || map[ppy][ppx]==6){
                        cm=((Pawn)Pieces[map[ppy][ppx]]).CanMove(ppx,ppy,posx,posy,map);
                        
                        
                    }else if(map[ppy][ppx]==1 || map[ppy][ppx]==7){
                        cm=((Rook)Pieces[map[ppy][ppx]]).CanMove(ppx,ppy,posx,posy,map);
                        
                                              
                    }else if(map[ppy][ppx]==3 || map[ppy][ppx]==9){
                        cm=((Bishop)Pieces[map[ppy][ppx]]).CanMove(ppx,ppy,posx,posy,map);
                        
                    }else if(map[ppy][ppx]==5 || map[ppy][ppx]==11){
                        cm=((Queen)Pieces[map[ppy][ppx]]).CanMove(ppx,ppy,posx,posy,map);
                        
                    }else if(map[ppy][ppx]==2 || map[ppy][ppx]==8){
                        cm=((Knight)Pieces[map[ppy][ppx]]).CanMove(ppx,ppy,posx,posy,map);
                        
                    }else if(map[ppy][ppx]==4 || map[ppy][ppx]==10){
                        cm=((King)Pieces[map[ppy][ppx]]).CanMove(ppx,ppy,posx,posy,map);
                        
                    }
                    if(cnt%2==0){
                        if(map[ppy][ppx]<6){
                            cm=false;
                        }
                    }else{
                        if(map[ppy][ppx]>=6){
                            cm=false;
                        }
                    }
                    
                    if(cm){
                        map[posy][posx]=map[ppy][ppx];
                        map[ppy][ppx]=-1;
                        cnt++;
                    }
                    
                    repaint();
                    ppx = -1;
                    ppy = -1;
                    posx = -1;
                    posy = -1;
                }

                repaint();
                
                
               
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        //initializing tiles
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j)%2==0){
                    g.setColor(Color.WHITE);
                    
                }else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect( j*50, i*50,50,50);
            }
        }
        
        this.Refresh(g); 
       
        if(ppx!=-1 && ppy!=-1){
            g.setColor(Color.RED);
            g.drawRect(ppx*50, ppy*50, 50, 50);
        }
    }
    
    protected void Refresh(Graphics g){
        //drawing the pieces in ChessBoard;
        //remove all the obhect creations here!!!
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                switch (map[j][i]) {
                    case 0:
                        //Pieces[map[j][i]]=new Pawn(1,this.path+"MayroPioni.png",1);
                        ((Pawn)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                        
                    case 1:
                        //Pieces[map[j][i]]=new Rook(1,this.path+"MayrosPyrgos.png",1);
                        ((Rook)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 2:
                        //Pieces[map[j][i]]=new Knight(1,this.path+"MayrosIppos.png",1);
                        ((Knight)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 3:
                        //Pieces[map[j][i]]=new Bishop(1,this.path+"MayrosAksiomatikos.png",1);
                        ((Bishop)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 4:
                        //Pieces[map[j][i]]=new King(1,this.path+"MayrosVasilias.png",1);
                        ((King)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 5:
                        //Pieces[map[j][i]]=new Queen(1,this.path+"MayrhVasilissa.png",1);
                        ((Queen)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 6:
                        ///Pieces[map[j][i]]=new Pawn(1,this.path+"LeykoPioni.png",1);
                        ((Pawn)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 7:
                        //Pieces[map[j][i]]=new Rook(1,this.path+"LeykosPyrgos.png",1);
                        ((Rook)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 8:
                        //Pieces[map[j][i]]=new Knight(1,this.path+"LeykosIppos.png",1);
                        ((Knight)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 9:
                        //Pieces[map[j][i]]=new Bishop(1,this.path+"LeykosAksiomatikos.png",1);
                        ((Bishop)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 10:
                        //Pieces[map[j][i]]=new King(1,this.path+"LeykosVasilias.png",1);
                        ((King)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                    case 11:
                        //Pieces[map[j][i]]=new Queen(1,this.path+"LeykhVasilissa.png",1);
                        ((Queen)Pieces[map[j][i]]).draw(50*i,50*j,this,g);
                        break;
                        
                    default:
                        break;
                }
            }
        }
    }
    
    
    protected void PiecesInit(){
        //initilizing pieces
        Pieces[0]=new Pawn(1,this.path+"MayroPioni.png",1);
        Pieces[1]=new Rook(1,this.path+"MayrosPyrgos.png",1);
        Pieces[2]=new Knight(1,this.path+"MayrosIppos.png",1);
        Pieces[3]=new Bishop(1,this.path+"MayrosAksiomatikos.png",1);
        Pieces[4]=new King(1,this.path+"MayrosVasilias.png",1);
        Pieces[5]=new Queen(1,this.path+"MayrhVasilissa.png",1);
        Pieces[6]=new Pawn(1,this.path+"LeykoPioni.png",0);
        Pieces[7]=new Rook(1,this.path+"LeykosPyrgos.png",0);
        Pieces[8]=new Knight(1,this.path+"LeykosIppos.png",0);
        Pieces[9]=new Bishop(1,this.path+"LeykosAksiomatikos.png",0);
        Pieces[10]=new King(1,this.path+"LeykosVasilias.png",0);
        Pieces[11]=new Queen(1,this.path+"LeykhVasilissa.png",0);
    }
}
