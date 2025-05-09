package bg.tu_varna.sit.b1.f23621684.parameters.contracts;

import bg.tu_varna.sit.b1.f23621684.extractors.contracts.Extractor;

public interface CommandParameter extends Extractor {
    String getName();
    boolean isOptional();

}

