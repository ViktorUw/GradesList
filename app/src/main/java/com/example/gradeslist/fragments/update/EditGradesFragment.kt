package com.example.gradeslist.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gradeslist.R
import com.example.gradeslist.databinding.FragmentEditGradesBinding
import com.example.gradeslist.model.Grades
import com.example.gradeslist.viewmodel.GradeViewModel

class EditGradesFragment : Fragment() {

    private val args by navArgs<EditGradesFragmentArgs>()
    private lateinit var binding: FragmentEditGradesBinding
    private lateinit var mUserViewModel: GradeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditGradesBinding.inflate(inflater)

        mUserViewModel = ViewModelProvider(this).get(GradeViewModel::class.java)
        binding.editNameOfSubject.setText(args.curentGrade.subject)
        binding.editGrade.setText(args.curentGrade.grade)

        binding.buttonConfirmChanges.setOnClickListener {
            updateItem()
        }
        binding.buttonDeleteGrade.setOnClickListener {
            deleteItem()
        }


        return binding.root
    }

    private fun updateItem() {
        val nameOfSubject = binding.editNameOfSubject.text.toString()
        val grade = binding.editGrade.text.toString()
        if (inputCheck(nameOfSubject, grade) && grade.toInt() <= 5) {
            val updatedGrade = Grades(args.curentGrade.id, nameOfSubject, grade)
            mUserViewModel.updateGrade(updatedGrade)
            Toast.makeText(requireContext(), "Ocena Zostałą Zmieniona!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editGradesFragment_to_gradesListFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Uzupełnij Wsystkie Pola (Ocena Powinna Być < 5)!",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    private fun deleteItem() {
        mUserViewModel.deleteGrade(args.curentGrade)
        Toast.makeText(requireContext(), "Ocena Zostałą Usunięta!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_editGradesFragment_to_gradesListFragment)
    }

    private fun inputCheck(subject: String, grade: String): Boolean {
        return !(TextUtils.isEmpty(subject) && TextUtils.isEmpty((grade)))
    }


}


