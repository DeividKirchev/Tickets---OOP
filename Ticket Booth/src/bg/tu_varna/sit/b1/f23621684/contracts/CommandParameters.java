package bg.tu_varna.sit.b1.f23621684.contracts;

import java.util.List;

public interface CommandParameters {
    List<ICommandParameter> getCommandParameters();
    void addCommandParameter(ICommandParameter cp);
}
