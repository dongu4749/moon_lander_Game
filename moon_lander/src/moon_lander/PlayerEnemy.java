package moon_lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * The space rocket with which player will have to land.
 * 
 * @author www.gametutorial.net
 */

public class PlayerEnemy extends JFrame{
    
    /**
     * We use this to generate a random number for starting x coordinate of the rocket.
     */
    private Random random;
 
    /**
     * X coordinate of the rocket.
     */
    private int x;
    /**
     * Y coordinate of the rocket.
     */
    private int y;
    
    /**
     * Is rocket landed?
     */
    
    
    
    /**
     * Has rocket crashed?
     */
    
        
    /**
     * ������ ���� �ӵ�.
     */
    private int speedAccelerating;
    /**
     * ������ ����/�ϰ� �ӵ�. �ӵ��� �������� ������ �߷��� ������ �޷� ������� �����̴�.
     */
    private double speedStopping;
    
    /**
     * ���� �� �浹 ���� ������ ���� �� �ִ� �ִ� �ӵ��Դϴ�.
     */
    
    
    /**
     * x��ǥ�󿡼� ������ �󸶳� ������ ��� �������� �����̴°�?
     */
    private int speedX;
    /**
     * y��ǥ�󿡼� ������ �󸶳� ������ ��� �������� �����̴°�?
     */
    private int speedY;
            
    /**
     * Image of the rocket in air.
     */
    public BufferedImage enemyImg;
    /**
     * Image of the rocket when landed.
     */
    private BufferedImage rocketLandedImg;
    /**
     * Image of the rocket when crashed.
     */
    private BufferedImage rocketCrashedImg;
    /**
     * Image of the rocket fire.
     */
    private BufferedImage rainbowImg;
    
    
    
    /**
     * Width of rocket.
     */
    public int enemyImgWidth;
    /**
     * Height of rocket.
     */
    public int enemyImgHeight;
    
    public void setSpeedX(int speedX) {
    	this.speedX=speedX;
    }
    
    public int getSpeedX() {
    	return speedX;
    }
    
    public void setSpeedY(int speedY) {
    	this.speedY=speedY;
    }
    
    public int getSpeedY() {
    	return speedY;
    }
    
    public int getCoordinateX() {
    	return x;
    }
    
    public int getCoordinateY() {
    	return y;
    }
    
    public void setSpeedStopping(double speedStopping) {
    	this.speedStopping=speedStopping;
    }
    public PlayerEnemy()
    {
        Initialize();
        LoadContent();
        
        //���� rocketImgWidth�� �����Ƿ� ���� x ��ǥ�� �����մϴ�.
        x = random.nextInt(Framework.frameWidth - enemyImgWidth);
    }
    
    
    public void Initialize()
    {
        random = new Random();
        
        ResetPlayer();
       
        speedStopping = 1;
       
        speedAccelerating = 1;
        
        
       
       
    }
    
    private void LoadContent()
    {
        try
        {
            URL enemyImgUrl = this.getClass().getResource("/resources/images/right.png");
            enemyImg = ImageIO.read(enemyImgUrl);
            enemyImgWidth = enemyImg.getWidth();
            enemyImgHeight = enemyImg.getHeight();
            
            
            
            URL rainbowImgUrl = this.getClass().getResource("/resources/images/rainbow.png");
            rainbowImg = ImageIO.read(rainbowImgUrl);
           
            
        }
        catch (IOException ex) {
            Logger.getLogger(PlayerRocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Here we set up the rocket when we starting a new game.
     */
    public void ResetPlayer()
    {
        
        
        x = random.nextInt(Framework.frameWidth - enemyImgWidth);
        y = 200;
        
        speedX = 0;
        speedY = 0;
        
    }
    
    
    /**
     * Here we move the rocket.
     */
    public void Update()
    {
        // Calculating speed for moving up or down.
        if(Canvas.keyboardKeyState(KeyEvent.VK_I))
            speedY -= speedAccelerating;
        else
            speedY += speedStopping;
        
        // Calculating speed for moving or stopping to the left.
        if(Canvas.keyboardKeyState(KeyEvent.VK_J))
            speedX -= speedAccelerating;
        else if(speedX < 0)
            speedX += speedStopping;
        
        // Calculating speed for moving or stopping to the right.
        if(Canvas.keyboardKeyState(KeyEvent.VK_L))
            speedX += speedAccelerating;
        else if(speedX > 0)
            speedX -= speedStopping;
        
        // Moves the rocket.
        x += speedX;
        y += speedY;
        
        
    }
    
    public void Draw(Graphics2D g2d)
    {
        g2d.setColor(Color.white);
        g2d.drawString("2P-Rocket coordinates: " + x + " : " + y, 5, 30);
        g2d.drawString("2P-Enemy", x+2, y-7);
        if(StageBase.stage_count==1)
        g2d.drawString("��������:1",700, 20);
        else if(StageBase.stage_count==2)
           g2d.drawString("��������:2",700, 20);
        else if(StageBase.stage_count==3)
           g2d.drawString("��������:3",700, 20);
        else if(StageBase.stage_count==4)
           g2d.drawString("��������:4",700, 20);
        else if(StageBase.stage_count==5)
           g2d.drawString("��������:5",700, 20);
        
      
        // If the rocket is landed.
        
            // If player hold down a W key we draw rocket fire.
            if(Canvas.keyboardKeyState(KeyEvent.VK_I))
                g2d.drawImage(rainbowImg, x + 16, y +40, null);
            g2d.drawImage(enemyImg, x, y, null);
        }
    
    
    
}