package com.example.gradeslist.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gradeslist.R
import com.example.gradeslist.viewmodel.GradeViewModel
import com.example.gradeslist.databinding.FragmentGradesListBinding


class GradesListFragment : Fragment() {
    lateinit var binding: FragmentGradesListBinding
    private lateinit var mGradesViewModel: GradeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGradesListBinding.inflate(inflater)

        // Recyckler
        val adapter = ListAdapter()
        val recyclerView = binding.gradesListRv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        // GradeViewModel
        mGradesViewModel = ViewModelProvider(this).get(GradeViewModel::class.java)
        mGradesViewModel.readAllData.observe(viewLifecycleOwner, Observer {grade ->
            adapter.setData(grade)
        })

        mGradesViewModel.averageGrade.observe(viewLifecycleOwner, Observer{average->
            binding.gradesListAverageGradeValue.text = "$average"
        })

        binding.buttonCreateNew.setOnClickListener{

            findNavController().navigate(R.id.action_gradesListFragment_to_addGradeFragment)
        }

        binding.buttonDeleteAll.setOnClickListener{
            mGradesViewModel.deleteAllGrades()
            Toast.makeText(requireContext(),"Wszystkie Oceny Zostały Usunięte", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}