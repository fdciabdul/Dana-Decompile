package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
class VersionedParcelStream extends VersionedParcel {
    private static final Charset getErrorConfigVersion = Charset.forName("UTF-16");
    int KClassImpl$Data$declaredNonStaticMembers$2;
    private FieldBuffer NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final DataOutputStream NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    int PlaceComponentResult;
    private final DataInputStream initRecordTimeStamp;
    private DataInputStream lookAheadTest;
    private int moveToNextValue;
    private DataOutputStream scheduleImpl;

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean MyBillsEntityDataFactory() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final <T extends Parcelable> T getErrorConfigVersion() {
        return null;
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.moveToNextValue = -1;
        this.PlaceComponentResult = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (VersionedParcelStream.this.PlaceComponentResult != -1 && VersionedParcelStream.this.KClassImpl$Data$declaredNonStaticMembers$2 >= VersionedParcelStream.this.PlaceComponentResult) {
                    throw new IOException();
                }
                int read = super.read();
                VersionedParcelStream.this.KClassImpl$Data$declaredNonStaticMembers$2++;
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (VersionedParcelStream.this.PlaceComponentResult != -1 && VersionedParcelStream.this.KClassImpl$Data$declaredNonStaticMembers$2 >= VersionedParcelStream.this.PlaceComponentResult) {
                    throw new IOException();
                }
                int read = super.read(bArr, i, i2);
                if (read > 0) {
                    VersionedParcelStream.this.KClassImpl$Data$declaredNonStaticMembers$2 += read;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                if (VersionedParcelStream.this.PlaceComponentResult != -1 && VersionedParcelStream.this.KClassImpl$Data$declaredNonStaticMembers$2 >= VersionedParcelStream.this.PlaceComponentResult) {
                    throw new IOException();
                }
                long skip = super.skip(j);
                if (skip > 0) {
                    VersionedParcelStream.this.KClassImpl$Data$declaredNonStaticMembers$2 += (int) skip;
                }
                return skip;
            }
        }) : null;
        this.initRecordTimeStamp = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = dataOutputStream;
        this.lookAheadTest = dataInputStream;
        this.scheduleImpl = dataOutputStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(boolean z, boolean z2) {
        if (!z) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        FieldBuffer fieldBuffer = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.PlaceComponentResult.size() != 0) {
                    FieldBuffer fieldBuffer2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    fieldBuffer2.KClassImpl$Data$declaredNonStaticMembers$2.flush();
                    int size = fieldBuffer2.PlaceComponentResult.size();
                    fieldBuffer2.getAuthRequestContext.writeInt((fieldBuffer2.MyBillsEntityDataFactory << 16) | (size >= 65535 ? 65535 : size));
                    if (size >= 65535) {
                        fieldBuffer2.getAuthRequestContext.writeInt(size);
                    }
                    fieldBuffer2.PlaceComponentResult.writeTo(fieldBuffer2.getAuthRequestContext);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected final VersionedParcel getAuthRequestContext() {
        return new VersionedParcelStream(this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean getAuthRequestContext(int i) {
        while (true) {
            try {
                int i2 = this.moveToNextValue;
                if (i2 == i) {
                    return true;
                }
                if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                    return false;
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 < this.PlaceComponentResult) {
                    this.initRecordTimeStamp.skip(r2 - r1);
                }
                this.PlaceComponentResult = -1;
                int readInt = this.initRecordTimeStamp.readInt();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                int i3 = readInt & 65535;
                if (i3 == 65535) {
                    i3 = this.initRecordTimeStamp.readInt();
                }
                this.moveToNextValue = (readInt >> 16) & 65535;
                this.PlaceComponentResult = i3;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void MyBillsEntityDataFactory(int i) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        FieldBuffer fieldBuffer = new FieldBuffer(i, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fieldBuffer;
        this.scheduleImpl = fieldBuffer.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void PlaceComponentResult(byte[] bArr) {
        try {
            if (bArr != null) {
                this.scheduleImpl.writeInt(bArr.length);
                this.scheduleImpl.write(bArr);
                return;
            }
            this.scheduleImpl.writeInt(-1);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected final void PlaceComponentResult(CharSequence charSequence) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        try {
            this.scheduleImpl.writeInt(i);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            if (str != null) {
                byte[] bytes = str.getBytes(getErrorConfigVersion);
                this.scheduleImpl.writeInt(bytes.length);
                this.scheduleImpl.write(bytes);
                return;
            }
            this.scheduleImpl.writeInt(-1);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void MyBillsEntityDataFactory(boolean z) {
        try {
            this.scheduleImpl.writeBoolean(z);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(Parcelable parcelable) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int scheduleImpl() {
        try {
            return this.lookAheadTest.readInt();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String moveToNextValue() {
        try {
            int readInt = this.lookAheadTest.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                this.lookAheadTest.readFully(bArr);
                return new String(bArr, getErrorConfigVersion);
            }
            return null;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] PlaceComponentResult() {
        try {
            int readInt = this.lookAheadTest.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                this.lookAheadTest.readFully(bArr);
                return bArr;
            }
            return null;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        try {
            return this.lookAheadTest.readBoolean();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class FieldBuffer {
        final DataOutputStream KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        final ByteArrayOutputStream PlaceComponentResult;
        final DataOutputStream getAuthRequestContext;

        FieldBuffer(int i, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.PlaceComponentResult = byteArrayOutputStream;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DataOutputStream(byteArrayOutputStream);
            this.MyBillsEntityDataFactory = i;
            this.getAuthRequestContext = dataOutputStream;
        }
    }
}
