package com.parakeetstudios.parabots.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ReflectionUtils {

    /**
     * Retrieves a set of classes present in the specified package.
     * <p>
     * This method searches for and returns all classes located within the given package name.
     * It utilizes the current thread's class loader to find the resources and iteratively checks
     * directories and files to gather all classes.
     * </p>
     *
     * @param pkgName The name of the package to search in, e.g., "com.parakeetstudios...".
     * @return A set of classes found within the specified package.
     * @throws ClassNotFoundException if a class cannot be located by the specified class name.
     * @throws IOException if there's an error reading the class resources.
     */
    public static Set<Class<?>> getClasses(String pkgName, ClassLoader classLoader) throws ClassNotFoundException, IOException {
        Paralog.info("getClasses running?");
        String path = pkgName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        Paralog.info(System.getProperty("java.class.path"));
        Paralog.info(path);
        Set<Class<?>> classes = new HashSet<>();

        while(resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            classes.addAll(findClasses(new File(resource.getFile()), pkgName));
        }
        return classes;
    }

    /**
     * Recursively finds and collects classes from the given directory and its subdirectories
     * that are part of the specified package.
     * <p>
     * This method is a helper function used to traverse directories and identify class files.
     * It's utilized by the {@link #getClasses(String, ClassLoader)} method to dig deeper into package structures.
     * </p>
     *
     * @param dir     The directory to start the search in.
     * @param pkgName The name of the package associated with the directory, used for class name resolution.
     * @return A set of classes found within the directory that match the package name.
     * @throws ClassNotFoundException if a class cannot be located by the specified class name.
     */
    private static Set<Class<?>> findClasses(File dir, String pkgName) throws ClassNotFoundException {
        Paralog.info("findClasses running?");
        Set<Class<?>> classes = new HashSet<>();
        if (!dir.exists()) return classes;
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, pkgName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(pkgName + "." + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
