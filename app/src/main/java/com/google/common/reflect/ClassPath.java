package com.google.common.reflect;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import com.google.common.reflect.ClassPath;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private final ImmutableSet<ResourceInfo> resources;
    private static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.resources = immutableSet;
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        ImmutableSet<LocationInfo> locationsFrom = locationsFrom(classLoader);
        HashSet hashSet = new HashSet();
        UnmodifiableIterator<LocationInfo> it = locationsFrom.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().file());
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<LocationInfo> it2 = locationsFrom.iterator();
        while (it2.hasNext()) {
            builder.addAll((Iterable) it2.next().scanResources(hashSet));
        }
        return new ClassPath(builder.build());
    }

    public final ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public final ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public final ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(new Predicate() { // from class: com.google.common.reflect.ClassPath$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return ((ClassPath.ClassInfo) obj).isTopLevel();
            }
        }).toSet();
    }

    public final ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }

    public final ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        String obj = sb.toString();
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getName().startsWith(obj)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }

    /* loaded from: classes7.dex */
    public static class ResourceInfo {
        private final File file;
        final ClassLoader loader;
        private final String resourceName;

        static ResourceInfo of(File file, String str, ClassLoader classLoader) {
            if (str.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION)) {
                return new ClassInfo(file, str, classLoader);
            }
            return new ResourceInfo(file, str, classLoader);
        }

        ResourceInfo(File file, String str, ClassLoader classLoader) {
            this.file = (File) Preconditions.checkNotNull(file);
            this.resourceName = (String) Preconditions.checkNotNull(str);
            this.loader = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final URL url() {
            URL resource = this.loader.getResource(this.resourceName);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.resourceName);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        final File getFile() {
            return this.file;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ResourceInfo) {
                ResourceInfo resourceInfo = (ResourceInfo) obj;
                return this.resourceName.equals(resourceInfo.resourceName) && this.loader == resourceInfo.loader;
            }
            return false;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ClassInfo extends ResourceInfo {
        private final String className;

        ClassInfo(File file, String str, ClassLoader classLoader) {
            super(file, str, classLoader);
            this.className = ClassPath.getClassName(str);
        }

        public final String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public final String getSimpleName() {
            int lastIndexOf = this.className.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.inRange('0', '9').trimLeadingFrom(this.className.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }

        public final String getName() {
            return this.className;
        }

        public final boolean isTopLevel() {
            return this.className.indexOf(36) == -1;
        }

        public final Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public final String toString() {
            return this.className;
        }
    }

    static ImmutableSet<LocationInfo> locationsFrom(ClassLoader classLoader) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<Map.Entry<File, ClassLoader>> it = getClassPathEntries(classLoader).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<File, ClassLoader> next = it.next();
            builder.add((ImmutableSet.Builder) new LocationInfo(next.getKey(), next.getValue()));
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class LocationInfo {
        private final ClassLoader classloader;
        final File home;

        LocationInfo(File file, ClassLoader classLoader) {
            this.home = (File) Preconditions.checkNotNull(file);
            this.classloader = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final File file() {
            return this.home;
        }

        public final ImmutableSet<ResourceInfo> scanResources() throws IOException {
            return scanResources(new HashSet());
        }

        public final ImmutableSet<ResourceInfo> scanResources(Set<File> set) throws IOException {
            ImmutableSet.Builder<ResourceInfo> builder = ImmutableSet.builder();
            set.add(this.home);
            scan(this.home, set, builder);
            return builder.build();
        }

        private void scan(File file, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        scanDirectory(file, builder);
                    } else {
                        scanJar(file, set, builder);
                    }
                }
            } catch (SecurityException e) {
                Logger logger = ClassPath.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot access ");
                sb.append(file);
                sb.append(": ");
                sb.append(e);
                logger.warning(sb.toString());
            }
        }

        private void scanJar(File file, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator<File> it = ClassPath.getClassPathFromManifest(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        File next = it.next();
                        if (set.add(next.getCanonicalFile())) {
                            scan(next, set, builder);
                        }
                    }
                    scanJarFile(jarFile, builder);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        private void scanJarFile(JarFile jarFile, ImmutableSet.Builder<ResourceInfo> builder) {
            Enumeration<? extends ZipEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                if (!jarEntry.isDirectory() && !jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
                    builder.add((ImmutableSet.Builder<ResourceInfo>) ResourceInfo.of(new File(jarFile.getName()), jarEntry.getName(), this.classloader));
                }
            }
        }

        private void scanDirectory(File file, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            scanDirectory(file, "", hashSet, builder);
        }

        private void scanDirectory(File file, String str, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Logger logger = ClassPath.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot read directory ");
                sb.append(file);
                logger.warning(sb.toString());
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(name);
                        sb2.append("/");
                        scanDirectory(canonicalFile, sb2.toString(), set, builder);
                        set.remove(canonicalFile);
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(name);
                    String obj = sb3.toString();
                    if (!obj.equals("META-INF/MANIFEST.MF")) {
                        builder.add((ImmutableSet.Builder<ResourceInfo>) ResourceInfo.of(file2, obj, this.classloader));
                    }
                }
            }
        }

        public final boolean equals(@CheckForNull Object obj) {
            if (obj instanceof LocationInfo) {
                LocationInfo locationInfo = (LocationInfo) obj;
                return this.home.equals(locationInfo.home) && this.classloader.equals(locationInfo.classloader);
            }
            return false;
        }

        public final int hashCode() {
            return this.home.hashCode();
        }

        public final String toString() {
            return this.home.toString();
        }
    }

    static ImmutableSet<File> getClassPathFromManifest(File file, @CheckForNull Manifest manifest) {
        if (manifest == null) {
            return ImmutableSet.of();
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String str : CLASS_PATH_ATTRIBUTE_SEPARATOR.split(value)) {
                try {
                    URL classPathEntry = getClassPathEntry(file, str);
                    if (classPathEntry.getProtocol().equals("file")) {
                        builder.add((ImmutableSet.Builder) toFile(classPathEntry));
                    }
                } catch (MalformedURLException unused) {
                    Logger logger2 = logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid Class-Path entry: ");
                    sb.append(str);
                    logger2.warning(sb.toString());
                }
            }
        }
        return builder.build();
    }

    static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader classLoader) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            newLinkedHashMap.putAll(getClassPathEntries(parent));
        }
        UnmodifiableIterator<URL> it = getClassLoaderUrls(classLoader).iterator();
        while (it.hasNext()) {
            URL next = it.next();
            if (next.getProtocol().equals("file")) {
                File file = toFile(next);
                if (!newLinkedHashMap.containsKey(file)) {
                    newLinkedHashMap.put(file, classLoader);
                }
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    private static ImmutableList<URL> getClassLoaderUrls(ClassLoader classLoader) {
        if (classLoader instanceof URLClassLoader) {
            return ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs());
        }
        if (classLoader.equals(ClassLoader.getSystemClassLoader())) {
            return parseJavaClassPath();
        }
        return ImmutableList.of();
    }

    static ImmutableList<URL> parseJavaClassPath() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (String str : Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value())) {
            try {
                try {
                    builder.add((ImmutableList.Builder) new File(str).toURI().toURL());
                } catch (SecurityException unused) {
                    builder.add((ImmutableList.Builder) new URL("file", (String) null, new File(str).getAbsolutePath()));
                }
            } catch (MalformedURLException e) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("malformed classpath entry: ");
                sb.append(str);
                logger2.log(level, sb.toString(), (Throwable) e);
            }
        }
        return builder.build();
    }

    static URL getClassPathEntry(File file, String str) throws MalformedURLException {
        return new URL(file.toURI().toURL(), str);
    }

    static String getClassName(String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    static File toFile(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }
}
