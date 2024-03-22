/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author jason
 */
public class Fecha_Date {

    public void sumadefecha(JDateChooser jd, int cantidad) {

        String strFormato = "dd/MM/yyyy";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(strFormato);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, cantidad);
        String fecha_suma = sdf.format(c1.getTime());
        jd.setDate(StringADate(fecha_suma));
    }

    public String sumadefechaMesPension(JDateChooser entrada, int cantidad) throws ParseException {

        String strFormato = "yyyy-MM-dd";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(strFormato);

        Calendar c1 = entrada.getCalendar().getInstance();
        c1.add(Calendar.MONTH, cantidad);
        String fecha_suma = sdf.format(c1.getTime());

        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaE = formato_del_Texto.parse(fecha_suma);

        int anio = entrada.getCalendar().get(Calendar.YEAR);
        int mes = fechaE.getMonth();
        int dia = entrada.getCalendar().get(Calendar.DAY_OF_MONTH);

        //VALIDAMOS SI EL MES TIENE 29 30 31
        String fecha_actual = anio + "-" + (mes + 1) + "-" + retornarDia(anio, (mes + 1), dia);

        return fecha_actual;
    }

    public int retornarDia(int anio, int mes, int diaentrada) {
        int diaretorno = 0;
        if (diaentrada == 29 || diaentrada == 30 || diaentrada == 31) {
            if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
                if (mes == 2) {
                    if (diaentrada == 29) {
                        diaretorno = 29;
                    } else if (diaentrada == 30) {
                        diaretorno = 29;
                    } else if (diaentrada == 31) {
                        diaretorno = 29;
                    }
                } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    if (diaentrada == 29) {
                        diaretorno = 29;
                    } else if (diaentrada == 30) {
                        diaretorno = 30;
                    } else if (diaentrada == 31) {
                        diaretorno = 31;
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (diaentrada == 29) {
                        diaretorno = 29;
                    } else if (diaentrada == 30) {
                        diaretorno = 30;
                    }
                }
            } else {
                if (mes == 2) {
                    if (diaentrada == 29) {
                        diaretorno = 28;
                    } else if (diaentrada == 30) {
                        diaretorno = 28;
                    } else if (diaentrada == 31) {
                        diaretorno = 28;
                    }
                } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    if (diaentrada == 29) {
                        diaretorno = 29;
                    } else if (diaentrada == 30) {
                        diaretorno = 30;
                    } else if (diaentrada == 31) {
                        diaretorno = 31;
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (diaentrada == 29) {
                        diaretorno = 29;
                    } else if (diaentrada == 30) {
                        diaretorno = 30;
                    }
                }
            }
        } else {
            diaretorno = diaentrada;
        }
        return diaretorno;
    }

    public static Date sumadefechaDias(Date fecha, int cantidad) {
        if (cantidad == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_MONTH, cantidad);
        return calendar.getTime();
    }

    public String getFecha(JDateChooser jd) {
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public Date StringADate(String fecha) {
        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaE = null;
        try {
            fechaE = formato_del_Texto.parse(fecha);
            return fechaE;
        } catch (ParseException ex) {
            return null;
        }
    }

    public String mostrar_fecha(JDateChooser jd) {
        return "" + leeFecha(getFecha(jd));
    }

    public void capturaymuestrahoradelsistema(JDateChooser jd) {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar(); 
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int anoo = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fecha_actual = dia + "/" + (mes + 1) + "/" + anoo;
        jd.setDate(StringADate(fecha_actual));
    }
// //metodo para guardar la fecha

    public String muestrahoradelsistema() {
        Calendar fecha = new GregorianCalendar();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String dato = hora + " : " + minuto + " : " + segundo;
        return dato;
    }
 
    public String retorna_hora_reportes() {
        Calendar fecha = new GregorianCalendar();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String dato = hora + "" + minuto + "" + segundo;
        return dato;
    }
 
    public String retorna_fecha_reportes() {
        String fecha_actual = "";
        Calendar fecha = new GregorianCalendar();
        int anoo = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
          fecha_actual = dia + "" + (mes + 1) + "" + anoo;
        return fecha_actual;
    }

    public String retorna_fecha_del_sistemaOrden() {
        String fecha = "";
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        fecha = sdf.format(date);
        return fecha;
    }

    public String retorna_fecha_del_sistema() {
        String fecha = "";
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        fecha = sdf.format(date);
        return fecha;
    }

    public Date leeFecha(String fecha) {//yyyy-MM-dd
        SimpleDateFormat formatodelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = null;
        Date fecha2 = null;
        try {
            fecha1 = formatodelTexto.parse(fecha);
            fecha2 = new java.sql.Date(fecha1.getTime());
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return fecha2;
    }

}
