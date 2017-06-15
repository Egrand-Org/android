
package cn.com.ico.www;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

import org.apache.cordova.CordovaActivity;

public class MainActivity extends CordovaActivity
{
    private static Context mContext;
    public static Context GetContext() {
        return mContext;
    }
    public static WebView view;
    private static final String APP_CACAHE_DIRNAME = "/webcache";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        /*
        此段代码重新设置webview的属性，可以代替下面的代码
        //super 父类init()初始化，否则项目直接蹦掉
        super.init();
        mContext = this;
        // webview缓存路径
        String cacheDirPath = getFilesDir().getAbsolutePath()+APP_CACAHE_DIRNAME;
        // 设置webview属性
        view = (WebView) appView.getEngine().getView();
        //水平不显示
        view.setHorizontalScrollBarEnabled(false);
        //垂直不显示
        view.setVerticalScrollBarEnabled(false);
        //获取webview settings
        WebSettings settings = view.getSettings();
        //设置 缓存模式
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //开启 DOM storage API 功能
        settings.setDomStorageEnabled(true);
        //开启 database storage API 功能
        settings.setDatabaseEnabled(true);
        //开启 Application Caches 功能
        settings.setAppCacheEnabled(true);

        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(false);
        //设置webView启用Javascript
        settings.setJavaScriptEnabled(true);

        view.loadUrl(Config.getStartUrl());
        */

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);

    }
}
