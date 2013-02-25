package instantiation;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 *
 * @author nkak
 */
public class UserDeserializer implements JsonDeserializer<User> 
{

  @Override
  public User deserialize(final JsonElement json, 
        final Type typeOfT, 
        final JsonDeserializationContext context) 
            throws JsonParseException 
  {

    User tmpUser = new User();
    // Parsing will be done here.
    return tmpUser;
  }
}