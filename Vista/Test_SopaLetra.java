package Vista;
import Negocio.*;

/**
 * Write a description of class Test_SopaLetra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test_SopaLetra
{

    public static void main(String nada[])
    {

        try{
            SopaDeLetras s=new SopaDeLetras("marco,ana,jose maria");
            SopaDeLetras c=new SopaDeLetras("beto,luis,juan,pepe");
            SopaDeLetras r=new SopaDeLetras("roberto,alberto,mamerto");

            System.out.println(s);
            System.out.println("*******************");
            System.out.println(s.toString2());
            
            if(s.esCuadrada() == true)System.out.println("Sopa 1 es Cuadrada");
            if(c.esCuadrada() == true)System.out.println("Sopa 2 es Cuadrada");
            if(c.esRectangular() == true)System.out.println("Sopa 2 es Rectangular");
            if(r.esRectangular() == true)System.out.println("Sopa 3 es Rectangular");
            if(s.esDispersa()== true)System.out.println("Sopa 1 es Dispersa");
            if(c.esDispersa()== true)System.out.println("Sopa 2 es Dispersa");
            if(r.esDispersa()== true)System.out.println("Sopa 3 es Dispersa");
            
            System.out.println(r.getContar("to"));
            System.out.println(r.getContar("mamerto"));
            
            try
            {
                String diagonal = "";
                if(c.getDiagonalPrincipal() != null)
                {
                    for(int i = 0; i < c.getDiagonalPrincipal().length; i++)
                    {
                        diagonal+=c.getDiagonalPrincipal()[i];
                    }
                    System.out.println(diagonal);
                }
                String diagonal2 = "";
                if(s.getDiagonalPrincipal() != null)
                {
                    for(int i = 0; i < s.getDiagonalPrincipal().length; i++)
                    {
                        diagonal2+=s.getDiagonalPrincipal()[i];
                    }
                    System.out.println(diagonal2);
                }
            }catch(Exception error)
            {
                System.err.println(error.getMessage());
            }
            
        }catch(Exception error)
        {
            System.err.println(error.getMessage());
        }

        
    }
}
