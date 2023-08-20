package com.minhchi.basemydocument.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.minhchi.basemydocument.databinding.DetailListBinding

class DetailFragment : Fragment() {

    lateinit var vb: DetailListBinding
    private val detailVM: DetailVM by lazy {
        ViewModelProvider(requireActivity()).get(DetailVM::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = DetailListBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}