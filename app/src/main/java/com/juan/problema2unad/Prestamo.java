package com.juan.problema2unad;

import android.content.Context;
import android.widget.Toast;

public class Prestamo {
    private Context context;
    private String nombreCliente;
    private String identificacion;
    private Double montoCredito;
    private int plazoSeleccionado;

    public Prestamo() {

    }

    public Prestamo(Context context) {
        this.context = context;
    }

    public Prestamo(String nombreCliente, String identificacion, Double montoCredito, int plazoSeleccionado) {
        this.nombreCliente = nombreCliente;
        this.identificacion = identificacion;
        this.montoCredito = montoCredito;
        this.plazoSeleccionado = plazoSeleccionado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Double getMontoCredito() {
        return montoCredito;
    }

    public void setMontoCredito(Double montoCredito) {
        this.montoCredito = montoCredito;
    }

    public int getPlazoSeleccionado() {
        return plazoSeleccionado;
    }

    public void setPlazoSeleccionado(int plazoSeleccionado) {
        this.plazoSeleccionado = plazoSeleccionado;
    }

    public Double CalcuarCuotas() {
        Double interesMensual;


        switch (plazoSeleccionado) {
            case 6:
                interesMensual = 0.0125;
                break;
            case 12:
                interesMensual = 0.01;
                break;
            case 18:
                interesMensual = 0.0075;
                break;
            default:
                interesMensual = 0.0;
        }


        return montoCredito * interesMensual;
    }

    public String mostrarInformacion() {
        Double total = ((CalcuarCuotas() * plazoSeleccionado) + montoCredito);//valor total de intereses + el monto del prestamo
        long totalFinal = Math.round(total); //hago esto para redondear el valor y queno me salgan tantos decimales

        return "Nombre del cliente: " + nombreCliente + "\n" +
                "Identificación: " + identificacion + "\n" +
                "Monto del crédito: " + montoCredito + "\n" +
                "Plazo seleccionado: " + plazoSeleccionado + " meses" + "\n" +
                "Cuota mensual: " + CalcuarCuotas() + "\n" +
                "Total a pagar de interes: " + CalcuarCuotas() * plazoSeleccionado + "\n" +
                "Total final a pagar : " + totalFinal;


    }

}

