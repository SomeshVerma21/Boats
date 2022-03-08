package com.infoware.boats.mainUI.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.infoware.boats.R
import com.infoware.boats.databinding.FragmentCollectionBinding
import com.infoware.boats.mainUI.adapters.CollectionAdapter
import com.infoware.boats.mainUI.databaseUtils.BoatDatabase
import com.infoware.boats.mainUI.databaseUtils.BoatsEntity
import com.infoware.boats.mainUI.databaseUtils.DatabaseDao

class CollectionFragment : Fragment() {
    private lateinit var binding:FragmentCollectionBinding
    private lateinit var dataSource:DatabaseDao
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_collection,container,false)
        dataSource  = BoatDatabase.getInstance(requireContext()).taskDatabaseDao
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.idCollectionList
        val list = dataSource.getALl() as MutableList
        Toast.makeText(requireContext(),list.size.toString(),Toast.LENGTH_SHORT).show()
        val sorted = list.sortedBy { it.boatPrice }
        val adapter = CollectionAdapter(requireContext(), sorted as MutableList<BoatsEntity>,dataSource)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CollectionFragment()
    }
}