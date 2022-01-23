import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import java.util.ArrayList;
import java.io.File;
import java.lang.Math;


public class Earth extends Group
{
    private Sphere sph;
    private Rotate ry;

    private ArrayList<Sphere> yellowSphere;


    Earth()
    {
        String imgPath = new File("").getAbsolutePath();
        imgPath += "\\data\\resourcestp\\earth_lights_4800.png";//C:\Users\ismae\Google Drive\Ismael_drive\ENSEA ISMAEL\ENSEA\3EME Année\java\projectjava\Project\data

        sph = new Sphere(300);
        ry = new Rotate(0, new Point3D(0, 1, 0));

        PhongMaterial pm = new PhongMaterial();
        Image img = new Image(imgPath);

        pm.setDiffuseMap(img);
        sph.setMaterial(pm);

        this.getChildren().add(sph);

        AnimationTimer animationTimer = new AnimationTimer()
        {
            @Override
            public void handle(long time)
            {
                ry.setAngle(0.25);
                sph.getTransforms().add(ry);
            }
        };

        animationTimer.start();
    }

    public Sphere createSphere(Aeroport a, Color color)
    {
        Sphere sp = new Sphere(2);
        PhongMaterial pm = new PhongMaterial(color);
        sp.setMaterial(pm);

        return sp;
    }

    public void displayRedSphere(Aeroport a)
    {
        Sphere sp = createSphere(a, Color.BLUE);
        this.getChildren().add(sp);
    }

}
