package com.example.gradeslist.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gradeslist.R
import com.example.gradeslist.model.Grades
import com.example.gradeslist.viewmodel.GradeViewModel
import com.example.gradeslist.databinding.FragmentAddGradeBinding

class AddGradeFragment : Fragment() {
    private lateinit var binding: FragmentAddGradeBinding
    private lateinit var mGradeViewModel: GradeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddGradeBinding.inflate(inflater)

        mGradeViewModel = ViewModelProvider(this).get(GradeViewModel::class.java)

        binding.buttonAdd.setOnClickListener{
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val subject = binding.nameOfSubjectInput.text.toString()
        val grade = binding.gradeInput.text.toString()

        if (inputCheck(subject,grade) && grade.toInt() <= 5) {
            // Create Object
            val grade = Grades(0, subject, grade)
            // Add data to Database
            mGradeViewModel.addGrade(grade)
            Toast.makeText(requireContext(), "Dodano Ocenę", Toast.LENGTH_LONG).show()
            // Navigate back
            findNavController().navigate(R.id.action_addGradeFragment_to_gradesListFragment)
        }else{
            Toast.makeText(requireContext(), "Uzupełnij Wsystkie Pola (Ocena Powinna Być < 5)!", Toast.LENGTH_LONG).show()
        }

        }
    private fun inputCheck(subject: String, grade: String): Boolean{
        return !(TextUtils.isEmpty(subject) && TextUtils.isEmpty((grade)))
    }
}



