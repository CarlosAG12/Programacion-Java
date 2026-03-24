package vista;

import modelo.PacienteAdulto;

public class Main {
    public static void main(String[] args) {

        PacienteAdulto adulto =
            new PacienteAdulto(
                "Carlos",
                25,
                70,
                1.75
            );

        System.out.println("Paciente: "
                + adulto.getNombre());

        System.out.println("IMC: "
                + adulto.calcularIMC());

        System.out.println("Estado: "
                + adulto.clasificarIMC());
    }
}
