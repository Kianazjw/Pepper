package com.komorebi.pepper.ui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.komorebi.pepper.R;

public class MapActivity extends AppCompatActivity {

    WebView webView;
    WebSettings mWebSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://720yun.com/t/54c23mskqcs?pano_id=2850524"));
        // 注意此处的判断intent.resolveActivity()可以返回显示该Intent的Activity对应的组件名
        // 官方解释 : Name of the component implementing an activity that can display the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            final ComponentName componentName = intent.resolveActivity(getPackageManager());
            // 打印Log   ComponentName到底是什么
            Log.e("TAG", "componentName = " + componentName.getClassName());
            startActivity(Intent.createChooser(intent, "请选择浏览器"));
        } else {
            Toast.makeText(getApplicationContext(), "没有匹配的程序", Toast.LENGTH_SHORT).show();
        }

//        webView = findViewById(R.id.webView);
//        webView.loadUrl("http://720yun.com/t/54c23mskqcs?pano_id=2850524");
//        //获取焦点
//        webView.requestFocus();
//        webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE,new android.graphics.Paint());
//
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
//                if(url == null) return false;
//
//                try {
//                    if(url.startsWith("weixin://") //微信
//                            || url.startsWith("alipays://") //支付宝
//                            || url.startsWith("mailto://") //邮件
//                            || url.startsWith("tel://")//电话
//                            || url.startsWith("dianping://")//大众点评
//                            || url.startsWith("vipshop://")
//                        //其他自定义的scheme
//                            ) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                        startActivity(intent);
//                        return true;
//                    }
//                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
//                    return true;//没有安装该app时，返回true，表示拦截自定义链接，但不跳转，避免弹出上面的错误页面
//                }
//
//                //处理http和https开头的url
//                wv.loadUrl(url);
//                return true;
//            }
//
//        });
//
//        mWebSettings = webView.getSettings();
//
//       mWebSettings.setJavaScriptEnabled(true);
//       mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//       mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
//       mWebSettings.setDomStorageEnabled(true);
//       mWebSettings.setDatabaseEnabled(true);
//       mWebSettings.setAppCacheEnabled(true);
//       mWebSettings.setAllowFileAccess(true);
//       mWebSettings.setSavePassword(true);
//       mWebSettings.setSupportZoom(true);
//       mWebSettings.setBuiltInZoomControls(true);
//       mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//       mWebSettings.setUseWideViewPort(true);
//
//    }

    }


}
