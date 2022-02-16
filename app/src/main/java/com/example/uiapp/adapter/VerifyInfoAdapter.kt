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
import com.example.uiapp.model.VerifyInfoModel

class VerifyInfoAdapter(private var ctx: Context, private var verifyInfoList: ArrayList<VerifyInfoModel>) :
    RecyclerView.Adapter<VerifyInfoAdapter.VerifyInfoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerifyInfoHolder {
        val layoutInflater = LayoutInflater.from(ctx)
        return VerifyInfoHolder(
            layoutInflater.inflate(
                R.layout.item_verify_info,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerifyInfoHolder, position: Int) {
        val verifyInfo =verifyInfoList[position]
        holder.imageViewVerifyInfoLogo.setImageURI(verifyInfo.verifyInfLogo.toUri())
        holder.tvVerifyInfoName.text=verifyInfo.verifyInfTitle

    }

    override fun getItemCount(): Int {
        return verifyInfoList.size
    }

    class VerifyInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewVerifyInfoLogo:ImageView=itemView.findViewById(R.id.imageViewVerifyLogo)
        val tvVerifyInfoName:TextView=itemView.findViewById(R.id.tvVerifyInfoName)
    }
}