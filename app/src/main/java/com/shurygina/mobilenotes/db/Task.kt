package com.shurygina.mobilenotes.db

import android.provider.BaseColumns

object Task: BaseColumns {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "mobilenotes.db"

    const val TABLE_NAME = "tasks"

    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_PRIORITY = "priority"
    const val COLUMN_NAME_CREATION_DATE = "creation_date"
    const val COLUMN_NAME_IS_DONE = "is_done"

    const val CREATE_TABLE_TASKS = "create table if not exists $TABLE_NAME (" +
            "${BaseColumns._ID} integer primary key, " +
            "$COLUMN_NAME_TITLE text, " +
            "$COLUMN_NAME_PRIORITY integer, " +
            "$COLUMN_NAME_IS_DONE integer, " +
            "$COLUMN_NAME_CREATION_DATE text)"

    const val DELETE_TABLE_TASKS = "drop table if exists $TABLE_NAME"
}