package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class CodeUET {
    private final String value;
}

