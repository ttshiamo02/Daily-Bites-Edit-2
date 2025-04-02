package vcmsa.ci.dailybitesedit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var clearButton: Button
    private lateinit var suggestButton: Button
    private lateinit var mealSuggestion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        timeInput = findViewById(R.id.timeInput)
        clearButton = findViewById(R.id.clearButton)
        suggestButton = findViewById(R.id.suggestButton)
        mealSuggestion = findViewById(R.id.MealSuggestion)


        suggestButton.setOnClickListener {
            val timeString = timeInput.text.toString()
            val suggestion= getMealSuggestion(timeString)
            mealSuggestion.text = suggestion

            clearButton.setOnClickListener {
                mealSuggestion.text = "" // Should clear the meal suggestion text
            }
        }
    }

    private fun getMealSuggestion(timeString :String):String {
        val timeParts = timeString.split(":")
        if (timeParts.size != 2)
            return "Invalid time format.Please enter the time in this format HH:MM "


        val hour: Number? = timeParts[0].toIntOrNull()
        val minute = timeParts[1].toIntOrNull()


        if (hour == null || minute == null) {
            return "Invalid time format.Please enter valid hours and minutes."

            }

       return when (hour) {
           in 7..15 -> " Have some Cereal or some Bacon and eggs"
           in 9..20 -> " Some Tea or Coffee?"
           in 11..25 -> " Have a sandwich or a salad?"
           in 15..30 -> "Have some sweets or nuts?"
           in 18..35 -> "Mash and garvy would do or some Spaghetti and Meatballs"
           in 21..40 -> "How about some Yogurt or some Avocado Toast"
           else -> "Its late now,Try again tomorrow :)"
       }
    }
}
