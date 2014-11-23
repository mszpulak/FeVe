package com.example.hw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FillData();
        
    }

    public void FillData() {
    	TextView textView1 = (TextView) findViewById(R.id.editText1); 
        
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);  
        
        String info="\nPhone Details:\n"; 
        String IMEINumber=tm.getDeviceId();
        String DeviceSoftwareVersion=tm.getDeviceSoftwareVersion();
        String Line1Number=tm.getLine1Number();
        String NetworkCountryIso=tm.getNetworkCountryIso();
        String NetworkOperator=tm.getNetworkOperator();
        String NetworkOperatorName=tm.getNetworkOperatorName();
        int NetworkType=tm.getNetworkType();
        int PhoneType=tm.getPhoneType();
        String SimCountryIso=tm.getSimCountryIso();
        String  SimOperator=tm.getSimOperator();
        String  SimSerialNumber=tm.getSimSerialNumber();
        int  SimState=tm.getSimState();
        String  SubscriberId=tm.getSubscriberId();
        
        String WholeText=info;
        WholeText+="\nIMEINumber: "+IMEINumber;
        WholeText+="\nDeviceSoftwareVersion: "+DeviceSoftwareVersion;
        WholeText+="\nLine1Number: "+Line1Number;
        WholeText+="\nNetworkCountryIso: "+NetworkCountryIso;
        WholeText+="\nNetworkOperator: "+NetworkOperator;
        WholeText+="\nNetworkOperatorName: "+NetworkOperatorName;
        WholeText+="\nSimCountryIso: "+SimCountryIso;
        WholeText+="\nSimOperator: "+SimOperator;
        WholeText+="\nSimSerialNumber: "+SimSerialNumber;
        WholeText+="\nSimState: "+SimState;
        WholeText+="\nSubscriberId: "+SubscriberId;
        
        String strPhoneType="";
        switch (PhoneType){  
                case (TelephonyManager.PHONE_TYPE_CDMA):  
                           strPhoneType="CDMA";  
                               break;  
                case (TelephonyManager.PHONE_TYPE_GSM):   
                           strPhoneType="GSM";                
                               break;  
                case (TelephonyManager.PHONE_TYPE_NONE):  
                            strPhoneType="NONE";                
                                break;  
        		}  
        WholeText+="\nPhoneType: "+strPhoneType;
        
        String strNetworkType="";
        switch (NetworkType){
        	case (TelephonyManager.NETWORK_TYPE_EDGE):
        		strNetworkType="EDGE";
        	case (TelephonyManager.NETWORK_TYPE_GPRS):
        		strNetworkType="GPRS";
        	case (TelephonyManager.NETWORK_TYPE_HSDPA):
        		strNetworkType="HSDPA";
        	case (TelephonyManager.NETWORK_TYPE_HSPA):
        		strNetworkType="HSPA";
        	case (TelephonyManager.NETWORK_TYPE_HSPAP):
        		strNetworkType="HSPAP";
        	case (TelephonyManager.NETWORK_TYPE_HSUPA):
        		strNetworkType="HSUPA";
        	case (TelephonyManager.NETWORK_TYPE_UMTS):
        		strNetworkType="UMTS";
        	case (TelephonyManager.NETWORK_TYPE_UNKNOWN):
        		strNetworkType="UNKNOWN";

        }
        WholeText+="\nNetworkType: "+strNetworkType;
        
        textView1.setText(WholeText);
    	
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }
}
