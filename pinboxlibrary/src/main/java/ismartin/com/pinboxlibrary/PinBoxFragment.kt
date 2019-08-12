package ismartin.com.pinboxlibrary

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_pin_box.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CHANGE_PIN = "changingPin"


class PinBoxFragment : Fragment(), View.OnClickListener, View.OnLongClickListener {
    // TODO: Rename and change types of parameters
    private var isChangePin: Boolean? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var currentPin: String = ""
    private var confirmPin: String = ""
    private var stateMachine: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isChangePin = it.getBoolean(CHANGE_PIN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_pin_box, container, false)

        initViews(view)
        initStateMachine()

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnDone ->{
            }
            else -> {
                val buttonPressed: Button = p0 as Button
                val inputNumber: String=buttonPressed.text.split("btn", "ok")[0]
                concatStringNumbers(inputNumber)
            }
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        when(p0?.id){

        }
        return true
    }

    fun initViews(view: View){
        var b0 = view.findViewById<Button>(R.id.btn0)
        var b1 = view.findViewById<Button>(R.id.btn1)
        var b2 = view.findViewById<Button>(R.id.btn2)
        var b3 = view.findViewById<Button>(R.id.btn3)
        var b4 = view.findViewById<Button>(R.id.btn4)
        var b5 = view.findViewById<Button>(R.id.btn5)
        var b6 = view.findViewById<Button>(R.id.btn6)
        var b7 = view.findViewById<Button>(R.id.btn7)
        var b8 = view.findViewById<Button>(R.id.btn8)
        var b9 = view.findViewById<Button>(R.id.btn9)
        var bDone = view.findViewById<Button>(R.id.btnDone)

        b0.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        b9.setOnClickListener(this)
        bDone.setOnClickListener(this)
    }

    fun initStateMachine(){

    }

    fun concatStringNumbers(stringNumber: String){
        if(currentPin.length < 5){
            currentPin += stringNumber
            etPin.setText(currentPin)
        }
    }

    fun eraseOneNumber(){
        if (currentPin.isNotEmpty()){
            currentPin = currentPin.substring(0, currentPin.length - 1)
            etPin.setText(currentPin)
        }
    }

    fun eraseAllNumbers(){
        if(currentPin.isNotEmpty()){
            currentPin = ""
            etPin.setText(currentPin)
        }
    }

    fun pinManagment(view: View){
        if(currentPin.length > 3){
            when(stateMachine) {
                0 -> {

                }
                1 -> {

                }
                2 -> {

                }
            }
        } else {

        }
    }

    fun showInfoMessage(typeInfo: Int, message: String){
        when(typeInfo){
            0 -> { //Info
                tvInfo.setTextColor(Color.BLUE)
            }
            1 -> { //Warning
                tvInfo.setTextColor(Color.YELLOW)
            }
            2 -> { //Error
                tvInfo.setTextColor(Color.RED)
            }
        }
        tvInfo.setText(message)
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PinBoxFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(changePin: Boolean) =
            PinBoxFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(CHANGE_PIN, changePin)
                }
            }
    }
}
