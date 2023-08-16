package com.parakeetstudios.parabots.core.v1_20_R1;

import com.parakeetstudios.parabots.core.EntityProgram;
import com.parakeetstudios.parabots.core.ProgramForType;
import com.parakeetstudios.parabots.core.utils.Paralog;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;


public class EntityProgramRegistry {

    private static final Map<EntityType, EntityProgram> programs = new HashMap<>();

    public static void registerPrograms(JavaPlugin plugin) {
        ServiceLoader<EntityProgram> loader = ServiceLoader.load(EntityProgram.class, plugin.getClass().getClassLoader());
        for (EntityProgram program : loader) {
            ProgramForType annotation = program.getClass().getAnnotation(ProgramForType.class);
            if (annotation != null) {
                EntityType type = annotation.value();
                programs.put(type, program);
            } else {
                Paralog.warning(program.getClass().getName() + " does not have an associated ProgramForType annotation to assign EntityType. Skipping...");
            }
        }
        if (programs.isEmpty()) {
            Paralog.warning("No EntityProgram implementations have been registered.");
        }
    }

    public static EntityProgram supplyBuilderForType(EntityType type) {
        return programs.get(type);
    }


}
