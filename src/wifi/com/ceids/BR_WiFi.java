package wifi.com.ceids;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

//http://android-er.blogspot.com/2011/01/monitor-wifi-status-and-information.html

public class BR_WiFi extends BroadcastReceiver{


	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
//		String s = WifiManager.NETWORK_STATE_CHANGED_ACTION;
		
		//Se usa para conectividad en general, ya sea 3G o WiFi
		
//		String s = ConnectivityManager.CONNECTIVITY_ACTION;
		
		
		//Obtener informaci�n del estado de la conexi�n
		
		NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
		
		//Obtener el servicio para manejar datos del wifi
		
		WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		
		//Obtiene la informaci�n de la conexi�n WiFi actual al que est� conectado
		
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
			
		
				
		if(networkInfo.isConnected()){
			
			//El IP de la conexi�n
			
			int intIP = wifiInfo.getIpAddress();
			
			//El nombre de la conexi�n
			
			String SSID = wifiInfo.getSSID();
			
			//Ancho de banda de la conexi�n
			
			int speed = wifiInfo.getLinkSpeed();
			
			//Conversi�n IP de integer a octetos
					
			String ip =  String.format("%d.%d.%d.%d", (intIP & 0xff), (intIP >> 8 & 0xff), (intIP >> 16 & 0xff), (intIP >> 24 & 0xff));
			
			//Mostrar el un toast el mensaje con los datos de la conexi�n
			
			Toast.makeText(context, "Conectado!!!"+'\n'+"SSID: "+SSID+'\n'+"IP: "+ip+'\n'+"Velocidad: "+speed, Toast.LENGTH_SHORT).show();
			
		}else{
			
			Toast.makeText(context, "Desconectado!!!", Toast.LENGTH_SHORT).show();
			
		}
					
		
		
	}
	
	
}
