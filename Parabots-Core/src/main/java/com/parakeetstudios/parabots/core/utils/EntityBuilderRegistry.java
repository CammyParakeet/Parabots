package com.parakeetstudios.parabots.core.utils;

import com.parakeetstudios.parabots.core.builders.BuilderForType;
import com.parakeetstudios.parabots.core.builders.EntityBuilder;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;

public class EntityBuilderRegistry {

    private static final Map<EntityType, EntityBuilder> builderRegister = new HashMap<>();

    public static void registerBuilders() throws Exception {
        for (Class<?> clazz : getClasses("com.parakeetstudios.parabots.core.builders")) {
            BuilderForType annot = clazz.getAnnotation(BuilderForType.class);
            builderRegister.put(annot.value(), (EntityBuilder) clazz.getConstructor().newInstance());
        }
    }

    public static EntityBuilder supplyBuilderForType(EntityType type) {
        return builderRegister.get(type);
    }


}
