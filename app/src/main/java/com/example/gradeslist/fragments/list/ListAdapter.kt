package com.example.gradeslist.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gradeslist.model.Grades
import com.example.gradeslist.R
import com.example.gradeslist.databinding.GradeListItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var gradesList = emptyList<Grades>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = GradeListItemBinding.bind(itemView)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grade_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = gradesList[position]
//        holder.binding.textLabel.text = currentItem.id.toString()
        holder.binding.textLabel.text = currentItem.subject
        holder.binding.textValue.text = currentItem.grade

        holder.binding.gradeItemLayout.setOnClickListener{
            val action = GradesListFragmentDirections.actionGradesListFragmentToEditGradesFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
         }


    }

    override fun getItemCount(): Int {
        return gradesList.size
    }

    fun setData(grade: List<Grades>) {
        this.gradesList = grade
        notifyDataSetChanged()
    }

}