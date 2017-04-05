package aleul850.passwordstrengthmeter;

/**
 * Created by Bauws on 2015-01-16.
 */
public class StrengthAlgorithm {
    int _strength;

    public StrengthAlgorithm(){
        _strength = 0;
    }

    public int checkStrength (String password){
        _strength = 0;
        //Set of if-methods that tests the strength of the password
        if (password.length() >= 8){
            _strength=_strength+10;
        }

        if (password.toLowerCase() != password && password.toUpperCase() != password){
            _strength=_strength+10;
        }

        if (password.matches(".*[0-9].*")){
            _strength=_strength+10;
        }

        if (password.matches(".*[\"\\\\!?@#£¤$%&/{()=}`´^¨~*'<|>§½,;.:_\\[\\]-].*")){
            _strength=_strength+10;
        }

        if (password.length() >= 12){
            _strength=_strength+10;
        }
        return _strength;
    }
}
