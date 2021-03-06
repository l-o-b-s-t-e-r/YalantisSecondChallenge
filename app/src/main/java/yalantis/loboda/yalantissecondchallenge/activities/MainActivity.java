package yalantis.loboda.yalantissecondchallenge.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import yalantis.loboda.yalantissecondchallenge.R;
import yalantis.loboda.yalantissecondchallenge.adapters.TabAdapter;
import yalantis.loboda.yalantissecondchallenge.fragments.ListViewFragment;
import yalantis.loboda.yalantissecondchallenge.fragments.RecyclerViewFragment;
import yalantis.loboda.yalantissecondchallenge.models.CardContent;
import yalantis.loboda.yalantissecondchallenge.models.Organization;

public class MainActivity extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    public static final String DETAIL_INFO = "DETAIL_INFO";
    public static AdapterView.OnItemClickListener onItemClickListener;
    public static List<CardContent> contents;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillInfo();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView firstLinkView = (TextView)findViewById(R.id.links);
        firstLinkView.setMovementMethod(LinkMovementMethod.getInstance());

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        List<Fragment> fragments = Arrays.asList(RecyclerViewFragment.newInstance(getString(R.string.status_progress), tabLayout),
                RecyclerViewFragment.newInstance(getString(R.string.status_done), tabLayout),
                ListViewFragment.newInstance(getString(R.string.status_waiting), tabLayout));

        FragmentStatePagerAdapter tabAdapter = new TabAdapter(fragmentManager, fragments);
        mViewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open_menu, R.string.close_menu);

        mActionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        mActionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu);

        mActionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(MainActivity.DETAIL_INFO, position);
                startActivity(intent);
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void fillInfo() {
        contents = Arrays.asList(
                CardContent.getInstance()
                        .setAddress(getString(R.string.address_municipal))
                        .setDate(new Date())
                        .setDays(7)
                        .setLikesCount(4)
                        .setOrganization(Organization.MUNICIPAL),

                CardContent.getInstance()
                        .setAddress(getString(R.string.address_building))
                        .setDate(new Date())
                        .setDays(5)
                        .setLikesCount(1)
                        .setOrganization(Organization.BUILDING),

                CardContent.getInstance()
                        .setAddress(getString(R.string.address_mall))
                        .setDate(new Date())
                        .setDays(8)
                        .setLikesCount(7)
                        .setOrganization(Organization.MALL),

                CardContent.getInstance()
                        .setAddress(getString(R.string.address_municipal))
                        .setDate(new Date())
                        .setDays(7)
                        .setLikesCount(4)
                        .setOrganization(Organization.MUNICIPAL),

                CardContent.getInstance()
                        .setAddress(getString(R.string.address_building))
                        .setDate(new Date())
                        .setDays(5)
                        .setLikesCount(1)
                        .setOrganization(Organization.BUILDING),

                CardContent.getInstance()
                        .setAddress(getString(R.string.address_mall))
                        .setDate(new Date())
                        .setDays(8)
                        .setLikesCount(7)
                        .setOrganization(Organization.MALL));
    }
}
