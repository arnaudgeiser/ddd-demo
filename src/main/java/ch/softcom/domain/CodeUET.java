package ch.softcom.domain;

import ch.softcom.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class CodeUET {
    private final String value;
}

