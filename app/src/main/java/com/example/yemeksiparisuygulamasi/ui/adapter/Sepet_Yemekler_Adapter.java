package com.example.yemeksiparisuygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimSepetBinding;
import com.example.yemeksiparisuygulamasi.data.entity.Sepet_Yemekler;

import com.example.yemeksiparisuygulamasi.ui.fragment.AnasayfaFragmentDirections;
import com.example.yemeksiparisuygulamasi.databinding.FragmentSepetBinding;
import com.example.yemeksiparisuygulamasi.ui.fragment.SepetFragment;
import com.example.yemeksiparisuygulamasi.ui.fragment.AnasayfaFragment;
import com.example.yemeksiparisuygulamasi.ui.fragment.YemekDetayFragment;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;

public class Sepet_Yemekler_Adapter extends RecyclerView.Adapter<Sepet_Yemekler_Adapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Sepet_Yemekler>sepetListesi;

    public Sepet_Yemekler_Adapter(Context mContext, List<Sepet_Yemekler>sepetListesi) {
        this.mContext = mContext;
        this.sepetListesi = sepetListesi;
    }


    public class CardTasarimTutucu extends RecyclerView.ViewHolder { //tasarımımızı temsil eden class
        private CardTasarimSepetBinding binding;
        public CardTasarimTutucu(CardTasarimSepetBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //tasarımımızı temsil eden class'ımıza(CardTasarimTutucu) nesne göndermemizi sağlayan bir yapı.
        CardTasarimSepetBinding binding = CardTasarimSepetBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        //elimizdeki veri kümesini hangi alana yazacığı,neye tıkladığımızda ne olacağı ile ilgili sorulara cevap olan alandır.
        //bu metoddaki holder nesnesiyle CardTasarimTutucu'ya erişeceğim,CardyTasarimTutucu sayesinde binding'e erişeceğim,binding sayesinde de card_tasarim.xml'deki görsel nesnelere erişebileceğim.
        //position sırayla getirmesini sağlıyor
        //dongu gibi çalışır,boyut nesne o kadar calışır ve ona göre sonuc getirir.
        Sepet_Yemekler sepetyemek = sepetListesi.get(position);
        CardTasarimSepetBinding ts = holder.binding;
        ts.setSepetNesnesi(sepetyemek);

        ts.tvSepetAd.setText(sepetyemek.getYemek_adi());
        ts.tvSepetAdet.setText(sepetyemek.getYemek_siparis_adet() +"  "+"Adet");
        ts.tvSepetFiyat.setText(sepetyemek.getYemek_fiyat()+" ₺");
        ts.imageViewResim.setImageResource(mContext.getResources()
                .getIdentifier(sepetyemek.getYemek_resim_adi(),"drawable",mContext.getPackageName()));



        ts.imageViewSepetSil.setOnClickListener(view -> {
            Snackbar.make(view,sepetyemek.getYemek_adi()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        Log.e("Yemek Sil",String.valueOf(sepetyemek.getSepet_yemek_id()));
                    }).show();
        });

    }

    @Override
    public int getItemCount() {

        return sepetListesi.size();
    }
}

