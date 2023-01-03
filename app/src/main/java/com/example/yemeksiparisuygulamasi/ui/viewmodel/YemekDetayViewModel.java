package com.example.yemeksiparisuygulamasi.ui.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;
import com.example.yemeksiparisuygulamasi.data.repo.YemeklerDaoRepository;
import com.google.android.material.snackbar.Snackbar;


public class YemekDetayViewModel extends ViewModel {

    private YemeklerDaoRepository yrepo = new YemeklerDaoRepository();


    public void Ekle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, View view, Yemekler gelenYemek){
        yrepo.Ekle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,view,gelenYemek);


        }



    }


