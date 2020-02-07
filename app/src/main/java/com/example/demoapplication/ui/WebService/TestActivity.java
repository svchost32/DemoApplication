package com.example.demoapplication.ui.WebService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;

import com.example.demoapplication.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class TestActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> {


    private String NAME_SPACE = "http://webservice.jd.com";
    private String METHOD_NAME = "Datainput";

    private String SOAP_ACTION = NAME_SPACE+"/"+METHOD_NAME;
    private String url = "http://70.106.253.97:8989/webservice?wsdl";

    private int LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        LoaderManager loaderManager = new LoaderManager(){
            @NonNull
            @Override
            public <D> Loader<D> initLoader(int id, @Nullable Bundle args, @NonNull LoaderCallbacks<D> callback) {
                return null;
            }

            @NonNull
            @Override
            public <D> Loader<D> restartLoader(int id, @Nullable Bundle args, @NonNull LoaderCallbacks<D> callback) {
                return null;
            }

            @Override
            public void destroyLoader(int id) {

            }

            @Nullable
            @Override
            public <D> Loader<D> getLoader(int id) {
                return null;
            }

            @Override
            public void markForRedelivery() {

            }

            @Override
            public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

            }
        };


    }

    @NonNull
    @Override
    public Loader<List<String>> onCreateLoader (int id, @Nullable Bundle args) {
        Object obj1 = new Object();
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<String>> loader, List<String> data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<String>> loader) {

    }
}
