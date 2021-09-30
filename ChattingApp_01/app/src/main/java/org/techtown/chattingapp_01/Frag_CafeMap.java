package org.techtown.chattingapp_01;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Frag_CafeMap extends Fragment {

    private Toolbar toolbar;
    private Frag_oneThousand frag_OneThousand;
    private Frag_twoThousand frag_TwoThousand;
    private Frag_threeThousand frag_ThreeThousand;
    private Frag_fourThousand frag_FourThousand;
    private Frag_fiveThousand frag_FiveThousand;
    private ScrollView scrollView;
    private WebView webView;
    private FragmentTransaction mFragmentTransaction;

    @Override
    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cafeMap, container, false);

        scrollView = view.findViewById(R.id.scrollView);

        childFragmentManager().beginTransaction().replace(R.id.lobby_container, frag_OneThousand).commit();

//        toolbar = view.findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);

        frag_OneThousand = new Frag_oneThousand();
        frag_TwoThousand = new Frag_twoThousand();
        frag_ThreeThousand = new Frag_threeThousand();
        frag_FourThousand = new Frag_fourThousand();
        frag_FiveThousand = new Frag_fiveThousand();

        webView = view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://172.23.12.39:5000/qgis2web0");

        //getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_OneThousand).commit();

        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("1000"));
        tabs.addTab(tabs.newTab().setText("2000"));
        tabs.addTab(tabs.newTab().setText("3000"));
        tabs.addTab(tabs.newTab().setText("4000"));
        tabs.addTab(tabs.newTab().setText("5000~"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = frag_OneThousand;
                    webView.loadUrl("http://172.23.12.39:5000/qgis2web1");
                } else if (position == 1) {
                    selected = frag_TwoThousand;
                    webView.loadUrl("http://172.23.12.39:5000/qgis2web2");
                } else if (position == 2) {
                    selected = frag_ThreeThousand;
                    webView.loadUrl("http://172.23.12.39:5000/qgis2web3");
                } else if (position == 3) {
                    selected = frag_FourThousand;
                    webView.loadUrl("http://172.23.12.39:5000/qgis2web4");
                } else if (position == 4) {
                    selected = frag_FiveThousand;
                    webView.loadUrl("http://172.23.12.39:5000/qgis2web5");
                }
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }

    public void onButton1Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1257230655?c=14384738.3189805,4284198.2916612,15,0,0,0,dh&placePath=%3Fentry=plt"));
        startActivity(myIntent); }
    public void onButton2Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vanbeek_official/"));
        startActivity(myIntent); }
    public void onButton3Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/twelvestoryceo/"));
        startActivity(myIntent); }
    public void onButton4Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%98%EC%82%BC%EB%8F%99%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%ED%98%91%EC%84%B1%ED%9C%B4%ED%8F%AC%EB%A0%88%EC%A0%90/place/1753624589?c=14384479.3119213,4284545.7719268,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton5Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%91%EA%B1%B0%EC%BB%A4%ED%94%BC%20%EC%9A%A9%ED%99%A9%EC%A0%90/place/1218017521?c=14385256.5112102,4284886.2833997,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton6Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.angelinus.com/index.asp"));
        startActivity(myIntent); }
    public void onButton7Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("ttps://www.instagram.com/refou_cafe_/"));
        startActivity(myIntent); }
    public void onButton8Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafehill_gyeongju/"));
        startActivity(myIntent); }
    public void onButton9Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%98%A4%EB%A6%AC%EC%A7%84%EC%95%8C/place/1083897685?c=14384842.8479824,4284422.8864906,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton10Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%82%AC%EB%B8%8C%EB%A6%AC%EB%82%98/place/11859365?c=14384204.7980570,4281523.3082565,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton11Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%A9%94%EA%B0%80%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EC%9A%A9%ED%99%A9%EC%A0%90/place/1980322280?c=14384561.4545736,4284561.2151411,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton12Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vintagegarden.kyungju/"));
        startActivity(myIntent); }
    public void onButton13Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://theventi.co.kr/new2020/main/main.html"));
        startActivity(myIntent); }
    public void onButton14Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe.adansonii/?igshid=txpsgbjl2mw0"));
        startActivity(myIntent); }
    public void onButton15Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B0%B0%EC%8A%A4%ED%82%A8%EB%9D%BC%EB%B9%88%EC%8A%A4%20%EA%B2%BD%EC%A3%BC%EC%9A%A9%ED%99%A9%EC%A0%90/place/1073291946?c=14384546.4487062,4284557.7665211,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton16Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%8F%99%EA%B0%90%20coffee/place/1179023390?c=14384496.0432408,4284537.7755380,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton17Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%8B%A4%EB%B9%84%EB%93%9C%20%EC%BB%A4%ED%94%BC/place/996473250?c=14384310.7630803,4282440.1767010,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton18Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%BD%EB%8B%A4%EB%B0%A9%20%EA%B2%BD%EC%A3%BC%EC%9A%A9%ED%99%A9%EC%A0%90/place/1742296790?c=14384475.2598918,4284544.5903295,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton19Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/viennacoffeehouse_yonghwangro/"));
        startActivity(myIntent); }
    public void onButton20Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/y_____sd/"));
        startActivity(myIntent); }
    public void onButton21Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thumbcoffee.co.kr/"));
        startActivity(myIntent); }
    public void onButton22Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe_yeoyou/"));
        startActivity(myIntent); }
    public void onButton23Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ediya.coffee/"));
        startActivity(myIntent); }
    public void onButton24Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1442366692?c=14370331.9293434,4280858.4799505,10,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton25Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EC%9A%A9%EA%B0%95%EB%8F%99%EC%A0%90/place/1092811750?c=14356082.6894315,4283873.6423743,10,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton26Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://akongcafe.modoo.at/"));
        startActivity(myIntent); }
    public void onButton27Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_illago"));
        startActivity(myIntent); }
    public void onButton28Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%A4%ED%94%BC%ED%94%8C%EB%A0%88%EC%9D%B4%EC%8A%A4%20%EB%8F%99%EC%B2%9C%EC%A0%90/place/36317490?c=14384225.6593296,4281382.8754674,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton29Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/9%EB%B2%88%EA%B0%80%EC%B9%B4%ED%8E%98/place/1226999672?c=14384734.2780830,4281775.2924059,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton30Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EA%B8%B8/place/34079445?c=14384230.1900329,4281460.6736902,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton31Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%B3%84%EB%A7%88%EB%A3%A8/place/1315219023?c=14384133.0637771,4281670.1987165,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton32Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%ED%99%88%ED%94%8C%EB%9F%AC%EC%8A%A4%EC%A0%90/place/1146757763?c=14384313.1787133,4283221.0620342,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton33Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%B4%84%EB%B4%84%20%EC%9A%A9%EA%B0%95%EC%A0%90/place/1392158633?c=14384650.5769579,4284667.9305489,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton34Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%A4%ED%94%BC%EC%BD%A9%EB%B6%80%EC%9D%B8/place/1850519392?c=14385937.0851810,4282895.7550244,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton35Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9A%94%EA%B1%B0%ED%94%84%EB%A0%88%EC%86%8C%20%EA%B2%BD%EC%A3%BC%EC%9A%A9%EA%B0%95%EC%A0%90/place/1955316435?c=14384894.4890942,4283638.5352913,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton36Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B2%A4%EC%9E%90%EB%A7%88%EC%8A%A4%EC%B9%B4%ED%8E%98/place/36826786?c=14385752.5953890,4279166.3953220,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton37Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_la.fleur"));
        startActivity(myIntent); }
    public void onButton38Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe._.dongcheon"));
        startActivity(myIntent); }
    public void onButton39Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%91%EA%B1%B0%EC%BB%A4%ED%94%BC%20%EB%8F%99%EC%B2%9C%EC%A0%90/place/1074204837?c=14384887.7653969,4281139.8145451,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton40Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/edgebrown_gyeongju"));
        startActivity(myIntent); }
    public void onButton41Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/1992_youth_fruit"));
        startActivity(myIntent); }
    public void onButton42Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe_don9urami/"));
        startActivity(myIntent); }
    public void onButton43Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_heewol"));
        startActivity(myIntent); }
    public void onButton44Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/__soraroom__"));
        startActivity(myIntent); }
    public void onButton45Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EB%8F%99%EC%B2%9C%EB%8F%99%EC%A0%90/place/36254063?c=14384372.2893629,4281161.9145143,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton46Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%93%9C%EB%A6%BD/place/38664396?c=14385444.7302052,4279273.2775865,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton47Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9A%94%EA%B1%B0%ED%94%84%EB%A0%88%EC%86%8C%20%EA%B2%BD%EC%A3%BC%EB%8F%99%EC%B2%9C%EC%A0%90/place/31317380?c=14384400.7871525,4281318.3324838,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton48Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EC%95%8C%EC%B2%9C%EC%A0%90/place/1893756394?c=14384946.4196366,4279940.3301118,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton49Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe_daonlaon"));
        startActivity(myIntent); }
    public void onButton50Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%8C%8C%EB%A6%AC%EB%B0%94%EA%B2%8C%EB%9C%A8%20%EA%B2%BD%EC%A3%BC%EC%8B%9C%EC%B2%AD%EC%A0%90/place/33284390?c=14384223.1212452,4280899.9592806,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton51Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%9A%9C%EB%A0%88%EC%A5%AC%EB%A5%B4%20%EA%B2%BD%EC%A3%BC%EB%8F%99%EC%B2%9C%EC%A0%90%20/place/11803750?c=14384217.7890416,4280927.5802069,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton52Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/503%EC%B9%B4%ED%8E%98/place/1726032776?c=14384392.6163019,4281140.0617788,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton53Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://coffeesong.modoo.at/"));
        startActivity(myIntent); }
    public void onButton54Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_gowoon"));
        startActivity(myIntent); }
    public void onButton55Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/cafe_maisondeu"));
        startActivity(myIntent); }
    public void onButton56Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%A4%ED%94%BC%EC%B4%9D%EA%B0%81/place/36992384?c=14384785.7076878,4279591.8569517,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton57Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/soohyangjk"));
        startActivity(myIntent); }
    public void onButton58Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%81%8C%EB%A6%BC%EC%B9%B4%ED%8E%98%20&%20%EC%9D%B4%EC%88%98%EB%AA%85%EB%A6%AC%EC%9B%90/place/1379995748?c=14384560.1410036,4281034.9604856,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton59Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/starpalace_cafe"));
        startActivity(myIntent); }
    public void onButton60Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%89%B4%EB%B9%88%20%EB%8F%99%EC%B2%9C%EC%A0%90/place/1989464589?c=14384500.8522428,4280428.3266376,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton61Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%94%A8%EC%97%90%EB%A1%9C/place/1763350611?c=14385460.5821007,4279183.9045509,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton62Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EB%8F%99%EC%B2%9C%ED%98%84%EB%8C%80%EC%A0%90/place/1410444654?c=14384496.3326715,4280302.7957787,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton63Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%8B%A4%EC%98%A8/place/1192294943?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=14396390.6198876,4256682.4595147,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton64Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9A%94%EA%B1%B0%ED%94%84%EB%A0%88%EC%86%8C%20%EA%B2%BD%EC%A3%BC%EB%8F%99%EC%B2%9C%ED%83%80%EC%9A%B4%EC%A0%90/place/31841388?c=14385053.0080491,4279791.3342918,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton65Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/laforet_1004"));
        startActivity(myIntent); }
    public void onButton66Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/chj981"));
        startActivity(myIntent); }
    public void onButton67Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EC%9D%B8%EB%8D%94%EB%AC%B8/place/1732952942?c=14384212.3009907,4280795.2448785,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton68Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/PAGE/place/37021241?c=14383748.5217282,4280729.2907051,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton69Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%AF%BC%EC%B2%A0%EC%BB%A4%ED%94%BC%EA%B3%B5%EB%B0%A9/place/1267365451?c=14385649.6916517,4279505.9832535,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton70Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%EB%B0%80%EB%A3%A8/place/1114790773?c=14384971.8561403,4279504.2940767,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton71Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1195107049?c=14385246.3700046,4279763.4415779,15,0,0,0,dh&placePath=%3Fentry=plt"));
        startActivity(myIntent); }
    public void onButton72Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/903%EC%BB%A4%ED%94%BC/place/1699456621?c=14385042.2657182,4279745.7940829,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton73Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%81%B4%EB%9E%98%EC%8B%9D%EB%B8%8C%EB%9D%BC%EC%9A%B4/place/15259758?c=14385412.5588724,4279189.7821650,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton74Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B0%94%EC%9D%B4%EB%A6%BC%EC%9D%98%EC%B0%A9%ED%95%9C%EC%BB%A4%ED%94%BC/place/20339635?c=14384381.1949221,4280930.7804480,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton75Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9C%84%EC%8A%A4/place/35038875?c=14384333.9286663,4280742.2425240,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton76Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/ONUI/place/1402165267?c=14384409.1138504,4280925.9732192,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton77Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%84%EB%B2%A8/place/1186285340?c=14384624.5393290,4280207.7284041,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton78Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/onuicoffee"));
        startActivity(myIntent); }
    public void onButton79Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ikhofi_/?utm_medium=copy_link"));
        startActivity(myIntent); }
    public void onButton80Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/alsace_bakery/"));
        startActivity(myIntent); }
    public void onButton81Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/salondegyeongju"));
        startActivity(myIntent); }
    public void onButton82Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/coffeeup_gyeongju"));
        startActivity(myIntent); }
    public void onButton83Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/sweethobby"));
        startActivity(myIntent); }
    public void onButton84Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/normalayer/"));
        startActivity(myIntent); }
    public void onButton85Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/enjoylife07"));
        startActivity(myIntent); }
    public void onButton86Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%B4%ED%8F%AC%EC%A6%88%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%ED%99%A9%EC%98%A4%EC%A0%90/place/1178189522?c=14383530.5915610,4279182.7510008,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton87Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.can-more.com/"));
        startActivity(myIntent); }
    public void onButton88Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%8D%94%EB%B2%A4%ED%8B%B0%20%EA%B2%BD%EC%A3%BC%EC%A4%91%EC%95%99%EC%A0%90/place/37130508?c=14383087.7069669,4278888.9842291,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton89Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%EB%94%98/place/38273877?c=14384163.3204147,4278853.6921012,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton90Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/droptop_official"));
        startActivity(myIntent); }
    public void onButton91Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/b_iscuit"));
        startActivity(myIntent); }
    public void onButton92Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%ED%94%84%EB%9D%BC%ED%95%98/place/35135685?c=14383445.7772410,4279102.2087897,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton93Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%8F%8C%EB%8B%B4%EC%95%A0/place/35343681?c=14383216.9154999,4279143.8599559,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton94Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%A5%B4%EB%95%85%EA%B3%A0%EB%92%A4%EC%83%A4/place/1904912312?c=14383062.2259355,4278845.8921444,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton95Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%97%90%EC%9D%B4%EC%97%90%EC%9D%B4%EC%97%90%EC%9D%B4/place/21037932?c=14383238.0995990,4278992.9662138,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton96Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%99%A9%EC%98%A4%EC%BB%A4%ED%94%BC/place/1309449763?c=14383822.4490020,4278798.8865371,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton97Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%82%98%EC%9A%B0%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EC%A4%91%EC%95%99%EC%A0%90/place/1824654129?c=14383822.4490020,4278798.8865371,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton98Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B9%BD%EB%8B%A4%EB%B0%A9%20%EA%B2%BD%EC%A3%BC%EB%A1%9C%EB%8D%B0%EC%98%A4%EC%A0%90/place/1570261370?c=14383063.4615818,4279193.7097313,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton99Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_1894/"));
        startActivity(myIntent); }
    public void onButton100Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/noka_gyeongju"));
        startActivity(myIntent); }
    public void onButton101Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%99%A9%EB%82%A8%EC%9B%90/place/1007171830?c=14383317.9935975,4278025.0603057,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton102Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%8A%A4%ED%83%80%EB%B2%85%EC%8A%A4%20%EA%B2%BD%EC%A3%BC%EB%8C%80%EB%A6%89%EC%9B%90%EC%A0%90/place/35201864?c=14383213.0861094,4277803.0003299,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton103Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/richoya18"));
        startActivity(myIntent); }
    public void onButton104Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/eero_coffee"));
        startActivity(myIntent); }
    public void onButton105Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/fetecoffee"));
        startActivity(myIntent); }
    public void onButton106Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/kodocoffeebar"));
        startActivity(myIntent); }
    public void onButton107Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/no_words______/"));
        startActivity(myIntent); }
    public void onButton108Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%B5%EB%84%9B/place/1554653198?c=14383077.7438725,4277581.3018788,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton109Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/skunkworks_official"));
        startActivity(myIntent); }
    public void onButton110Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%9E%91%EC%BD%A9%EB%9C%A8%EB%A0%88/place/1894573919?c=14382596.7657486,4278060.1437792,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton111Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/beak_yi_dang/"));
        startActivity(myIntent); }
    public void onButton112Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/beak_yi_dang/"));
        startActivity(myIntent); }
    public void onButton113Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafeohi_gyeongju"));
        startActivity(myIntent); }
    public void onButton114Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/lasocoffeestudio"));
        startActivity(myIntent); }
    public void onButton115Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/sulwoldessert"));
        startActivity(myIntent); }
    public void onButton116Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/620collins"));
        startActivity(myIntent); }
    public void onButton117Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_sodis_3rd"));
        startActivity(myIntent); }
    public void onButton118Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/bimil._.place"));
        startActivity(myIntent); }
    public void onButton119Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe.mongry"));
        startActivity(myIntent); }
    public void onButton120Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%A6%AC%ED%8B%80%ED%8F%AC%EB%A0%88%EC%8A%A4%ED%8A%B8/place/1257338886?c=14382592.2350453,4278163.4175483,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton121Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/kissthetiramisu"));
        startActivity(myIntent); }
    public void onButton122Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%9C%EC%84%B1%EB%AF%B8%EC%9D%B8/place/1569567512?c=14383572.8484397,4277924.2594551,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton123Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/hn.darak"));
        startActivity(myIntent); }
    public void onButton124Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_swipy"));
        startActivity(myIntent); }
    public void onButton125Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/le_turtle_"));
        startActivity(myIntent); }
    public void onButton126Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%B3%B4%EB%A6%84%EC%95%A4%ED%8E%8D/place/1428057143?c=14383153.0515080,4278234.6977545,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton127Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/hodu_cafe"));
        startActivity(myIntent); }
    public void onButton128Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafeflorian_gj"));
        startActivity(myIntent); }
    public void onButton129Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%84%EC%B9%B4%EC%9D%B4%EB%B8%8C/place/1134052435?c=14382658.2808992,4278099.8136433,15,0,0,0,dh&placePath=%3Fentry%253Dbmp"));
        startActivity(myIntent); }
    public void onButton130Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/o_r_o_t__"));
        startActivity(myIntent); }
    public void onButton131Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/counts.coffee"));
        startActivity(myIntent); }
    public void onButton132Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/official_cafestairs"));
        startActivity(myIntent); }
    public void onButton133Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/eldorado.tea.cafe"));
        startActivity(myIntent); }
    public void onButton134Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%85%90%EC%BB%A4%ED%94%BC%ED%95%98%EC%9A%B0%EC%8A%A4/place/1949871459?c=14383089.3210995,4278536.0543638,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton135Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%981909/place/922165392?c=14382613.1074499,4277964.9174710,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton136Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%86%8C%EB%82%98%EA%B8%B0/place/1663412836?c=14383008.5476770,4277843.4519274,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton137Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/gyeongju_arte"));
        startActivity(myIntent); }
    public void onButton138Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B5%90%EB%8F%99%EC%BB%A4%ED%94%BC/place/1686726629?c=14376208.9639362,4277700.8284468,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton139Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafedow.creatorlink.net/About"));
        startActivity(myIntent); }
    public void onButton140Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B2%A8%EB%A0%98351%20%ED%99%A9%EB%82%A8%EC%A0%90/place/1052481422?c=14379811.4185056,4278093.9915428,12,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton141Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/hwangnam.place"));
        startActivity(myIntent); }
    public void onButton142Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/gratus_cafe"));
        startActivity(myIntent); }
    public void onButton143Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/coffee_sharp"));
        startActivity(myIntent); }
    public void onButton144Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%9D%A5%EB%A5%9C%EB%9C%B0/place/1385546005?c=14379811.4185056,4278093.9915428,12,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton145Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%89%BC%ED%91%9C/place/36624493?c=14383175.3821979,4277962.4046612,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton146Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B7%B8%EB%A6%BC%EC%BB%A4%ED%94%BC/place/1513728016?c=14383190.2433499,4277993.5470667,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton147Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BD%94%EC%BD%94%EB%AA%AC/place/1949821891?c=14382652.4700218,4277020.5811886,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton148Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%99%A9%EB%82%A8%ED%94%8C%EB%A0%88%EC%9D%B4%EC%8A%A4/place/1541270606?c=14382607.6416629,4278173.7573374,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton149Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%8E%98%EC%9D%B4%EC%A7%80%EB%82%98%EC%9D%B8/place/1448327735?c=14389251.3001929,4280249.5623416,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton150Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/starbuckskorea"));
        startActivity(myIntent); }
    public void onButton151Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B5%AC%EB%A6%89/place/1603665702?c=14388772.6152505,4280369.9147789,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton152Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%94%8C%EB%9D%BC%EB%B9%84%EC%9A%B0%EC%8A%A4/place/1951484646?c=14389128.3812112,4280365.5610273,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton153Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_constance"));
        startActivity(myIntent); }
    public void onButton154Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/thesamgarden/"));
        startActivity(myIntent); }
    public void onButton155Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafevinca_"));
        startActivity(myIntent); }
    public void onButton156Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%EB%B4%84%EC%97%AC%EB%A6%84%EA%B0%80%EC%9D%84%EA%B2%A8%EC%9A%B8/place/36793044?c=14389234.2460469,4280414.9768976,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton157Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EC%95%84%EC%9A%B0%ED%86%A0/place/1542010612?c=14389176.2708561,4280290.4625186,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton158Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EC%82%AC%EB%9E%91%EC%B1%84/place/1068544520?c=14388591.3203278,4280302.2738810,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton159Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EB%B6%81%EA%B5%B0%EC%A0%90/place/1198667957?c=14388678.9621629,4280403.8109240,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton160Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%A4%ED%94%BC%EB%AA%85%EA%B0%80%20%ED%95%9C%ED%99%94%EB%A6%AC%EC%A1%B0%ED%8A%B8%EA%B2%BD%EC%A3%BC%EC%A0%90/place/1932186014?c=14389341.7472792,4281491.8535718,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton161Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9A%94%EA%B1%B0%ED%94%84%EB%A0%88%EC%86%8C%20%EA%B2%BD%EC%A3%BC%EB%B2%84%EB%93%9C%ED%8C%8C%ED%81%AC%EC%A0%90/place/36254176?c=14388472.4088478,4279914.0987890,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton162Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%B2%A0%EB%84%A4%20%ED%95%9C%ED%99%94%EB%A6%AC%EC%A1%B0%ED%8A%B8%20%EA%B2%BD%EC%A3%BC%EC%A0%90/place/1725683671?c=14389357.0537091,4281499.0510550,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton163Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%B2%A0%EB%84%A4%20%EA%B2%BD%EC%A3%BCCC%EC%A0%90/place/36948584?c=14388572.9526119,4281994.1641565,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton164Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%94%84%EB%9E%91%EC%A0%9C%EB%A6%AC%20%EA%B2%BD%EC%A3%BC%EC%BC%84%EC%8B%B1%ED%84%B4%EB%A6%AC%EC%A1%B0%ED%8A%B8%EC%A0%90/place/1846865711?c=14389633.9275466,4281358.0004821,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton165Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.herbcastle.co.kr/"));
        startActivity(myIntent); }
    public void onButton166Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/_daoncafe/"));
        startActivity(myIntent); }
    public void onButton167Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_kwaerung"));
        startActivity(myIntent); }
    public void onButton168Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%B8%94%EB%9E%99%EA%B3%B5%EB%8B%A8/place/1958493192?c=14392904.2381513,4259142.9052509,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton169Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EC%9E%85%EC%8B%A4%EC%A0%90/place/716448608?c=14395513.3889043,4260513.4298384,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton170Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EB%94%94%EC%95%BC%EC%BB%A4%ED%94%BC%20%EA%B2%BD%EC%A3%BC%EC%99%B8%EB%8F%99%EA%B3%B5%EB%8B%A8%EC%A0%90/place/35471582?c=14394973.1108877,4263117.3476098,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton171Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%A0%EB%B9%84%EB%89%B4/place/15771116?c=14393676.5171187,4268556.1161608,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton172Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%8C%8C%EC%8A%A4%EC%BF%A0%EC%B0%8C%20%EB%82%A8%EA%B2%BD%EC%A3%BCIC%EC%A0%90/place/1360104771?c=14394243.5340770,4267016.6520025,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton173Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%A1%9C%EB%93%9C/place/670317735?c=14395734.4805450,4261224.0312236,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton174Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9A%94%EA%B1%B0%ED%94%84%EB%A0%88%EC%86%8C%20%EA%B2%BD%EC%A3%BC%EC%99%B8%EB%8F%99%EB%AF%B8%EC%86%8C%EC%A7%80%EC%9B%80%EC%8B%9C%ED%8B%B0%EC%A0%90/place/1698803704?c=14395186.3099765,4261007.2896129,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton175Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.selecto.co.kr/"));
        startActivity(myIntent); }
    public void onButton176Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%A0%EB%A6%AC%EC%8A%A4%20%EC%99%B8%EB%8F%99%ED%9C%B4%EA%B2%8C%EC%86%8C%EC%83%81%ED%96%89%EC%A0%90/place/38230846?c=14391380.5192252,4255686.9172981,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton177Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%A4%ED%94%BC%EB%A7%98/place/1479152680?c=14394269.5383101,4269512.6992346,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton178Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%8D%94%EB%B9%88%EC%8A%A4%EC%BB%A4%ED%94%BC/place/1000785666?c=14395562.3472164,4261607.9084550,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton179Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%A7%88%EC%8B%A4/place/1774526553?c=14396894.2515279,4262058.7918798,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton180Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/S%20CAFE/place/1888688090?c=14393655.2550960,4268055.9472343,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton181Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B8%EC%83%9D%EC%BB%A4%ED%94%BC%EC%B9%B4%ED%8E%98,%EB%94%94%EC%A0%80%ED%8A%B8/place/1251704779?c=14394917.6960452,4256455.0227471,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton182Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%82%B0%EB%BD%80%EC%B9%B4%ED%8E%98/place/1730010361?c=14395844.5755214,4256820.2312672,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton183Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BB%A4%ED%94%BC%ED%95%98%EC%9A%B0%EC%8A%A4/place/1279436486?c=14392834.5632820,4260216.1486138,13,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton184Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/potential_roasters"));
        startActivity(myIntent); }
    public void onButton185Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%95%98%EC%9D%B4%EB%93%9C%EC%96%B4%EC%9B%A8%EC%9D%B4/place/1135198727?c=14396347.7284878,4255999.1767423,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton186Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/cafe_dayflower?igshid=fp"));
        startActivity(myIntent); }
    public void onButton187Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%83%90%EC%95%A4%ED%83%90%EC%8A%A4%20%EC%99%B8%EB%8F%99%ED%9C%B4%EA%B2%8C%EC%86%8C%20%EC%9A%B8%EC%82%B0%EB%B0%A9%ED%96%A5%EC%A0%90/place/1611486847?c=14391062.6130234,4255509.9006975,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton188Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe.kingsroad.kyung_ju"));
        startActivity(myIntent); }
    public void onButton189Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%96%B4%EC%9D%BC%EB%A6%AC%20%EC%B9%B4%ED%8E%98/place/1339534021?c=14408795.4516844,4270232.4075985,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton190Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ulsan_pol"));
        startActivity(myIntent); }
    public void onButton191Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EC%99%95%EB%A6%89/place/1889290633?c=14413046.5537947,4264875.7503988,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton192Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/redlotus1125/"));
        startActivity(myIntent); }
    public void onButton193Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_naif"));
        startActivity(myIntent); }
    public void onButton194Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B0%B0%EB%A6%AC%EB%B9%88%EC%9B%8D%EC%8A%A4/place/1165380249?c=14415578.2039182,4273378.1369945,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton195Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/startcoffee_"));
        startActivity(myIntent); }
    public void onButton196Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%ED%97%A4%EB%B8%90/place/1174572804?c=14413349.3094138,4266881.9202964,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton197Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/coffee_daruda"));
        startActivity(myIntent); }
    public void onButton198Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/Alchemist's%20Cafe%20%EC%83%A4%EA%B0%88/place/1218814574?c=14416615.3787459,4275598.3682466,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton199Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/mocha___coffee"));
        startActivity(myIntent); }
    public void onButton200Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafequan.modoo.at/"));
        startActivity(myIntent); }
    public void onButton201Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B9%8C%ED%8E%98%EC%BB%A4%ED%94%BC%EB%82%98%EB%AC%B4/place/1753068657?c=14415038.8609853,4274283.4899083,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton202Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%86%8C%ED%92%8D%EC%B9%B4%ED%8E%98/place/1037137518?c=14416813.0932935,4278095.6667695,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton203Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/coffee_tetrar"));
        startActivity(myIntent); }
    public void onButton204Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B3%B5%EA%B0%90/place/1451995454?c=14412452.8758183,4274137.4127812,13,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton205Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_here_there"));
        startActivity(myIntent); }
    public void onButton206Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%9D%B4%EC%8A%A4%ED%8A%B8%EC%95%B5%EA%B8%80%20%EB%B2%A0%EC%9D%B4%EC%BB%A4%EB%A6%AC%EC%B9%B4%ED%8E%98/place/1022625699?c=14410094.4722183,4255174.1689998,13,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton207Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/littleprince3"));
        startActivity(myIntent); }
    public void onButton208Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EB%85%95%20%EC%83%81%EA%B3%84%EB%A6%AC/place/1773764266?c=14406465.9132284,4255342.7529563,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton209Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%93%9C%ED%8C%8C%EB%A6%AC%20%EC%A3%BC%EC%83%81%EC%A0%88%EB%A6%AC%EC%A0%90/place/1673664279?c=14411905.1060000,4257501.2080034,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton210Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_colonnade"));
        startActivity(myIntent); }
    public void onButton211Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/dalcafe.gj"));
        startActivity(myIntent); }
    public void onButton212Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/hwasodam_"));
        startActivity(myIntent); }
    public void onButton213Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%AA%A8%EB%85%B8%EC%BB%A4%ED%94%BC/place/37086149?c=14411999.3156851,4257449.4014078,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton214Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%8C%8C%EB%A6%AC%EB%B0%94%EA%B2%8C%EB%9C%A8%20%EA%B2%BD%EC%A3%BC%EC%96%91%EB%82%A8%EC%A0%90/place/104852939?c=14411778.8140377,4259123.3583172,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton215Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/CAFEYOY/place/1035060987?c=14411398.5466571,4256097.7745788,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton216Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe%20yangnam"));
        startActivity(myIntent); }
    public void onButton217Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/nicecafe_pension"));
        startActivity(myIntent); }
    public void onButton218Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%EB%B2%A0%EB%84%A4%20%EA%B2%BD%EC%A3%BC%EC%A3%BC%EC%83%81%EC%A0%88%EB%A6%AC%EC%A0%90/place/36254113?c=14411999.3379490,4257505.2785320,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton219Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%EB%B9%84%EC%8A%A4%ED%83%80/place/1634762766?c=14411563.3551633,4256600.8223819,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton220Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%97%94%EC%A0%9C%EB%A6%AC%EB%84%88%EC%8A%A4%20%EA%B2%BD%EC%A3%BC%EC%A3%BC%EC%83%81%EC%A0%88%EB%A6%AC%EC%A0%90/place/1448592538?c=14411954.6097776,4257469.6443261,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton221Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%84%EB%82%A0%EB%A1%9C%EA%B7%B8%EC%B9%B4%ED%8E%98/place/1442732561?c=14404595.1335259,4254527.0159980,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton222Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%84%EB%B2%A0%ED%81%AC/place/1463101057?c=14410400.5785541,4260864.6392636,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton223Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe.m.3658"));
        startActivity(myIntent); }
    public void onButton224Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98%20%EC%96%B8%EC%A0%9C%EB%82%98/place/1126859091?c=14410314.3393446,4254936.9527665,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton225Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%8F%99%EB%84%A4%EC%B9%B4%ED%8E%98/place/35895760?c=14411562.3866837,4256602.1105911,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton226Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%A0%95%EC%95%84%ED%8A%B8%EC%BB%A4%ED%94%BC/place/15774342?c=14412568.7816722,4259190.6350072,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton227Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%85%8C%EB%9D%BC%EC%BB%A4%ED%94%BC/place/15773331?c=14410900.2694844,4255906.3215522,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton228Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%BD%9C%EB%A1%9C%EB%A0%88%EC%9D%B4%EB%93%9C%20%EC%B9%B4%ED%8E%98/place/1130736161?c=14412481.7743582,4257596.3381612,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton229Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B9%B4%ED%8E%98jj/place/1511338988?c=14412099.9930325,4258096.6177230,15,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton230Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/35milli_meter/"));
        startActivity(myIntent); }
    public void onButton231Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ariel94924/222428655031"));
        startActivity(myIntent); }
    public void onButton232Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/p_acep_ace"));
        startActivity(myIntent); }
    public void onButton233Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/jinhyundong.coffee"));
        startActivity(myIntent); }
    public void onButton234Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafedroptop.com/"));
        startActivity(myIntent); }
    public void onButton235Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1574292319?c=14398450.9321552,4270630.9411632,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton236Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1574292319?c=14398450.9321552,4270630.9411632,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton237Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1285770179?c=14392242.2990632,4277233.6318800,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton238Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jsiove8/221415542256"));
        startActivity(myIntent); }
    public void onButton239Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.caffebene.co.kr/menu/index.html"));
        startActivity(myIntent); }
    public void onButton240Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1792851435?c=14396658.8998604,4271041.1533941,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton241Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/peri2132/222077685474"));
        startActivity(myIntent); }
    public void onButton242Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton243Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/qhal409/222064772333"));
        startActivity(myIntent); }
    public void onButton244Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://byeolbandalban.modoo.at/"));
        startActivity(myIntent); }
    public void onButton245Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dagamdagam/222350369443"));
        startActivity(myIntent); }
    public void onButton246Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blueone.com/"));
        startActivity(myIntent); }
    public void onButton247Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/yuni_garden"));
        startActivity(myIntent); }
    public void onButton248Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/quineka/222010001975"));
        startActivity(myIntent); }
    public void onButton249Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe.oldcity"));
        startActivity(myIntent); }
    public void onButton250Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_so.won"));
        startActivity(myIntent); }
    public void onButton251Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/dimension_coffee"));
        startActivity(myIntent); }
    public void onButton252Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/cafe.half_round?igshid=ozfnuojp5k81"));
        startActivity(myIntent); }
    public void onButton253Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blueone.com/"));
        startActivity(myIntent); }
    public void onButton254Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe23c"));
        startActivity(myIntent); }
    public void onButton255Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/creative02/222386172239"));
        startActivity(myIntent); }
    public void onButton256Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_your_round"));
        startActivity(myIntent); }
    public void onButton257Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/_elin.coffee_"));
        startActivity(myIntent); }
    public void onButton258Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/roamerscoffee"));
        startActivity(myIntent); }
    public void onButton259Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/bom_dasi"));
        startActivity(myIntent); }
    public void onButton260Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/omignon_official"));
        startActivity(myIntent); }
    public void onButton261Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1787892068?c=14394916.5717183,4273633.8721170,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton262Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/cafe_bach"));
        startActivity(myIntent); }
    public void onButton263Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/xxooo60/222149840549"));
        startActivity(myIntent); }
    public void onButton264Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/beauty4121/221328254868"));
        startActivity(myIntent); }
    public void onButton265Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/mangowith/220668250046"));
        startActivity(myIntent); }
    public void onButton266Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/363_cafe"));
        startActivity(myIntent); }
    public void onButton267Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/rws9000/221865396977"));
        startActivity(myIntent); }
    public void onButton268Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hollys.co.kr/"));
        startActivity(myIntent); }
    public void onButton269Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/emily_00/222413505337"));
        startActivity(myIntent); }
    public void onButton270Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/sosmarrin/221621957583"));
        startActivity(myIntent); }
    public void onButton271Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_l_garden"));
        startActivity(myIntent); }
    public void onButton272Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_numaru"));
        startActivity(myIntent); }
    public void onButton273Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/blisscoffee_bakery"));
        startActivity(myIntent); }
    public void onButton274Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/basilla.gyeongju"));
        startActivity(myIntent); }
    public void onButton275Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/0watergirl0/221553727536"));
        startActivity(myIntent); }
    public void onButton276Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dudn1222/222354680212"));
        startActivity(myIntent); }
    public void onButton277Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/babyish77/222395705489"));
        startActivity(myIntent); }
    public void onButton278Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ruddhr0495/221719599765"));
        startActivity(myIntent); }
    public void onButton279Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/k933319/222372303516"));
        startActivity(myIntent); }
    public void onButton280Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1306816097?c=14379962.0894364,4289237.4641256,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton281Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1513795200?c=14380092.8453102,4289524.7474552,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton282Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/36254178?c=14380015.9792019,4289207.5815969,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton283Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1175720148?c=14380094.1477483,4289652.7902939,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton284Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1314165570?c=14382919.4809524,4292618.5414879,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton285Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1326568757?c=14382919.4809524,4292618.5414879,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton286Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/lyunwha33"));
        startActivity(myIntent); }
    public void onButton287Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_angil"));
        startActivity(myIntent); }
    public void onButton288Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.facebook.com/lody.lee.31"));
        startActivity(myIntent); }
    public void onButton289Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/moneywjd/222105622372"));
        startActivity(myIntent); }
    public void onButton290Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.opus11.co.kr"));
        startActivity(myIntent); }
    public void onButton291Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EA%B0%95%EB%8F%99%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1367199679?c=14378917.2112999,4292463.9546140,11,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton292Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafebombom.co.kr/"));
        startActivity(myIntent); }
    public void onButton293Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/grateful-4-all/221764687701"));
        startActivity(myIntent); }
    public void onButton294Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ook386/221972256406"));
        startActivity(myIntent); }
    public void onButton295Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/seonae001/221656602299"));
        startActivity(myIntent); }
    public void onButton296Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EA%B0%95%EB%8F%99%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1253208399?c=14376399.0085709,4301140.8736978,11,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton297Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/majaki"));
        startActivity(myIntent); }
    public void onButton298Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/indongflower_2010"));
        startActivity(myIntent); }
    public void onButton299Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/PostList.naver?blogId=nea114"));
        startActivity(myIntent); }
    public void onButton300Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EA%B0%95%EB%8F%99%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/962955181?c=14376841.2252481,4302140.5516074,11,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton301Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://0547622003.tshome.co.kr/"));
        startActivity(myIntent); }
    public void onButton302Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/thfdlv2777/222406904599"));
        startActivity(myIntent); }
    public void onButton303Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/wildflowerdiary_official"));
        startActivity(myIntent); }
    public void onButton304Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_freci"));
        startActivity(myIntent); }
    public void onButton305Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_freci"));
        startActivity(myIntent); }
    public void onButton306Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_freci"));
        startActivity(myIntent); }
    public void onButton307Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EA%B0%95%EC%9D%8D%20%EC%B9%B4%ED%8E%98/place/21581787?c=14378038.6444827,4301984.0263353,16,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton308Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/sulbing_angang"));
        startActivity(myIntent); }
    public void onButton309Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/nleefamily/221579131173"));
        startActivity(myIntent); }
    public void onButton310Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/lwj3836/222314658748"));
        startActivity(myIntent); }
    public void onButton311Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/quineka/222010001975"));
        startActivity(myIntent); }
    public void onButton312Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/mkkim8795/222136890171"));
        startActivity(myIntent); }
    public void onButton313Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/zhangxm5761/222218616735"));
        startActivity(myIntent); }
    public void onButton314Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EA%B0%95%EC%9D%8D%20%EC%B9%B4%ED%8E%98/place/31847591?c=14381958.8828025,4301060.6227319,18,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton315Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EA%B0%95%EC%9D%8D%EC%B9%B4%ED%8E%98/place/97844699?c=14382029.9714293,4301056.5221326,19,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton316Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/gkflafosem1/221072485796"));
        startActivity(myIntent); }
    public void onButton317Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yogerpresso.co.kr/menu/menu_list.html?catcode=101000&prdcode=2105030002"));
        startActivity(myIntent); }
    public void onButton318Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yogerpresso.co.kr/menu/menu_list.html?catcode=101000&prdcode=2105030002"));
        startActivity(myIntent); }
    public void onButton319Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe_n.o.n/?igshid=17jynnkg2w4hy"));
        startActivity(myIntent); }
    public void onButton320Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/donapple/221272612699"));
        startActivity(myIntent); }
    public void onButton321Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coffeeplace.kr"));
        startActivity(myIntent); }
    public void onButton322Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EA%B0%95%EC%9D%8D%EC%B9%B4%ED%8E%98/place/1054416278?c=14383366.5177636,4299490.2203178,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton323Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton324Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EA%B0%95%EC%9D%8D%EC%B9%B4%ED%8E%98/place/1110425464?c=14384752.8350421,4299412.6644285,19,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton325Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/setyna/220804854339"));
        startActivity(myIntent); }
    public void onButton326Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.19tea.co.kr/"));
        startActivity(myIntent); }
    public void onButton327Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton328Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafebombom.co.kr/bbs/board.php?bo_table=menu&sca=NEW"));
        startActivity(myIntent); }
    public void onButton329Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton330Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tlj.co.kr/"));
        startActivity(myIntent); }
    public void onButton331Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coffeebay.com/home/menu/menu_new"));
        startActivity(myIntent); }
    public void onButton332Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/k1009eun/222427920801"));
        startActivity(myIntent); }
    public void onButton333Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/psy3764/222185928224"));
        startActivity(myIntent); }
    public void onButton334Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%95%88%EA%B0%95%EC%9D%8D%EC%B9%B4%ED%8E%98/place/1845824473?c=14385549.6710892,4299663.4401027,19,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton335Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/d.r_ag"));
        startActivity(myIntent); }
    public void onButton336Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/hoy9932/222367911083"));
        startActivity(myIntent); }
    public void onButton337Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/vldksh8973/221504236083"));
        startActivity(myIntent); }
    public void onButton338Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_de_sofa"));
        startActivity(myIntent); }
    public void onButton339Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/official_undernine/"));
        startActivity(myIntent); }
    public void onButton340Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton341Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1613671497?c=14379635.1440919,4285671.3566290,19,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton342Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://theventi.co.kr/"));
        startActivity(myIntent); }
    public void onButton343Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton344Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.myungga.com/"));
        startActivity(myIntent); }
    public void onButton345Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/sosoje314/222434142097"));
        startActivity(myIntent); }
    public void onButton346Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://starblanc.modoo.at/"));
        startActivity(myIntent); }
    public void onButton347Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/u.space6147"));
        startActivity(myIntent); }
    public void onButton348Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_floor_master"));
        startActivity(myIntent); }
    public void onButton349Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1802332380?c=14382010.4014628,4282426.3574418,15,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton350Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton351Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/earlybird_kyeongju"));
        startActivity(myIntent); }
    public void onButton352Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/agong05/222117658462"));
        startActivity(myIntent); }
    public void onButton353Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/onmyway86/221682828015"));
        startActivity(myIntent); }
    public void onButton354Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cafebombom.co.kr/"));
        startActivity(myIntent); }
    public void onButton355Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/kye_stellar"));
        startActivity(myIntent); }
    public void onButton356Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flowercafemihwa.modoo.at/"));
        startActivity(myIntent); }
    public void onButton357Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tlj.co.kr/"));
        startActivity(myIntent); }
    public void onButton358Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton359Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1706111965?c=14382613.3968805,4282329.2659643,19,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton360Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/wiseegg88/222080550806"));
        startActivity(myIntent); }
    public void onButton361Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/19862639?c=14382706.0926205,4281982.0212881,19,0,0,0,dh"));
        startActivity(myIntent); }
    public void onButton362Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/hwa_u00/222303398160"));
        startActivity(myIntent); }
    public void onButton363Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/zaerac/222002286620"));
        startActivity(myIntent); }
    public void onButton364Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/sweet_table._"));
        startActivity(myIntent); }
    public void onButton365Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe._.dongcheon"));
        startActivity(myIntent); }
    public void onButton366Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ohmycustard.kr/"));
        startActivity(myIntent); }
    public void onButton367Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/usm96/221830682443"));
        startActivity(myIntent); }
    public void onButton368Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_floor_master"));
        startActivity(myIntent); }
    public void onButton369Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/lyw7340"));
        startActivity(myIntent); }
    public void onButton370Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/ma_reve__"));
        startActivity(myIntent); }
    public void onButton371Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/scene__coffee"));
        startActivity(myIntent); }
    public void onButton372Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/pittorecoffee?igshid=n22xv9l6nmmb"));
        startActivity(myIntent); }
    public void onButton373Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/harudoughnut"));
        startActivity(myIntent); }
    public void onButton374Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mosso_bakery_official"));
        startActivity(myIntent); }
    public void onButton375Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/seongdonggaga"));
        startActivity(myIntent); }
    public void onButton376Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/bonbonbon_cakecafe"));
        startActivity(myIntent); }
    public void onButton377Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dessert39.com/menu/menu.php?Txt_bcode=030510001&Txt_nbyn="));
        startActivity(myIntent); }
    public void onButton378Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/shep99/222307945651"));
        startActivity(myIntent); }
    public void onButton379Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/suninjangclub"));
        startActivity(myIntent); }
    public void onButton380Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/tenpercent.coffee.yong.hwang"));
        startActivity(myIntent); }
    public void onButton381Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/1013_yoo/222373959316"));
        startActivity(myIntent); }
    public void onButton382Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tenpercentcoffee.com/"));
        startActivity(myIntent); }
    public void onButton383Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/oscardegrey"));
        startActivity(myIntent); }
    public void onButton384Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gong-cha.co.kr/brand/menu/order.php"));
        startActivity(myIntent); }
    public void onButton385Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/_midnight_cafe"));
        startActivity(myIntent); }
    public void onButton386Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/welcome_bok2ne"));
        startActivity(myIntent); }
    public void onButton387Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ksyactto/221397030833"));
        startActivity(myIntent); }
    public void onButton388Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/shoutbanana/222222733184"));
        startActivity(myIntent); }
    public void onButton389Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/https://instagram.com/givememoore"));
        startActivity(myIntent); }
    public void onButton390Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://haimstar.com/"));
        startActivity(myIntent); }
    public void onButton391Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_hippie_shop"));
        startActivity(myIntent); }
    public void onButton392Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.megacoffee.me/bbs/content.php?co_id=menu1"));
        startActivity(myIntent); }
    public void onButton393Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hollys.co.kr/"));
        startActivity(myIntent); }
    public void onButton394Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/delight1290/222226346056"));
        startActivity(myIntent); }
    public void onButton395Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://newtrocafe.com/"));
        startActivity(myIntent); }
    public void onButton396Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton397Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/kangyj4943/222219673024"));
        startActivity(myIntent); }
    public void onButton398Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dutchandbean.com/"));
        startActivity(myIntent); }
    public void onButton399Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rollingpin.co.kr/"));
        startActivity(myIntent); }
    public void onButton400Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://churros1500_gyeongju@instagram.com/"));
        startActivity(myIntent); }
    public void onButton401Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/kko_eun/222358785192"));
        startActivity(myIntent); }
    public void onButton402Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/quineka/222010001975"));
        startActivity(myIntent); }
    public void onButton403Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/heeya_BPM"));
        startActivity(myIntent); }
    public void onButton404Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton405Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe.t.kenya"));
        startActivity(myIntent); }
    public void onButton406Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton407Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe_yan/"));
        startActivity(myIntent); }
    public void onButton408Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tlj.co.kr/"));
        startActivity(myIntent); }
    public void onButton409Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/fmb977l"));
        startActivity(myIntent); }
    public void onButton410Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://0547775150.bdp.kr/"));
        startActivity(myIntent); }
    public void onButton411Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton412Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://composecoffee.com/board_koTk88"));
        startActivity(myIntent); }
    public void onButton413Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/drinkingmc/220551318344"));
        startActivity(myIntent); }
    public void onButton414Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1076061485?c=14384549.7326312,4282348.6759485,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton415Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://composecoffee.com/board_koTk88"));
        startActivity(myIntent); }
    public void onButton416Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/hhwwii1008"));
        startActivity(myIntent); }
    public void onButton417Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton418Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jhappy6129/222049866856"));
        startActivity(myIntent); }
    public void onButton419Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/yhyhjong/222063028651"));
        startActivity(myIntent); }
    public void onButton420Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.crashop.co.kr/17"));
        startActivity(myIntent); }
    public void onButton421Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/smmh444/222292694430"));
        startActivity(myIntent); }
    public void onButton422Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/mizzakong"));
        startActivity(myIntent); }
    public void onButton423Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/brillant__1"));
        startActivity(myIntent); }
    public void onButton424Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton425Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/"));
        startActivity(myIntent); }
    public void onButton426Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/speed5658/222197593794"));
        startActivity(myIntent); }
    public void onButton427Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://voilakorea.com/"));
        startActivity(myIntent); }
    public void onButton428Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coffeeplace.kr"));
        startActivity(myIntent); }
    public void onButton429Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton430Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/amasvin_korea/"));
        startActivity(myIntent); }
    public void onButton431Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton432Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/coffice.togo"));
        startActivity(myIntent); }
    public void onButton433Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://theventi.co.kr/"));
        startActivity(myIntent); }
    public void onButton434Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tlj.co.kr/"));
        startActivity(myIntent); }
    public void onButton435Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.smoothieking.co.kr/"));
        startActivity(myIntent); }
    public void onButton436Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton437Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.no1juicy.com/products/best"));
        startActivity(myIntent); }
    public void onButton438Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/nias0823/220073595589"));
        startActivity(myIntent); }
    public void onButton439Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/soso_cafe_"));
        startActivity(myIntent); }
    public void onButton440Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/mi2502/222087033900"));
        startActivity(myIntent); }
    public void onButton441Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.10000lab.com/"));
        startActivity(myIntent); }
    public void onButton442Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/skyyks111/222057941620"));
        startActivity(myIntent); }
    public void onButton443Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/chacha_sz/221743613409"));
        startActivity(myIntent); }
    public void onButton444Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/fmb977l"));
        startActivity(myIntent); }
    public void onButton445Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/success8142/222269725571"));
        startActivity(myIntent); }
    public void onButton446Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1604648183?c=14384559.2393157,4282762.5852719,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton447Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1080017245?c=14383151.4262434,4280109.0086398,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton448Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jec1228/221717178561"));
        startActivity(myIntent); }
    public void onButton449Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton450Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/berries_official"));
        startActivity(myIntent); }
    public void onButton451Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/saragarden"));
        startActivity(myIntent); }
    public void onButton452Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coffeebay.com/home/menu/menu_new"));
        startActivity(myIntent); }
    public void onButton453Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yogerpresso.co.kr/"));
        startActivity(myIntent); }
    public void onButton454Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/specialdark/222206142433"));
        startActivity(myIntent); }
    public void onButton455Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/kjiwin2011"));
        startActivity(myIntent); }
    public void onButton456Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Tsl-%ED%8B%B0%EC%97%90%EC%8A%A4%EC%97%98-1735547020057049/?pnref=story"));
        startActivity(myIntent); }
    public void onButton457Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/15742618?c=14383494.6798933,4280675.3547174,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton458Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.caffebene.co.kr/menu/index.html"));
        startActivity(myIntent); }
    public void onButton459Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/rlagudrl1326/221034882674"));
        startActivity(myIntent); }
    public void onButton460Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1188436270?c=14384378.6791016,4282855.9715235,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton461Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://avendutch.com/"));
        startActivity(myIntent); }
    public void onButton462Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/qkehel/220464575216"));
        startActivity(myIntent); }
    public void onButton463Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dlawltn22/222090554992"));
        startActivity(myIntent); }
    public void onButton464Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/sweet2497249/221377707701"));
        startActivity(myIntent); }
    public void onButton465Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/camellia_62/220368730812"));
        startActivity(myIntent); }
    public void onButton466Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/mini710/221263723126"));
        startActivity(myIntent); }
    public void onButton467Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1226031159?c=14382905.5994119,4280156.6516642,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton468Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.caffe-pascucci.co.kr/product/productList.asp?typeCode=00100010"));
        startActivity(myIntent); }
    public void onButton469Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton470Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1678588107?c=14384308.5589544,4281678.1929989,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton471Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafebombom.co.kr/bbs/board.php?bo_table=menu&sca=NEW"));
        startActivity(myIntent); }
    public void onButton472Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/setyna/221420102857"));
        startActivity(myIntent); }
    public void onButton473Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton474Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/wiseegg88/222072337145"));
        startActivity(myIntent); }
    public void onButton475Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/708773005?c=14384120.4178830,4280346.9786304,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton476Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.masigray.com:5021/Menu/List.asp"));
        startActivity(myIntent); }
    public void onButton477Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dlselvldzmrhdwn/222387924861"));
        startActivity(myIntent); }
    public void onButton478Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1578647333?c=14384386.5827855,4280163.0379604,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton479Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1513795200?c=14387496.7157749,4289524.7474552,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton480Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1544177358?c=14384961.2473928,4284715.9645026,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton481Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1490737502?c=14381295.6858041,4281613.5383781,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton482Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1306816097?c=14387365.9599010,4289237.4641256,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton483Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/setyna/221002869715"));
        startActivity(myIntent); }
    public void onButton484Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1401525912?c=14385189.8976269,4284151.4415470,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton485Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/cxz5076/222015976019"));
        startActivity(myIntent); }
    public void onButton486Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://composecoffee.com/board_koTk88"));
        startActivity(myIntent); }
    public void onButton487Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1233170641?c=14383099.2619301,4281724.7165422,19,0,0,0,dh&placePath=%2Fphoto%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton488Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1343643192?c=14382768.7654938,4280428.6562610,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton489Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1861652253?c=14384509.9359132,4280848.3848394,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton490Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.breadnco.kr/product/beverage/"));
        startActivity(myIntent); }
    public void onButton491Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1657253917?c=14383678.3459212,4282382.4546234,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton492Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/bobbob1937/222436187914"));
        startActivity(myIntent); }
    public void onButton493Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%ED%98%84%EA%B3%A1%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1454616797?c=14371611.7695291,4279959.1452879,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton494Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/hhddu/222007900886"));
        startActivity(myIntent); }
    public void onButton495Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/songhyun4479/222246481076"));
        startActivity(myIntent); }
    public void onButton496Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/gc_dabang"));
        startActivity(myIntent); }
    public void onButton497Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/wndud9631/222142156865"));
        startActivity(myIntent); }
    public void onButton498Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/pj7796/222104955201"));
        startActivity(myIntent); }
    public void onButton499Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/guuvelyy/222023412365"));
        startActivity(myIntent); }
    public void onButton500Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ghnaa0822/222271000444"));
        startActivity(myIntent); }
    public void onButton501Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/oyso_cafe/"));
        startActivity(myIntent); }
    public void onButton502Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton503clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%9C%EB%A9%B4%EC%B9%B4%ED%8E%98/place/173363069?c=14371672.2160126,4279824.5556922,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton504Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton505Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tomntoms.com/"));
        startActivity(myIntent); }
    public void onButton506Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dunkindonuts.co.kr/menu/main.php?top=D"));
        startActivity(myIntent); }
    public void onButton507Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/krsc22/222341248762"));
        startActivity(myIntent); }
    public void onButton508Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dunkindonuts.co.kr/menu/main.php?top=D"));
        startActivity(myIntent); }
    public void onButton509Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafedroptop.com/"));
        startActivity(myIntent); }
    public void onButton510Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe___forest"));
        startActivity(myIntent); }
    public void onButton511Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%82%B0%EB%82%B4%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1829351834?c=14365071.2819031,4267195.4600877,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton512Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/the_coffee_road/"));
        startActivity(myIntent); }
    public void onButton513Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/yoon5172/222275087345"));
        startActivity(myIntent); }
    public void onButton514Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/1_992_j/222429806990"));
        startActivity(myIntent); }
    public void onButton515Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/nleefamily/222360569098"));
        startActivity(myIntent); }
    public void onButton516Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dunkindonuts.co.kr/menu/main.php?top=D"));
        startActivity(myIntent); }
    public void onButton517Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_notary"));
        startActivity(myIntent); }
    public void onButton518Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dalin66/222141804834"));
        startActivity(myIntent); }
    public void onButton519Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tomntoms.com/menu/menu.html"));
        startActivity(myIntent); }
    public void onButton520Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafedroptop.com/"));
        startActivity(myIntent); }
    public void onButton521Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/neul_in116"));
        startActivity(myIntent); }
    public void onButton522Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cafe_vana"));
        startActivity(myIntent); }
    public void onButton523Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/bonny21/222308983385"));
        startActivity(myIntent); }
    public void onButton524Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/laon_coffee_roasters"));
        startActivity(myIntent); }
    public void onButton525Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/woon5400/222166462282"));
        startActivity(myIntent); }
    public void onButton526Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/fairy646/222395080286"));
        startActivity(myIntent); }
    public void onButton527Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/csh_0613/222406414282"));
        startActivity(myIntent); }
    public void onButton528Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafedroptop.com/"));
        startActivity(myIntent); }
    public void onButton529Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/gami1023/221535772195"));
        startActivity(myIntent); }
    public void onButton530Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/studio0330_cafe"));
        startActivity(myIntent); }
    public void onButton531Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://khssl.modoo.at/"));
        startActivity(myIntent); }
    public void onButton532Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jowayo777/221067652667"));
        startActivity(myIntent); }
    public void onButton533Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EB%82%B4%EB%82%A8%EB%A9%B4%EC%B9%B4%ED%8E%98/place/1373353729?c=14389683.9211300,4273745.7512564,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton534Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hwarangro33.modoo.at/"));
        startActivity(myIntent); }
    public void onButton535Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/skycody123/221665881026"));
        startActivity(myIntent); }
    public void onButton536Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.makeus.net/44154"));
        startActivity(myIntent); }
    public void onButton537Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/boreumdal_10"));
        startActivity(myIntent); }
    public void onButton538Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%B1%EA%B1%B4%EB%8F%99%EC%B9%B4%ED%8E%98/place/1438310330?c=14383146.0383801,4279764.8973259,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton539Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%B1%EA%B1%B4%EB%8F%99%EC%B9%B4%ED%8E%98/place/36860158?c=14382841.0118434,4279125.1148515,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton540Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/babywoo12/222104046447"));
        startActivity(myIntent); }
    public void onButton541Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/rainthema/220765103540"));
        startActivity(myIntent); }
    public void onButton542Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/uhmamooshi"));
        startActivity(myIntent); }
    public void onButton543Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/yellow_doughnut"));
        startActivity(myIntent); }
    public void onButton544Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/olivee_gj"));
        startActivity(myIntent); }
    public void onButton545Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe_neung/"));
        startActivity(myIntent); }
    public void onButton546Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/gabong___"));
        startActivity(myIntent); }
    public void onButton547Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/u_truth/222312244007"));
        startActivity(myIntent); }
    public void onButton548Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/star_ogi/222434370995"));
        startActivity(myIntent); }
    public void onButton549Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/kim385719/222402609889"));
        startActivity(myIntent); }
    public void onButton550Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/91427ib/222413406567"));
        startActivity(myIntent); }
    public void onButton551Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/zaerac/222417423016"));
        startActivity(myIntent); }
    public void onButton552Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dusl1984/222438240109"));
        startActivity(myIntent); }
    public void onButton553Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/aden_hwangnam"));
        startActivity(myIntent); }
    public void onButton554Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/sulha83/222436962079"));
        startActivity(myIntent); }
    public void onButton555Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/__walkcoffee"));
        startActivity(myIntent); }
    public void onButton556Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/krug.roasters/?hl=ko"));
        startActivity(myIntent); }
    public void onButton557Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://coffeeplace.kr/"));
        startActivity(myIntent); }
    public void onButton558Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/wolsung.dessert"));
        startActivity(myIntent); }
    public void onButton559Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/qufl1024/222440245583"));
        startActivity(myIntent); }
    public void onButton560Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/ssuny.84"));
        startActivity(myIntent); }
    public void onButton561Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/3ducks_coffee"));
        startActivity(myIntent); }
    public void onButton562Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/giwa_croissant"));
        startActivity(myIntent); }
    public void onButton563Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/bang0374/222383124860"));
        startActivity(myIntent); }
    public void onButton564Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/roasterydg?igshid=lxaiudkmkb5r"));
        startActivity(myIntent); }
    public void onButton565Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/nokeum_bakery/"));
        startActivity(myIntent); }
    public void onButton566Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton567Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/pain_atellier"));
        startActivity(myIntent); }
    public void onButton568Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.starbucks.co.kr/"));
        startActivity(myIntent); }
    public void onButton569Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/artcafepalette/"));
        startActivity(myIntent); }
    public void onButton570Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://smartstore.naver.com/gjb"));
        startActivity(myIntent); }
    public void onButton571Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/misil_official"));
        startActivity(myIntent); }
    public void onButton572Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/alsace_bakery/"));
        startActivity(myIntent); }
    public void onButton573Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/viet.caphe_gyeongju/"));
        startActivity(myIntent); }
    public void onButton574Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/richoya18"));
        startActivity(myIntent); }
    public void onButton575Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/242cafe"));
        startActivity(myIntent); }
    public void onButton576Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ssbnc.kr/"));
        startActivity(myIntent); }
    public void onButton577Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/clockwork_thesaro"));
        startActivity(myIntent); }
    public void onButton578Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe__ordinaire"));
        startActivity(myIntent); }
    public void onButton579Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/gaeul8965/222308078922"));
        startActivity(myIntent); }
    public void onButton580Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/ideal______"));
        startActivity(myIntent); }
    public void onButton581Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/yeolmaedal_"));
        startActivity(myIntent); }
    public void onButton582Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_kurobo"));
        startActivity(myIntent); }
    public void onButton583Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.starbucks.co.kr/"));
        startActivity(myIntent); }
    public void onButton584Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/myway0328/222389745365"));
        startActivity(myIntent); }
    public void onButton585Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mojjigyeongyu.modoo.at/"));
        startActivity(myIntent); }
    public void onButton586Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/gyeongju_booboo"));
        startActivity(myIntent); }
    public void onButton587Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/sulbing0"));
        startActivity(myIntent); }
    public void onButton588Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/lej3632/222437633215"));
        startActivity(myIntent); }
    public void onButton589Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/lola__coffee"));
        startActivity(myIntent); }
    public void onButton590Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://caferoffi.modoo.at/"));
        startActivity(myIntent); }
    public void onButton591Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/le_turtle_"));
        startActivity(myIntent); }
    public void onButton592Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/cafe737"));
        startActivity(myIntent); }
    public void onButton593Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/butterhills_"));
        startActivity(myIntent); }
    public void onButton594Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.starbucks.co.kr/"));
        startActivity(myIntent); }
    public void onButton595Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/yeongguk_jegwa_"));
        startActivity(myIntent); }
    public void onButton596Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/jigeum.kr"));
        startActivity(myIntent); }
    public void onButton597Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/ma_reve__"));
        startActivity(myIntent); }
    public void onButton598Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_onjeon"));
        startActivity(myIntent); }
    public void onButton599Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/jyejye_caron"));
        startActivity(myIntent); }
    public void onButton600Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/aubelune_macaron"));
        startActivity(myIntent); }
    public void onButton601Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/jangmigrida"));
        startActivity(myIntent); }
    public void onButto602Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jinx75/222174960203"));
        startActivity(myIntent); }
    public void onButton603Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/yeorihwa"));
        startActivity(myIntent); }
    public void onButton604Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/adela__bake"));
        startActivity(myIntent); }
    public void onButton605Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/pudding_dansi"));
        startActivity(myIntent); }
    public void onButton606Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gong-cha.co.kr/brand/menu/order.php"));
        startActivity(myIntent); }
    public void onButton607Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jaycoffee.co.kr/"));
        startActivity(myIntent); }
    public void onButton608Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dalkomm.com/menu/"));
        startActivity(myIntent); }
    public void onButton609Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kis9600.modoo.at/"));
        startActivity(myIntent); }
    public void onButton610Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://paikdabang.com/menu/menu_coffee/"));
        startActivity(myIntent); }
    public void onButton611Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/39HZgte"));
        startActivity(myIntent); }
    public void onButton612Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/tlsdmswjd127/222237486440"));
        startActivity(myIntent); }
    public void onButton613Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/chunghyo_coffee/"));
        startActivity(myIntent); }
    public void onButton614Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/lovyu0/222240520545"));
        startActivity(myIntent); }
    public void onButton615Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ediya.com/"));
        startActivity(myIntent); }
    public void onButton616Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/moonbb18/222150934046"));
        startActivity(myIntent); }
    public void onButton617Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/rkdms2009/222201027169"));
        startActivity(myIntent); }
    public void onButton618Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%A0%EB%8F%84%EB%8F%99%EC%B9%B4%ED%8E%98/place/1389967807?c=14379719.9806758,4279373.7475968,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton619Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton620Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/l79921/"));
        startActivity(myIntent); }
    public void onButton621Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jinisana/222433071057"));
        startActivity(myIntent); }
    public void onButton622Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%A0%EB%8F%84%EB%8F%99%EC%B9%B4%ED%8E%98/place/1177509339?c=14379766.7125981,4279306.8819277,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton623Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yogerpresso.co.kr/"));
        startActivity(myIntent); }
    public void onButton624Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/kmingu9204/221199012333"));
        startActivity(myIntent); }
    public void onButton625Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wednesday.7x7.kr/"));
        startActivity(myIntent); }
    public void onButton626Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tlj.co.kr/"));
        startActivity(myIntent); }
    public void onButton627Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris.co.kr/"));
        startActivity(myIntent); }
    public void onButton628Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/hoho123492/220078452059"));
        startActivity(myIntent); }
    public void onButton629Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%A0%EB%8F%84%EB%8F%99%EC%B9%B4%ED%8E%98/place/31992777?c=14381773.5803781,4278818.1803712,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton630Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%A0%EB%8F%84%EB%8F%99%EC%B9%B4%ED%8E%98/place/19907809?c=14378483.5328277,4278148.4228119,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton631Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://masigray.com/"));
        startActivity(myIntent); }
    public void onButton632Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%A0%EB%8F%84%EB%8F%99%EC%B9%B4%ED%8E%98/place/1333392472?c=14380860.7382897,4279018.6872144,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton633Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/fls9733/222327213852"));
        startActivity(myIntent); }
    public void onButton634Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/fls9733/221396640716"));
        startActivity(myIntent); }
    public void onButton635Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%EC%84%A0%EB%8F%84%EB%8F%99%EC%B9%B4%ED%8E%98/place/1371106007?c=14381359.2492334,4278847.7597392,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton636Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/c.ommencement/"));
        startActivity(myIntent); }
    public void onButton637Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_freci"));
        startActivity(myIntent); }
    public void onButton638Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/wildflowerdiary_official"));
        startActivity(myIntent); }
    public void onButton639Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/thfdlv2777/222406904599"));
        startActivity(myIntent); }
    public void onButton640Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://0547622003.tshome.co.kr/"));
        startActivity(myIntent); }
    public void onButton641Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EA%B0%95%EB%8F%99%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/962955181?c=14376841.2252481,4302140.5516074,11,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton642Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.blog.naver.com/PostList.naver?blogId=nea114"));
        startActivity(myIntent); }
    public void onButton643Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/indongflower_2010"));
        startActivity(myIntent); }
    public void onButton644Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/majaki"));
        startActivity(myIntent); }
    public void onButton645Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EA%B0%95%EB%8F%99%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1253208399?c=14376399.0085709,4301140.8736978,11,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton646Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/seonae001/221656602299"));
        startActivity(myIntent); }
    public void onButton647Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ook386/221972256406"));
        startActivity(myIntent); }
    public void onButton648Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/grateful-4-all/221764687701"));
        startActivity(myIntent); }
    public void onButton649Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafebombom.co.kr/"));
        startActivity(myIntent); }
    public void onButton650Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EA%B0%95%EB%8F%99%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1367199679?c=14378917.2112999,4292463.9546140,11,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton651Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.opus11.co.kr"));
        startActivity(myIntent); }
    public void onButton652Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/moneywjd/222105622372"));
        startActivity(myIntent); }
    public void onButton653Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.facebook.com/lody.lee.31"));
        startActivity(myIntent); }
    public void onButton654Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_angil"));
        startActivity(myIntent); }
    public void onButton655Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/lyunwha33"));
        startActivity(myIntent); }
    public void onButton656Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1326568757?c=14382919.4809524,4292618.5414879,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton657Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1314165570?c=14382919.4809524,4292618.5414879,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton658Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1175720148?c=14380094.1477483,4289652.7902939,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton659Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/36254178?c=14380015.9792019,4289207.5815969,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton660Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1513795200?c=14380092.8453102,4289524.7474552,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton661licked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%20%EC%B2%9C%EB%B6%81%EB%A9%B4%20%EC%B9%B4%ED%8E%98/place/1306816097?c=14379962.0894364,4289237.4641256,12,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton662Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/k933319/222372303516"));
        startActivity(myIntent); }
    public void onButton663Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ruddhr0495/221719599765"));
        startActivity(myIntent); }
    public void onButton664Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/babyish77/222395705489"));
        startActivity(myIntent); }
    public void onButton665Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dudn1222/222354680212"));
        startActivity(myIntent); }
    public void onButton666Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/0watergirl0/221553727536"));
        startActivity(myIntent); }
    public void onButton667Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/basilla.gyeongju"));
        startActivity(myIntent); }
    public void onButton668Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/blisscoffee_bakery"));
        startActivity(myIntent); }
    public void onButton669Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_numaru"));
        startActivity(myIntent); }
    public void onButton670Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_l_garden"));
        startActivity(myIntent); }
    public void onButton671Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/sosmarrin/221621957583"));
        startActivity(myIntent); }
    public void onButton672Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/emily_00/222413505337"));
        startActivity(myIntent); }
    public void onButton673Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hollys.co.kr/"));
        startActivity(myIntent); }
    public void onButton674Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/rws9000/221865396977"));
        startActivity(myIntent); }
    public void onButton675Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/363_cafe"));
        startActivity(myIntent); }
    public void onButton676Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/mangowith/220668250046"));
        startActivity(myIntent); }
    public void onButton677Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/beauty4121/221328254868"));
        startActivity(myIntent); }
    public void onButton678Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/xxooo60/222149840549"));
        startActivity(myIntent); }
    public void onButton679Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/cafe_bach"));
        startActivity(myIntent); }
    public void onButton680Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1787892068?c=14394916.5717183,4273633.8721170,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton681Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/omignon_official"));
        startActivity(myIntent); }
    public void onButton682Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/bom_dasi"));
        startActivity(myIntent); }
    public void onButton683Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/roamerscoffee"));
        startActivity(myIntent); }
    public void onButton684Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/_elin.coffee_"));
        startActivity(myIntent); }
    public void onButton685Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_your_round"));
        startActivity(myIntent); }
    public void onButton686Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/creative02/222386172239"));
        startActivity(myIntent); }
    public void onButton687Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe23c"));
        startActivity(myIntent); }
    public void onButton688Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blueone.com/"));
        startActivity(myIntent); }
    public void onButton689Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/cafe.half_round?igshid=ozfnuojp5k81"));
        startActivity(myIntent); }
    public void onButton690Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/dimension_coffee"));
        startActivity(myIntent); }
    public void onButton691Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/cafe_so.won"));
        startActivity(myIntent); }
    public void onButton692Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/cafe.oldcity"));
        startActivity(myIntent); }
    public void onButton693Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/quineka/222010001975"));
        startActivity(myIntent); }
    public void onButton694Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/yuni_garden"));
        startActivity(myIntent); }
    public void onButton695Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blueone.com/"));
        startActivity(myIntent); }
    public void onButton696Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/dagamdagam/222350369443"));
        startActivity(myIntent); }
    public void onButton697Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://byeolbandalban.modoo.at/"));
        startActivity(myIntent); }
    public void onButton698Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/qhal409/222064772333"));
        startActivity(myIntent); }
    public void onButton699Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baskinrobbins.co.kr/"));
        startActivity(myIntent); }
    public void onButton700Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/peri2132/222077685474"));
        startActivity(myIntent); }
    public void onButton701Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1792851435?c=14396658.8998604,4271041.1533941,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton702Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.caffebene.co.kr/menu/index.html"));
        startActivity(myIntent); }
    public void onButton703Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jsiove8/221415542256"));
        startActivity(myIntent); }
    public void onButton704Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1285770179?c=14392242.2990632,4277233.6318800,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton705Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EA%B2%BD%EC%A3%BC%ED%95%98%EB%8F%99%EC%B9%B4%ED%8E%98/place/1574292319?c=14398450.9321552,4270630.9411632,19,0,0,0,dh&placePath=%3Fentry%253Dpll"));
        startActivity(myIntent); }
    public void onButton706Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafedroptop.com/"));
        startActivity(myIntent); }
    public void onButton707Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/jinhyundong.coffee"));
        startActivity(myIntent); }
    public void onButton708Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/p_acep_ace"));
        startActivity(myIntent); }
    public void onButton709Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ariel94924/222428655031"));
        startActivity(myIntent); }
}

