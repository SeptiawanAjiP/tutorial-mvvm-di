package com.dewakoding.tutorialmvvm.ui.addnote

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.model.Note
import com.dewakoding.tutorialmvvm.databinding.ActivityCreateBinding
import com.dewakoding.tutorialmvvm.repository.NoteRepository
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModel
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModelFactory
import dagger.hilt.android.AndroidEntryPoint


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
@AndroidEntryPoint
class AddNoteActivity: AppCompatActivity() {
    private val binding by lazy { ActivityCreateBinding.inflate(layoutInflater) }
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgCheck.setOnClickListener {
            if (!binding.etTitle.text.toString().isNullOrEmpty()
                && !binding.etDescription.text.toString().isNullOrEmpty()) {
                noteViewModel.insert(Note(null, binding.etTitle.text.toString(), binding.etDescription.text.toString()))
            } else {
                Toast.makeText(applicationContext, "Ada data yang masih kosong", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}