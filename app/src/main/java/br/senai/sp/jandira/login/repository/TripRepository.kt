package br.senai.sp.jandira.login.repository

import androidx.compose.runtime.Composable
import br.senai.sp.jandira.login.model.Trip
import java.time.LocalDate

class TripRepository {

    companion object {

        @Composable
        fun getTrips(): List<Trip> {
            return listOf(

                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Cidade muito bonita, com muitas opções de passeios.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4, 23),
                ),
                Trip(
                    id = 2,
                    location = "São Roque",
                    description = "Cidade muito bonita, com muitas opções de restaurantes.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4, 23),
                ),
                Trip(
                    id = 3,
                    location = "Rio de Janeiro",
                    description = "Cidade muito bonita, com muitas montanhas.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4, 23),
                ),

            )

        }

    }

}