package examples.aaronhoskins.com.kotlinintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    /**
     *  val - final, immutable
     *  var - non-final, mutable
     */
    val welcomeString = "Welcome to Kotlin"
    var messageTwo = "Message Two"

    val name  by lazy { getFirstName() }
    lateinit var address : String
    var message : String? = null
    companion object {
        fun returnValue() : String = "returned Value"

    }

    //Java = public void onCreate(@Nullable Bundle saveInstanceState)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageTwo = "Something meaningful"

        tvWelcomeMessage.text = welcomeString
        tvSecondMessage.text = messageTwo

        //message = "I am not null, dont ignore me :("
        //tvThirdMessage.text = message?: "DEFAULT"
        tvThirdMessage.text = message
        //JAVA
        //tvThrirdMessage.setText(message == null ? "DEFAULT : message):
    }


    fun getFirstName() : String{
        return "Aaron Hoskins"
    }
}
