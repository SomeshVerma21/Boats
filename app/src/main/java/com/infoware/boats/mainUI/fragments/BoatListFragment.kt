package com.infoware.boats.mainUI.fragments

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.infoware.boats.R
import com.infoware.boats.databinding.FragmentBoatListBinding
import com.infoware.boats.mainUI.adapters.BoatListAdapter
import com.infoware.boats.mainUI.models.Data
import com.infoware.boats.mainUI.viewModels.BoatListViewModel

class BoatListFragment : Fragment() {
    private lateinit var binding:FragmentBoatListBinding
    private lateinit var viewModel: BoatListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(BoatListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_boat_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.idBoatListView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewModel._listBoats.observe(viewLifecycleOwner, Observer {
            viewModel._listBoats.value?.let {
                val adapter = BoatListAdapter(requireContext(), viewModel.listBoats.value!!.data)
                recyclerView.adapter = adapter
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoatListFragment()
    }
}