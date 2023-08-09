package com.parakeetstudios.parabots.core.v1_20_R1;

import com.parakeetstudios.parabots.core.EntityProgram;
import com.parakeetstudios.parabots.core.ProgramForType;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;


public class EntityProgramRegistry {

    private static final Map<EntityType, EntityProgram> programs = new HashMap<>();

    public static void registerBuilders() throws Exception {
        for (Class<?> clazz : getClasses("com.parakeetstudios.parabots.core.v1_20_R1.program")) {
            ProgramForType annot = clazz.getAnnotation(ProgramForType.class);
            programs.put(annot.value(), (EntityProgram) clazz.getConstructor().newInstance());
        }
    }

    public static EntityProgram supplyBuilderForType(EntityType type) {
        return programs.get(type);
    }


}
