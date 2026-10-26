package org.ucb.mobile3p.translations.data.entity

import androidx.room3.ColumnInfo
import androidx.room3.Entity

@Entity(tableName = "translations", primaryKeys = ["locale", "key"])
data class TranslationEntity(
    @ColumnInfo(name = "locale")
    var locale: String = "",

    @ColumnInfo(name = "key")
    var key: String = "",

    @ColumnInfo(name = "value")
    var value: String = ""
)
