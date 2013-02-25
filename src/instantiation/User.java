/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instantiation;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author nkak
 */
public class User
{
    @SerializedName("http://registry.gpii.org/common/fontSize") List<VariableIntValue> fontSize;
    @SerializedName("http://registry.gpii.org/common/foregroundColor") List<VariableStringValue> foregroundColor;
    @SerializedName("http://registry.gpii.org/common/backgroundColor") List<VariableStringValue> backgroundColor;
    @SerializedName("http://registry.gpii.org/common/fontFaceFontName") List<VariableStringArrayValue> fontFaceFontName;
    @SerializedName("http://registry.gpii.org/common/fontFaceGenericFontFace") List<VariableStringValue> fontFaceGenericFontFace;
    @SerializedName("http://registry.gpii.org/common/magnification") List<VariableDoubleValue> magnification;
    @SerializedName("http://registry.gpii.org/common/tracking") List<VariableStringValue> tracking;
    @SerializedName("http://registry.gpii.org/common/invertImages") List<VariableBooleanValue> invertImages;
    @SerializedName("http://registry.gpii.org/common/ScreenReaderTTSEnabled") List<VariableStringValue> screenReaderTTSEnabled;

    class VariableStringValue
    {
        String value;
        Condition condition;
    }
    class VariableDoubleValue
    {
        Double value;
        Condition condition;
    }
    class VariableIntValue
    {
        int value;
        Condition condition;
    }
    class VariableBooleanValue
    {
        boolean value;
        Condition condition;
    }
    class VariableStringArrayValue
    {
        List<String> value;
        Condition condition;
    }
    
    class Condition
    {
        Operator operator;
        
        class Operator
        {
            String type;
            String property;
            String value;
        }
    }
}