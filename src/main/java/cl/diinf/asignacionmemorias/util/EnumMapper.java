package cl.diinf.asignacionmemorias.util;

public class EnumMapper {
    public String actionMapper(Action action) {
        if(action == Action.ENTREGA)
            return "El alumno ha entregado para corregir";
        else if(action == Action.ASIGNACION_CORRECTOR)
            return "Se ha asignado un corrector a la memoria";
        else if(action == Action.CORRECCION)
            return "Profesor de la comisión ha realizado corrección";
        else
            return "Desconocido";
    }

    public String statusMapper(Status status) {
        if(status == Status.ENTREGA_PENDIENTE)
            return "El alumno no ha relizado la entrega";
        else if(status == Status.ENTREGA_REALIZADA)
            return "El alumno ha relizado la entrega";
        else if(status == Status.ASIGNACION_COMISION_OFF)
            return "Aún no se asigna comisión";
        else if(status == Status.ASIGNACION_COMISION_ON)
            return "Comisión asignada";
        else if(status == Status.EN_REVISION)
            return "Memoria en correción";
        else if(status == Status.CORRECCION_1)
            return "Profesor 1 de comisión ya ha revisado";
        else if(status == Status.CORRECCION_2)
            return "Profesor 2 de comisión ya ha revisado";
        else if(status == Status.REVISADA)
            return "La entrega ha sido revisada por la comisión";
        else if(status == Status.LISTO)
            return "El alumno ha sido notificado de las correcciones";
        else
            return "Desconocido";

    }
}
