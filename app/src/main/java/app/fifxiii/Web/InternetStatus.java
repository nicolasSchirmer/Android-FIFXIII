package app.fifxiii.Web;

// classe de verificação de status de internet

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetStatus {

    NetworkInfo conection;

    // status = false --> nao tem conexao com internet
    // status = true  --> tem conexao com internet
    private boolean status;

    // wifiStatus = false --> é conexao movel
    // wifiStatus = true  --> é conexao wifi
    //private boolean wifiStatus;

    // método construtor, passa contexto como parametro
    public InternetStatus(Context context){
        // cria um objeto de serviço de conexao
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // verifica o tipo de conexao
        conection = connectivityManager.getActiveNetworkInfo();

        // determina tem conexao com internet
        status = conection != null && conection.isConnected();

        // se tem conexao, determina se é wifi ou movel
        //if(status) wifiStatus = conection.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public boolean hasConection(){
        return status;
    }

    /**
    public boolean isWifi(){
        return wifiStatus;
    }
     **/
}
