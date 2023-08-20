package com.minhchi.basemydocument.fragment.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasekotlin.fragment.home.MovieVM
import com.minhchi.basemydocument.model.RepositoryData
import com.minhchi.basemydocument.adapter.MovieAdapter
import com.minhchi.basemydocument.databinding.MovieListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    lateinit var vb: MovieListBinding

    private val vm: MovieVM by lazy {
        ViewModelProvider(this).get(MovieVM::class.java)
    }
    private var repoAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vb = MovieListBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initMainViewModel()
    }

    private fun initViewModel() {
        vb.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())

            val decoration =
                DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            repoAdapter = MovieAdapter()
            adapter = repoAdapter
        }
    }

    private fun initMainViewModel() {
//        vm.getAllRepositoryList().observe(viewLifecycleOwner) {
//            repoAdapter.submitList(it)
//            repoAdapter.notifyDataSetChanged()
//        }

        vm.getAllRepositoryList().observe(requireActivity(), Observer<List<RepositoryData>> {
            repoAdapter.submitList(it)
            repoAdapter.notifyDataSetChanged()
        })
        vm.makeApiCall()
    }


}

