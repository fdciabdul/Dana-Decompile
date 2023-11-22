package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class DatabaseTableConfigLoader {
    private static final String CONFIG_FILE_END_MARKER = "# --table-end--";
    private static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
    private static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
    private static final String CONFIG_FILE_START_MARKER = "# --table-start--";
    private static final String FIELD_NAME_DATA_CLASS = "dataClass";
    private static final String FIELD_NAME_TABLE_NAME = "tableName";

    public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader bufferedReader) throws SQLException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            DatabaseTableConfig fromReader = fromReader(bufferedReader);
            if (fromReader == null) {
                return arrayList;
            }
            arrayList.add(fromReader);
        }
    }

    public static <T> DatabaseTableConfig<T> fromReader(BufferedReader bufferedReader) throws SQLException {
        DatabaseTableConfig<T> databaseTableConfig = new DatabaseTableConfig<>();
        boolean z = false;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals(CONFIG_FILE_END_MARKER)) {
                    break;
                } else if (readLine.equals(CONFIG_FILE_FIELDS_START)) {
                    readFields(bufferedReader, databaseTableConfig);
                } else if (readLine.length() != 0 && !readLine.startsWith("#") && !readLine.equals(CONFIG_FILE_START_MARKER)) {
                    String[] split = readLine.split("=", -2);
                    if (split.length != 2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DatabaseTableConfig reading from stream cannot parse line: ");
                        sb.append(readLine);
                        throw new SQLException(sb.toString());
                    }
                    readTableField(databaseTableConfig, split[0], split[1]);
                    z = true;
                }
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", e);
            }
        }
        if (z) {
            return databaseTableConfig;
        }
        return null;
    }

    public static <T> void write(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        try {
            writeConfig(bufferedWriter, databaseTableConfig);
        } catch (IOException e) {
            throw SqlExceptionUtil.create("Could not write config to writer", e);
        }
    }

    private static <T> void writeConfig(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws IOException, SQLException {
        bufferedWriter.append(CONFIG_FILE_START_MARKER);
        bufferedWriter.newLine();
        if (databaseTableConfig.getDataClass() != null) {
            bufferedWriter.append(FIELD_NAME_DATA_CLASS).append('=').append((CharSequence) databaseTableConfig.getDataClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseTableConfig.getTableName() != null) {
            bufferedWriter.append("tableName").append('=').append((CharSequence) databaseTableConfig.getTableName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_START);
        bufferedWriter.newLine();
        if (databaseTableConfig.getFieldConfigs() != null) {
            Iterator<DatabaseFieldConfig> it = databaseTableConfig.getFieldConfigs().iterator();
            while (it.hasNext()) {
                DatabaseFieldConfigLoader.write(bufferedWriter, it.next(), databaseTableConfig.getTableName());
            }
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_END);
        bufferedWriter.newLine();
        bufferedWriter.append(CONFIG_FILE_END_MARKER);
        bufferedWriter.newLine();
    }

    private static <T> void readTableField(DatabaseTableConfig<T> databaseTableConfig, String str, String str2) {
        if (str.equals(FIELD_NAME_DATA_CLASS)) {
            try {
                databaseTableConfig.setDataClass(Class.forName(str2));
            } catch (ClassNotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown class specified for dataClass: ");
                sb.append(str2);
                throw new IllegalArgumentException(sb.toString());
            }
        } else if (str.equals("tableName")) {
            databaseTableConfig.setTableName(str2);
        }
    }

    private static <T> void readFields(BufferedReader bufferedReader, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        DatabaseFieldConfig fromReader;
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals(CONFIG_FILE_FIELDS_END) || (fromReader = DatabaseFieldConfigLoader.fromReader(bufferedReader)) == null) {
                    break;
                }
                arrayList.add(fromReader);
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read next field from config file", e);
            }
        }
        databaseTableConfig.setFieldConfigs(arrayList);
    }
}
