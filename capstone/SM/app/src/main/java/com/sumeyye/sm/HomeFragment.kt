package com.sumeyye.sm

import android.os.Bundle
import android.view.Gravity.apply
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat.apply
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sumeyye.sm.databinding.ActivityMainBinding
import com.sumeyye.sm.databinding.FragmentHomeBinding
import com.sumeyye.sm.databinding.FragmentLoginBinding
import com.sumeyye.sm.home.AllClothesAdapter
import com.sumeyye.sm.home.ClothesFragmentViewModel
import com.sumeyye.sm.model.ClothesBasketRoomModel
import com.sumeyye.sm.model.ClothesModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var fAuth:FirebaseAuth

    private val viewModel by lazy { ClothesFragmentViewModel(requireContext()) }
    private val allClothesAdapter by lazy { AllClothesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated( // tüm kodlar buraya
        view: View,
        savedInstanceState: Bundle?
    ) { //tasarıma ait işlemler yapılır
        super.onViewCreated(view, savedInstanceState)
        //adaptörden clothes dao'daki veriyi gönder. Listeyi gönderme.Caner hocanınki de liste
        //önce Dao Repository -> view model -> fragment
        //viewmodildan aldığımız verileri observe ediyoruz. Bu bize bir list doöndürür. Bunu da recylerView'e veririz

        initObservers()

    }

    private fun initObservers() {

        with(binding) {

            with(viewModel) {

                clothesList.observe(viewLifecycleOwner) { list ->
                    rvClothes.apply {
                        setHasFixedSize(true)
                        layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                        adapter = allClothesAdapter.also { adapter ->
                            adapter.updateList(list)
                            adapter.onAddBasketClick = {
                                viewModel.addClothesToBasket(
                                    ClothesBasketRoomModel(
                                        user = it.user, //user = fAuth.uid, firebaseden ui vermem lazım . Çektiğimiz yerde de ui verilecek. Çünkü onun olduğu satırlar gelmeli
                                        title = it.title,
                                        price = it.price,
                                        description = it.description,
                                        category = it.category,
                                        image = it.image,
                                        rate=it.rate,
                                        count=it.count,
                                        sale_state = it.sale_state
                                    )
                                )
                            }
                        }
                    }
                }
                isClothesAddedBasket.observe(viewLifecycleOwner) {
                    if (it) Snackbar.make(requireView(), "success", Snackbar.LENGTH_LONG).show()
                    else Snackbar.make(requireView(), "error", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
