package id.dana.data.uploadfiles.model;

import android.content.Context;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u0006*\u00020\t0\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u0006*\u00020\u00120\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u001b\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/data/uploadfiles/model/UploadFilesPreference;", "", "Lid/dana/domain/uploadfiles/UploadFilesEntity;", "selectedFile", "", "addSelectedUploadFiles", "(Lid/dana/domain/uploadfiles/UploadFilesEntity;)V", "clearData", "()V", "Lid/dana/data/storage/LocalStorageFactory$Builder;", "createBuilder", "()Lid/dana/data/storage/LocalStorageFactory$Builder;", "", "getSelectedUploadFiles", "()Ljava/util/List;", "", "getTotalSize", "()I", "Lid/dana/data/storage/PreferenceFacade;", "initSocialPreferences", "()Lid/dana/data/storage/PreferenceFacade;", "initUserInfoObserver", "listUploadFiles", "setSelectedUploadFiles", "(Ljava/util/List;)V", "totalSize", "setTotalSize", "(I)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "", "socialWidgetPreferences", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UploadFilesPreference {
    private static final String LIST_UPLOAD_FILES = "list_upload_files";
    private static final String TOTAL_SIZE = "total_size";
    private final Context context;
    private PreferenceFacade preferenceFacade;
    private final Serializer serializer;
    private final String socialWidgetPreferences;

    @Inject
    public UploadFilesPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
        this.socialWidgetPreferences = "UploadFilesPreference production";
        PreferenceFacade initSocialPreferences = initSocialPreferences();
        Intrinsics.checkNotNullExpressionValue(initSocialPreferences, "");
        this.preferenceFacade = initSocialPreferences;
        initUserInfoObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreferenceFacade initSocialPreferences() {
        return new LocalStorageFactory(createBuilder()).createData2("local");
    }

    private final LocalStorageFactory.Builder createBuilder() {
        return new LocalStorageFactory.Builder(this.context).setPreferenceGroup(this.socialWidgetPreferences).setPassword(UserInfoManager.instance().getUserId()).setSerializerFacade(this.serializer);
    }

    private final void initUserInfoObserver() {
        UserInfoManager.instance().addUserChangeObserver(new IAPUserChangeObserver() { // from class: id.dana.data.uploadfiles.model.UploadFilesPreference$initUserInfoObserver$1
            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserChanged(IAPLoginUserInfo p0) {
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserLogout() {
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserLogin(IAPLoginUserInfo p0) {
                PreferenceFacade initSocialPreferences;
                UploadFilesPreference uploadFilesPreference = UploadFilesPreference.this;
                initSocialPreferences = uploadFilesPreference.initSocialPreferences();
                Intrinsics.checkNotNullExpressionValue(initSocialPreferences, "");
                uploadFilesPreference.preferenceFacade = initSocialPreferences;
            }
        });
    }

    public final void setSelectedUploadFiles(List<UploadFilesEntity> listUploadFiles) {
        Intrinsics.checkNotNullParameter(listUploadFiles, "");
        this.preferenceFacade.saveData(LIST_UPLOAD_FILES, (String) listUploadFiles);
    }

    public final void addSelectedUploadFiles(UploadFilesEntity selectedFile) {
        Intrinsics.checkNotNullParameter(selectedFile, "");
        List mutableList = CollectionsKt.toMutableList((Collection) getSelectedUploadFiles());
        mutableList.add(selectedFile);
        this.preferenceFacade.saveData(LIST_UPLOAD_FILES, new Gson().toJson(CollectionsKt.toList(mutableList)));
    }

    public final List<UploadFilesEntity> getSelectedUploadFiles() {
        new ArrayList();
        String string = this.preferenceFacade.getString(LIST_UPLOAD_FILES);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        Type type = new TypeToken<List<? extends UploadFilesEntity>>() { // from class: id.dana.data.uploadfiles.model.UploadFilesPreference$getSelectedUploadFiles$listType$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "");
        Object fromJson = new Gson().fromJson(string, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "");
        return (List) fromJson;
    }

    public final void setTotalSize(int totalSize) {
        this.preferenceFacade.saveData(TOTAL_SIZE, Integer.valueOf(totalSize));
    }

    public final int getTotalSize() {
        Integer integer = this.preferenceFacade.getInteger(TOTAL_SIZE);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public final void clearData() {
        this.preferenceFacade.clearAllData();
    }
}
