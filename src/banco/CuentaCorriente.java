package banco;
public class CuentaCorriente extends Cuenta{
    
    private double lim;
    
    Cuenta c1=new Cuenta(0);
    
    public CuentaCorriente(int noCuenta){
        super(noCuenta);
        this.lim=lim=0.0;
    }
    
    public double getLim(){
        return lim;
    }
    
    public void setLim(double lim){
        this.lim=lim;
    }
    
    @Override
    public void depositar(double suma){
        if(lim!=0 && lim>0){
            lim-=suma;
            System.out.println("Ya no cuenta con sobregiro \n Su saldo es de"+suma);
        }
        else{
            System.out.println("Su saldo es de"+suma);
        }
        if(suma<0){
            System.out.println("No es posible depositar una cantidad negativa");
        }
    }
    public double limiteSobregiro(double suma){
        if(suma>super.getBalance());
        lim=suma-super.getBalance();
         return lim;
    }   
}                       

