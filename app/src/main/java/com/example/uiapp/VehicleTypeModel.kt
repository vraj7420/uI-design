package com.example.uiapp

class VehicleTypeModel(var imgUri: String, var vehicleType: String) {
    var isSelected = false
    fun setSelectedVehicle(selected: Boolean) {
        isSelected=selected
    }
}