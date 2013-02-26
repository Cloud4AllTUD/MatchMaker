package instantiation;

import java.lang.reflect.Type;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 *
 * @author nkak
 */
public class UserDeserializer_OLD_JSON_STRUCTURE implements JsonDeserializer<User_OLD_JSON_STRUCTURE> 
{

  @Override
  public User_OLD_JSON_STRUCTURE deserialize(final JsonElement json, 
        final Type typeOfT, 
        final JsonDeserializationContext context) 
            throws JsonParseException 
  {

    User_OLD_JSON_STRUCTURE tmpUser = new User_OLD_JSON_STRUCTURE();
    // Parsing will be done here.
    return tmpUser;
  }
}
