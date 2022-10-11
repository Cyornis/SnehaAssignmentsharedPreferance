package com.example.snehaAssignment1.model

data class UserToDoEventModel(
    val message : String?=null,
    val error : Boolean=true,
    val clickEvent: ClickEvent = ClickEvent.Nothing
)
