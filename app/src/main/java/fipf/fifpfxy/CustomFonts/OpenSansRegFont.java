package fipf.fifpfxy.CustomFonts;

// Classe da fonte open sans regular

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import fipf.fifpfxy.App;

public class OpenSansRegFont extends TextView{

    // Tipos de construtores

    public OpenSansRegFont(Context context) {
        this(context, null);
    }

    public OpenSansRegFont(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OpenSansRegFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(App.openSansRegType);
    }
}
