package AaronSwingPalette;

import javax.swing.*;
import java.awt.*;

/**/
public class AaronJCheckBox extends JCheckBox {
    public AaronJCheckBox(){
        super();
        setFont(new Font("Droid Sans Mono", Font.PLAIN, 20));
    }

    public AaronJCheckBox(String text){
        super(text);
        setFont(new Font("Droid Sans Mono", Font.PLAIN, 20));
    }
}