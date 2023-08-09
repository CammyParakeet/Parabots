package com.parakeetstudios.parabots.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ReflectionUtils {

    public static Set<Class<?>> getClasses(String pkgName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = pkgName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        Set<Class<?>> classes = new HashSet<>();

        while(resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            classes.addAll(findClasses(new File(resource.getFile()), pkgName));
        }
        return classes;
    }

    private static Set<Class<?>> findClasses(File dir, String pkgName) throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        if (!dir.exists()) return classes;
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, pkgName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(pkgName + "." + file.getName()));
            }
        }
        return classes;
    }

}
