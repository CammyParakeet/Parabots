package com.parakeetstudios.parabots.core.v1_20_R1;

import com.parakeetstudios.parabots.core.EntityProgram;
import com.parakeetstudios.parabots.core.ProgramForType;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static com.parakeetstudios.parabots.core.utils.ReflectionUtils.getClasses;


public class EntityProgramRegistry {

    private static final Map<EntityType, EntityProgram> programs = new HashMap<>();

    /**
     * Registers all EntityProgram implementations within the specified package.
     * <p>
     * This method scans the provided package for classes that have been annotated with
     * {@link ProgramForType}. For each found class, it creates a new instance and
     * registers it into a static map with the entity type from the annotation as the key.
     * </p>
     * <p>
     * The method is intended to be called during the plugin's initialization process to
     * automatically discover and register all the available entity programs.
     * </p>
     * <p>
     * It is crucial that classes within the specified package have a default constructor
     * (i.e., no-args constructor) as this method relies on it to create new instances.
     * </p>
     *
     * @throws Exception if there is an issue accessing the class, its annotations,
     * or invoking its constructor.
     */
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
