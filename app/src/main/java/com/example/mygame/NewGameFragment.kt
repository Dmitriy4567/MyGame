package com.example.mygame

import android.app.AlertDialog
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewGameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewGameFragment : Fragment() {
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

        return inflater.inflate(R.layout.fragment_new_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bExit: Button? =view?.findViewById(R.id.bExit)
        val bNew:Button?=view?.findViewById(R.id.bNew)
        val bContinue:Button?=view?.findViewById(R.id.bContinue)


        bExit?.setOnClickListener {
            val builder = AlertDialog.Builder(ContextThemeWrapper(context, android.R.style.Theme_DeviceDefault_Panel))
            builder.setTitle("Выход")
            builder.setMessage("Вы действительно хотите выйти?")

            builder.setPositiveButton("Да") { dialog, which ->
                activity?.finishAffinity()
            }

            builder.setNegativeButton("Нет") { dialog, which ->
            }
            builder.show()
        }

        bNew?.setOnClickListener {
            getParentFragmentManager().beginTransaction().replace(R.id.frameLayoutNG,StartFragment()).commit()
        }

        bContinue?.setOnClickListener {
            Toast.makeText(activity, "Продолжить", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewGameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewGameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}