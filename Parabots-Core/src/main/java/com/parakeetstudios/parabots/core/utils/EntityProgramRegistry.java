package com.parakeetstudios.parabots.core.utils;

import com.parakeetstudios.parabots.core.builders.ProgramForType;
import com.parakeetstudios.parabots.core.builders.EntityProgram;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;

public class EntityProgramRegistry {

    private static final Map<EntityType, EntityProgram> programs = new HashMap<>();

    public static void registerBuilders() throws Exception {
        for (Class<?> clazz : getClasses("com.parakeetstudios.parabots.core.builders")) {
            ProgramForType annot = clazz.getAnnotation(ProgramForType.class);
            programs.put(annot.value(), (EntityProgram) clazz.getConstructor().newInstance());
        }
    }

    public static EntityProgram supplyBuilderForType(EntityType type) {
        return programs.get(type);
    }


}
