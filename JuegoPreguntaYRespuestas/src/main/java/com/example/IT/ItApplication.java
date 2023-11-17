package com.example.IT;

import com.example.IT.modelos.Categoria;
import com.example.IT.modelos.Pregunta;
import com.example.IT.servicios.ServicioCategoria;
import com.example.IT.servicios.ServicioPregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class ItApplication {

    @Autowired
    ServicioPregunta servicioPregunta;

    public static void main(String[] args) {

        SpringApplication.run(ItApplication.class, args);


    }

    @Bean
    CommandLineRunner initBbdd(ServicioPregunta servicioPregunta, ServicioCategoria servicioCategoria) {
        return args -> {
            //Esto sirve para meter los datos en la bbdd si esta vacia

            //if (servicioPregunta.findAll() == null) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("CulturaGeneral.csv"));
                    //leemos la primera linea del csv
                    String linea = br.readLine();
                    //volvemos a leer para obtener la primera pregunta
                    linea = br.readLine();
                    while (linea != null) {
                        String[] articulos = linea.split(";");
                        Pregunta pregunta = new Pregunta();

                        Categoria categoria = servicioCategoria.findByNameCategory(articulos[1]);
                        if(Objects.isNull(categoria)){
                            categoria = new Categoria();
                            categoria.setNameCategory(articulos[1]);
                            servicioCategoria.save(categoria);
                        }


                        //pregunta.setId(Long.parseLong(articulos[0]));
                        pregunta.setCategoria(categoria);
                        pregunta.setQuestion(articulos[2]);
                        pregunta.setCorrect_answer(articulos[3]);
                        pregunta.setIncorrect_answer_a(articulos[4]);
                        pregunta.setIncorrect_answer_b(articulos[5]);
                        pregunta.setIncorrect_answer_c(articulos[6]);
                        //pregunta.setVisualizaciones(Integer.parseInt(articulos[7]));
                        servicioPregunta.save(pregunta);
                        linea = br.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
              //}

        };
    }
}


	/*public void rellenarBaseDatos(String tabla){

		CarteraSQLiteOpenHelper mDbHelper = new CarteraSQLiteOpenHelper(getContext());

		SQLiteDatabase db = mDbHelper.getWritableDatabase();

		ConexionBbdd conexionBbdd = db.rawQuery("SELECT count(*) FROM " + tabla, null);

	}*/




    /*private int id_question;

    private String correct_answer;
    private String incorrect_answer_a;
    private String incorrect_answer_b;
    private String incorrect_answer_c;

    private String username;

    private int visualizaciones;

    @ManyToOne
    private Categorias categoria;*/








