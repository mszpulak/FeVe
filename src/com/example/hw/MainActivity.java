package com.example.hw;

import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.activity_main);
        
        FillData();
        startTestingActivity();
        
    }

    public void FillData() {
    	TextView textView1 = (TextView) findViewById(R.id.TextView1); 
        
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);  
        
        String info="\nPhone Details:"; 
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
        List<CellInfo>  AllCellInfo= tm.getAllCellInfo();
        
        String AllCellInfoString="";
        for(int i = 0; i < AllCellInfo.size(); i++) {
        	AllCellInfoString+="\n"+AllCellInfo.get(i).toString();
        	AllCellInfoString+="\n===================";
        }
        
        String  CellLocation=tm.getCellLocation().toString();
        
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
        
        String WholeText=info;
        WholeText+="\nIMEINumber: "+IMEINumber;
        //WholeText+="\nDeviceSoftwareVersion: "+DeviceSoftwareVersion;
        WholeText+="\nPhoneNumber: "+Line1Number;
        
        WholeText+="\nPhoneType: "+strPhoneType;
        WholeText+="\nNetworkType: "+strNetworkType;
        WholeText+="\nSubscriberId: "+SubscriberId;
        WholeText+="\nNetworkCountryIso: "+NetworkCountryIso;    
        WholeText+="\nNetworkOperator: "+NetworkOperator;
        WholeText+="\nNetworkOperatorName: "+NetworkOperatorName;
        WholeText+="\n===================";
        //WholeText+="\nSimCountryIso: "+SimCountryIso;
        //WholeText+="\nSimOperator: "+SimOperator;
        //WholeText+="\nSimSerialNumber: "+SimSerialNumber;
        //WholeText+="\nSimState: "+SimState;
        
        WholeText+="\nCellLocation: "+CellLocation;
        WholeText+="\n===================";
        WholeText+=AllCellInfoString;
        
        textView1.setText(WholeText);
    	
    }
    
    public void startTestingActivity() {
    	Intent i = new Intent();
    	i.setComponent(new ComponentName("com.android.settings", "com.android.settings.RadioInfo"));
    	i.setAction(Intent.ACTION_MAIN);
    	startActivity(i); 
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
    	startTestingActivity();
    }
    /** Called when the user clicks the Send button */
    public void refreshFillData(View view) {
        // Do something in response to button
    	FillData();
    }
    
}
