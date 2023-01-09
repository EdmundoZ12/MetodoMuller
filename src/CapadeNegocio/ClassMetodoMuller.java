/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapadeNegocio;
import CapadeNegocio.ClassPolinomio;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *
 * @author Usuario
 */
public class ClassMetodoMuller {
    ClassPolinomio P;
    float x0;
    float x1;
    float x2;
    float ErroTolerancia;
    float V[][];
    int fila;
    int columna;
    int dim;
    

    public ClassMetodoMuller(ClassPolinomio P, float x0, float x1, float x2, float ErroTolerancia) {
        this.P = P;
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.ErroTolerancia = ErroTolerancia;
        V=new float[5][13];
        this.dim=-1;
    }
    
    public void CalcularIteraciones(){
        float error=(int) (1*Math.pow(10,3));
        int j=0;
        if(!bEsCompleja()){
           while(error>ErroTolerancia){
            dim++;
            float x01=P.EvaluarPolinomio(x0);
            float x11=P.EvaluarPolinomio(x1);
            float x21=P.EvaluarPolinomio(x2);
            float h0=(x1-x0);
            float h1=(x2-x1);
            float d0=((x11-x01)/(x1-x0));
            float d1=((x21-x11)/(x2-x1));
            float a=((d1-d0)/(h1+h0));
            float b=((a*h1)+d1);
            float c=x21;
            float raiz=(b*b)-(4*a*c);
            float x3=0;
            Redimencionar();
            x3=ValorMayordeb(a,b,c);
            error=Math.abs((x3-x2)/x3)*100;
            V[dim][0]=dim;
            V[dim][1]=x0;
            V[dim][2]=x1;
            V[dim][3]=x2;
            V[dim][4]=Redonder4Decimales(h0);
            V[dim][5]=Redonder4Decimales(h1);
            V[dim][6]=Redonder4Decimales(d0);
            V[dim][7]=Redonder4Decimales(d1);
            V[dim][8]=Redonder4Decimales(a);
            V[dim][9]=Redonder4Decimales(b);
            V[dim][10]=Redonder4Decimales(c);
            V[dim][11]=Redonder4Decimales(x3);
            V[dim][12]=Redonder4Decimales(error);
            this.x0=x1;
            this.x1=x2;
            this.x2=Redonder4Decimales(x3);  
          }  
        }
      
    }
    
    public void Redimencionar(){
        if(V.length-1==dim){
               float d[][];
            d=new float[13][dim];
            System.arraycopy(V, 0, d,0,V.length);
            V=new float[13][dim+1];
            System.arraycopy(d,0, V, 0,d.length);
        }
    }
    
    public boolean bEsCompleja(){
        float x01=P.EvaluarPolinomio(x0);
        float x11=P.EvaluarPolinomio(x1);
        float x21=P.EvaluarPolinomio(x2);
        float h0=(x1-x0);
        float h1=(x2-x1);
        float d0=((x11-x01)/(x1-x0));
        float d1=((x21-x11)/(x2-x1));
        float a=((d1-d0)/(h1+h0));
        float b=((a*h1)+d1);
        float c=x21;
        float raiz=(b*b)-(4*a*c);
        return (raiz<0);
        
        
    }
    
    public float getElementos(int i,int j){
        return V[i-1][j-1];
    }
    
    public int getCantidad(){
        return dim;
    }
    
    private float Redonder4Decimales(float numero){
        BigDecimal bd= new BigDecimal(numero);
        bd=bd.setScale(4, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
    
    private float ValorMayordeb(float a,float b,float c){
        float b1=Math.abs((float) (b+(Math.sqrt(((b*b)-(4*a*c))))));
        float b2=Math.abs((float) (b-(Math.sqrt(((b*b)-(4*a*c))))));
        if(b1>b2){
           return (float) (x2+((-2*c)/(b+(Math.sqrt(((b*b)-(4*a*c)))))));
        }else{
            return (float) (x2+((-2*c)/(b-(Math.sqrt(((b*b)-(4*a*c)))))));
        }
        
    }
    
    
}
