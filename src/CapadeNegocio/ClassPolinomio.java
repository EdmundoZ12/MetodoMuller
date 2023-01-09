/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapadeNegocio;

/**
 *
 * @author Usuario
 */
public class ClassPolinomio {
    ClassMonomio p[];
    int dim;

    public ClassPolinomio() {
        this.p=new ClassMonomio[3];
        for (int i = 1; i <+ p.length; i++) {
            this.p[i]=new ClassMonomio();
        }
      this.dim=-1;  
    }
    
    
    private boolean vacia(){
        return (dim==-1);
    }
    
    private void Redimencionar(){
        if(p.length-1==dim){
            ClassMonomio p1[];
            p1=new ClassMonomio[p.length];
            System.arraycopy(p, 0, p1, 0,p.length);
            p=new ClassMonomio[p1.length+1];
            System.arraycopy(p1, 0, p, 0,p1.length);
        }
    }

    public void setMonomio(ClassMonomio a){
        ClassMonomio b=new ClassMonomio();
          b.setCoeficiente(a.getCoeficiente());
          b.setSigno(a.getSigno());
          b.setExponente(a.getExponente());
        if(vacia()){
          this.dim++;
          this.p[dim]=b;
        }else{
            Redimencionar();
            int i=0;
            while ((i<=dim)&&(p[i]).getExponente()<b.getExponente()) {
               i++;
            }
             if(i>dim){
               this.dim++;
               this.p[i]=b;
             }else{
                 if(p[i].getExponente()==b.getExponente()){
                    float suma=this.p[i].Coeficiente+b.Coeficiente;
                    if(suma==0){
                        for (int j = i; j < dim; j++) {
                            this.p[j]=p[j+1];
                        }
                        this.dim--;
                    }else{
                        this.p[i].setCoeficiente(Math.abs(suma));
                        if(suma>=0){
                           this.p[i].setSigno('+');
                        }else{
                            this.p[i].setSigno('-');
                        }
                    }
                 }else{
                     for (int j = dim; j>=i ; j--) {
                      this.p[j+1]=p[j];   
                     }
                    this.p[i]=b;
                    this.dim++;
                 }
             }
        }
    }  
    
    public void EliminarMonomio(int Exponente){
        int i=0;
        while(p[i].getExponente()!=Exponente){
            i++;
        }
         if(i<=dim){
             for (int j = i; j < dim; j++) {
                 p[j]=p[j+1];
             }
           dim--;  
         }     
    }
    
    
    public ClassMonomio getMonomio(int Exponente){
        int i=0;
        while((i<=dim)&&(p[i].getExponente()!=Exponente)){
            i++;
        }
      return p[i];  
    }
    
    public void Suma(ClassPolinomio A,ClassPolinomio B){
        for (int i = 0; i <= A.dim; i++) {
            this.setMonomio(A.p[i]);
        }
        for (int i = 0; i <=B.dim; i++) {
            this.setMonomio(B.p[i]);
        }
    }
    
    public void Resta(ClassPolinomio A,ClassPolinomio B){
       for (int i = 0; i <= A.dim; i++) {
            this.setMonomio(A.p[i]);
        }
        for (int i = 0; i <=B.dim; i++) {
            if(B.p[i].getSigno()=='+'){
                B.p[i].setSigno('-');
            }else{
               B.p[i].setSigno('+'); 
            }    
            this.setMonomio(B.p[i]);
        } 
    }
    
    public float EvaluarPolinomio(float Valor){
        float Resultado=0;
        float vexp;
        float exp;
        for (int i = 0; i <= dim; i++) {
              exp=p[i].getExponente();  
              vexp=(float) Math.pow(Valor, exp);
              Resultado=Resultado+(p[i].Coeficiente*vexp);
        } 
      return Resultado;  
    }

    @Override
    public String toString() {
       String S="F(X)=";
        for (int i = dim; i >=0 ; i--) {
            S=S+p[i].toString();
        }
        return S;
    }
    
    
    
    
    
    
}
