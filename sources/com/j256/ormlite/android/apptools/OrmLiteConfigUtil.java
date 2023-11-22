package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes8.dex */
public class OrmLiteConfigUtil {
    protected static final String RAW_DIR_NAME = "raw";
    protected static final String RESOURCE_DIR_NAME = "res";
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    protected static int maxFindSourceLevel = 20;

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            throw new IllegalArgumentException("Main can take a single file-name argument.");
        }
        writeConfigFile(strArr[0]);
    }

    public static void writeConfigFile(String str) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, new File("."), 0);
        writeConfigFile(str, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(String str, Class<?>[] clsArr) throws SQLException, IOException {
        File findRawDir = findRawDir(new File("."));
        if (findRawDir == null) {
            System.err.println("Could not find raw directory which is typically in the res directory");
        } else {
            writeConfigFile(new File(findRawDir, str), clsArr);
        }
    }

    public static void writeConfigFile(File file) throws SQLException, IOException {
        writeConfigFile(file, new File("."));
    }

    public static void writeConfigFile(File file, File file2) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file2, 0);
        writeConfigFile(file, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(File file, Class<?>[] clsArr) throws SQLException, IOException {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Writing configurations to ");
        sb.append(file.getAbsolutePath());
        printStream.println(sb.toString());
        writeConfigFile(new FileOutputStream(file), clsArr);
    }

    public static void writeConfigFile(OutputStream outputStream, File file) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file, 0);
        writeConfigFile(outputStream, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(OutputStream outputStream, Class<?>[] clsArr) throws SQLException, IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 4096);
        try {
            writeHeader(bufferedWriter);
            for (Class<?> cls : clsArr) {
                writeConfigForTable(bufferedWriter, cls);
            }
            System.out.println("Done.");
        } finally {
            bufferedWriter.close();
        }
    }

    protected static File findRawDir(File file) {
        for (int i = 0; file != null && i < 20; i++) {
            File findResRawDir = findResRawDir(file);
            if (findResRawDir != null) {
                return findResRawDir;
            }
            file = file.getParentFile();
        }
        return null;
    }

    private static void writeHeader(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.append('#');
        bufferedWriter.newLine();
        bufferedWriter.append("# generated on ").append((CharSequence) new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
        bufferedWriter.newLine();
        bufferedWriter.append('#');
        bufferedWriter.newLine();
    }

    private static void findAnnotatedClasses(List<Class<?>> list, File file, int i) throws SQLException, IOException {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                if (i < maxFindSourceLevel) {
                    findAnnotatedClasses(list, file2, i + 1);
                }
            } else if (file2.getName().endsWith(".java")) {
                String packageOfClass = getPackageOfClass(file2);
                if (packageOfClass == null) {
                    PrintStream printStream = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not find package name for: ");
                    sb.append(file2);
                    printStream.println(sb.toString());
                } else {
                    String substring = file2.getName().substring(0, r6.length() - 5);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(packageOfClass);
                    sb2.append(".");
                    sb2.append(substring);
                    try {
                        Class<?> cls = Class.forName(sb2.toString());
                        if (classHasAnnotations(cls)) {
                            list.add(cls);
                        }
                        try {
                            for (Class<?> cls2 : cls.getDeclaredClasses()) {
                                if (classHasAnnotations(cls2)) {
                                    list.add(cls2);
                                }
                            }
                        } catch (Throwable th) {
                            PrintStream printStream2 = System.err;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Could not load inner classes for: ");
                            sb3.append(cls);
                            printStream2.println(sb3.toString());
                            PrintStream printStream3 = System.err;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("     ");
                            sb4.append(th);
                            printStream3.println(sb4.toString());
                        }
                    } catch (Throwable th2) {
                        PrintStream printStream4 = System.err;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Could not load class file for: ");
                        sb5.append(file2);
                        printStream4.println(sb5.toString());
                        PrintStream printStream5 = System.err;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("     ");
                        sb6.append(th2);
                        printStream5.println(sb6.toString());
                    }
                }
            }
        }
    }

    private static void writeConfigForTable(BufferedWriter bufferedWriter, Class<?> cls) throws SQLException, IOException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                for (Field field : cls2.getDeclaredFields()) {
                    DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(databaseType, extractTableName, field);
                    if (fromField != null) {
                        arrayList.add(fromField);
                    }
                }
            } catch (Error e) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append("Skipping ");
                sb.append(cls);
                sb.append(" because we got an error finding its definition: ");
                sb.append(e.getMessage());
                printStream.println(sb.toString());
                return;
            }
        }
        if (arrayList.isEmpty()) {
            PrintStream printStream2 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Skipping ");
            sb2.append(cls);
            sb2.append(" because no annotated fields found");
            printStream2.println(sb2.toString());
            return;
        }
        DatabaseTableConfigLoader.write(bufferedWriter, new DatabaseTableConfig(cls, extractTableName, arrayList));
        bufferedWriter.append("#################################");
        bufferedWriter.newLine();
        PrintStream printStream3 = System.out;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wrote config for ");
        sb3.append(cls);
        printStream3.println(sb3.toString());
    }

    private static boolean classHasAnnotations(Class<?> cls) {
        while (cls != null) {
            if (cls.getAnnotation(DatabaseTable.class) != null) {
                return true;
            }
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.getAnnotation(DatabaseField.class) != null || field.getAnnotation(ForeignCollectionField.class) != null) {
                        return true;
                    }
                }
                try {
                    cls = cls.getSuperclass();
                } catch (Throwable th) {
                    PrintStream printStream = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not get super class for: ");
                    sb.append(cls);
                    printStream.println(sb.toString());
                    PrintStream printStream2 = System.err;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("     ");
                    sb2.append(th);
                    printStream2.println(sb2.toString());
                    return false;
                }
            } catch (Throwable th2) {
                PrintStream printStream3 = System.err;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Could not load get delcared fields from: ");
                sb3.append(cls);
                printStream3.println(sb3.toString());
                PrintStream printStream4 = System.err;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("     ");
                sb4.append(th2);
                printStream4.println(sb4.toString());
            }
        }
        return false;
    }

    private static String getPackageOfClass(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.contains("package")) {
                        String[] split = readLine.split("[ \t;]");
                        if (split.length > 1 && split[0].equals("package")) {
                            return split[1];
                        }
                    }
                } else {
                    bufferedReader.close();
                    return null;
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    private static File findResRawDir(File file) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().equals(RESOURCE_DIR_NAME) && file2.isDirectory()) {
                File[] listFiles = file2.listFiles(new FileFilter() { // from class: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.1
                    @Override // java.io.FileFilter
                    public final boolean accept(File file3) {
                        return file3.getName().equals(OrmLiteConfigUtil.RAW_DIR_NAME) && file3.isDirectory();
                    }
                });
                if (listFiles.length == 1) {
                    return listFiles[0];
                }
            }
        }
        return null;
    }
}
