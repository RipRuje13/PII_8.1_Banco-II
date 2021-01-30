package banco;
public class CuentaAhorro extends Cuenta{
    
    private double interes;
    private double res;
    
    public CuentaAhorro( int noCuenta){
        super(noCuenta);        
        this.interes=0.0;
    }
    
    public double getInteres(){
        return interes;
    }
    
    public void setInteres(double interes){
        this.interes=interes;
    }
    
    public double Interes(){
       interes= super.getBalance()*0.015;
       
       return interes;
    }
    
    @Override
    public void retirar(double cantidad){
        double ret, ic=super.getBalance();
       ret=super.getBalance()+Interes();
       this.res=ret-cantidad;       
  }
} 
