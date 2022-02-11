package com.example.uiapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView


class VehicleTypeAdapter(
    private var ctx: Context,
    private var vehicleTypeList: ArrayList<VehicleTypeModel>
) :
    RecyclerView.Adapter<VehicleTypeAdapter.VehicleTypeHolder>() {

    private var selectedItemCount = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleTypeHolder {
        val layoutInflater = LayoutInflater.from(ctx)
        return VehicleTypeHolder(
            layoutInflater.inflate(
                R.layout.item_vehicle_tasker,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: VehicleTypeHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val vehicleType = vehicleTypeList[position]
        holder.imvContact.setImageURI(vehicleType.imgUri.toUri())
        holder.tvVehicleType.text = vehicleType.vehicleType
        holder.cvVehicleItem.setOnClickListener {
            vehicleType.setSelectedVehicle(!vehicleType.isSelected)
            if (vehicleType.isSelected) {
                holder.imageSelected.visibility = View.VISIBLE
                holder.cvVehicleItem.setBackgroundResource(R.drawable.selected_item_card_view_background)
                selectedItemCount += 1
            } else {
                holder.imageSelected.visibility = View.GONE
                holder.cvVehicleItem.setBackgroundResource(R.drawable.unselected_card_view_background)
                selectedItemCount -=1
            }
        }
        if(selectedItemCount==0){
            Screen2Activity.btnNextForAdapter.setBackgroundResource(R.drawable.round_button_with_gray_color)
            Screen2Activity.btnNextForAdapter.isClickable=false
        }
        else{
            Screen2Activity.btnNextForAdapter.setBackgroundResource(R.drawable.round_button_with_purple_color)
            Screen2Activity.btnNextForAdapter.isClickable=true
        }
    }

    override fun getItemCount(): Int {
        return vehicleTypeList.size
    }

    class VehicleTypeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvVehicleType: TextView = itemView.findViewById(R.id.tvVehicleType)
        var imvContact: ImageView = itemView.findViewById(R.id.imageviewVehicle)
        var cvVehicleItem: CardView = itemView.findViewById(R.id.cvVehicleItem)
        var imageSelected: ImageView = itemView.findViewById(R.id.imageSelected)
    }
}