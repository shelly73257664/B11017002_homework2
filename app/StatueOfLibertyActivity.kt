import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_statue_of_liberty.*

class StatueOfLibertyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statue_of_liberty)

        // 設置自由女神的照片和說明文字
        imageView.setImageResource(R.drawable.statue_of_liberty)
        textView.text = getString(R.string.statue_of_liberty_description)
    }
}
