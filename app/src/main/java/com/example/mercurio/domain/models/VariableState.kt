package com.example.mercurio.domain.models

data class VariableState<T>(
    var value: T,
    val error: Error
) {
    fun onChange(newValue: T) {
        value = newValue
    }
}


