package com.example.marketplace.fragmentUi

import android.content.Context
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.marketplace.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.all_shops_cards.view.*
import kotlinx.android.synthetic.main.fragment_main_dashboard.*
import kotlinx.android.synthetic.main.fragment_main_dashboard.view.*
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

/**
 * A simple [Fragment] subclass.
 */
class MainDashboardFragment : Fragment() {

    lateinit var main_view: View
    private val adapter = GroupAdapter<GroupieViewHolder>()

//    private val excite = Section()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        main_view = inflater.inflate(R.layout.fragment_main_dashboard, container, false)

        val spinner: Spinner = main_view.sp_category
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
//            main_view.rv_all_shops_items.adapter = adapter
//            adapter.add(AllShops("ewew"))
//            adapter.add(AllShops("wew"))
//            adapter.add(AllShops("ewew"))
//            adapter.add(AllShops("ewew"))

        val groupAdapter = adapter.apply {
            spanCount = 3
        }
        main_view.rv_all_shops_items.apply {
            layoutManager = GridLayoutManager(this.context, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }

            adapter = groupAdapter

        }

        groupAdapter.add(AllShops("ddsds"))
        groupAdapter.add(AllShops("ddsds"))
        groupAdapter.add(AllShops("ddsds"))
        groupAdapter.add(AllShops("ddsds"))
        groupAdapter.add(AllShops("ddsds"))


        return main_view
    }

    class AllShops(val text: String) : Item<GroupieViewHolder>() {
        override fun getLayout(): Int {
            return R.layout.all_shops_cards
        }

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.tv_name2.text = text
            Log.i("vvvv", "$text")
        }

        override fun getSpanSize(spanCount: Int, position: Int) = spanCount / 3

    }

}
