package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    public final InternalRewinder getAuthRequestContext;

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final void MyBillsEntityDataFactory() {
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.getAuthRequestContext = new InternalRewinder(parcelFileDescriptor);
    }

    /* loaded from: classes3.dex */
    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final /* synthetic */ DataRewinder<ParcelFileDescriptor> BuiltInFictitiousFunctionClassFactory(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final Class<ParcelFileDescriptor> KClassImpl$Data$declaredNonStaticMembers$2() {
            return ParcelFileDescriptor.class;
        }
    }

    /* loaded from: classes3.dex */
    public static final class InternalRewinder {
        private final ParcelFileDescriptor MyBillsEntityDataFactory;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.MyBillsEntityDataFactory = parcelFileDescriptor;
        }

        public final ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.MyBillsEntityDataFactory.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.MyBillsEntityDataFactory;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final /* synthetic */ ParcelFileDescriptor PlaceComponentResult() throws IOException {
        return this.getAuthRequestContext.rewind();
    }
}
