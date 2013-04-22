package childout_javier;

import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.cdm.CaptureDeviceManager;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Permite mostrar en un JPanel el vídeo obtenido desde una webcam, con posibilidad
 * de capturar una imagen.
 * 
 * Ejemplo de uso:
 * WebCamCapture b = new WebCamCapture();
 * jPanelVideo.setLayout(new javax.swing.BoxLayout(jPanelVideo, javax.swing.BoxLayout.LINE_AXIS));
 * jPanelVideo.add(b.Componente());
 * 
 * Captura de la imagen:
 * b.capturarImagen();
 * b.setImage(jLabelImagen);
 * 
 * Requiere tener instalado en el PC el software JMF
 * Hay que añadir la librería jmf.jar que se instala en el PC con el JMF
 * JMF No funciona con el JDK de 64 bits (obtiene error: no jmvfw in java.library.path).
 */

public class WebCamCapture {
    //Controlador universal de windows
    private String dispositivo = "vfw:Microsoft WDM Image Capture (Win32):0";
    private Player player = null;

    public Component Componente(){
        Component componente_video;
        try {
            // Se obtiene el dispositivo
            CaptureDeviceInfo device = CaptureDeviceManager.getDevice(dispositivo);
            //se obtiene la fuente de datos de captura
            MediaLocator localizador = device.getLocator();
            //El localizador es del tipo "vfw://0" video para windows
            //se crea el PLAYER y se ejecuta
            player = Manager.createRealizedPlayer(localizador);
            player.start();
        } catch (IOException ex) {
            Logger.getLogger(WebCamCapture.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(WebCamCapture.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(WebCamCapture.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Si se pudo crear el PLAYER, se obtiene el componente de video
        if ((componente_video = player.getVisualComponent()) != null) {
                //se da un tamaÃ±o al componente
                componente_video.setSize(320, 240);
                return componente_video;
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo crear el video...");
                return null;
            }
    }

    //Metodo para capturar la imagen de la webcam
    Image img = null;
    public void capturarImagen(){
        FrameGrabbingControl ControlFG = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buffer = ControlFG.grabFrame();
        // creamos la imagen awt
       BufferToImage imagen = new BufferToImage((VideoFormat)buffer.getFormat());
       img = imagen.createImage(buffer);
    }

    public Image getImagen(){
        return img;
    }

    public void setImage(JLabel lb){
        capturarImagen();        
        lb.setIcon( new javax.swing.ImageIcon( img ) );
        System.out.println("ancho= " + img.getWidth(null));
        System.out.println("alto= " + img.getHeight(null));
    }
    
    public static void showDevicesList() {
        Vector devices = new Vector(javax.media.CaptureDeviceManager.getDeviceList(null));
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(devices.elementAt(i));
        }
    }    
}
