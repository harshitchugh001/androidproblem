package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import java.lang.Double.sum

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var z:View

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
        // Inflate the layout for this fragment
         z=inflater.inflate(R.layout.fragment_blank2, container, false)
        init(container)

        return z
    }
    private lateinit var buttonListener: Interface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buttonListener=try {
            activity as Interface
        }
        catch (e:ClassCastException){
            throw ClassCastException("$context must implement onButtonPressed Interface")
        }
    }


    private fun init(root: ViewGroup?) {

//        val args=this.arguments
//        val first=args?.get("first")
//        val second=args?.get("second")


        val plus: Button = z.findViewById(R.id.plus)
        val minus: Button = z.findViewById(R.id.minus)
        val multiply: Button = z.findViewById(R.id.multiply)
        val divide: Button = z.findViewById(R.id.divide)

        Toast.makeText(context, "init", Toast.LENGTH_LONG).show()
//        plus.setOnClickListener(){
//            val bundle=Bundle()
//            bundle.putInt("first", first as Int)
//            val fragment3=BlankFragment3()
//            fragment3.arguments=bundle
//        }

        plus.setOnClickListener {
//            var sum1=sum(first as Double, second as Double)
//            val sum2=sum1.toString()
//            Toast.makeText(context, "toast working", Toast.LENGTH_LONG).show()
//            Toast.makeText(context, first.toString(), Toast.LENGTH_LONG).show()
            buttonListener.onButtonPressed("plus")
        }
        minus.setOnClickListener {
            buttonListener.onButtonPressed("minus")
        }
        multiply.setOnClickListener {
            buttonListener.onButtonPressed("multiply")
        }
        divide.setOnClickListener {
            buttonListener.onButtonPressed("divide")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}




