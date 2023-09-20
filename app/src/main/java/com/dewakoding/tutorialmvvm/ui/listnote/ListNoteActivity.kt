package com.dewakoding.tutorialmvvm.ui.listnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.model.Note
import com.dewakoding.tutorialmvvm.databinding.ActivityMainBinding
import com.dewakoding.tutorialmvvm.listener.OnNoteClickListener
import com.dewakoding.tutorialmvvm.ui.addnote.AddNoteActivity
import com.dewakoding.tutorialmvvm.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListNoteActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    lateinit var adapter: ListNoteAdapter
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ListNoteAdapter(applicationContext, object: OnNoteClickListener {
            override fun onDelete(note: Note) {
               noteViewModel.delete(note)
            }

        })
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        binding.recyclerView.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(applicationContext, AddNoteActivity::class.java)
            startActivity(intent)
        }

        noteViewModel.getAll().observe(this) { list ->
            list.let {
                adapter.updateList(list)
            }
        }
    }
}