package com.example.tokoalatmusik.fragment

import android.graphics.ColorSpace
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tokoalatmusik.R
import com.example.tokoalatmusik.adapter.AdapterProduk
import com.example.tokoalatmusik.model.produk
import com.inyongtisto.tutorial.adapter.AdapterSlider


class HomeFragment : Fragment() {

    lateinit var vp_slider : ViewPager
    lateinit var rv_produkterbaru :RecyclerView
    lateinit var rv_produkterlaris :RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_home,container,false)
        vp_slider = view.findViewById(R.id.vp_slider)
        rv_produkterbaru = view.findViewById(R.id.rv_produkterbaru)
        rv_produkterlaris = view.findViewById(R.id.rv_produkterlaris)

        val  arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.gitarslider)
        arrSlider.add(R.drawable.piano_slider)
        arrSlider.add(R.drawable.drum_slider)

        val adapterSlider = AdapterSlider (arrSlider,activity)
        vp_slider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rv_produkterbaru.adapter = AdapterProduk(arrprodukterbaru)
        rv_produkterbaru.layoutManager = layoutManager

       //
        val layoutManager1 = LinearLayoutManager(activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL


        rv_produkterlaris.adapter = AdapterProduk(arrprodukterlaris)
        rv_produkterlaris.layoutManager = layoutManager1

        return view
    }


    val arrprodukterbaru: ArrayList<produk>get(){
        val  arr = ArrayList<produk>()
        val p1 = produk()
        p1.nama = "Gitar Gibson Les Paul Classic"
        p1.harga = " 100 Juta"
        p1.gambar = R.drawable.lespaul

        val p2 = produk()
        p2.nama = "Gitar Ibanez Herman Li Signature Model EGEN 18TVF"
        p2.harga = " 70 Juta"
        p2.gambar = R.drawable.ibanez

        val p3 = produk()
        p3.nama = "Synthesizer Keyboard Roland FANTOM 8"
        p3.harga = " 75 Juta"
        p3.gambar = R.drawable.fantom8_gal

        val p4 = produk()
        p4.nama = "Synthesizer Keyboard Roland MONTAGE 8"
        p4.harga = " 63 Juta"
        p4.gambar = R.drawable.montage8

        val p5 = produk()
        p5.nama = "Sonor JF-SSE-11-NEWPORT Beech Matte Walnut Veneer 4-Piece Shell Pack"
        p5.harga = " 107 Juta"
        p5.gambar = R.drawable.sonor

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)


        return arr
    }

    val arrprodukterlaris: ArrayList<produk>get(){
        val  arr = ArrayList<produk>()
        val p1 = produk()
        p1.nama = "Gitar Gibson Les Paul Classic"
        p1.harga = " 100 Juta"
        p1.gambar = R.drawable.lespaul

        val p2 = produk()
        p2.nama = "Gitar Ibanez Herman Li Signature Model EGEN 18TVF"
        p2.harga = " 70 Juta"
        p2.gambar = R.drawable.ibanez

        val p3 = produk()
        p3.nama = "Synthesizer Keyboard Roland FANTOM 8"
        p3.harga = " 75 Juta"
        p3.gambar = R.drawable.fantom8_gal

        val p4 = produk()
        p4.nama = "Synthesizer Keyboard Roland MONTAGE 8"
        p4.harga = " 63 Juta"
        p4.gambar = R.drawable.montage8

        val p5 = produk()
        p5.nama = "Sonor JF-SSE-11-NEWPORT Beech Matte Walnut Veneer 4-Piece Shell Pack"
        p5.harga = " 107 Juta"
        p5.gambar = R.drawable.sonor

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)


        return arr
    }
}