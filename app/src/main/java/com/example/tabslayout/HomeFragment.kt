import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabslayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    interface FragmentInteractionListener {
        fun onLoginButtonClicked(username: String, password: String)
    }

    private var listener: FragmentInteractionListener? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentInteractionListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.registerButton.setOnClickListener() {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            listener?.onLoginButtonClicked(username, password)
        }

        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
