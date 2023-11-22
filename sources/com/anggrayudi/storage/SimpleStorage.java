package com.anggrayudi.storage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.view.ComponentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.files.DialogFolderChooserExtKt;
import com.anggrayudi.storage.callback.CreateFileCallback;
import com.anggrayudi.storage.callback.FilePickerCallback;
import com.anggrayudi.storage.callback.FolderPickerCallback;
import com.anggrayudi.storage.callback.StorageAccessCallback;
import com.anggrayudi.storage.extension.ContextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.file.StorageType;
import id.dana.promocenter.model.PromoActionType;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u00014B\u001d\b\u0016\u0012\u0006\u0010\u0006\u001a\u000200\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b1\u00102B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020-¢\u0006\u0004\b1\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0003\u0010\nJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012¢\u0006\u0004\b\u0003\u0010\u0013J\u0017\u0010\t\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0015R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\u000b8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001cR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u001dX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0014\u0010!\u001a\u0004\u0018\u00010\u001fX\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010#R\u0012\u0010'\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b%\u0010&R\u0012\u0010(\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010&R\u0012\u0010%\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b'\u0010&R\u0012\u0010)\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010,\u001a\u0004\u0018\u00010*X\u0087\u0002¢\u0006\u0006\n\u0004\b)\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010."}, d2 = {"Lcom/anggrayudi/storage/SimpleStorage;", "", "", "PlaceComponentResult", "()V", "", "p0", "Landroid/net/Uri;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILandroid/net/Uri;)V", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(ILandroid/content/Intent;)V", "MyBillsEntityDataFactory", "p2", "getAuthRequestContext", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "", "(Landroid/net/Uri;)Z", "Lcom/anggrayudi/storage/callback/CreateFileCallback;", "Lcom/anggrayudi/storage/callback/CreateFileCallback;", "", "Ljava/lang/String;", "Lcom/anggrayudi/storage/file/StorageType;", "Lcom/anggrayudi/storage/file/StorageType;", "()Landroid/content/Intent;", "Lcom/anggrayudi/storage/callback/FilePickerCallback;", "Lcom/anggrayudi/storage/callback/FilePickerCallback;", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "scheduleImpl", "Ljava/io/File;", "Ljava/io/File;", "getErrorConfigVersion", "moveToNextValue", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "GetContactSyncConfig", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lcom/anggrayudi/storage/ComponentWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "initRecordTimeStamp", "Landroidx/activity/ComponentActivity;", "<init>", "(Landroidx/activity/ComponentActivity;Landroid/os/Bundle;)V", "(Lcom/anggrayudi/storage/ComponentWrapper;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleStorage {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    FolderPickerCallback scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    StorageAccessCallback NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public CreateFileCallback PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public int moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final ComponentWrapper initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public StorageType BuiltInFictitiousFunctionClassFactory;
    public FilePickerCallback getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public int GetContactSyncConfig;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public File getErrorConfigVersion;

    private SimpleStorage(ComponentWrapper componentWrapper) {
        this.initRecordTimeStamp = componentWrapper;
        this.GetContactSyncConfig = 1;
        this.moveToNextValue = 2;
        this.lookAheadTest = 3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 4;
        this.BuiltInFictitiousFunctionClassFactory = StorageType.UNKNOWN;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "");
        this.getErrorConfigVersion = externalStorageDirectory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private SimpleStorage(ComponentActivity componentActivity, Bundle bundle) {
        this(new ComponentActivityWrapper(componentActivity));
        Intrinsics.checkNotNullParameter(componentActivity, "");
        if (bundle != null) {
            PlaceComponentResult(bundle);
        }
        ComponentActivityWrapper componentActivityWrapper = (ComponentActivityWrapper) this.initRecordTimeStamp;
        Intrinsics.checkNotNullParameter(this, "");
        componentActivityWrapper.KClassImpl$Data$declaredNonStaticMembers$2 = this;
    }

    public /* synthetic */ SimpleStorage(ComponentActivity componentActivity, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, (i & 2) != 0 ? null : bundle);
    }

    @JvmName(name = "getAuthRequestContext")
    private final Intent getAuthRequestContext() {
        if (Build.VERSION.SDK_INT >= 29) {
            Object systemService = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2().getSystemService("storage");
            if (systemService != null) {
                Intent createOpenDocumentTreeIntent = ((StorageManager) systemService).getPrimaryStorageVolume().createOpenDocumentTreeIntent();
                Intrinsics.checkNotNullExpressionValue(createOpenDocumentTreeIntent, "");
                return createOpenDocumentTreeIntent;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.storage.StorageManager");
        }
        return Companion.MyBillsEntityDataFactory(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public static /* synthetic */ void getAuthRequestContext(SimpleStorage simpleStorage, int i, StorageType storageType, StorageType storageType2, String str, int i2) {
        Intent authRequestContext;
        Object obj;
        if ((i2 & 1) != 0) {
            i = simpleStorage.GetContactSyncConfig;
        }
        if ((i2 & 2) != 0) {
            storageType = StorageType.EXTERNAL;
        }
        if ((i2 & 4) != 0) {
            storageType2 = StorageType.UNKNOWN;
        }
        if ((i2 & 8) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(storageType, "");
        Intrinsics.checkNotNullParameter(storageType2, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (storageType == StorageType.DATA || storageType2 == StorageType.DATA) {
            throw new IllegalArgumentException("Cannot use StorageType.DATA because it is never available in Storage Access Framework's folder selector.");
        }
        if (Build.VERSION.SDK_INT < 29 && !Companion.getAuthRequestContext(simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2())) {
            StorageAccessCallback storageAccessCallback = simpleStorage.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (storageAccessCallback != null) {
                storageAccessCallback.MyBillsEntityDataFactory();
            }
        } else if (storageType == StorageType.EXTERNAL && storageType2.isExpected(storageType) && Build.VERSION.SDK_INT < 29 && !Companion.PlaceComponentResult()) {
            DocumentFile MyBillsEntityDataFactory = DocumentFileCompat.MyBillsEntityDataFactory(simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), PromoActionType.PRIMARY);
            if (MyBillsEntityDataFactory != null) {
                Uri errorConfigVersion = MyBillsEntityDataFactory.getErrorConfigVersion();
                Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
                simpleStorage.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion);
                StorageAccessCallback storageAccessCallback2 = simpleStorage.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (storageAccessCallback2 != null) {
                    storageAccessCallback2.KClassImpl$Data$declaredNonStaticMembers$2(i, MyBillsEntityDataFactory);
                }
            }
        } else {
            if (storageType != StorageType.SD_CARD || Build.VERSION.SDK_INT < 24) {
                authRequestContext = simpleStorage.getAuthRequestContext();
            } else {
                Object systemService = simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2().getSystemService("storage");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.os.storage.StorageManager");
                }
                List<StorageVolume> storageVolumes = ((StorageManager) systemService).getStorageVolumes();
                Intrinsics.checkNotNullExpressionValue(storageVolumes, "");
                Iterator<T> it = storageVolumes.iterator();
                while (true) {
                    authRequestContext = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((StorageVolume) obj).isRemovable()) {
                        break;
                    }
                }
                StorageVolume storageVolume = (StorageVolume) obj;
                if (storageVolume != null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        authRequestContext = storageVolume.createOpenDocumentTreeIntent();
                    } else if (storageVolume.isPrimary()) {
                        authRequestContext = Companion.MyBillsEntityDataFactory(simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2());
                    } else {
                        authRequestContext = storageVolume.createAccessIntent(null);
                    }
                }
                if (authRequestContext == null) {
                    authRequestContext = Companion.MyBillsEntityDataFactory(simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2());
                }
            }
            if (!simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, i)) {
                StorageAccessCallback storageAccessCallback3 = simpleStorage.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (storageAccessCallback3 != null) {
                    storageAccessCallback3.getAuthRequestContext(authRequestContext);
                    return;
                }
                return;
            }
            simpleStorage.GetContactSyncConfig = i;
            simpleStorage.PlaceComponentResult();
            simpleStorage.BuiltInFictitiousFunctionClassFactory = storageType2;
            simpleStorage.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static /* synthetic */ void PlaceComponentResult(final SimpleStorage simpleStorage) {
        Intent authRequestContext;
        FolderPickerCallback folderPickerCallback;
        final int i = simpleStorage.moveToNextValue;
        simpleStorage.moveToNextValue = i;
        simpleStorage.PlaceComponentResult();
        if (Build.VERSION.SDK_INT < 21) {
            ?? r5 = 0;
            DialogCallbackExtKt.onCancel(MaterialDialog.negativeButton$default(DialogFolderChooserExtKt.folderChooser$default(new MaterialDialog(simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), r5, 2, r5), simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), simpleStorage.getErrorConfigVersion, null, false, 0, true, null, new Function2<MaterialDialog, File, Unit>() { // from class: com.anggrayudi.storage.SimpleStorage$openFolderPicker$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog, File file) {
                    invoke2(materialDialog, file);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog, File file) {
                    Intrinsics.checkNotNullParameter(materialDialog, "");
                    Intrinsics.checkNotNullParameter(file, "");
                    SimpleStorage.this.getErrorConfigVersion = file;
                    FolderPickerCallback folderPickerCallback2 = SimpleStorage.this.scheduleImpl;
                    if (folderPickerCallback2 != null) {
                        int i2 = i;
                        DocumentFile KClassImpl$Data$declaredNonStaticMembers$2 = DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(file);
                        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                        folderPickerCallback2.getAuthRequestContext(i2, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                }
            }, 92, null), 17039360, null, new Function1<MaterialDialog, Unit>() { // from class: com.anggrayudi.storage.SimpleStorage$openFolderPicker$3
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                    invoke2(materialDialog);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog) {
                    Intrinsics.checkNotNullParameter(materialDialog, "");
                    materialDialog.cancel();
                }
            }, 2, null), new Function1<MaterialDialog, Unit>() { // from class: com.anggrayudi.storage.SimpleStorage$openFolderPicker$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                    invoke2(materialDialog);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog) {
                    Intrinsics.checkNotNullParameter(materialDialog, "");
                    FolderPickerCallback folderPickerCallback2 = SimpleStorage.this.scheduleImpl;
                    if (folderPickerCallback2 != null) {
                        folderPickerCallback2.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            }).show();
        } else if (Build.VERSION.SDK_INT > 28 || Companion.getAuthRequestContext(simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2())) {
            if (Build.VERSION.SDK_INT < 30) {
                authRequestContext = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                authRequestContext = simpleStorage.getAuthRequestContext();
            }
            if (simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, i) || (folderPickerCallback = simpleStorage.scheduleImpl) == null) {
                return;
            }
            folderPickerCallback.MyBillsEntityDataFactory(authRequestContext);
        } else {
            FolderPickerCallback folderPickerCallback2 = simpleStorage.scheduleImpl;
            if (folderPickerCallback2 != null) {
                folderPickerCallback2.getAuthRequestContext();
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SimpleStorage simpleStorage, String[] strArr) {
        Intent intent;
        FilePickerCallback filePickerCallback;
        int i = simpleStorage.lookAheadTest;
        Intrinsics.checkNotNullParameter(strArr, "");
        simpleStorage.lookAheadTest = i;
        simpleStorage.PlaceComponentResult();
        if (Build.VERSION.SDK_INT < 21) {
            intent = new Intent("android.intent.action.GET_CONTENT");
        } else {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        }
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        if (strArr.length > 1) {
            intent.setType("*/*").putExtra("android.intent.extra.MIME_TYPES", strArr);
        } else {
            String str = (String) ArraysKt.firstOrNull(strArr);
            intent.setType(str != null ? str : "*/*");
        }
        if (simpleStorage.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(intent, i) || (filePickerCallback = simpleStorage.getAuthRequestContext) == null) {
            return;
        }
        filePickerCallback.BuiltInFictitiousFunctionClassFactory(intent);
    }

    public final void getAuthRequestContext(int p0, int p1, Intent p2) {
        Uri data;
        PlaceComponentResult();
        if (p0 == this.GetContactSyncConfig) {
            if (p1 == -1) {
                data = p2 != null ? p2.getData() : null;
                if (data == null) {
                    return;
                }
                PlaceComponentResult(p0, data);
                return;
            }
            StorageAccessCallback storageAccessCallback = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (storageAccessCallback != null) {
                storageAccessCallback.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } else if (p0 == this.moveToNextValue) {
            if (p1 == -1) {
                data = p2 != null ? p2.getData() : null;
                if (data == null) {
                    return;
                }
                MyBillsEntityDataFactory(p0, data);
                return;
            }
            FolderPickerCallback folderPickerCallback = this.scheduleImpl;
            if (folderPickerCallback != null) {
                folderPickerCallback.BuiltInFictitiousFunctionClassFactory();
            }
        } else if (p0 == this.lookAheadTest) {
            if (p1 == -1) {
                if (p2 == null) {
                    return;
                }
                BuiltInFictitiousFunctionClassFactory(p0, p2);
                return;
            }
            FilePickerCallback filePickerCallback = this.getAuthRequestContext;
            if (filePickerCallback != null) {
                filePickerCallback.MyBillsEntityDataFactory();
            }
        } else if (p0 == this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            data = p2 != null ? p2.getData() : null;
            if (data != null) {
                KClassImpl$Data$declaredNonStaticMembers$2(p0, data);
                return;
            }
            CreateFileCallback createFileCallback = this.PlaceComponentResult;
            if (createFileCallback != null) {
                createFileCallback.MyBillsEntityDataFactory();
            }
        }
    }

    public final void PlaceComponentResult(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = p0.getString("com.anggrayudi.storage.lastVisitedFolder");
        if (string != null) {
            this.getErrorConfigVersion = new File(string);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getString("com.anggrayudi.storage.expectedBasePathForAccessRequest");
        this.BuiltInFictitiousFunctionClassFactory = StorageType.values()[p0.getInt("com.anggrayudi.storage.expectedStorageTypeForAccessRequest")];
        this.GetContactSyncConfig = p0.getInt("com.anggrayudi.storage.requestCodeStorageAccess");
        PlaceComponentResult();
        this.moveToNextValue = p0.getInt("com.anggrayudi.storage.requestCodeFolderPicker");
        PlaceComponentResult();
        this.lookAheadTest = p0.getInt("com.anggrayudi.storage.requestCodeFilePicker");
        PlaceComponentResult();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0.getInt("com.anggrayudi.storage.requestCodeCreateFile");
        PlaceComponentResult();
        if ((this.initRecordTimeStamp instanceof FragmentWrapper) && p0.containsKey("com.anggrayudi.storage.requestCodeFragmentPicker")) {
            ((FragmentWrapper) this.initRecordTimeStamp).getAuthRequestContext = p0.getInt("com.anggrayudi.storage.requestCodeFragmentPicker");
        }
    }

    private final void PlaceComponentResult() {
        if (SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(this.lookAheadTest), Integer.valueOf(this.moveToNextValue), Integer.valueOf(this.GetContactSyncConfig), Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0)}).size() >= 4) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Request codes must be unique. File picker=");
        sb.append(this.lookAheadTest);
        sb.append(", Folder picker=");
        sb.append(this.moveToNextValue);
        sb.append(", Storage access=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", Create file=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        throw new IllegalArgumentException(sb.toString());
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\fR\u0011\u0010\u000f\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0011"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorage$Companion;", "", "Landroid/content/Context;", "p0", "", "PlaceComponentResult", "(Landroid/content/Context;)V", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/content/Intent;", "", "getAuthRequestContext", "(Landroid/content/Context;)Z", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "()Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        public static String KClassImpl$Data$declaredNonStaticMembers$2() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "");
            return absolutePath;
        }

        @JvmName(name = "PlaceComponentResult")
        public static boolean PlaceComponentResult() {
            return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26) {
                DocumentFile MyBillsEntityDataFactory = ContextUtils.MyBillsEntityDataFactory(p0, DocumentFileCompat.MyBillsEntityDataFactory(PromoActionType.PRIMARY));
                intent.putExtra("android.provider.extra.INITIAL_URI", MyBillsEntityDataFactory == null ? null : MyBillsEntityDataFactory.getErrorConfigVersion());
            }
            return intent;
        }

        @JvmStatic
        public static boolean getAuthRequestContext(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && BuiltInFictitiousFunctionClassFactory(p0);
        }

        @JvmStatic
        private static boolean BuiltInFictitiousFunctionClassFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, "android.permission.READ_EXTERNAL_STORAGE") == 0;
        }

        @JvmStatic
        public static void PlaceComponentResult(final Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ThreadsKt.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new Function0<Unit>() { // from class: com.anggrayudi.storage.SimpleStorage$Companion$cleanupRedundantUriPermissions$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:38:0x0047 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x001c A[SYNTHETIC] */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2() {
                    /*
                        r10 = this;
                        android.content.Context r0 = r1
                        android.content.ContentResolver r0 = r0.getContentResolver()
                        java.util.List r1 = r0.getPersistedUriPermissions()
                        java.lang.String r2 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                        java.lang.Iterable r1 = (java.lang.Iterable) r1
                        java.util.ArrayList r3 = new java.util.ArrayList
                        r3.<init>()
                        java.util.Collection r3 = (java.util.Collection) r3
                        java.util.Iterator r1 = r1.iterator()
                    L1c:
                        boolean r4 = r1.hasNext()
                        if (r4 == 0) goto L4b
                        java.lang.Object r4 = r1.next()
                        r5 = r4
                        android.content.UriPermission r5 = (android.content.UriPermission) r5
                        boolean r6 = r5.isReadPermission()
                        if (r6 == 0) goto L44
                        boolean r6 = r5.isWritePermission()
                        if (r6 == 0) goto L44
                        android.net.Uri r5 = r5.getUri()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
                        boolean r5 = com.anggrayudi.storage.extension.UriUtils.BuiltInFictitiousFunctionClassFactory(r5)
                        if (r5 == 0) goto L44
                        r5 = 1
                        goto L45
                    L44:
                        r5 = 0
                    L45:
                        if (r5 == 0) goto L1c
                        r3.add(r4)
                        goto L1c
                    L4b:
                        java.util.List r3 = (java.util.List) r3
                        java.lang.Iterable r3 = (java.lang.Iterable) r3
                        java.util.ArrayList r1 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
                        r1.<init>(r4)
                        java.util.Collection r1 = (java.util.Collection) r1
                        java.util.Iterator r3 = r3.iterator()
                    L60:
                        boolean r4 = r3.hasNext()
                        if (r4 == 0) goto L74
                        java.lang.Object r4 = r3.next()
                        android.content.UriPermission r4 = (android.content.UriPermission) r4
                        android.net.Uri r4 = r4.getUri()
                        r1.add(r4)
                        goto L60
                    L74:
                        java.util.List r1 = (java.util.List) r1
                        android.content.Context r3 = r1
                        java.lang.Iterable r1 = (java.lang.Iterable) r1
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        java.util.Collection r4 = (java.util.Collection) r4
                        java.util.Iterator r5 = r1.iterator()
                    L85:
                        boolean r6 = r5.hasNext()
                        r7 = 2
                        java.lang.String r8 = "/tree/"
                        r9 = 0
                        if (r6 == 0) goto La5
                        java.lang.Object r6 = r5.next()
                        android.net.Uri r6 = (android.net.Uri) r6
                        java.lang.String r6 = r6.getPath()
                        if (r6 == 0) goto L9f
                        java.lang.String r9 = kotlin.text.StringsKt.substringAfter$default(r6, r8, r9, r7, r9)
                    L9f:
                        if (r9 == 0) goto L85
                        r4.add(r9)
                        goto L85
                    La5:
                        java.util.List r4 = (java.util.List) r4
                        java.util.Collection r4 = (java.util.Collection) r4
                        java.util.List r3 = com.anggrayudi.storage.file.DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(r3, r4)
                        android.content.Context r4 = r1
                        java.util.Iterator r1 = r1.iterator()
                    Lb3:
                        boolean r5 = r1.hasNext()
                        if (r5 == 0) goto Le4
                        java.lang.Object r5 = r1.next()
                        android.net.Uri r5 = (android.net.Uri) r5
                        java.lang.String r6 = r5.getPath()
                        if (r6 != 0) goto Lc6
                        r6 = r2
                    Lc6:
                        java.lang.String r6 = kotlin.text.StringsKt.substringAfter$default(r6, r8, r9, r7, r9)
                        java.lang.String r6 = com.anggrayudi.storage.file.DocumentFileCompat.getAuthRequestContext(r4, r6)
                        boolean r6 = r3.contains(r6)
                        if (r6 != 0) goto Lb3
                        r6 = 3
                        r0.releasePersistableUriPermission(r5, r6)
                        java.lang.String r6 = "Removed redundant URI permission => "
                        java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
                        java.lang.String r6 = "SimpleStorage"
                        com.fullstory.instrumentation.InstrumentInjector.log_d(r6, r5)
                        goto Lb3
                    Le4:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.SimpleStorage$Companion$cleanupRedundantUriPermissions$1.invoke2():void");
                }
            });
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, Uri p1) {
        CreateFileCallback createFileCallback;
        DocumentFile authRequestContext = DocumentFileCompat.getAuthRequestContext(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), p1);
        if (authRequestContext == null || (createFileCallback = this.PlaceComponentResult) == null) {
            return;
        }
        createFileCallback.getAuthRequestContext(p0, authRequestContext);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if ((!r5.isEmpty()) != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(int r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.SimpleStorage.BuiltInFictitiousFunctionClassFactory(int, android.content.Intent):void");
    }

    private final void MyBillsEntityDataFactory(int p0, Uri p1) {
        DocumentFile MyBillsEntityDataFactory = ContextUtils.MyBillsEntityDataFactory(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), p1);
        String KClassImpl$Data$declaredNonStaticMembers$2 = UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(p1, this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2());
        StorageType.Companion companion = StorageType.INSTANCE;
        StorageType PlaceComponentResult = StorageType.Companion.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
        if (MyBillsEntityDataFactory == null || !DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2())) {
            FolderPickerCallback folderPickerCallback = this.scheduleImpl;
            if (folderPickerCallback != null) {
                folderPickerCallback.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
                return;
            }
            return;
        }
        String obj = p1.toString();
        if ((Intrinsics.areEqual(obj, "content://com.android.providers.downloads.documents/tree/downloads") || Intrinsics.areEqual(obj, "content://com.android.externalstorage.documents/tree/home%3A")) || (DocumentFileCompat.MyBillsEntityDataFactory(p1) && (((Build.VERSION.SDK_INT < 24 && PlaceComponentResult == StorageType.SD_CARD) || Build.VERSION.SDK_INT == 29) && !DocumentFileCompat.PlaceComponentResult(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), KClassImpl$Data$declaredNonStaticMembers$2)))) {
            KClassImpl$Data$declaredNonStaticMembers$2(p1);
        }
        if ((Build.VERSION.SDK_INT < 29 && PlaceComponentResult == StorageType.EXTERNAL) || ((Build.VERSION.SDK_INT >= 30 && KClassImpl$Data$declaredNonStaticMembers$2(p1)) || ((DocumentFileUtils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2()) && (UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(p1) || !UriUtils.BuiltInFictitiousFunctionClassFactory(p1))) || DocumentFileCompat.PlaceComponentResult(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), KClassImpl$Data$declaredNonStaticMembers$2)))) {
            FolderPickerCallback folderPickerCallback2 = this.scheduleImpl;
            if (folderPickerCallback2 != null) {
                folderPickerCallback2.getAuthRequestContext(p0, MyBillsEntityDataFactory);
                return;
            }
            return;
        }
        FolderPickerCallback folderPickerCallback3 = this.scheduleImpl;
        if (folderPickerCallback3 != null) {
            folderPickerCallback3.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(com.anggrayudi.storage.file.DocumentFileUtils.MyBillsEntityDataFactory(r2, r9.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2()), r9.KClassImpl$Data$declaredNonStaticMembers$2) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(int r10, android.net.Uri r11) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.SimpleStorage.PlaceComponentResult(int, android.net.Uri):void");
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri p0) {
        try {
            this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2().getContentResolver().takePersistableUriPermission(p0, 3);
            Context applicationContext = this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "");
            Companion.PlaceComponentResult(applicationContext);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
