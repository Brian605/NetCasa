package com.return0.netcasa;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    Dialog dialog;
    boolean contentView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ProgressBar progressBar = findViewById(R.id.progress);
        ImageView imgView = findViewById(R.id.refresh);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        webView = findViewById(R.id.webview);
        String url = "https://cart.netcasa.co.ke";


        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView.findViewById(R.id.nav_home).setBackgroundColor(getResources().getColor(R.color.colorblue));
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorwhite));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.specials:
                        loadPage(progressBar, webView, getString(R.string.specialurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.home:
                        drawer.closeDrawers();
                        break;
                    case R.id.account:
                    case R.id.Login:
                        loadPage(progressBar, webView, getString(R.string.loginurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.checkorder:
                        loadPage(progressBar, webView, getString(R.string.checkorderurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Cart:
                    case R.id.Checkout:
                        loadPage(progressBar, webView, getString(R.string.checkouturl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Food:
                        loadPage(progressBar, webView, getString(R.string.foodurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Grills:
                        loadPage(progressBar, webView, getString(R.string.grillsurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.maindishes:
                        loadPage(progressBar, webView, getString(R.string.maindishesurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.fastFoods:
                        loadPage(progressBar, webView, getString(R.string.fastfoodsurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Pizzas:
                        loadPage(progressBar, webView, getString(R.string.pizzasurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Chicken:
                        loadPage(progressBar, webView, getString(R.string.chickenurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Fish:
                        loadPage(progressBar, webView, getString(R.string.fishurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Snacks:
                        loadPage(progressBar, webView, getString(R.string.snacksurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.BreakFast:
                        loadPage(progressBar, webView, getString(R.string.breakfasturl));
                        drawer.closeDrawers();
                        break;
                    case R.id.drinks:
                        loadPage(progressBar, webView, getString(R.string.drinksurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Milkshakes:
                        loadPage(progressBar, webView, getString(R.string.milkshakesurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.DrinkingWater:
                        loadPage(progressBar, webView, getString(R.string.drinkwaterurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.FruitJuices:
                        loadPage(progressBar, webView, getString(R.string.fruitsurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.soda:
                        loadPage(progressBar, webView, getString(R.string.sodaurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.winesandSpirits:
                        loadPage(progressBar, webView, getString(R.string.winesurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.Filmsandlibs:
                        loadPage(progressBar, webView, getString(R.string.filmsurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.series:
                        loadPage(progressBar, webView, getString(R.string.seriesurl));
                        drawer.closeDrawers();
                        break;
                    case R.id.movies:
                        loadPage(progressBar, webView, getString(R.string.moviesurl));
                        drawer.closeDrawers();
                        break;

                    default:
                        recreate();
                        drawer.closeDrawers();
                        break;


                }

                return true;
            }
        });

        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorwhite), PorterDuff.Mode.SRC_ATOP);
        }

        if (!isNetworkAvailable()){
            showError();
            return;
        }

        // setCollapsingToolbar();
        loadWebView(webView, url, progressBar, imgView);
    }

    private void loadPage(ProgressBar progressBar, WebView webView, String s) {
        progressBar.setVisibility(View.VISIBLE);
        webView.loadUrl(s);

    }

    //<editor-fold desc="Send Email feedback">
    private void openGmail() {
        String address = "returnzero41@gmail.com";
        //String gpackage="com.google.android.gm";
        // String activity="com.google.android.gm.ComposeActivityGmail";
        String subject = "NetCasa Support";
        String message = "Hi, edit this message to include your queries";

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mailto:" + address));
        // intent.setClassName(gpackage,activity);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        getApplicationContext().startActivity(intent);
    }
//</editor-fold>

    //<editor-fold desc="Send Sms">
    private void sendSms() {
        Dexter.withActivity(MainActivity.this)
                .withPermission(Manifest.permission.SEND_SMS)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                 Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("sms:+254750280961")) ;
                 intent.putExtra("sms_body","NetCasa Edit this Message to include your queries");
                 startActivity(intent);


                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Please Grant Permission");
                            builder.setMessage(getString(R.string.smsprompt));
                            builder.setPositiveButton("Take Me To Settings", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri=Uri.fromParts("package",getPackageName(),null);
                                    intent.setData(uri);
                                    startActivityForResult(intent,101);
                                }
                            });
                            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finishAffinity();
                                    System.exit(0);
                                }
                            });
                            builder.show(); }


                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                }).check();

    }
//</editor-fold>

    //<editor-fold desc="Make Phone Call">
    private void callPhone() {

        Dexter.withActivity(MainActivity.this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Intent intent=new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:0750280961"));
                       getApplicationContext().startActivity(intent);

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Please Grant Permission");
                            builder.setMessage(getString(R.string.prompt));
                            builder.setPositiveButton("Take Me To Settings", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri=Uri.fromParts("package",getPackageName(),null);
                                    intent.setData(uri);
                                    startActivityForResult(intent,101);
                                }
                            });
                            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finishAffinity();
                                    System.exit(0);
                                }
                            });
                            builder.show(); }

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
token.continuePermissionRequest();
                    }
                }).check();
    }
//</editor-fold>

    //<editor-fold desc="Open whatsapp">
    private void gotoWhatsapp() {
try {
    //webView.loadUrl("https://wa.me/+254750280961");
    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://wa.me/+254750280961"));
    getApplicationContext().startActivity(intent);

}catch (Exception e){

  showError();
}
    }
//</editor-fold>

//<editor-fold desc="Load WebView">
    @SuppressLint("SetJavaScriptEnabled")
    private void loadWebView(final WebView webView, String url, final ProgressBar progress, ImageView imgView) {
        WebSettings settings=webView.getSettings();
        //settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
       // settings.setLoadsImagesAutomatically(true);
        settings.setSupportZoom(true);
        webView.setHorizontalScrollBarEnabled(false);
        if (18< Build.VERSION.SDK_INT){
            settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        }
        try {
            webView.loadUrl(url);
        }catch (Exception e){
            showError();

            return;
        }

        webView.setWebChromeClient(new ChromeClient(this));
        webView.setWebViewClient(new Client(progress));
        imgView.setClickable(true);
        imgView.setFocusable(true);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
progress.setVisibility(View.VISIBLE);
                webView.loadUrl("javascript:window.location.reload(true)");
            }
        });

    }
//</editor-fold>

    public void showError(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
        View view=inflater.inflate(R.layout.networkerror,null,false);
        builder.setView(view);

        builder.setCancelable(true);
        dialog=builder.create();
        dialog.show();
    }

    public class ChromeClient extends WebChromeClient{
        Context context;
        ChromeClient(Context context){
            super();
            this.context=context;
        }
    }

    public class Client extends WebViewClient{
        ProgressBar progressBar;
        Client(ProgressBar progressBar){
            this.progressBar=progressBar;
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String request) {
            view.loadUrl(request);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            //
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.nav_about){
            setContentView(R.layout.about);
            contentView=false;
        }
        else
            if (item.getItemId()==R.id.nav_phone){
                callPhone();
            }
        else
            if (item.getItemId()==R.id.nav_message){
                sendSms();
            }
        else
            if (item.getItemId()==R.id.nav_whatsapp){
                gotoWhatsapp();
            }
        else
            if (item.getItemId()==R.id.feedback){
                openGmail();
            }

        return true;
    }

    @Override
    public void onBackPressed() {
        if(!contentView){
         setContentView(R.layout.activity_main);
         contentView=true;
         recreate();
        }else {
            super.onBackPressed();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager!=null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
