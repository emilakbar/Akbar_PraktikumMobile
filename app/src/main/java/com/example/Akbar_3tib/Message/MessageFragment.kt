
package com.example.Akbar_3tib.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Akbar_3tib.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(
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
            .supportActionBar?.title = "Message"
        val messages = listOf(
            MessageModel(
                "HJ Mansur",
                "Halo, apo kabar diak?",
                "https://i.pravatar.cc/150?img=1",
                "09.30"
            ),
            MessageModel(
                "Antok service ac",
                "Alah tu boyy!!.",
                "https://i.pravatar.cc/150?img=2",
                "09.45"
            ),
            MessageModel(
                "Ajo Pariaman",
                "Bali salalauak ciek da!",
                "https://i.pravatar.cc/150?img=3",
                "10.00"
            ),
            MessageModel(
                "Tukang galon",
                "Anjay gokil bro",
                "https://i.pravatar.cc/150?img=4",
                "10.15"
            ),
            MessageModel(
                "Megawati",
                "File tugas sudah saya kirim.",
                "https://i.pravatar.cc/150?img=5",
                "10.30"
            ),
            MessageModel(
                "Fajar",
                "Baik, nanti saya periksa.",
                "https://i.pravatar.cc/150?img=6",
                "10.45"
            ),
            MessageModel(
                "Gita",
                "Kapan kita mengerjakan proyek?",
                "https://i.pravatar.cc/150?img=7",
                "11.00"
            ),
            MessageModel(
                "Hendra",
                "Besok kita diskusikan bersama.",
                "https://i.pravatar.cc/150?img=8",
                "11.15"
            ),
            MessageModel(
                "Indah",
                "Oke, terima kasih!",
                "https://i.pravatar.cc/150?img=9",
                "11.30"
            ),
            MessageModel(
                "Prabowo",
                "Semangat mengerjakan tugas!",
                "https://i.pravatar.cc/150?img=10",
                "11.45"
            )
        )
        // Menampilkan daftar pesan
        binding.listMessageItems.adapter =
            MessageAdapter(requireContext(), messages)

        // Membuka halaman detail saat pesan ditekan
        binding.listMessageItems.setOnItemClickListener {
                _, _, position, _ ->

            val selectedMessage = messages[position]

            val intent = Intent(
                requireContext(),
                MessageDetailActivity::class.java
            ).apply {
                putExtra(
                    "senderName",
                    selectedMessage.senderName
                )
                putExtra(
                    "messageText",
                    selectedMessage.messageText
                )
                putExtra(
                    "avatarUrl",
                    selectedMessage.avatarUrl
                )
                putExtra(
                    "messageTime",
                    selectedMessage.messageTime
                )
            }

            startActivity(intent)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
