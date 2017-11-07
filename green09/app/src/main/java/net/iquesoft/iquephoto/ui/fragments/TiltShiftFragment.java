package net.iquesoft.iquephoto.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import net.iquesoft.iquephoto.R;
import net.iquesoft.iquephoto.core.ImageEditorView;
import net.iquesoft.iquephoto.core.enums.EditorTool;
import net.iquesoft.iquephoto.presentation.presenters.fragment.TiltShiftFragmentPresenter;
import net.iquesoft.iquephoto.presentation.views.fragment.TiltShiftView;
import net.iquesoft.iquephoto.utils.ToolbarUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static net.iquesoft.iquephoto.core.enums.EditorTool.LINEAR_TILT_SHIFT;
import static net.iquesoft.iquephoto.core.enums.EditorTool.RADIAL_TILT_SHIFT;

public class TiltShiftFragment extends ToolFragment implements TiltShiftView {
    @InjectPresenter
    TiltShiftFragmentPresenter mPresenter;

    private Unbinder mUnbinder;

    private ImageEditorView mImageEditorView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageEditorView =
                (ImageEditorView) getActivity().findViewById(R.id.image_editor_view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tilt_shift, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mImageEditorView.changeTool(RADIAL_TILT_SHIFT);
        ToolbarUtil.updateTitle(R.string.tilt_shift, getActivity());
        ToolbarUtil.updateSubtitle(R.string.tilt_shift_radial, getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onTiltShiftChanged(EditorTool command) {
        mImageEditorView.changeTool(command);
    }

    @OnClick(R.id.button_linear_tilt_shift)
    void onClickLinear() {
        mPresenter.changeTiltShift(LINEAR_TILT_SHIFT);
    }

    @OnClick(R.id.button_radial_tilt_shift)
    void onClickRadial() {
        mPresenter.changeTiltShift(RADIAL_TILT_SHIFT);
    }
}