package com.example.desempenio.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<Peleador>> peleadoresLiveData;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        peleadoresLiveData = new MutableLiveData<>(new ArrayList<>());
        mText.setValue("Lista de todos los peleadores");
    }

    public void agregarPeleador(Peleador peleador) {
        List<Peleador> peleadoresActuales = peleadoresLiveData.getValue();
        if (peleadoresActuales != null) {
            peleadoresActuales.add(peleador);
            peleadoresLiveData.postValue(peleadoresActuales);  // postValue se usa en lugar de setValue en caso de que quieras trabajar en hilos de background
        }
    }

    public LiveData<List<Peleador>> getPeleadores() {
        return peleadoresLiveData;
    }

    public LiveData<String> getText() {
        return mText;
    }
}