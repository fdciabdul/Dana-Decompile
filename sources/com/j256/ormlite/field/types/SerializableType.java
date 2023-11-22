package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class SerializableType extends BaseDataType {
    private static final SerializableType singleTon = new SerializableType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return true;
    }

    public static SerializableType getSingleton() {
        return singleTon;
    }

    private SerializableType() {
        super(SqlType.SERIALIZABLE);
    }

    protected SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBytes(i);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        Throwable th;
        byte[] bArr = (byte[]) obj;
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                Object readObject = objectInputStream2.readObject();
                IOUtils.closeQuietly(objectInputStream2);
                return readObject;
            } catch (Exception e) {
                e = e;
                objectInputStream = objectInputStream2;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not read serialized object from byte array: ");
                    sb.append(Arrays.toString(bArr));
                    sb.append("(len ");
                    sb.append(bArr.length);
                    sb.append(")");
                    throw SqlExceptionUtil.create(sb.toString(), e);
                } catch (Throwable th2) {
                    objectInputStream2 = objectInputStream;
                    th = th2;
                    th = th;
                    objectInputStream = objectInputStream2;
                    IOUtils.closeQuietly(objectInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                objectInputStream = objectInputStream2;
                IOUtils.closeQuietly(objectInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th4) {
            th = th4;
            IOUtils.closeQuietly(objectInputStream);
            throw th;
        }
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(null);
                    return byteArray;
                } catch (Exception e) {
                    e = e;
                    objectOutputStream2 = objectOutputStream;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not write serialized object to byte array: ");
                    sb.append(obj);
                    throw SqlExceptionUtil.create(sb.toString(), e);
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                objectOutputStream = objectOutputStream2;
                th = th3;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }
}
