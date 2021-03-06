package uk.co.mysterymayhem.mystlib.reflection.lambda.extrafunction;

import java.util.Objects;

/**
 * Created by Mysteryem on 2016-12-30.
 */
@FunctionalInterface
public interface ObjShortConsumer<T> {
    default ObjShortConsumer<T> andThen(ObjShortConsumer<? super T> after) {
        Objects.requireNonNull(after);
        return (t, v) -> {
            this.accept(t, v);
            after.accept(t, v);
        };
    }

    void accept(T t, short value);

    default ShortConsumer bind(T instance) {
        return (s) -> this.accept(instance, s);
    }
}
