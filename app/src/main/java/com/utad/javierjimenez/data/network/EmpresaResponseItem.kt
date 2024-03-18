package com.utad.javierjimenez.data.network


import com.google.gson.annotations.SerializedName

data class EmpresaResponseItem(
    @SerializedName("dead_line")
    val deadLine: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("details")
    val details: List<String>,
    @SerializedName("employee")
    val employee: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("project")
    val project: Project?,
    @SerializedName("task_title")
    val taskTitle: String
)