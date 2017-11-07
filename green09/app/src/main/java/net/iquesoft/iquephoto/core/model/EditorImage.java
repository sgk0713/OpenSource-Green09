package net.iquesoft.iquephoto.core.model;

import android.graphics.Bitmap;

import net.iquesoft.iquephoto.core.enums.EditorTool;

public class EditorImage {
    private EditorTool mCommand;
    private Bitmap mBitmap;

    public EditorImage(EditorTool command, Bitmap bitmap) {
        mCommand = command;
        mBitmap = bitmap;
    }

    public EditorTool getCommand() {
        return mCommand;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

}