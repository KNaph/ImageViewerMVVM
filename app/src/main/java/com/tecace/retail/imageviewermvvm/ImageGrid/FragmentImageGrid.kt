package com.tecace.retail.imageviewermvvm.ImageGrid

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

import android.util.Log
import android.view.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecace.retail.imageviewermvvm.R
import java.io.File

class FragmentImageGrid : Fragment() {

    val TAG = this.javaClass.simpleName

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var files: Array<File>
    private lateinit var fileList: ArrayList<File>

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "KP## onCreate")

        super.onCreate(savedInstanceState)

        initFiles()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG, "KP## onCreateView")
        return inflater.inflate(R.layout.fragment_image_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "KP## onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        viewManager = GridLayoutManager(this.context,context!!.resources.getInteger(R.integer.grid_column_count))
        viewAdapter = context?.let { ImageGridAdapter(it, fileList) }!!

//        var imagegrid_recycler : RecyclerView = view.findViewById(R.id.imagegrid_recycler)

        imagegrid_recycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

//        RecyclerView decoration is used for grid divider
        imagegrid_recycler.addItemDecoration(ImageGridDecorator(
            context!!.resources.getDimensionPixelSize(R.dimen.photogrid_spacing),
            context!!.resources.getInteger(R.integer.grid_column_count))
        )

    }

    private fun initFiles() {
        Log.d(TAG, "KP## initFiles")

        val completePath = this.context?.getExternalFilesDir("images")

        val dir = File(completePath.toString())
        files = dir.listFiles()
        this.fileList = ArrayList()

        for (file in files) {
//                Log.d(TAG, "KP## ${file.name}")
                fileList.add(file)
            }
        }

    fun obtainViewModel(): ImageViewModel =
}