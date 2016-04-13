package nesca.giuseppe.volleytutorial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int egg=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // inizializza();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Effettua uno swipe da sinistra verso destra per mostrare il menù", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {

        invalidateOptionsMenu();
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vf);
        switch (viewFlipper.getDisplayedChild())
        {
            case 1: getMenuInflater().inflate(R.menu.main,menu);break;          //spike
            case 2: getMenuInflater().inflate(R.menu.main2,menu); break;        //palleggio
            case 3: getMenuInflater().inflate(R.menu.main3,menu); break;
            case 4: getMenuInflater().inflate(R.menu.main4,menu); break;
            case 5: getMenuInflater().inflate(R.menu.main5,menu); break;
            default: getMenuInflater().inflate(R.menu.main0,menu); break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_scrollSalto) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.spikeContent);
            TextView textView = (TextView) findViewById(R.id.saltoTitle);
            myscroll(scrollView, textView);
            return true;
        }
        if (id == R.id.action_scrollMani){
            ScrollView scrollView = (ScrollView) findViewById(R.id.spikeContent);
            TextView textView = (TextView) findViewById(R.id.movManT);
            myscroll(scrollView, textView);
            return true;
        }
        if(id==R.id.action_scrollAInf){
            ScrollView scrollView = (ScrollView) findViewById(R.id.palleggioContent);
            TextView textView = (TextView) findViewById(R.id.inferioriTitPall);
            myscroll(scrollView, textView);
            return true;
        }
        if(id==R.id.action_scrollASup){
            ScrollView scrollView = (ScrollView) findViewById(R.id.palleggioContent);
            TextView textView = (TextView) findViewById(R.id.superioriTitPall);
            myscroll(scrollView, textView);
            return true;
        }
        if(id==R.id.action_scrollTronco){
            ScrollView scrollView = (ScrollView) findViewById(R.id.palleggioContent);
            TextView textView = (TextView) findViewById(R.id.troncoTitoloPall);
            myscroll(scrollView, textView);
            return true;
        }
        if(id==R.id.action_scrollTecnica){
            ScrollView scrollView = (ScrollView) findViewById(R.id.blockContent);
            TextView textView = (TextView) findViewById(R.id.blockTecnicaTitle);
            myscroll(scrollView,textView);
        }
        if(id==R.id.action_scrollStrategie){
            ScrollView scrollView = (ScrollView) findViewById(R.id.blockContent);
            TextView textView = (TextView) findViewById(R.id.blockStrategieTitle);
            myscroll(scrollView,textView);
        }
        if(id==R.id.action_scrollRicezione){
            ScrollView scrollView = (ScrollView) findViewById(R.id.bagherContent);
            TextView textView = (TextView) findViewById(R.id.bagherRicezioneTitle);
            myscroll(scrollView,textView);
        }
        if(id==R.id.action_scrollDifesa){
            ScrollView scrollView = (ScrollView) findViewById(R.id.bagherContent);
            TextView textView = (TextView) findViewById(R.id.bagherDifesaTitle);
            myscroll(scrollView,textView);
        }
        if(id==R.id.action_scrollFloat){
            ScrollView scrollView=(ScrollView) findViewById(R.id.servContent);
            TextView textView = (TextView) findViewById(R.id.servFloatTitle);
            myscroll(scrollView,textView);
        }
        if(id==R.id.action_scrollSpin){
            ScrollView scrollView=(ScrollView) findViewById(R.id.servContent);
            TextView textView = (TextView) findViewById(R.id.servSpinTitle);
            myscroll(scrollView,textView);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimaryDark));
        if (id == R.id.nav_spike) {
            changeContent(1);
        } else if (id == R.id.nav_palleggio) {
            changeContent(2);
        } else if (id == R.id.nav_block) {
            changeContent(3);
        } else if (id == R.id.nav_bagher) {
            changeContent(4);
        } else if (id == R.id.nav_servizio) {
            changeContent(5);
        }
        else changeContent(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void returntomainview(View view)
    {
        changeContent(0);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(getResources().getColorStateList(R.color.colorAccent));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void info(View view)
    {
        TextView textView = (TextView) findViewById(R.id.welcomText2);
        if (egg==0) {
            //setTitle();

            textView.setText(R.string.info);
            egg++;
        }
        else{
            textView.setText("");
            textView = (TextView) findViewById(R.id.welcomeText);
            textView.setText("May the ball be with you");
        }

    }
    public void spike() //1
    {
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vf);
        viewFlipper.setDisplayedChild(1);
    }

    public void changeContent(int n)
    {
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vf);
        viewFlipper.setDisplayedChild(n);
    }

    public void myscroll(ScrollView scrollView, TextView textView) //FUNZIONANTE  usa come riferimento per le altre
    {

        int y = textView.getTop()-textView.getHeight();
        int x = textView.getScrollX();
        scrollView.scrollTo(x,y); //yessss QUESTA FUNZIONA
    }
}
