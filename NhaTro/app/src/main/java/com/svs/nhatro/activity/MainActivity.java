package com.svs.nhatro.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.svs.nhatro.R;
import com.svs.nhatro.adapter.MainAdapter;
import com.svs.nhatro.base.BaseActivity;
import com.svs.nhatro.base.BaseFragment;
import com.svs.nhatro.fragment.favorite.FavoriteFragment;
import com.svs.nhatro.fragment.home.HomeFragment;
import com.svs.nhatro.fragment.menu.MenuFragment;
import com.svs.nhatro.fragment.post.PostFragment;
import com.svs.nhatro.others.constant.AppConstant;
import com.svs.nhatro.others.view.NotScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    private static final int[] tabIcons = {R.drawable.selector_home, R.drawable.selector_favorite,
            R.drawable.selector_post, R.drawable.selector_menu};

    @BindView(R.id.actMain_tlMain)
    TabLayout tlMain;
    @BindView(R.id.actMain_vpMain)
    NotScrollViewPager vpMain;

    private ArrayList<BaseFragment> fragments;
    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FavoriteFragment());
        fragments.add(new PostFragment());
        fragments.add(new MenuFragment());
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), fragments);
        vpMain.setAdapter(mainAdapter);
        vpMain.setOffscreenPageLimit(fragments.size());
        tlMain.setupWithViewPager(vpMain);
        tlMain.addOnTabSelectedListener(this);
        createTab();
    }

    @SuppressLint("InflateParams")
    private void createTab() {
        textViews = new TextView[fragments.size()];
        ImageView[] imageViews = new ImageView[fragments.size()];
        View[] views = new View[fragments.size()];
        String[] titles = {getString(R.string.home), getString(R.string.favorite),
                getString(R.string.post), getString(R.string.menu)};
        for (int i = 0; i < fragments.size(); i++) {
            views[i] = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tab, null);
            imageViews[i] = views[i].findViewById(R.id.itemTab_imvImage);
            textViews[i] = views[i].findViewById(R.id.itemTab_tvTitle);
            imageViews[i].setBackgroundResource(tabIcons[i]);
            textViews[i].setText(titles[i]);
            views[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            tlMain.getTabAt(i).setCustomView(views[i]);
        }
        textViews[AppConstant.HOME_INDEX].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        textViews[tab.getPosition()].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        textViews[tab.getPosition()].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
