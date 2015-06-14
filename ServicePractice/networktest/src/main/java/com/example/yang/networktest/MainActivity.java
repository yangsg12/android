package com.example.yang.networktest;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends Activity implements View.OnClickListener {


    public static final int SHOW_RESPONSE = 0;
    private Button sendRequest;
    private TextView responseText;
    private Handler handler = new Handler() {
       public void handlerMessage(Message msg){
           switch (msg.what){
               case SHOW_RESPONSE:
                   String response = (String) msg.obj;
                   responseText.setText(response);
           }
       }

        @Override
        public void publish(LogRecord record) {
            Log.d("这个handler!","what ");
        }

        @Override
        public void close() {
            Log.d("Tag","close()")    ;
        }

        @Override
        public void flush() {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendRequest = (Button)findViewById(R.id.send_request);
        responseText = (TextView)findViewById(R.id.respon);
        sendRequest.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request){
            sendRequestWithHttpURLConnection();
        }
    }

    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection = null;
                    URL  url = new URL("http://www.baidu.com");
                    connection =(HttpURLConnection) url.openConnection() ;
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder()  ;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Message message = new Message();
                    message.what = SHOW_RESPONSE;
                    message.obj = response.toString();
                    //handler.sendMessage(message);

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //if (connection != null) {
                    //    connection.disconnect();
                    //}
                }

            }
        }).start();
    }


    private void sendRequestWithHttpClient(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://www.baidu.com");
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        HttpEntity entity = httpResponse.getEntity();
                        String response = EntityUtils.toString(entity, "utf-8");
                        Message message = new Message();
                        message.what = SHOW_RESPONSE;
                        message.obj = response.toString();
                        //handler.sendMessage(message);
                    }

                }catch (Exception e){
                      e.printStackTrace();
                }
            }
        }).start();
    }

  /*  HttpUtil.sendHttpRequest(address,new HttpCallbackListener() {
        onFinish(String response){

        };

        onError
    })*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
