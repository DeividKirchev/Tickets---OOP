package bg.tu_varna.sit.b1.f23621684.contracts;

import java.util.List;
import java.util.Map;

public interface Executable {
    Map<CommandParameter, String> execute(List<String> params);
}
