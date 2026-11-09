package com.example.Akbar_3tib.Home.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.Akbar_3tib.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    // Data 10 menu kopi
    private val productList = listOf(
        ProductModel(
            "Espresso",
            "Rp 18.000",
            "https://picsum.photos/seed/espresso/400/300"
        ),
        ProductModel(
            "Americano",
            "Rp 20.000",
            "https://picsum.photos/seed/americano/400/300"
        ),
        ProductModel(
            "Cappuccino",
            "Rp 25.000",
            "https://picsum.photos/seed/cappuccino/400/300"
        ),
        ProductModel(
            "Cafe Latte",
            "Rp 25.000",
            "https://picsum.photos/seed/latte/400/300"
        ),
        ProductModel(
            "Mocha",
            "Rp 28.000",
            "https://picsum.photos/seed/mocha/400/300"
        ),
        ProductModel(
            "Macchiato",
            "Rp 27.000",
            "https://picsum.photos/seed/macchiato/400/300"
        ),
        ProductModel(
            "Caramel Latte",
            "Rp 30.000",
            "https://picsum.photos/seed/caramel/400/300"
        ),
        ProductModel(
            "Vanilla Latte",
            "Rp 28.000",
            "https://picsum.photos/seed/vanilla/400/300"
        ),
        ProductModel(
            "Cold Brew",
            "Rp 24.000",
            "https://picsum.photos/seed/coldbrew/400/300"
        ),
        ProductModel(
            "Kopi Susu Gula Aren",
            "Rp 22.000",
            "https://picsum.photos/seed/kopisusu/400/300"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val productAdapter = ProductAdapter(productList) { selectedItem ->

            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()

        }

        binding.rvProducts.apply {
            // Grid 2 kolom
            layoutManager = GridLayoutManager(requireContext(), 2)

            // Memasang adapter
            adapter = productAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}