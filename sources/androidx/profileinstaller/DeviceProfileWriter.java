package androidx.profileinstaller;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public class DeviceProfileWriter {
    private final File BuiltInFictitiousFunctionClassFactory;
    private byte[] DatabaseTableConfigUtil;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Executor NetworkUserEntityData$$ExternalSyntheticLambda0;
    final ProfileInstaller.DiagnosticsCallback PlaceComponentResult;
    private final AssetManager getAuthRequestContext;
    private final String getErrorConfigVersion;
    private final String lookAheadTest;
    private DexProfileData[] scheduleImpl;
    private boolean moveToNextValue = false;
    private final byte[] MyBillsEntityDataFactory = getAuthRequestContext();

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, String str2, String str3, File file) {
        this.getAuthRequestContext = assetManager;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = executor;
        this.PlaceComponentResult = diagnosticsCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.lookAheadTest = str2;
        this.getErrorConfigVersion = str3;
        this.BuiltInFictitiousFunctionClassFactory = file;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.MyBillsEntityDataFactory == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, 3, Integer.valueOf(Build.VERSION.SDK_INT)));
            return false;
        } else if (this.BuiltInFictitiousFunctionClassFactory.canWrite()) {
            this.moveToNextValue = true;
            return true;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, 4, null));
            return false;
        }
    }

    public final DeviceProfileWriter KClassImpl$Data$declaredNonStaticMembers$2() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.scheduleImpl;
        byte[] bArr = this.MyBillsEntityDataFactory;
        if (dexProfileDataArr != null && bArr != null) {
            if (this.moveToNextValue) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(7, e);
                } catch (IllegalStateException e2) {
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(8, e2);
                }
                try {
                    ProfileTranscoder.MyBillsEntityDataFactory(byteArrayOutputStream, bArr);
                    if (!ProfileTranscoder.getAuthRequestContext(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(5, null);
                        this.scheduleImpl = null;
                        byteArrayOutputStream.close();
                        return this;
                    }
                    this.DatabaseTableConfigUtil = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    this.scheduleImpl = null;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
            }
        }
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.profileinstaller.DexProfileData[], java.lang.Object, byte[]] */
    public final boolean PlaceComponentResult() {
        byte[] bArr = this.DatabaseTableConfigUtil;
        if (bArr == null) {
            return false;
        }
        if (this.moveToNextValue) {
            ?? r2 = 0;
            try {
                try {
                    try {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(this.BuiltInFictitiousFunctionClassFactory);
                            try {
                                Encoding.PlaceComponentResult(byteArrayInputStream, fileOutputStream);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, 1, r2));
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } catch (Throwable th) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, 6, e));
                        return false;
                    }
                } catch (IOException e2) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, 7, e2));
                    return false;
                }
            } finally {
                this.DatabaseTableConfigUtil = null;
                this.scheduleImpl = null;
            }
        }
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    private static byte[] getAuthRequestContext() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        switch (Build.VERSION.SDK_INT) {
            case 24:
            case 25:
                return ProfileVersion.BuiltInFictitiousFunctionClassFactory;
            case 26:
                return ProfileVersion.getAuthRequestContext;
            case 27:
                return ProfileVersion.PlaceComponentResult;
            case 28:
            case 29:
            case 30:
                return ProfileVersion.lookAheadTest;
            case 31:
                return ProfileVersion.moveToNextValue;
            default:
                return null;
        }
    }

    private static boolean getErrorConfigVersion() {
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        return i == 24 || i == 25 || i == 31;
    }

    public final DeviceProfileWriter MyBillsEntityDataFactory() {
        AssetFileDescriptor openFd;
        if (this.moveToNextValue) {
            if (this.MyBillsEntityDataFactory == null) {
                return this;
            }
            try {
                openFd = this.getAuthRequestContext.openFd(this.lookAheadTest);
            } catch (FileNotFoundException e) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(6, e);
            } catch (IOException e2) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(7, e2);
            } catch (IllegalStateException e3) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(8, e3);
            }
            try {
                FileInputStream createInputStream = openFd.createInputStream();
                try {
                    this.scheduleImpl = ProfileTranscoder.MyBillsEntityDataFactory(createInputStream, ProfileTranscoder.getAuthRequestContext(createInputStream, ProfileTranscoder.KClassImpl$Data$declaredNonStaticMembers$2), this.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openFd != null) {
                        openFd.close();
                    }
                    DexProfileData[] dexProfileDataArr = this.scheduleImpl;
                    if (dexProfileDataArr != null && getErrorConfigVersion()) {
                        try {
                            openFd = this.getAuthRequestContext.openFd(this.getErrorConfigVersion);
                            try {
                                createInputStream = openFd.createInputStream();
                                try {
                                    this.scheduleImpl = ProfileTranscoder.BuiltInFictitiousFunctionClassFactory(createInputStream, ProfileTranscoder.getAuthRequestContext(createInputStream, ProfileTranscoder.BuiltInFictitiousFunctionClassFactory), this.MyBillsEntityDataFactory, dexProfileDataArr);
                                    if (createInputStream != null) {
                                        createInputStream.close();
                                    }
                                    if (openFd != null) {
                                        openFd.close();
                                    }
                                    return this;
                                } finally {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable th) {
                                            th.addSuppressed(th);
                                        }
                                    }
                                }
                            } finally {
                            }
                        } catch (FileNotFoundException e4) {
                            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(9, e4);
                        } catch (IOException e5) {
                            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(7, e5);
                        } catch (IllegalStateException e6) {
                            this.scheduleImpl = null;
                            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(8, e6);
                        }
                    }
                    return this;
                } finally {
                }
            } finally {
            }
        }
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }
}
