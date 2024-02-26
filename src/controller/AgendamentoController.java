
package controller;

import model.Agendamento;


public class AgendamentoController {
     public boolean agendarHorario(int dia, int mes, String hora, int cod_fun, int cod_usr){
        if(dia!=0 && mes!=0 && hora!=null && hora.length()>0 && cod_fun>0 && cod_fun>0){
            Agendamento a = new Agendamento(dia, mes, hora, cod_fun, cod_usr);
            a.agendarHorario(a);
            return true;
        }
        
        return false;
    }
}
