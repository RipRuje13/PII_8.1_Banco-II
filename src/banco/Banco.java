//entrega 15/04/20
//Lizbeth Evelin  Barranco Morales
//Rogelio Adrián Noriega Luna 

package banco;
import java.util.Scanner;
public class Banco {
    public static void main(String[] args) {
        int num,opc,i=0;
        double cantidad=0;
        double lim;
        
        Scanner sc=new Scanner(System.in);
        Cuenta cta=new Cuenta(0);
        Cuenta a[] = new Cuenta[5];
        
        for(int e=0;e<5;e++){
            a[e]=new Cuenta(0);  
        }                
        
        do{
            System.out.println("1.Crear cuenta");
            System.out.println("2.Eliminar cuenta");
            System.out.println("3.Depositar");
            System.out.println("4.Retirar"); 
            System.out.println("5.Mostrar cuentas");
            System.out.println("6.Actualizar");
            System.out.println("7.Salir");
            System.out.println("Opcion:");
            opc=sc.nextInt();
            switch(opc){
                case 1:    
                    System.out.println("\t1.Cuenta ahorro\n\t2.Cuenta corriente");
                    int op=sc.nextInt();
                        if(op==1){
                            System.out.println("\n*****Se genera el 1.5% de interes a su ahorro*****\n");
                            System.out.println("Ingrese su numero de cuenta");
                            num=sc.nextInt();
                            System.out.println("Ingrese el deposito para ahorrar.");
                            cantidad=sc.nextDouble();

                            a[i]=new CuentaAhorro(num);
                            a[i].depositar(cantidad);
                            System.out.println("La cuenta se creo exitosamente"+a[i]);
                        }
                        if(op==2){
                            System.out.println("Ingrese su numero de cuenta");
                            num=sc.nextInt();
                            System.out.println("De qué cantidad desea que sea su prestamo?");
                            lim=sc.nextDouble();
                             a[i]=new CuentaCorriente(num);
                             a[i].depositar(cantidad);
                            System.out.println("La cuenta se creo exitosamente\nNumero de cuenta"+a[i]);
                       }
                    i++;
                        break;
                case 2:
                        System.out.println("¿Que numero de cuenta desea eliminar? ");
                        num=sc.nextInt();
                        int n=Checar(num,a);
                        if(n>=0){
                        a[n]=null;
                     }
                     else{
                         System.out.println("El numero de cuenta no existe\nPor favor verifiquelo");
                     }
                     break;
                    
                case 3:
                    System.out.println("Ingrese numero de cuenta al que desea depositar");
                    num=sc.nextInt();
                    System.out.println("¿Que cantidad deseas depositar?(deposito mayor a $50)");
                    cantidad=sc.nextDouble();
                    n=Checar(num,a);
                    if(n>=0){
                        a[n].depositar(cantidad);
                    }
                    else{
                        System.out.println("El numero de cuenta no existe\nPor favor verifiquelo");
                    }
                     break;
                case 4:
                    System.out.println("Ingrese el numero de cuenta de la que desea retirar");
                    num=sc.nextInt();
                    n=Checar(num,a);
                    if(n>=0){
                    System.out.println("¿Que cantidad desea retirar?");
                    cantidad=sc.nextDouble();
                    if(a[n] instanceof CuentaCorriente){
                         ((CuentaCorriente)a[n]).retirar(cantidad);
                    }
                    if(a[n] instanceof CuentaAhorro){
                        ((CuentaAhorro)a[n]).retirar(cantidad); 
                        }
                    }
                    else{
                        System.out.println("El numero de cuenta no existe\nPor favor verifiquelo");
                    }
                    break;
                case 5:
                    System.out.println("Mostar cuentas");
                    int tam=a.length;
                    for(int j=0;j<tam;j++){
                        System.out.println(a[j].toString()); 
                    }
                    break;
                case 6:
                    System.out.println("Actualizar");
                    actualizar(a);
                    break;
                }
        }while(opc!=7);
    }
        
    public static void actualizar(Cuenta a[]){
    int i;
    double suma;
    
    for(i=0;i<5;i++){
        if(a[i] instanceof CuentaAhorro && a[i]!=null){
            if(a[i].getBalance()!=0){
                ((CuentaAhorro)a[i]).Interes();
                
                suma=a[i].getBalance()+(a[i].getBalance()*0.015);
                System.out.println("El saldo actual es"+suma);
            }
            else{
                if(((CuentaCorriente)a[i]).getLim()<2000 && a[i]!=null)
                    System.out.println("HAY UNA CUENTA CON SOBRE GIRO!!\nLa cuenta: "+a[i].getNoCuenta());
                    System.out.println("El sobre giro es de: " +((CuentaCorriente)a[i]).getLim()); 
            }
        }
    }
    }       
    public static int Checar(int noCuenta,Cuenta a[]){
        int i,n=-1;
        for(i=0;i<5;i++){
            try {
            if(noCuenta == a[i].getNoCuenta())
                n=i;
            } catch(Exception e) {
                
            }
        }
         return n;   
    }
}
