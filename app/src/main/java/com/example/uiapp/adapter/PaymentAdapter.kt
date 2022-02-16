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
import com.example.uiapp.model.PaymentModel

class PaymentAdapter(private var ctx: Context, private var paymentList: ArrayList<PaymentModel>) :
    RecyclerView.Adapter<PaymentAdapter.PaymentVieHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentVieHolder {
        val layoutInflater = LayoutInflater.from(ctx)
        return PaymentVieHolder(
            layoutInflater.inflate(
                R.layout.item_payment,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PaymentVieHolder, position: Int) {
        val payment = paymentList[position]
        holder.tvPaymentName.text = payment.paymentName
        holder.tvPaymentStatus.text = payment.paymentStatus
        holder.tvPaymentAmount.text = payment.paymentAmount
        holder.tvCardEnding.text = payment.cardEnding
        holder.tvAuthorizedDateAndTime.text = payment.authorizeDateAndTime
        holder.tvPersonName.text = payment.personName
        holder.tvTaskId.text = payment.taskId
        holder.imageViewCard.setImageURI(payment.cardImage.toUri())
        holder.imageViewPerson.setImageURI(payment.imageViewPerson.toUri())
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    class PaymentVieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPaymentName: TextView = itemView.findViewById(R.id.tvPaymentName)
        val tvAuthorizedDateAndTime: TextView = itemView.findViewById(R.id.tvAuthorizeDateAndTime)
        val tvPaymentAmount: TextView = itemView.findViewById(R.id.tvPaymentAmount)
        val tvPaymentStatus: TextView = itemView.findViewById(R.id.tvPaymentStatus)
        val imageViewCard: ImageView = itemView.findViewById(R.id.imageViewCard)
        val tvCardEnding: TextView = itemView.findViewById(R.id.tvCardEnding)
        val imageViewPerson: ImageView = itemView.findViewById(R.id.imageViewPerson)
        val tvPersonName: TextView = itemView.findViewById(R.id.tvPersonName)
        val tvTaskId: TextView = itemView.findViewById(R.id.tvTaskId)
    }
}