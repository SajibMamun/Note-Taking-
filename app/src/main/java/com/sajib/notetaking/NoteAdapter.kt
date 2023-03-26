package com.sajib.notetaking

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sajib.notetaking.databinding.ItemdesignBinding
import com.sajib.notetaking.roomdb.Note


class NoteAdapter(var mContext:Context,var listener: UserClickedListener):ListAdapter<Note, NoteAdapter.NoteViewHolder>(
    comparator
) {



    //colorlistarrays
    private val backgroundColors = intArrayOf(
        com.sajib.notetaking.R.color.color1,
        com.sajib.notetaking.R.color.color2,
        com.sajib.notetaking.R.color.color3,
        com.sajib.notetaking.R.color.color4,
        com.sajib.notetaking.R.color.color5,
        com.sajib.notetaking.R.color.color6,
    )
    //////

    class NoteViewHolder(var binding: ItemdesignBinding):RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
  return  NoteViewHolder(ItemdesignBinding.inflate(LayoutInflater.from(parent.context),parent,
      false)
  )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
getItem(position).let {

    holder.binding.notettileid.text=it.NoteTitle
    holder.binding.notedetailsid.text=it.NoteDetails





    holder.binding.deletenotebtn.setOnClickListener {_->
        listener.NoteDelete(it,mContext)
    }


    holder.binding.editnotebtnid.setOnClickListener {_ ->
      //  listener.NoteUpdate(it)
        var intent= Intent(mContext,EditNoteActivity::class.java)
        intent.putExtra("id",it.NoteID)
        intent.putExtra("title",it.NoteTitle)
        intent.putExtra("description",it.NoteDetails)
        mContext.startActivity(intent)
    }






    //setcolor
    val index: Int = position % backgroundColors.size
    val color = ContextCompat.getColor(mContext, backgroundColors[index])
    holder.binding.itemlayoutid.setBackgroundColor(color)
    ///



    holder.binding.addtofvrtbtn.setOnClickListener {
        holder.binding.addtofvrtbtn.setImageResource(R.drawable.favourite)

        Toast.makeText(mContext,"added to favourite",Toast.LENGTH_SHORT).show()
    }








}
    }







    companion object  {

        var comparator=object :DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
         return  oldItem.NoteID==newItem.NoteID
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
          return oldItem==newItem;
            }

        }
    }



}