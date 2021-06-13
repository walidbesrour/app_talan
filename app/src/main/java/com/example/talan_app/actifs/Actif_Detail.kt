package com.example.talan_app.actifs

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talan_app.R
import com.example.talan_app.adapters.ViewAdapterPageView
import com.example.talan_app.databinding.ActivityActifDetailBinding
import com.example.talan_app.actifs.detail_actif.CompteurFragment
import com.example.talan_app.actifs.detail_actif.FilsDetailFragment
import com.example.talan_app.actifs.detail_actif.PieceDetacheeFragment
import com.example.talan_app.actifs.detail_actif.RisquePrecautionFragment
import com.example.talan_app.adapters.Adapter_List_PieceJ
import com.example.talan_app.repository.RetrofitRepository
import com.example.talan_app.view_model.Actif_ListFactory_VM
import com.example.talan_app.view_model.Actif_List_VM
import com.google.android.material.textfield.TextInputEditText
import com.squareup.picasso.Picasso
import java.lang.Exception


class Actif_Detail : AppCompatActivity() {


    private lateinit var binding: ActivityActifDetailBinding

    var adapter_list : Adapter_List_PieceJ  ?=null
    private lateinit var viewModel: Actif_List_VM

    var descripActif =""

   var img = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityActifDetailBinding.inflate(layoutInflater)
      setContentView(binding.root)

        val num = intent.getStringExtra("assetnumD")
        val assetnum = "ASSETNUM=$num"

       val siteid = intent.getStringExtra("siteidD")


        setUpTabs(num.toString(),siteid.toString())


        binding.btnDescription.setOnClickListener {

            descriptioview(descripActif)
        }

        binding.btnPiece.setOnClickListener {
            ListPiece(assetnum)
        }




        val repository = RetrofitRepository()
        val viewModelFactory = Actif_ListFactory_VM(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Actif_List_VM::class.java)

        val sharedAPI = this.getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedAPI.getString("SAVE_APIKEY", null)


        if (Apikey != null){
            viewModel.getDetailActif(Apikey,assetnum,"assetnum,description,status,parent,siteid,locations,serialnum,serviceaddress")
            viewModel.myResponseDetail.observe(this, androidx.lifecycle.Observer { Myresponse1 ->

                if (Myresponse1.isSuccessful) {

                    println(Myresponse1.body())

                            binding.Codedetail.text = Myresponse1.body()!!.member[0].assetnum
                            binding.DiscriptionActif.text = Myresponse1.body()!!.member[0].description
                            binding.statusDetail.text = Myresponse1.body()!!.member[0].status
                            binding.codesite.text = Myresponse1.body()!!.member[0].siteid
                            binding.codeparent.text = Myresponse1.body()!!.member[0].parent
                            binding.Emplacement.text = Myresponse1.body()!!.member[0].locations[0].location
                            binding.descEmplacement.text = Myresponse1.body()!!.member[0].locations[0].description
                            binding.EtatActif.text = Myresponse1.body()!!.member[0].locations[0].status
                            binding.NSERIE.text = Myresponse1.body()!!.member[0].serialnum

                    if (Myresponse1.body()!!.member[0].serviceaddress != null){
                        binding.Address.text = Myresponse1.body()!!.member[0].serviceaddress[0].addresscode
                        binding.city.text = Myresponse1.body()!!.member[0].serviceaddress[0].county
                        binding.adress.text = Myresponse1.body()!!.member[0].serviceaddress[0].formattedaddress
                        binding.Province.text = Myresponse1.body()!!.member[0].serviceaddress[0].regiondistrict
                    }else{
                        binding.Address.text = ""
                        binding.city.text = ""
                        binding.adress.text = ""
                        binding.Province.text = ""
                    }

                        if( Myresponse1.body()!!.member[0].description_longdescription != null){
                            descripActif = Myresponse1.body()!!.member[0].description_longdescription
                        }
                    if (Myresponse1.body()!!.member[0]._imagelibref != null){

                         img = Myresponse1.body()!!.member[0]._imagelibref
                    }







                } else {
                    Log.d("response --", Myresponse1.code().toString())
                    Log.d("response --", Myresponse1.message().toString())
                    Log.e("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "onCreate: " )


                }
            })



        }

        binding.btnimg.setOnClickListener {
            println("**********************//////////////////// $img")
            imgActif(img)
        }
    }


    private fun setUpTabs(num :String, siteid : String) {
        val adapter = ViewAdapterPageView(supportFragmentManager)
        adapter.addFragment(CompteurFragment(num), "COMPTEURS")
        adapter.addFragment(RisquePrecautionFragment(num), "RISQUES PRECAUTION")
        adapter.addFragment(PieceDetacheeFragment(num), "PIECE DETACHEES")
        adapter.addFragment(FilsDetailFragment(num,siteid), "ACTIFS FILS ")

        binding.viewPageActif.adapter = adapter
        binding.tabDetailActif.setupWithViewPager(binding.viewPageActif)
        binding.tabDetailActif.getTabAt(0)!!
        binding.tabDetailActif.getTabAt(1)!!
        binding.tabDetailActif.getTabAt(2)!!



    }


    fun descriptioview(txt :String){
        val view = View.inflate(this, R.layout.dialog_description_detaille,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        val textView = dialog.findViewById<TextInputEditText>(R.id.DetaiDescription) as TextView
        textView.text= txt
        dialog.findViewById<Button>(R.id.btnok1)?.setOnClickListener { dialog.dismiss() }
    }

    fun ListPiece(assetnum:String){
        val view = View.inflate(this, R.layout.dialog_piece_joint,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)

//

        adapter_list = Adapter_List_PieceJ(this)

        val recycleActif = dialog.findViewById<TextInputEditText>(R.id.recyclePieceJoint) as RecyclerView

        recycleActif.adapter = adapter_list
        recycleActif.layoutManager = LinearLayoutManager(this)

        val repository = RetrofitRepository()
        val viewModelFactory = Actif_ListFactory_VM(repository)

        val sharedPreferences = getSharedPreferences("APIKEY", Context.MODE_PRIVATE)
        val Apikey = sharedPreferences.getString("SAVE_APIKEY", null)

        viewModel = ViewModelProvider(this, viewModelFactory).get(Actif_List_VM::class.java)

        if (Apikey != null) {
            viewModel.getPieceActif(Apikey,assetnum,"doclinks{*}\n")



            viewModel.myResponseJoint.observe(this, androidx.lifecycle.Observer { Myresponse ->
                if (Myresponse.isSuccessful) {
                    println(Myresponse.body())
             try {
                 Myresponse.body()?.let { adapter_list!!.setData(it.member[0].doclinks.member) }
             }catch (e:Exception){
                 Log.e("TAG", "ListPiece: $e" )
             }






                } else {
                    Log.d("response --", Myresponse.code().toString())
                    Log.d("response --", Myresponse.message().toString())
                    println("+++++++++++++++++++++++++++++++++++++")
                }
            })


        }


        dialog.findViewById<Button>(R.id.btnPiecejoint)?.setOnClickListener { dialog.dismiss() }
    }

    fun imgActif(img : String){
        val lien = img


        val view = View.inflate(this, R.layout.dialog_image,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        val img = dialog.findViewById<ImageView>(R.id.imageActif) as ImageView

        Picasso.get().load(lien).into(img)

        dialog.findViewById<Button>(R.id.btnokImg)?.setOnClickListener { dialog.dismiss() }
    }
}