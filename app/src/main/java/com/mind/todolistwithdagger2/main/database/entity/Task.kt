package com.mind.todolistwithdagger2.main.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
class Task(

    var title : String,
    var description : String,
    var time : String,
    var category : String

){
    @PrimaryKey(autoGenerate = true)
    var id : Int  = 0

    //archived flag  0 = "to do" and 1 = archived
    var flag : Int = 0
}