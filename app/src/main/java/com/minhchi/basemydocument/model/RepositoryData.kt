package com.minhchi.basemydocument.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.minhchi.basemydocument.model.Owner

@Entity(tableName = "repositories")
class RepositoryData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "owner")
    val owner: Owner?
)


