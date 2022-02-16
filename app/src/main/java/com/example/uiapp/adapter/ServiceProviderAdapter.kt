package com.example.uiapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.uiapp.R
import com.example.uiapp.model.ServiceProviderModel

class ServiceProviderAdapter(private var ctx: Context, private var serviceProviderList: ArrayList<ServiceProviderModel>) :
    RecyclerView.Adapter<ServiceProviderAdapter.ServiceProviderHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceProviderHolder {
        val layoutInflater = LayoutInflater.from(ctx)
        return ServiceProviderHolder(
            layoutInflater.inflate(
                R.layout.item_service,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ServiceProviderHolder, position: Int) {
        val serviceProvider = serviceProviderList[position]
        holder.imageViewService.setImageURI(serviceProvider.serviceProviderImage.toUri())
        holder.tvServiceName.text=serviceProvider.serviceName
        holder.tvServiceProviderRate.text=serviceProvider.serviceRate
    }

    override fun getItemCount(): Int {
        return serviceProviderList.size
    }

    class ServiceProviderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewService:ImageView=itemView.findViewById(R.id.imageViewServiceProvider)
        val tvServiceName:TextView=itemView.findViewById(R.id.tvServiceProviderName)
        val tvServiceProviderRate:TextView=itemView.findViewById(R.id.tvServiceProviderRate)

    }
}