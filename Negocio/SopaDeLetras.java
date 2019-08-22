package Negocio;

/**
 * Write a description of class SopaDeLetras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SopaDeLetras
{
    // instance variables - replace the example below with your own
    private char sopas[][];

    /**
     * Constructor for objects of class SopaDeLetras
     */
    public SopaDeLetras()
    {

    }

    public SopaDeLetras(String palabras) throws Exception
    {
        if(palabras==null || palabras.isEmpty())
        {
            throw new Exception("Error no se puede crear la matriz de char para la sopa de letras");
        }

        //Crear la matriz con las correspondientes filas:

        String palabras2[]=palabras.split(",");
        this.sopas=new char[palabras2.length][];
        int i=0;
        for(String palabraX:palabras2)
        {
            //Creando las columnas de la fila i
            this.sopas[i]=new char[palabraX.length()];
            pasar(palabraX,this.sopas[i]);
            i++;

        }   
    }

    private void pasar (String palabra, char fila[])
    {

        for(int j=0;j<palabra.length();j++)
        {
            fila[j]=palabra.charAt(j);
        }
    }

    public String toString()
    {
        String msg="";
        for(int i=0;i<this.sopas.length;i++)
        {
            for (int j=0;j<this.sopas[i].length;j++)
            {
                msg+=this.sopas[i][j]+"\t";
            }

            msg+="\n";

        }
        return msg;
    }

    public String toString2()
    {
        String msg="";
        for(char filas[]:this.sopas)
        {
            for (char dato :filas)
            {
                msg+=dato+"\t";
            }

            msg+="\n";

        }
        return msg;
    }

    public boolean esCuadrada()
    {
        int totalHorizontal = sopas[0].length;
        boolean cuadrada = false;
        for(int i = 1; i < sopas.length; i++)
        { if(sopas.length == totalHorizontal)
            {
                if (sopas[i].length == totalHorizontal)
                {
                    cuadrada = true;
                }
                else {cuadrada = false;}
            }
        }
        return cuadrada;
    }

    public boolean esDispersa()
    {
        int size = 0;
        int contador = 0;
        for (int i = 1; i < sopas.length; i++)
        {
            if(sopas[i].length != size)
            {
                size = sopas[i].length;
                contador++;
            }
        }
        if (contador > 1)return true;
        return false;
    }

    public boolean esRectangular()
    {
        int yAxis = 0;
        for (int i = 0; i < sopas.length; i++)
        {
            if(sopas[i].length == yAxis || yAxis == 0)
            {
                yAxis = sopas[i].length;
            }
            else{return false;}
        }
        if (yAxis != sopas.length)
        {
            return true;
        }
        return false;
    }

    /*
    retorna cuantas veces esta la palabra en la matriz
     */
    public int getContar(String palabra)
    {
        char [] palabraDes = new char[palabra.length()];
        int contador = 0;
        char caracter;
        for(int i = 0; i < palabra.length(); i++)
        {
            palabraDes[i] = palabra.charAt(i); 
        }
        for (int i = 0; i < sopas.length; i++)
        {
            for (int j = 0; j < sopas[i].length; j++)
            {
                int contadorLetras = 0;
                if (sopas[i][j] == palabraDes[0])
                {
                    for(int k = 0;k < palabra.length(); k++)
                    {
                        if (sopas[i][j++] == palabraDes[k])
                        {
                            contadorLetras++;
                        }
                    }
                    j--;
                }
                if (contadorLetras == palabra.length())
                {
                    contador++;
                }
            }
        }
        return contador;
    }

    /*
    debe ser cuadrada sopas
     */
    public char []getDiagonalPrincipal() throws Exception
    {
        char [] diagonalPrincipal = new char[sopas.length];
        if (this.esCuadrada() == false)
        {
            throw new Exception ("No es Cuadrada");
        }
        for (int i = 0; i < sopas.length; i++)
        {
            diagonalPrincipal[i] = sopas[i][i];
        }
        return  diagonalPrincipal;
    }
}
