package br.senai.sp.jandira.login.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.login.model.User

@Database(entities = [User::class], version = 1)
abstract class TripDb : RoomDatabase() {

    companion object {

        private lateinit var instanceDb: TripDb

        fun getDataBase(context: Context): TripDb {

            if (!::instanceDb.isInitialized) {
                instanceDb = Room
                    .databaseBuilder(
                        context,
                        TripDb::class.java,
                        "db_trip"
                    ).build()

            }
            return instanceDb
        }
    }
}