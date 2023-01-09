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
public class ClassMonomio {
    float Coeficiente;
    float Exponente;

    public ClassMonomio() {
        this.Coeficiente=0;
        this.Exponente=1;//0^0=1
    }

    public ClassMonomio(int Coeficiente, int Exponente) {
        this.Coeficiente = Coeficiente;
        this.Exponente = Exponente;
    }

    public void setCoeficiente(float Coeficiente) {
        if(Coeficiente>=0){
          this.Coeficiente=+Math.abs(Coeficiente);
        }else{
          this.Coeficiente=-Math.abs(Coeficiente);
        }
    }

    public void setExponente(float Exponente) {
        this.Exponente = Exponente;
    }
    
    public void setSigno(char Signo){
        if(Signo=='+'){
         this.Coeficiente=+Math.abs(Coeficiente);   
        }else{
         this.Coeficiente=-Math.abs(Coeficiente);   
        }
    }

    public float getCoeficiente() {
        return Math.abs(Coeficiente);
    }

    public float getExponente() {
        return Exponente;
    }
    
    public char getSigno(){
        if(this.Coeficiente>=0){
            return '+';
        }else{
            return '-'; 
        }
    }

    @Override
    public String toString() {
        String S="";
        if(getExponente()==0){
          S=S+getSigno()+getCoeficiente()+" ";  
        }else{
         S=S+getSigno()+getCoeficiente()+"X^"+getExponente()+" ";   
        }
        
        return S;
    }
    
    
    
    
    
    
    
    
    
    
    
}
