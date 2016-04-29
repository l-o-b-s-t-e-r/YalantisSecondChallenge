package yalantis.loboda.yalantissecondchallenge.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import yalantis.loboda.yalantissecondchallenge.R;
import yalantis.loboda.yalantissecondchallenge.fragments.DetailFragment;

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
