package com.example.snehaAssignment1.model

data class SignUpEventModel(
    val message : String?=null,
    val error : Boolean=true,
    val result: UserDetails?=null,
    val clickEvent: ClickEvent=ClickEvent.Nothing
///val type: enum class can be created using this ---> {toast,dialog,...}
)
