package net.iquesoft.iquephoto.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import net.iquesoft.iquephoto.App;
import net.iquesoft.iquephoto.models.Font;
import net.iquesoft.iquephoto.presentation.views.fragment.FontsView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class FontsPresenter extends MvpPresenter<FontsView> {
    @Inject
    List<Font> mFonts;

    public FontsPresenter() {
        App.getAppComponent().inject(this);

        getViewState().setupAdapter(mFonts);
    }

}
