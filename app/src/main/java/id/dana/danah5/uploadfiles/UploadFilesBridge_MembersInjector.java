package id.dana.danah5.uploadfiles;

import dagger.MembersInjector;
import id.dana.domain.uploadfiles.AddSelectedFiles;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.uploadfiles.GetSelectedFiles;
import id.dana.domain.uploadfiles.GetTotalFilesSize;
import id.dana.domain.uploadfiles.RemoveSelectedFile;
import id.dana.domain.uploadfiles.SetTotalFilesSize;
import id.dana.domain.uploadfiles.UploadFile;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UploadFilesBridge_MembersInjector implements MembersInjector<UploadFilesBridge> {
    private final Provider<AddSelectedFiles> addSelectedFilesProvider;
    private final Provider<ClearFiles> clearFilesProvider;
    private final Provider<GetSelectedFiles> getSelectedFilesProvider;
    private final Provider<GetTotalFilesSize> getTotalFilesSizeProvider;
    private final Provider<RemoveSelectedFile> removeSelectedFileProvider;
    private final Provider<SetTotalFilesSize> setTotalFilesSizeProvider;
    private final Provider<UploadFile> uploadFileProvider;

    public UploadFilesBridge_MembersInjector(Provider<GetSelectedFiles> provider, Provider<AddSelectedFiles> provider2, Provider<RemoveSelectedFile> provider3, Provider<UploadFile> provider4, Provider<ClearFiles> provider5, Provider<SetTotalFilesSize> provider6, Provider<GetTotalFilesSize> provider7) {
        this.getSelectedFilesProvider = provider;
        this.addSelectedFilesProvider = provider2;
        this.removeSelectedFileProvider = provider3;
        this.uploadFileProvider = provider4;
        this.clearFilesProvider = provider5;
        this.setTotalFilesSizeProvider = provider6;
        this.getTotalFilesSizeProvider = provider7;
    }

    public static MembersInjector<UploadFilesBridge> create(Provider<GetSelectedFiles> provider, Provider<AddSelectedFiles> provider2, Provider<RemoveSelectedFile> provider3, Provider<UploadFile> provider4, Provider<ClearFiles> provider5, Provider<SetTotalFilesSize> provider6, Provider<GetTotalFilesSize> provider7) {
        return new UploadFilesBridge_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public final void injectMembers(UploadFilesBridge uploadFilesBridge) {
        injectGetSelectedFiles(uploadFilesBridge, this.getSelectedFilesProvider.get());
        injectAddSelectedFiles(uploadFilesBridge, this.addSelectedFilesProvider.get());
        injectRemoveSelectedFile(uploadFilesBridge, this.removeSelectedFileProvider.get());
        injectUploadFile(uploadFilesBridge, this.uploadFileProvider.get());
        injectClearFiles(uploadFilesBridge, this.clearFilesProvider.get());
        injectSetTotalFilesSize(uploadFilesBridge, this.setTotalFilesSizeProvider.get());
        injectGetTotalFilesSize(uploadFilesBridge, this.getTotalFilesSizeProvider.get());
    }

    public static void injectGetSelectedFiles(UploadFilesBridge uploadFilesBridge, GetSelectedFiles getSelectedFiles) {
        uploadFilesBridge.getSelectedFiles = getSelectedFiles;
    }

    public static void injectAddSelectedFiles(UploadFilesBridge uploadFilesBridge, AddSelectedFiles addSelectedFiles) {
        uploadFilesBridge.addSelectedFiles = addSelectedFiles;
    }

    public static void injectRemoveSelectedFile(UploadFilesBridge uploadFilesBridge, RemoveSelectedFile removeSelectedFile) {
        uploadFilesBridge.removeSelectedFile = removeSelectedFile;
    }

    public static void injectUploadFile(UploadFilesBridge uploadFilesBridge, UploadFile uploadFile) {
        uploadFilesBridge.uploadFile = uploadFile;
    }

    public static void injectClearFiles(UploadFilesBridge uploadFilesBridge, ClearFiles clearFiles) {
        uploadFilesBridge.clearFiles = clearFiles;
    }

    public static void injectSetTotalFilesSize(UploadFilesBridge uploadFilesBridge, SetTotalFilesSize setTotalFilesSize) {
        uploadFilesBridge.setTotalFilesSize = setTotalFilesSize;
    }

    public static void injectGetTotalFilesSize(UploadFilesBridge uploadFilesBridge, GetTotalFilesSize getTotalFilesSize) {
        uploadFilesBridge.getTotalFilesSize = getTotalFilesSize;
    }
}
