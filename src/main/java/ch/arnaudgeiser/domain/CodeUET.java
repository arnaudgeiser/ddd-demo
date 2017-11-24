package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class CodeUET {
    private final String value;
}

