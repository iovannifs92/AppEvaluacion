package com.sistemas.evaluacion;

public class Comentario {
    //Campos correspondientes a la base de datos
    int id;
    String r1;
    String r2;
    String r3, r4, r5, r6, r8, r8a, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r21a, r22, r22a, r23, r24, r25;



    //Constructor
    public Comentario(int _id, String _r1,String _r2, String _r3, String _r4, String _r5,String _r6, String _r8,
                      String _r8a, String _r9, String _r10, String _r11, String _r12, String _r13, String _r14,
                      String _r15, String _r16, String _r17, String _r18, String _r19, String _r20, String _r21,
                      String _r21a, String _r22, String _r22a, String _r23, String _r24, String _r25){
        this.id=_id;
        this.r1=_r1;
        this.r2=_r2;
        this.r3=_r3;
        this.r4=_r4;
        this.r5=_r5;
        this.r6=_r6;
        this.r8=_r8;
        this.r8a=_r8a;
        this.r9=_r9;
        this.r10=_r10;
        this.r11=_r11;
        this.r12=_r12;
        this.r13=_r13;
        this.r14=_r14;
        this.r15=_r15;
        this.r16=_r16;
        this.r17=_r17;
        this.r18=_r18;
        this.r19=_r19;
        this.r20=_r20;
        this.r21=_r21;
        this.r21a=_r21a;
        this.r22=_r22;
        this.r23=_r23;
        this.r24=_r24;
        this.r25=_r25;

    }

    //Represetacion del objeto como cadena de texto
    @Override
    public String toString() {
        return r1;
    }



    //Metodos de acceso a cada atribito de la clase
    public int getId(){
        return id;
    }

    public String getR1(){
        return r1;
    }
}
