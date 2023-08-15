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

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;


public class EntityProgramRegistry {

    private static final Map<EntityType, EntityProgram> programs = new HashMap<>();

    /**
     * Registers all entity programs located within a specific package.
     * <p>
     * This method scans a given package for classes annotated with the {@link ProgramForType} annotation,
     * instantiates them, and registers them into the {@code programs} map. The entity type specified in
     * the annotation is used as the key, and the instantiated class (assumed to be an {@link EntityProgram})
     * serves as the value in the map.
     * </p>
     *
     * @param plugin The active instance of the {@link JavaPlugin} that's responsible for these programs.
     *               This is used to derive the appropriate class loader for loading the entity program classes.
     *
     * @throws Exception if there's an error during class scanning, instantiation, or registration.
     */
    public static void registerPrograms(JavaPlugin plugin) {
        Paralog.info("Before the loop...");
        try {
            for (Class<?> clazz : getClasses("com.parakeetstudios.parabots.core.v1_20_R1.program", plugin.getClass().getClassLoader())) {
                ProgramForType annot = clazz.getAnnotation(ProgramForType.class);
                Paralog.info("TYPE: " + clazz.getAnnotation(ProgramForType.class).toString());
                programs.put(annot.value(), (EntityProgram) clazz.getConstructor().newInstance());
            }
        } catch (Exception e) {
            Paralog.severe("Error registering programs: " + e.getMessage());
        }
    }

    public static EntityProgram supplyBuilderForType(EntityType type) {
        return programs.get(type);
    }


}
