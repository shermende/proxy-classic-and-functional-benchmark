package dev.shermende.model;

public class IOriginImpl implements IOrigin {
    @Override
    public String action(
            String s
    ) {
        return String.format("%s: %s.", "original-action", s);
    }

    @Override
    public String anotherAction(
            String s
    ) {
        return String.format("%s: %s.", "original-another-action", s);
    }
}
