import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;


public class LwjglShiftTest {

    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 480;
    
    public static void main(String[] args) throws Exception {
        setDisplayMode();
        Display.setTitle("Shift Test");
        Display.setFullscreen(false);
        Display.setVSyncEnabled(true);
        Display.create(new PixelFormat(32, 0, 24, 8, 0));
        Mouse.setGrabbed(false);
        
    	GL11.glMatrixMode(GL11.GL_PROJECTION);
    	GL11.glLoadIdentity();
    	GL11.glOrtho(0, 800, 0, 600, 1, -1);
    	GL11.glMatrixMode(GL11.GL_MODELVIEW);
    	
        while (true) {

        	if (Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                break;
            }

        	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        	
            Text.drawString("left shift", 10, 10);
            Text.drawString("right shift", 300, 10);
            
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
                Text.drawString("down", 100, 10);
            else
                Text.drawString("up", 100, 10);
            
            if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
                Text.drawString("down", 400, 10);
            else
                Text.drawString("up", 400, 10);
            
            Display.update();
        }
    }
     
    private static void setDisplayMode() throws Exception
    {
        DisplayMode[] dm = org.lwjgl.util.Display.getAvailableDisplayModes(SCREEN_WIDTH, SCREEN_HEIGHT, -1, -1, -1, -1, 60, 60);
        org.lwjgl.util.Display.setDisplayMode(dm, new String[] {
                "width=" + SCREEN_WIDTH,
                "height=" + SCREEN_HEIGHT,
                "freq=" + 60,
                "bpp=" + org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel()
         });
    }	
}
