import java.util.List;

public class NumberToSendWhatsapp {
    private String _urlToSend;
    private boolean _send;
    public final String URL_OF_WHATSAPP = "https://web.whatsapp.com/send?phone=";

    public NumberToSendWhatsapp(int number, int prefix) {
        _urlToSend = URL_OF_WHATSAPP + prefix + number;
        _send = false;
    }

    public void sent() {
        _send = true;
    }

    public boolean isSent() {
        return _send;
    }
    public String getUrlToSend(){
        return _urlToSend;
    }

    public static String whatNotSent(List<NumberToSendWhatsapp> list) {
        String temp = "";
        for (NumberToSendWhatsapp x : list        )
        {
            if (!x.isSent()){
                temp= temp + x.getUrlToSend().substring(x.getUrlToSend().indexOf('=')+1)+"\n";
            }


        }
        return temp;
    }
    public static String whatSent(List<NumberToSendWhatsapp> list) {
        String temp = "";
        for (NumberToSendWhatsapp x : list        )
        {
            if (x.isSent()){
                temp= temp + x.getUrlToSend().substring(x.getUrlToSend().indexOf('=')+1)+"\n";
            }


        }
        return temp;
    }
}
