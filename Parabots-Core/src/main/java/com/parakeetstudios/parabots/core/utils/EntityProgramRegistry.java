package com.parakeetstudios.parabots.core.utils;

import com.parakeetstudios.parabots.core.builders.BuilderForType;
import com.parakeetstudios.parabots.core.builders.EntityProgram;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;

public class EntityProgramRegistry {

    private static final Map<EntityType, EntityProgram> builderRegister = new HashMap<>();

    public static void registerBuilders() throws Exception {
        for (Class<?> clazz : getClasses("com.parakeetstudios.parabots.core.builders")) {
            BuilderForType annot = clazz.getAnnotation(BuilderForType.class);
            builderRegister.put(annot.value(), (EntityProgram) clazz.getConstructor().newInstance());
        }
    }

    public static EntityProgram supplyBuilderForType(EntityType type) {
        return builderRegister.get(type);
    }


}
