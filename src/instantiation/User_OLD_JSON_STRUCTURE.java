package instantiation;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations .SerializedName;
import java.util.Collection;


/**
 *
 * @author nkak
 */
public class User_OLD_JSON_STRUCTURE
{
    Display display;
}
class Display
{
    ScreenEnhancement screenEnhancement;
}

class ScreenEnhancement
{
    Integer fontSize;
    String foregroundColor;
    String backgroundColor;
    FontFace fontFace;
    Double magnification;
    String tracking;
    Boolean invertImages;
    @SerializedName("-provisional-showCrosshairs") Boolean provisionalShowCrosshairs;
}

class FontFace
{
    List<String> fontName;
    String genericFontFace;
}