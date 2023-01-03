package com.example.yemeksiparisuygulamasi.data.repo;

import android.util.Log;
import android.view.View;

import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;
import com.google.android.material.snackbar.Snackbar;

public class YemeklerDaoRepository { //DAO:Database Access Object


    public void Ekle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet, View view, Yemekler gelenYemek){


        Snackbar.make(view, gelenYemek.getYemek_adi() + " " + "Sepete Eklendi", Snackbar.LENGTH_SHORT).show();
        Log.e("Yemek ekle",String.valueOf(yemek_adi));

    }
/*
    public void Sil(View view)
    {
        Snackbar.make(view,"Sepetten Silindi", Snackbar.LENGTH_SHORT).show();


    }*/


    }





