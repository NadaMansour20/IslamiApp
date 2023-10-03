package com.android.islami.islamiproject.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.android.islami.R
import kotlin.collections.ArrayList

class QranAdapter:RecyclerView.Adapter<QranAdapter.QranViewHolder> {
    var datalist:ArrayList<String>
    constructor(datalist: ArrayList<String>) : super(){
        this.datalist=datalist
    }

    class QranViewHolder : RecyclerView.ViewHolder{
        var suraname:TextView?=null
        constructor(itemView: View) : super(itemView){
          suraname =itemView.findViewById(R.id.suraname)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QranViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.quranitem,parent,false)
        return QranViewHolder(view)
    }
    override fun getItemCount(): Int {
        return datalist.size
    }
    override fun onBindViewHolder(holder: QranViewHolder, position: Int) {
        var data=datalist.get(position)
        holder.suraname!!.setText(data)

        if(suranameonclick!=null){
            holder.suraname?.setOnClickListener {
                suranameonclick?.suraonclick(position, data)

            }
        }
    }
    var suranameonclick:Suranameclicklistener?=null
    interface  Suranameclicklistener{
        fun suraonclick(pos:Int,suraname:String)
    }

}