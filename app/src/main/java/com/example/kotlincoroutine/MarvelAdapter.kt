package com.example.kotlincoroutine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MarvelAdapter(val context: Context) : RecyclerView.Adapter<MarvelAdapter.DataViewHolder>() {

   // private lateinit var mcontext: Context
    //= ArrayList()
    var dataList: List<ModelListView> = listOf()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        //context = parent.context
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val data = dataList[position]
        val name = holder.itemView.name
        val realName = holder.itemView.realName
        val team = holder.itemView.team
        val firstappearance = holder.itemView.firstappearance
        val createdby= holder.itemView.createdby
        val publisher=holder.itemView.publisher
        val imageurl=holder.itemView.imageurl
        val bio=holder.itemView.bio

        name.text = data.name
        realName.text = data.realname
        team.text = data.team
        firstappearance.text=data.firstappearance
        createdby.text=data.createdby
        publisher.text=data.publisher
        imageurl.text=data.imageurl
        bio.text=data.bio

    }

    fun setData(dataList: List<ModelListView>)
    {
        this.dataList = dataList
        notifyDataSetChanged()

    }



    // fun submitData(dataList: ArrayList<ModelListView>){
    //    dataModelArrayList = dataList
    // }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}