package com.example.mygame

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class StartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val Voin = DataSelectPerson(R.drawable.fon5,"Борис","4","5","2","1","Это тупой рыцарь. Всё...")
    val Mag = DataSelectPerson(R.drawable.mg,"Олег","2","1","3","5","Олег, он и в Африке Олег.")
    val Vor = DataSelectPerson(R.drawable.vr,"Владимир Владимирович","3","2","5","3","Вор, дебошир, алкоголик, фрилансер.")

    private lateinit var adapterPersons: AdapterPersons
    private lateinit var rcPersons: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager= LinearLayoutManager(context)
        rcPersons = view.findViewById(R.id.rcPersons)
        var spisokArrayList=ArrayList<DataSelectPerson>()
        spisokArrayList.add(Voin)
        spisokArrayList.add(Mag)
        spisokArrayList.add(Vor)
        rcPersons.layoutManager = layoutManager
        rcPersons.setHasFixedSize(true)//?????
        adapterPersons = AdapterPersons(spisokArrayList)
        rcPersons.adapter = adapterPersons

        adapterPersons.onItemClick = {
            val intent = Intent(activity,MainActivity::class.java)
            intent.putExtra("person",it)
            startActivity(intent)
        }


    }



    companion object {

        @JvmStatic
        fun newInstance() = StartFragment()
    }

}