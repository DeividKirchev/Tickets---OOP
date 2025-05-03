package bg.tu_varna.sit.b1.f23621684.validators;


public class StringValidator extends BaseValidator {

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        if (s.length() <= 2)
            return "Invalid string size.";
        if (s.charAt(0) != '"' || s.charAt(s.length() - 1) != '"')
            return "Strings must be surrounded by \" characters";
        return null;
    }
}
