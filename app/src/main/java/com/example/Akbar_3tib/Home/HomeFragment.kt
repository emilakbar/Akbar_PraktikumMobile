
package com.example.Akbar_3tib.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Akbar_3tib.BaseActivity
import com.example.Akbar_3tib.LoginActivity
import com.example.Akbar_3tib.MainActivity
import com.example.Akbar_3tib.R
import com.example.Akbar_3tib.databinding.FragmentHomeBinding
import com.example.Akbar_3tib.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
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

        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.title = "Home"

        val preferences = requireActivity()
            .getSharedPreferences(
                "LoginSession",
                AppCompatActivity.MODE_PRIVATE
            )

        val username = preferences.getString("username", "Username")

        binding.txtUsername.text = "Username: $username"
        binding.txtPassword.text = "Status: Berhasil login"

        // Tombol Snackbar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Item dihapus",
                Snackbar.LENGTH_LONG
            ).setAction("BATAL") {
                Snackbar.make(
                    binding.root,
                    "Penghapusan dibatalkan",
                    Snackbar.LENGTH_SHORT
                ).show()
            }.show()
        }

        // Tombol Alert Dialog
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus Data")
                .setMessage(
                    "Data yang dihapus tidak bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    dialog.dismiss()

                    Snackbar.make(
                        binding.root,
                        "Data berhasil dihapus",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                .setCancelable(false)
                .show()
        }

        // Tombol Pertemuan 5
        binding.btnToLima.setOnClickListener {
            startActivity(
                Intent(requireActivity(), LimaActivity::class.java)
            )
        }

        // Tombol Pertemuan 6
        binding.btnToEnam.setOnClickListener {
            startActivity(
                Intent(requireActivity(), MainActivity::class.java)
            )
        }

        // Tombol Kembali
        binding.btnKembali.setOnClickListener {
            requireActivity().finish()
        }

        // Tombol Logout
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah kamu yakin ingin keluar?")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Logout") { _, _ ->

                    preferences.edit()
                        .clear()
                        .apply()

                    val logoutIntent = Intent(
                        requireActivity(),
                        LoginActivity::class.java
                    ).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }

                    startActivity(logoutIntent)
                    requireActivity().finish()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
