package com.uzdev.guidebook.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uzdev.alichtechtask.ui.fragment.MainViewModel
import com.uzdev.guidebook.R
import com.uzdev.guidebook.databinding.FragmentMainBinding
import com.uzdev.guidebook.ui.adapter.MyAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    lateinit var binding: FragmentMainBinding
    lateinit var myAdapter: MyAdapter
    lateinit var mainViewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        binding = FragmentMainBinding.bind(view)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            myAdapter = MyAdapter()
            adapter = myAdapter
        }
        loadData()
    }


    private fun loadData() {
        mainViewModel.getGuideDataObserve().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                myAdapter.setListData(it.data)
            }
        })
        mainViewModel.makeApiCall()
    }
}