package com.example.yemeksiparisuygulamasi.ui.viewmodel;

import android.view.View;
import androidx.lifecycle.ViewModel;

import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;
import com.example.yemeksiparisuygulamasi.data.repo.YemeklerDaoRepository;

public class SepetViewModel extends ViewModel {
    private YemeklerDaoRepository yrepo = new YemeklerDaoRepository();
/*
    public void Sil( View view){
        yrepo.Sil(view);

    }*/
}
