package bg.tu_varna.sit.b1.f23621684.validators;


public class StringValidator extends BaseValidator {

    @Override
    public boolean validate(String s) {
        if (!super.validate(s)) return false;
        return s.length() > 2 && s.charAt(0) == '"' && s.charAt(s.length() - 1) == '"';
    }
}
