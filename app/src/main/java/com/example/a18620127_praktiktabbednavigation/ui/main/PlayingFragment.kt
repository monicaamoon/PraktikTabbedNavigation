package com.example.a18620127_praktiktabbednavigation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a18620127_praktiktabbednavigation.Movie
import com.example.a18620127_praktiktabbednavigation.MovieAdapter
import com.example.a18620127_praktiktabbednavigation.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayingFragment : Fragment() {

    private val movie = arrayOf("Bad Boys for Life","The Old Guard","Raised by Wolves","Elite","The Walking Dead: World Beyond","Artemis Fowl","Black Box","Riverdale","Law & Order : Special Victims Unit","Scary Movie 5","Star Trek: Discovery","Hubie Halloween","District 9","The Hurricane Heist","Paddington 2","Pride & Prejudice ")
    private val movieYear = arrayOf("2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012",
            "2013","2014","2015","2016")

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            var view:View
            view = inflater.inflate(R.layout.fragment_playing, container, false)

            var movieList:ArrayList<Movie> = ArrayList<Movie>()

            for (i in 0 until  movie.size){
                val mov = Movie(movie[i], movieYear[i])
                movieList.add(mov)
            }

            var rvMovie:RecyclerView
            rvMovie = view.findViewById(R.id.rv_movie)

            rvMovie.setHasFixedSize(true)
            rvMovie.layoutManager = LinearLayoutManager(context)

            val movieAdapter = MovieAdapter(movieList)
            rvMovie.adapter = movieAdapter

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlayingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}