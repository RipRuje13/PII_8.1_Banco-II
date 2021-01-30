package banco;

public class Cuenta {
  
    private double balance;
   final private int noCuenta;
    
   public Cuenta(int a){    
		balance = 0.0;
		noCuenta = a;
    }
   
    public double getBalance(){
        return balance;
    }
    
    public int getNoCuenta(){
		return noCuenta;
    }
   
    public void depositar(double suma){
	if (suma>0)
	    balance += suma;    
	else
	    System.err.println("No es posible depositar cantidad negativa.");    
    }    
    public void retirar(double suma){
	if (suma > 0)
	    balance -= suma;    
	else
	    System.err.println("No es posible retirar cantidad negativa.");    
    }    

    @Override
    public String toString(){
		return "No. Cuenta: " + noCuenta + " - " + "Balance = " + balance;    
    }
}

  

 