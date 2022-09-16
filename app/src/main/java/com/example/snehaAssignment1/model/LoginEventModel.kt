package com.example.snehaAssignment1.model

data class LoginEventModel(
    val message : String?=null,
    val error : Boolean=true,
    val result: UserDetails?=null,
    val clickEvent: ClickEvent=ClickEvent.Nothing
)
