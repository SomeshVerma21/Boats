package com.infoware.boats.mainUI.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.infoware.boats.R
import com.infoware.boats.Utils.EndPoints
import com.infoware.boats.databinding.FragmentBoatDetailsBinding
import com.infoware.boats.mainUI.models.boatDetailsModel.Data
import com.infoware.boats.mainUI.databaseUtils.BoatDatabase
import com.infoware.boats.mainUI.databaseUtils.BoatsEntity
import com.infoware.boats.mainUI.databaseUtils.DatabaseDao
import com.infoware.boats.mainUI.viewModels.BoatDetails

class BoatDetailsFragment : Fragment() {
    private lateinit var binding:FragmentBoatDetailsBinding
    private lateinit var viewModel:BoatDetails
    private lateinit var dataSource:DatabaseDao
    private var boatKey:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BoatDetails::class.java)
        dataSource = BoatDatabase.getInstance(requireContext()).taskDatabaseDao
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val boatId = arguments?.getString("id")
        if (boatId != null) {
            viewModel.getDetailsOfBoat(boatId)
        }
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_boat_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val shimmerView = binding.idShimmerLayout
        shimmerView.startShimmerAnimation()
        viewModel._response.observe(viewLifecycleOwner, Observer {
            if (viewModel._response.value == true){
                Handler().postDelayed(Runnable {
                    shimmerView.stopShimmerAnimation()
                    shimmerView.visibility = View.GONE
                    binding.idDetailsLayout.visibility = View.VISIBLE
                    viewModel.resultData.value?.data?.let { it1 -> updateUI(it1) }
                },1200)
            }
        })
    }

    private fun updateUI(data:Data)
    {
        binding.idBoatName.text = data.cruise_name
        binding.boatPrice.text = "$"+data.cruise_price
        binding.idBoatWidth.text = data.cruise_width
        binding.idBoatHight.text = data.cruise_height
        binding.idCaptionName.text = data.captain.first_name+" "+data.captain.lastName
        binding.idBoatCaptionEmail.text = data.captain.email
        binding.idBoatCaptionMobile.text = data.captain.phone
        binding.idBoatPaxCapacity.text = data.cruise_pax_capacity.toString()
        binding.idBoatDescription.text = data.cruise_desc
        val thumbnail = binding.idMainThumbnailImg
        Glide.with(thumbnail).load(EndPoints.imgBaseUrl+data.cruise_thumb_img).into(thumbnail)
        val uid = dataSource.checkBoatInfo(data.id)
        if (uid.isNotEmpty()){
            binding.idAddToCollctionBtn.isActivated = false
            binding.idAddToCollctionBtn.text = "Already in collection"
            binding.idAddToCollctionBtn.alpha = 0.5F
        }else{
            binding.idAddToCollctionBtn.setOnClickListener {
                dataSource.addToCollection(BoatsEntity(null,data.id))
                binding.idAddToCollctionBtn.isActivated = false
                binding.idAddToCollctionBtn.text = "Added to collection"
                binding.idAddToCollctionBtn.alpha = 0.5F
                Toast.makeText(requireContext(),"Added to Collection",Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BoatDetailsFragment()
    }
}