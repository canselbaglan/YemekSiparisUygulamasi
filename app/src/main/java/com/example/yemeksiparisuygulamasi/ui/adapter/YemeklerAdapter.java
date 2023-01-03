package com.example.yemeksiparisuygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import com.example.yemeksiparisuygulamasi.ui.fragment.AnasayfaFragmentDirections;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimBinding;
import com.example.yemeksiparisuygulamasi.ui.fragment.AnasayfaFragment;
import com.example.yemeksiparisuygulamasi.ui.fragment.YemekDetayFragment;
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler;

import java.util.List;

public class YemeklerAdapter extends RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Yemekler> yemeklerListesi;

    public YemeklerAdapter(Context mContext, List<Yemekler> yemeklerListesi) {
        this.mContext = mContext;
        this.yemeklerListesi = yemeklerListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;

        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        //kac tane nesnem varsa bana o kadar yemek nesnesi getirecektir
        Yemekler yemek = yemeklerListesi.get(position);//yemekler nesnesini tek tek getirecek.
        CardTasarimBinding t = holder.binding;// bu benim textView vs. onlara erişimimi sağlayacak olan kodum
        t.setYemekNesnesi(yemek);


        t.textViewAd.setText(yemek.getYemek_adi());
        t.imageViewYemek.setImageResource(mContext.getResources()
                .getIdentifier(yemek.getYemek_resim_adi(),"drawable",mContext.getPackageName()));

        t.textViewFiyat.setText(yemek.getYemek_fiyat()+" ₺");
        t.cardViewYemek.setOnClickListener(view -> {
            AnasayfaFragmentDirections.YemekDetayGecis gecis = AnasayfaFragmentDirections.yemekDetayGecis(yemek);
            Navigation.findNavController(view).navigate(gecis);

        });

    }

    @Override
    public int getItemCount() {

        return yemeklerListesi.size();
    }



}
