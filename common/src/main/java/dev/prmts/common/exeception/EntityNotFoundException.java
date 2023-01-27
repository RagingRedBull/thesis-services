package dev.prmts.common.exeception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Class<?> clazz, Object id) {
        super(String.format("Could not find entity %S with ID of %s",
                clazz.getSimpleName(), id.toString()));
    }
}
