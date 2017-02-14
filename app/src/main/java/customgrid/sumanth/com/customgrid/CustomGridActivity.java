package customgrid.sumanth.com.customgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CustomGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        int[] data = {1,2,3,4};
        CustomGridView cgView = new CustomGridView(this,data);
        rootLayout.addView(cgView);

    }
}
