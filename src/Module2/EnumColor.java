package Module2;

import java.util.Locale;

/**
 * Created by Angel on 17/5/2017.
 */
public enum EnumColor {

    E_Color_1("Red", "红"),
    E_Color_2("Green", "青"),
    E_Color_3("Blue", "蓝");

    String name_en;
    String name_zh;

    public static EnumColor[] values = values(); // this prevents re-initialisation everytime values() is called.

    EnumColor(String name_en, String name_zh) {
        this.name_en = name_en;
        this.name_zh = name_zh;
    }

    @Override
    public String toString( ) {

        return Locale.getDefault().equals(Locale.CHINESE) ? name_zh : name_en;
    }
}
