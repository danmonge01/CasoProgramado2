package segundocasoprogramado;

import javax.swing.JOptionPane;

/**
 * @author Daniel
 */
public class SegundoCasoProgramado {
    
    int fila=6,columna=8,opcion,contadorPersonas;
    String nombre;
    int cedula;
    String direccion;
    int nombreContador=0;
    int cedulaContador=0;
    int direccionContador=0;
    CampoButaca matriz[][];
    Comprador comprador[];
    
    public SegundoCasoProgramado ()
    {
        matriz = new CampoButaca[fila][columna];        
        llenarMatriz();
        llenarCampos();
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Estas son las butacas disponibles\n\n"+valoresMatriz()+
                    "\n\nDigite: \n"+
                    "1.Para generar una nueva sala de cine\n"+
                    "2.Para vender butacas"));
            
            switch(opcion)
            {
                case 1:
                    crearButaca();
                    break;
                case 2:
                    comprarEntrada();
                    break;
            }
            
        }while(opcion!=5);
    }
    
    public void crearButaca ()
    {
        fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila"));
        columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna"));
        llenarMatriz();
        llenarCampos();
    }
    
    public void llenarMatriz ()
    {
        for (fila=0;fila<matriz.length;fila++)
        {
            for (columna=0;columna<matriz[0].length;columna++)
            {
                matriz[fila][columna] = new CampoButaca("ocupado");
            }
        }
    }
    
    public void llenarCampos ()
    {
        for (int contador=0;contador<9;contador++)
        {
            fila = azar();
            columna = azar();
            matriz[fila][columna].setEstado("disponible");
        }
    }
    
    public int azar () 
    {
        return (int)(Math.random()*(4-1)+0);
    }
    
    public String valoresMatriz ()
    {
        String valores = "";
        for (fila=0;fila<matriz.length;fila++)
        {
            for (columna=0;columna<matriz[0].length;columna++)
            {
                if (matriz[fila][columna].getEstado().equals("ocupado"))
                {
                    valores+=" (Sold):"+fila+","+columna;
                }
                else
                {
                    valores+=" (Free):"+fila+","+columna;
                }
            }
            valores+="\n";
        }
        return valores;
    }
    
    public void comprarEntrada ()
    {    
        int salir;
        generarComprador();
        do{
            fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la primera posicion\nEjemplo: 0"));
            columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la segunda posicion\nEjemplo: 2"));
            if(!matriz[fila][columna].getEstado().equals("ocupado"))
            {
                matriz[fila][columna].setEstado("ocupado");
                salir=1;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"El asiento ya ha sido vendido");
                JOptionPane.showMessageDialog(null,"Verifique los asientos\n\n"+valoresMatriz());
                salir=2;
            }
        }while(salir!=1);
    }
    
    public void generarComprador ()
    {
        comprador = new Comprador[contadorPersonas];
        contadorPersonas+=1;
        nombre = JOptionPane.showInputDialog("Digite su nombre por favor");
        cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite su cedula por favor"));
        direccion = JOptionPane.showInputDialog("Digite su direccion por favor");
        //comprador[contadorPersonas] = new Comprador(nombre,cedula,direccion);
        comprador[contadorPersonas].setNombre(nombre);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SegundoCasoProgramado segundoCasoProgramado = new SegundoCasoProgramado();
    }
    
}
