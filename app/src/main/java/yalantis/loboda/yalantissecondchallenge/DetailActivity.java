package yalantis.loboda.yalantissecondchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_detail, new DetailFragment())
                .commit();
    }
}
