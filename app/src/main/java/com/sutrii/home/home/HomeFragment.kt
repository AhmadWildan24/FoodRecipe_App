package com.sutrii.home.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.sutrii.home.CategoryMakanan
import com.sutrii.home.CategoryMinuman
import com.sutrii.home.CategorySemua
import com.sutrii.home.R
import com.sutrii.home.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var button_semua: Button
    private lateinit var button_makanan: Button
    private lateinit var button_minuman: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        button_semua = view.findViewById(R.id.button_semua)
        button_makanan = view.findViewById(R.id.button_makanan)
        button_minuman = view.findViewById(R.id.button_minuman)

        button_semua.setOnClickListener {
            onCategoryButtonClick(button_semua)
            replaceInnerFragment(CategorySemua())
        }

        button_makanan.setOnClickListener {
            onCategoryButtonClick(button_makanan)
            replaceInnerFragment(CategoryMakanan())
        }

        button_minuman.setOnClickListener {
            onCategoryButtonClick(button_minuman)
            replaceInnerFragment(CategoryMinuman())
        }

        // Set initial state (e.g., make btnCategory1 active)
        onCategoryButtonClick(button_semua)

        return view
    }

    private fun onCategoryButtonClick(clickedButton: Button) {
        // Reset all buttons to inactive state
        resetButtonStyle(button_semua)
        resetButtonStyle(button_makanan)
        resetButtonStyle(button_minuman)

        // Set the clicked button to active state
        setButtonActiveStyle(clickedButton)
    }

    private fun setButtonActiveStyle(button: Button) {
        button.setBackgroundResource(R.drawable.button_background)
        button.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        button.isEnabled = false // Optional: Disable the button to prevent multiple clicks
    }

    private fun resetButtonStyle(button: Button) {
        button.setBackgroundResource(R.drawable.button_background)
        button.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
        button.isEnabled = true // Optional: Enable the button if needed
    }

    private fun replaceInnerFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.ContainerCategory, fragment)
            .addToBackStack(null)
            .commit()
    }
}