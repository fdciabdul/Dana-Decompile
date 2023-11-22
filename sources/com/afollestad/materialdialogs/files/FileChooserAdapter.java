package com.afollestad.materialdialogs.files;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.files.util.FilesUtilExtKt;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008d\u0001\u0012\u0006\u0010,\u001a\u00020\"\u0012\u0006\u0010A\u001a\u00020\u0018\u0012\u0006\u0010@\u001a\u00020\u001e\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010;\u001a\u00020\u001e\u0012\u001a\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u000101j\u0004\u0018\u0001`2\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012.\u0010%\u001a*\u0012\u000b\u0012\t\u0018\u00010\"¢\u0006\u0002\b#\u0012\u000b\u0012\t\u0018\u00010\u0018¢\u0006\u0002\b#\u0012\u0004\u0012\u00020\f\u0018\u00010!j\u0004\u0018\u0001`$¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u0003*\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R<\u0010%\u001a*\u0012\u000b\u0012\t\u0018\u00010\"¢\u0006\u0002\b#\u0012\u000b\u0012\t\u0018\u00010\u0018¢\u0006\u0002\b#\u0012\u0004\u0012\u00020\f\u0018\u00010!j\u0004\u0018\u0001`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R(\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u000101j\u0004\u0018\u0001`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010 R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010 R$\u0010<\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010+\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u001bR\u0014\u0010@\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010 "}, d2 = {"Lcom/afollestad/materialdialogs/files/FileChooserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/afollestad/materialdialogs/files/FileChooserViewHolder;", "", "position", "actualIndex", "(I)I", "getItemCount", "()I", "getSelectedIndex", "goUpIndex", "index", "", "itemClicked", "(I)V", "newFolderIndex", "holder", "onBindViewHolder", "(Lcom/afollestad/materialdialogs/files/FileChooserViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/afollestad/materialdialogs/files/FileChooserViewHolder;", "Ljava/io/File;", "directory", "switchDirectory", "(Ljava/io/File;)V", "iconRes", "(Ljava/io/File;)I", "", "allowFolderCreation", "Z", "Lkotlin/Function2;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/ParameterName;", "Lcom/afollestad/materialdialogs/files/FileCallback;", "callback", "Lkotlin/jvm/functions/Function2;", "", "contents", "Ljava/util/List;", "currentFolder", "Ljava/io/File;", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/widget/TextView;", "emptyView", "Landroid/widget/TextView;", "Lkotlin/Function1;", "Lcom/afollestad/materialdialogs/files/FileFilter;", "filter", "Lkotlin/jvm/functions/Function1;", "folderCreationLabel", "Ljava/lang/Integer;", "isLightTheme", "Lkotlinx/coroutines/Job;", "listingJob", "Lkotlinx/coroutines/Job;", "onlyFolders", "selectedFile", "getSelectedFile", "()Ljava/io/File;", "setSelectedFile", "waitForPositiveButton", "initialFolder", "<init>", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/io/File;ZLandroid/widget/TextView;ZLkotlin/jvm/functions/Function1;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class FileChooserAdapter extends RecyclerView.Adapter<FileChooserViewHolder> {
    private final boolean allowFolderCreation;
    private final Function2<MaterialDialog, File, Unit> callback;
    private List<? extends File> contents;
    private File currentFolder;
    private final MaterialDialog dialog;
    private final TextView emptyView;
    private final Function1<File, Boolean> filter;
    private final Integer folderCreationLabel;
    private final boolean isLightTheme;
    private Job listingJob;
    private final boolean onlyFolders;
    private File selectedFile;
    private final boolean waitForPositiveButton;

    /* JADX WARN: Multi-variable type inference failed */
    public FileChooserAdapter(MaterialDialog materialDialog, File file, boolean z, TextView textView, boolean z2, Function1<? super File, Boolean> function1, boolean z3, Integer num, Function2<? super MaterialDialog, ? super File, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(file, "");
        Intrinsics.checkParameterIsNotNull(textView, "");
        this.dialog = materialDialog;
        this.waitForPositiveButton = z;
        this.emptyView = textView;
        this.onlyFolders = z2;
        this.filter = function1;
        this.allowFolderCreation = z3;
        this.folderCreationLabel = num;
        this.callback = function2;
        this.currentFolder = file;
        MDUtil mDUtil = MDUtil.INSTANCE;
        this.isLightTheme = MDUtil.isColorDark$default(mDUtil, MDUtil.resolveColor$default(mDUtil, materialDialog.getWindowContext(), null, 16842806, null, 10, null), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1, null);
        DialogCallbackExtKt.onDismiss(materialDialog, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.files.FileChooserAdapter.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog2) {
                invoke2(materialDialog2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog2) {
                Intrinsics.checkParameterIsNotNull(materialDialog2, "");
                Job job = FileChooserAdapter.this.listingJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
            }
        });
        switchDirectory(file);
    }

    @JvmName(name = "getSelectedFile")
    public final File getSelectedFile() {
        return this.selectedFile;
    }

    @JvmName(name = "setSelectedFile")
    public final void setSelectedFile(File file) {
        this.selectedFile = file;
    }

    public final void itemClicked(int index) {
        File file = this.currentFolder;
        Context context = this.dialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        File betterParent = FilesUtilExtKt.betterParent(file, context, this.allowFolderCreation, this.filter);
        if (betterParent != null && index == goUpIndex()) {
            switchDirectory(betterParent);
        } else if (this.currentFolder.canWrite() && this.allowFolderCreation && index == newFolderIndex()) {
            DialogFileChooserExtKt.showNewFolderCreator(this.dialog, this.currentFolder, this.folderCreationLabel, new Function0<Unit>() { // from class: com.afollestad.materialdialogs.files.FileChooserAdapter$itemClicked$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    File file2;
                    FileChooserAdapter fileChooserAdapter = FileChooserAdapter.this;
                    file2 = fileChooserAdapter.currentFolder;
                    fileChooserAdapter.switchDirectory(file2);
                }
            });
        } else {
            int actualIndex = actualIndex(index);
            List<? extends File> list = this.contents;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            File file2 = list.get(actualIndex);
            Context context2 = this.dialog.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "");
            File jumpOverEmulated = FilesUtilExtKt.jumpOverEmulated(file2, context2);
            if (jumpOverEmulated.isDirectory()) {
                switchDirectory(jumpOverEmulated);
                return;
            }
            int selectedIndex = getSelectedIndex();
            this.selectedFile = jumpOverEmulated;
            if (this.waitForPositiveButton && DialogActionExtKt.hasActionButtons(this.dialog)) {
                DialogActionExtKt.setActionButtonEnabled(this.dialog, WhichButton.POSITIVE, true);
                notifyItemChanged(index);
                notifyItemChanged(selectedIndex);
                return;
            }
            Function2<MaterialDialog, File, Unit> function2 = this.callback;
            if (function2 != null) {
                function2.invoke(this.dialog, jumpOverEmulated);
            }
            this.dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchDirectory(File directory) {
        Job launch$default;
        Job job = this.listingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FileChooserAdapter$switchDirectory$1(this, directory, null), 2, null);
        this.listingJob = launch$default;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        List<? extends File> list = this.contents;
        int size = list != null ? list.size() : 0;
        File file = this.currentFolder;
        Context context = this.dialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        if (FilesUtilExtKt.hasParent(file, context, this.allowFolderCreation, this.filter)) {
            size++;
        }
        return (this.allowFolderCreation && this.currentFolder.canWrite()) ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FileChooserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.md_file_chooser_item, parent, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "");
        inflate.setBackground(DialogListExtKt.getItemSelector(this.dialog));
        FileChooserViewHolder fileChooserViewHolder = new FileChooserViewHolder(inflate, this);
        MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, fileChooserViewHolder.getNameView(), this.dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
        return fileChooserViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(FileChooserViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "");
        File file = this.currentFolder;
        Context context = this.dialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        File betterParent = FilesUtilExtKt.betterParent(file, context, this.allowFolderCreation, this.filter);
        if (betterParent != null && position == goUpIndex()) {
            InstrumentInjector.Resources_setImageResource(holder.getIconView(), this.isLightTheme ? R.drawable.icon_return_dark : R.drawable.icon_return_light);
            holder.getNameView().setText(betterParent.getName());
            View view = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "");
            view.setActivated(false);
        } else if (this.allowFolderCreation && this.currentFolder.canWrite() && position == newFolderIndex()) {
            InstrumentInjector.Resources_setImageResource(holder.getIconView(), this.isLightTheme ? R.drawable.icon_new_folder_dark : R.drawable.icon_new_folder_light);
            TextView nameView = holder.getNameView();
            Context windowContext = this.dialog.getWindowContext();
            Integer num = this.folderCreationLabel;
            nameView.setText(windowContext.getString(num != null ? num.intValue() : R.string.files_new_folder));
            View view2 = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "");
            view2.setActivated(false);
        } else {
            int actualIndex = actualIndex(position);
            List<? extends File> list = this.contents;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            File file2 = list.get(actualIndex);
            InstrumentInjector.Resources_setImageResource(holder.getIconView(), iconRes(file2));
            holder.getNameView().setText(file2.getName());
            View view3 = holder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "");
            File file3 = this.selectedFile;
            String absolutePath = file3 != null ? file3.getAbsolutePath() : null;
            Object absolutePath2 = file2.getAbsolutePath();
            if (absolutePath2 == null) {
                absolutePath2 = Boolean.FALSE;
            }
            view3.setActivated(Intrinsics.areEqual(absolutePath, absolutePath2));
        }
    }

    private final int goUpIndex() {
        File file = this.currentFolder;
        Context context = this.dialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        return FilesUtilExtKt.hasParent(file, context, this.allowFolderCreation, this.filter) ? 0 : -1;
    }

    private final int newFolderIndex() {
        File file = this.currentFolder;
        Context context = this.dialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        return FilesUtilExtKt.hasParent(file, context, this.allowFolderCreation, this.filter) ? 1 : 0;
    }

    private final int actualIndex(int position) {
        File file = this.currentFolder;
        Context context = this.dialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        if (FilesUtilExtKt.hasParent(file, context, this.allowFolderCreation, this.filter)) {
            position--;
        }
        return (this.currentFolder.canWrite() && this.allowFolderCreation) ? position - 1 : position;
    }

    private final int iconRes(File file) {
        return this.isLightTheme ? file.isDirectory() ? R.drawable.icon_folder_dark : R.drawable.icon_file_dark : file.isDirectory() ? R.drawable.icon_folder_light : R.drawable.icon_file_light;
    }

    private final int getSelectedIndex() {
        int i = -1;
        if (this.selectedFile == null) {
            return -1;
        }
        List<? extends File> list = this.contents;
        if (list == null || !list.isEmpty()) {
            List<? extends File> list2 = this.contents;
            if (list2 != null) {
                int i2 = 0;
                Iterator<? extends File> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String absolutePath = it.next().getAbsolutePath();
                    File file = this.selectedFile;
                    if (Intrinsics.areEqual(absolutePath, file != null ? file.getAbsolutePath() : null)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0) {
                File file2 = this.currentFolder;
                Context context = this.dialog.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "");
                return FilesUtilExtKt.hasParent(file2, context, this.allowFolderCreation, this.filter) ? i + 1 : i;
            }
            return i;
        }
        return -1;
    }
}
